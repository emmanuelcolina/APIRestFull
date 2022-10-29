package com.crud.jwt.service;

import com.crud.jwt.dto.PetDto;
import com.crud.jwt.entity.Pet;
import com.crud.jwt.repository.PetRepository;
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

    private PetDto mapToDto(Pet pet){
        return modelMapper.map(pet, PetDto.class);
    }
}
