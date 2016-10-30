/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blindway.mazegenerator;

import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Hugo Alvarez
 */
public class KruskalAlgorithmMazeGenerator implements MazeGenerator{
    public final int DX[] = {-1,0,0,1};
    public final int DY[] = {0,-1,1,0};
    public DisjointSet UF;
    public int n,m;
    public int[][] maze;
    public KruskalAlgorithmMazeGenerator(int n, int m) {
        this.m=m;
        this.n=n;
        maze= new int[n][m];
    }

    @Override
    public void build(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int[][] getMaze() {
        return maze;
    }

    @Override
    public String display() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    public void kruskal(){

    }
    
    public void print(){
        
    }
}
