/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blindway.game;

import edu.eci.arsw.blindway.entities.BlindWayException;
import edu.eci.arsw.blindway.entities.Mapa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author masterhugo
 */

public class Game {
    
    private Mapa mapa;
    
    
    private boolean state;
    
    private boolean move;

    public Game() throws BlindWayException{
        mapa = new Mapa();
    }
    
    public void createGame(int n, int m) throws BlindWayException{
        mapa.buildMaze(n, m);
    }
    
    public boolean moveLeft(){
        move=false;
        if(!state){
            move=mapa.moveLeft();
            state=winGame();
        }
        return move;
    }
    
    public boolean moveRight(){
        move=false;
        if(!state){
            move=mapa.moveRight();
            state=winGame();
        }
        return move;
    }
    
    public boolean moveUp(){
        move=false;
        if(!state){
            move=mapa.moveUP();
            state=winGame();
        }
        return move;
    }
    
    public boolean moveDown(){
        move=false;
        if(!state){
            move=mapa.moveDown();
            state=winGame();
        }
        return move;
    }
    
    public int[][] getLabyrinth(){
        return mapa.getCeldas();
    }
    
    public int[] getCar(){
        int[] pos = new int[2];
        pos[0]=mapa.getCarro().getX();
        pos[1]=mapa.getCarro().getY();
        return pos;
    }
    
    public boolean getState(){
        return state;
    }
    
    public boolean winGame(){
        return mapa.finish();
    }
}
