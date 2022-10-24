package com.crud.pets.service;

import com.crud.pets.dto.PetDto;
import com.crud.pets.entity.Pet;
import com.crud.pets.repository.PetRepository;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PetService {

    private final PetRepository petRepository;

    private final ModelMapper modelMapper;


    //podemos facilmente retornar una enteidad de tipo: Pet, pero las buenas practicas indican no retornar entitys como beans
    public List<PetDto> getAllPets(){
        return petRepository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }
    
    public PetDto createPet (PetDto petDto){
        Pet pet = mapToEntetity(petDto);
        
        return mapToDto(petRepository.save(pet));
    }
    
    public PetDto getPetById(Long id){
        return mapToDto(petRepository.findById(id).get());
    }
    
    public PetDto updatePet(PetDto petDto, Long id){
        Pet pet = petRepository.findById(id).get();
        
        pet.setBirthDate(petDto.getBirthDate());
        pet.setGender(petDto.getGender());
        pet.setHasVaccinesUpdated(petDto.getHasVaccinesUpdated());
        pet.setName(petDto.getName());
        pet.setRace(petDto.getRace());
        
        petRepository.save(pet);
        
        return mapToDto(pet);
    }
    
    public String deletePet(Long id){
        
        Pet pet = petRepository.findById(id).get();
        
        petRepository.delete(pet);
        
        return "Pet Deleted";
    }

    private PetDto mapToDto(Pet pet){
        return modelMapper.map(pet, PetDto.class);
    }
    
    private Pet mapToEntetity (PetDto petDto){
        return modelMapper.map(petDto, Pet.class);
    }
}
