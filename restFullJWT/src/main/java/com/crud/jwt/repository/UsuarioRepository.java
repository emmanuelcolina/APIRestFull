/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.crud.jwt.repository;

import com.crud.jwt.entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author USUARIO
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
  
    Optional <Usuario> findOneByEmail(String email);
        
}
