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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Leonardo Andres
 */
@CrossOrigin
@RestController
@RequestMapping("/salas")
public class SalasController {
    StubSala salas = StubSala.getInstance();
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> manejadorGetRecursoSalas() {
        try {
            StubUsuario.getInstance().registroUsuario("Leonardo Herrera",20,"Masculino","Saiga","contraseña123","leonardo.ft3@gmail.com");
            Usuario u=StubUsuario.getInstance().cargarUsuarioPorNick("Saiga");
            int id = StubSala.getInstance().crearSala(u);
            StubUsuario.getInstance().vaciarUsuarios();
            ArrayList<Sala> data = salas.obtenerSalas();
            return new ResponseEntity<>(data,HttpStatus.ACCEPTED);
        } catch (RegistroUsuarioException | CreacionSalaException ex) {
            Logger.getLogger(SalasController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.ACCEPTED);
        }
    }
}
