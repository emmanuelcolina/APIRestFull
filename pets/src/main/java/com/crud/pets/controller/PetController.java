package com.crud.pets.controller;

import com.crud.pets.dto.PetDto;
import com.crud.pets.service.PetService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/pets")
@AllArgsConstructor
public class PetController {

    private final PetService petService;

    @GetMapping
    public List<PetDto> getAllPets()
    {
        return petService.getAllPets();
    }
    
    @PostMapping
    public ResponseEntity<PetDto> createPet(@RequestBody PetDto petDto){
        return new ResponseEntity(petService.createPet(petDto), HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<PetDto> getPetById(@PathVariable Long id){
        return new ResponseEntity(petService.getPetById(id), HttpStatus.OK);
    } 
    
    @PutMapping("/{id}")
    public ResponseEntity<PetDto> updatePet(@RequestBody PetDto petDto, @PathVariable Long id){
        return new ResponseEntity(petService.updatePet(petDto, id), HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public String deletePet(@PathVariable Long id){
        return petService.deletePet(id);
    }
    
    
}
