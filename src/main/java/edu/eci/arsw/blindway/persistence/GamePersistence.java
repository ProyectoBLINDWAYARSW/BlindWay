/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blindway.persistence;

import edu.eci.arsw.blindway.game.Game;

/**
 *
 * @author masterhugo
 */
public interface GamePersistence {
    /**
     * Crea un juego nuevo con un id especifico, de tamano n*m
     * @param id - el identificador del juego
     * @param n - la cantidad de filas del juego
     * @param m - la cantidad de columnas del juego
     */
    public void createGame(int id, int n, int m);
    /**
     * Obtiene el juego especifico
     * @param id - el identificador del juego
     * @return el juego identificado con el id
     */
    public Game getGame(int id);
    
}
