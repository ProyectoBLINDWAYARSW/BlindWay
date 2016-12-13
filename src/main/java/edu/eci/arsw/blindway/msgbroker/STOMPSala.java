/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blindway.msgbroker;

import edu.eci.arsw.blindway.entities.Invitacion;
import edu.eci.arsw.blindway.entities.Usuario;
import edu.eci.arsw.blindway.persistence.StubSala;
import edu.eci.arsw.blindway.persistence.StubUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;

/**
 *
 * @author 2107262
 */
public class STOMPSala {
    @Autowired
    SimpMessagingTemplate msgt;
    @MessageMapping("/load.{id}")    
    public void chooseRoom(String name,@DestinationVariable Integer id) throws Exception {    
        synchronized(msgt){
           Usuario u=StubUsuario.getInstance().cargarUsuarioPorNick(name);
           msgt.convertAndSend("/topic/load."+id, u);
        }   
    }
}
