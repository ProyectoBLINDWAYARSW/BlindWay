/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blindway.controller;

import edu.eci.arsw.blindway.entities.Mensajes;
import edu.eci.arsw.blindway.entities.Usuario;
import edu.eci.arsw.blindway.persistence.RegistroUsuarioException;
import edu.eci.arsw.blindway.persistence.StubUsuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Leonardo Andres
 */
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    StubUsuario stub = StubUsuario.getInstance();
    @RequestMapping(method = RequestMethod.POST)    
    public ResponseEntity<?> manejadorPostRecursoUsuario(String nombre, int edad, String genero, String nickname, String contrasena, String correoElectronico){
        try {
            StubUsuario.getInstance().registroUsuario(nombre, edad, genero, nickname, contrasena, correoElectronico);
            System.out.println("El usuario fue creado satisfactoriamente.");
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (RegistroUsuarioException ex) {
            System.out.println(ex.getMessage());
            return new ResponseEntity<>("Error al crear un usuario",HttpStatus.FORBIDDEN);            
        }       
    }
}
