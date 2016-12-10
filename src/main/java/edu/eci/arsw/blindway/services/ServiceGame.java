/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blindway.services;

import edu.eci.arsw.blindway.persistence.GamePersistence;

/**
 *
 * @author masterhugo
 */
public class ServiceGame {
    
    private GamePersistence game;
    
    public ServiceGame(){
        
    }
    public void createGame(int id, int n, int m){
        game.createGame(id, n, m);
    }
    
    
    
}
