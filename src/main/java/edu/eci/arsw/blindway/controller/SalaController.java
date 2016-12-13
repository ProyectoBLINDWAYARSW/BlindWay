/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blindway.controller;

import edu.eci.arsw.blindway.entities.Sala;
import edu.eci.arsw.blindway.entities.Usuario;
import edu.eci.arsw.blindway.persistence.CreacionSalaException;
import edu.eci.arsw.blindway.persistence.RegistroUsuarioException;
import edu.eci.arsw.blindway.persistence.StubSala;
import edu.eci.arsw.blindway.persistence.StubUsuario;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Hugo Alvarez
 */
@CrossOrigin
@RestController
@RequestMapping("/room")
public class SalaController {
    StubSala salas = StubSala.getInstance();
    @RequestMapping(path="/creacion/{nick}",method = RequestMethod.GET)
    public ResponseEntity<?> manejadorGetRecursoSalaCreacion(@PathVariable String nick) {
        try {
            Usuario u=StubUsuario.getInstance().cargarUsuarioPorNick(nick);
            int id = StubSala.getInstance().crearSala(u);
            return new ResponseEntity<>(StubSala.getInstance().obtenerSala(id),HttpStatus.ACCEPTED);
        } catch (RegistroUsuarioException | CreacionSalaException ex) {
            Logger.getLogger(SalasController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_ACCEPTABLE);
        }
    }
    @RequestMapping(path="/obtencion/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> manejadorGetRecursoSalaCreacion(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(StubSala.getInstance().obtenerSala(id),HttpStatus.ACCEPTED);
        } catch (CreacionSalaException ex) {
            Logger.getLogger(SalasController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_ACCEPTABLE);
        }
    } 
}
