/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blindway.mazegenerator;

/**
 *
 * @author Hugo Alvarez
 */
public interface MazeGenerator {
    public int[][] getMaze();
    public void build(int x,int y);
    public String display();
}
