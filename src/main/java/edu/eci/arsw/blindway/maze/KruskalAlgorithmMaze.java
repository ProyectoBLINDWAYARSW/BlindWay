/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blindway.maze;

import edu.eci.arsw.blindway.entities.Celda;
import edu.eci.arsw.blindway.entities.Posicion;
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
public class KruskalAlgorithmMaze {
    public final int DX[] = {-1,0,0,1};
    public final int DY[] = {0,-1,1,0};
    public LinkedList<Posicion> listaCeldas;
    public HashMap<Posicion,Integer> mapeo;
    public List<Celda> celdasLaberinto;
    public DisjointSet UF;
    public int n,m;
    public KruskalAlgorithmMaze(List<Posicion> pos, int n, int m) {
        listaCeldas = (LinkedList<Posicion>) pos;
        mapeo = new HashMap<>();
        celdasLaberinto = new ArrayList<Celda>();
        this.m=m;
        this.n=n;
    }
    
    
    
    public void kruskal(){
        UF = new  DisjointSet(listaCeldas.size());
        for (int i = 0; i < listaCeldas.size(); i++) {
            mapeo.put(listaCeldas.get(i),i);
        }
        
        long seed = System.nanoTime();
        Collections.shuffle(listaCeldas, new Random(seed));
        System.out.println("Cuanto vale "+UF.numDisjointSets());
        while(!listaCeldas.isEmpty()){
            //System.out.println("Entro al while");
            Posicion x=listaCeldas.poll();
            Random direccion = new Random();
            int dir = direccion.nextInt(4);
            int nx=x.getX()+DX[dir],ny=x.getY()+DY[dir];
            Posicion y = new Posicion(nx, ny);
            if(mapeo.containsKey(y)){
                int i=mapeo.get(x),j = mapeo.get(y);
                if(rango(x,y)){
                    //System.out.println("Entro al if");
                    UF.unionSet(i, j);
                    celdasLaberinto.add(new Celda(x, y));
                    
                }
            }
            
        }
    }
    
    public void print(){
        for(Celda celda : celdasLaberinto) {
            System.out.println(celda);
        }
    }
    public boolean rango(Posicion x, Posicion y){
        return abs(x.getX()-y.getX())<=1 && abs(x.getY()-y.getY())<=1 && abs(x.getX()-y.getX())>=-1 && abs(x.getY()-y.getY())>=-1
                && x.getX()>=0 && y.getX()>=0 && x.getY()>=0 && y.getY()>=0 && x.getX()<n && y.getX()<n && x.getY()<m && y.getY()<m;
    }
}
