package com.crud.jwt.controller;

import com.crud.jwt.dto.PetDto;
import com.crud.jwt.service.PetService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
