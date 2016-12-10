/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blindway.msgbroker;

import edu.eci.arsw.blindway.entities.Invitacion;
import edu.eci.arsw.blindway.entities.Mensajes;
import edu.eci.arsw.blindway.entities.Usuario;
import edu.eci.arsw.blindway.persistence.RegistroUsuarioException;
import edu.eci.arsw.blindway.persistence.StubUsuario;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

/**
 *
 * @author 2107262
 */
@Controller
public class STOMPUsuario {
    @Autowired
    SimpMessagingTemplate msgt;
    @MessageMapping("/usuario")    
    public void crearUsuario(String caracter){    
        try {
            System.out.println("Entra");
            String[] character=caracter.split(",");
            String nombre=character[0];
            int edad=Integer.parseInt(character[1]);
            String genero=character[2];
            String nickname=character[3];
            String contraseña=character[4];
            String correo=character[5];
            StubUsuario.getInstance().registroUsuario(nombre, edad, genero, nickname, contraseña, correo);
            Mensajes.mostrarMensaje("El usuario fue creado satisfactoriamente.", "Creación completada");
        } catch (RegistroUsuarioException ex) {
            Mensajes.mostrarMensaje(ex.getMessage(), "No se pudo crear usuario.");
        }
    }
}
