/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blindway.controller;

import edu.eci.arsw.blindway.entities.BlindWayException;
import edu.eci.arsw.blindway.entities.Mapa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
    private Mapa map;
    
    @RequestMapping(method = RequestMethod.GET)
    public String test(){
        return "Ok";
    }
    @RequestMapping(path = "/maze/{x}/{y}", method = RequestMethod.GET)
    public ResponseEntity<?> getCurrentWord(@PathVariable Integer x,@PathVariable Integer y) throws BlindWayException{
        System.out.println(x+ " " +y+ " "+map);
        map.buildMaze(x,y);
        return new ResponseEntity<>(map.display(),HttpStatus.ACCEPTED);
    }
}
