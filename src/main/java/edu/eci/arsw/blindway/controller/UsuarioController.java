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
    public ResponseEntity<?> manejadorPostRecursoUsuario(@RequestBody Usuario caracter){
        System.out.println("Entra" + caracter + "  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        /*try {
            System.out.println("Entra" + caracter + "  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            /*String nombre=character[0];
            int edad=Integer.parseInt(character[1]);
            String genero=character[2];
            String nickname=character[3];
            String contraseña=character[4];
            String correo=character[5];
            StubUsuario.getInstance().registroUsuario(nombre, edad, genero, nickname, contraseña, correo);
            Mensajes.mostrarMensaje("El usuario fue creado satisfactoriamente.", "Creación completada");
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (RegistroUsuarioException ex) {
            Mensajes.mostrarMensaje(ex.getMessage(), "No se pudo crear usuario.");
            return new ResponseEntity<>("Error al crear un usuario",HttpStatus.FORBIDDEN);            
        }       
        */
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
