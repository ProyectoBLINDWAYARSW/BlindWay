/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blindway.persistence;

import edu.eci.arsw.blindway.entities.BlindWayException;
import edu.eci.arsw.blindway.game.Game;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;

/**
 *
 * @author masterhugo
 */
@Service
public class StubGamePersistence implements GamePersistence{
    private final ConcurrentHashMap<Integer,Game> gamesState;

    public StubGamePersistence() {
        this.gamesState = new ConcurrentHashMap<>();
    }
    
    
    @Override
    public void createGame(int id, int n, int m) throws BlindWayException{
        if (gamesState.containsKey(id)){
            throw new BlindWayException("The game "+id+" already exist.");
        }         
        else{
            Game o = new Game();
            o.createGame(n, n);
            gamesState.put(id, o);
         
        }
    }

    @Override
    public Game getGame(int id) throws BlindWayException{
        if (!gamesState.containsKey(id)){
            throw new BlindWayException("The game "+id+" doesnt exist.");
        }
        else{
            return gamesState.get(id);
        }
    }
    
}
