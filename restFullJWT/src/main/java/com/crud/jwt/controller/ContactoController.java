/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crud.jwt.controller;

import com.crud.jwt.entity.Contacto;
import com.crud.jwt.service.ContactoService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USUARIO
 */

@RestController
@RequestMapping("/api/v1/contactos")
@AllArgsConstructor
public class ContactoController {
    
    private final ContactoService contactoService;
    
    @GetMapping()
    public List<Contacto> listContacto(){
        return contactoService.getAllContactos();
    }
}
