/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blindway.msgbroker;


import edu.eci.arsw.blindway.entities.BlindWayException;
import edu.eci.arsw.blindway.entities.Mensajes;
import edu.eci.arsw.blindway.game.Game;
import edu.eci.arsw.blindway.services.ServiceGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

/**
 *
 * @author masterhugo
 */
@Controller
public class StompGame {
    
    @Autowired
    public ServiceGame game;
    @Autowired
    private SimpMessagingTemplate msgt;
    
    @MessageMapping("/move.{id}")  
    public void move(String s,@DestinationVariable Integer id)throws BlindWayException{
        System.out.println("Entroooooooooo!!!!!!!!!!!!!!!");
        Game g = game.getGame(id);
        boolean tmp = false;
        switch (s) {
            case "Up":
                tmp = g.moveUp();
                break;
            case "Down":
                tmp = g.moveDown();
                break;
            case "Left":
                tmp = g.moveLeft();
                break;
            case "Right":
                tmp = g.moveRight();
                break;
            default:
                break;
        }
        msgt.convertAndSend("/topic/move."+id, s+" "+tmp);
    }
}
