/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blindway.services;

import edu.eci.arsw.blindway.entities.BlindWayException;
import edu.eci.arsw.blindway.game.Game;
import edu.eci.arsw.blindway.persistence.GamePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author masterhugo
 */
@Service
public class ServiceGame {
    @Autowired
    private GamePersistence game;
    
    public ServiceGame(){
        
    }
    public void createGame(int id, int n, int m) throws BlindWayException{
        game.createGame(id, n, m);
    }
    public Game getGame(int id) throws BlindWayException{
        return game.getGame(id);
    }
    
    
    
}
