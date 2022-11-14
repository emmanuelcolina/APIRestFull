/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crud.jwt.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 *
 * @author USUARIO
 */
public class TokenUtils {
    
    //clave de encriptacion
    private static final String ACCESS_TOKEN_SECRET = "4qhq8LrEBfYcaRHxhdb9zURb2rf8e7Ud";
    
    //tiempo de vida util del token
    private final static Long ACCESS_TOKEN_VALIDITY_SECONDS = 2_592_000L;
    
    
    
    //producira un token que sera enviado al cliente
    public static String createToken(String nombre, String email){
        
        long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1_000;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);
        
        Map<String, Object> extra = new HashMap<>();
        
        //nombre de usuario
        extra.put("nombre", nombre);
        
        return Jwts.builder()
                .setSubject(email)
                .setExpiration(expirationDate)
                .addClaims(extra)
                .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
                .compact();
    }
    
    
    //retorna un UsernamePasswordAuthenticationToken para que spring security reconzaca 
    //y pueda dejar pasar el proceso de autorizacion para un usuario, que esta intentando acceder
    //a un endpoint mediante un token, y el token esta en un formato plano
    
    public static UsernamePasswordAuthenticationToken getAuthentication(String token){
        
        //sentencia try/catch por si se envia un token errado o uno expirado
        try{
            //proceso inverso para cuando se crea un token
            Claims claims = Jwts.parserBuilder()
                .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();
        
            String email = claims.getSubject();
        
            return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
        } catch(JwtException e){
            
            System.out.println("Token Invalido o Token Expirado");
            return null;
        }
    }   
    
}
