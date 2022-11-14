/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crud.jwt.security;

import lombok.Data;

/**
 *
 * @author USUARIO
 */

@Data
public class AuthCredentials {
    
    private String email;
    private String password;
}
