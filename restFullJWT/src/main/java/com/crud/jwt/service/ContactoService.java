/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crud.jwt.service;

import com.crud.jwt.entity.Contacto;
import com.crud.jwt.repository.ContactoRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */

@Service
@AllArgsConstructor
public class ContactoService {
    
    private final ContactoRepository contactoRepository;
    
    public List<Contacto> getAllContactos(){
        return contactoRepository.findAll();
    }
}
