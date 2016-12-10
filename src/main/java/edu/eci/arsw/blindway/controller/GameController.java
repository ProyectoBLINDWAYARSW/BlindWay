/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blindway.controller;

import edu.eci.arsw.blindway.entities.BlindWayException;
import edu.eci.arsw.blindway.entities.Carro;
import edu.eci.arsw.blindway.entities.Mapa;
import edu.eci.arsw.blindway.entities.Mensajes;
import edu.eci.arsw.blindway.game.Game;
import edu.eci.arsw.blindway.services.ServiceGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Hugo Alvarez
 */
@RestController
@RequestMapping("/blindway")
public class GameController {

    @Autowired
    public ServiceGame game;

    @RequestMapping(method = RequestMethod.GET)
    public String test(){
        return "Ok";
    }
    @RequestMapping(path = "/maze/{id}/{x}/{y}", method = RequestMethod.GET)
    public ResponseEntity<?> setMaze(@PathVariable Integer id,@PathVariable Integer x,@PathVariable Integer y) throws BlindWayException{
        try{
            game.createGame(id,x,y);
        }catch(BlindWayException e){
        }
        Game g = game.getGame(id);
        return new ResponseEntity<>(g.getLabyrinth(),HttpStatus.ACCEPTED);
    }
    @RequestMapping(path = "/maze/{id}/{x}/{y}/car", method = RequestMethod.GET)
    public ResponseEntity<?> getCar(@PathVariable Integer id,@PathVariable Integer x,@PathVariable Integer y) throws BlindWayException{
        Game g = game.getGame(id);
        return new ResponseEntity<>(g.getCar(),HttpStatus.ACCEPTED);
    }
}
