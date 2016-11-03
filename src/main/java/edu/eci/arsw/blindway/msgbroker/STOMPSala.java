/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blindway.msgbroker;

import edu.eci.arsw.blindway.entities.Invitacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;

/**
 *
 * @author 2107262
 */
public class STOMPSala {
    @Autowired
    SimpMessagingTemplate msgt;
    @MessageMapping("/invitacion")    
    public void getInvitacion(Invitacion inv) throws Exception {    
        synchronized(msgt){
           inv.getDestino().añadirInvitacion(inv);
        }   
    }
}
