/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blindway.test;

import edu.eci.arsw.blindway.entities.BlindWayException;
import edu.eci.arsw.blindway.entities.Mapa;
import edu.eci.arsw.blindway.mazegenerator.RecursiveMazeGenerator;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 *
 * @author Hugo Alvarez
 */
public class MapaTest {
    private final int DX[] = {0,-1,1,0};
    private final int DY[] = {-1,0,0,1};
    
    private boolean rango(int x, int y,int n, int m){
        return x>=0 && y>=0 && x<n && y<m;
    }
    
    private boolean dfs(int ix,int iy,int fx,int fy, int[][] maze){
        int n = maze.length;
        int m = maze[0].length;
        boolean vis[][] = new boolean[n][m];
        for (int i = 0; i < vis.length; i++) {
            Arrays.fill(vis[i], false);
        }
        Deque<Pair> st= new ArrayDeque<>();
        st.add(new Pair(ix,iy));
        while(!st.isEmpty()){
            Pair p = st.poll();
            if(p.x == fx && p.y == fy) return true;
            if(!vis[p.x][p.y]){
                vis[p.x][p.y]=true;
                for (int i = 0; i < DX.length; i++) {
                    int nx=p.x+DX[i],ny=p.y+DY[i];
                    if(rango(nx,ny,n,m) && !vis[nx][ny]){
                        st.add(new Pair(nx,ny));
                    }
                }
            }
        }
        return false;
    }
    @Test
    public void CE1DeberiaCrearUnLaberintoConInicioYFin(){
        try{
            Mapa map = new Mapa();
            map.setKam(new RecursiveMazeGenerator());
            map.buildMaze(5, 5);
            assertTrue("No se creo apropiadamente el laberinto CE1DeberiaCrearUnLaberintoConInicioYFin",dfs(map.getInicioX(),map.getInicioY(),map.getFinX(),map.getFinY(),map.getCeldas()));
        }catch(BlindWayException ex){
            fail("Error en la creacion del mapa test 1: " + ex.getMessage());
        }
    }
    @Test
    public void CE2NoDeberiaCrearUnLaberintoConMenorTamano(){
        try{
            Mapa map = new Mapa();
            map.setKam(new RecursiveMazeGenerator());
            map.buildMaze(1, 5);
            fail("No debio crear el laberinto de menor tamaño");
        }catch(BlindWayException ex){
            assertEquals("El laberinto no pueder ser muy pequeño o con datos negativos",ex.getMessage());
        }
    }
    @Test
    public void CE3DeberiaMoverElCarroATravesDelLaberinto(){
        try{
            Mapa map = new Mapa();
            map.setKam(new RecursiveMazeGenerator());
            map.buildMaze(5, 4);
            int[][] maze = map.getCeldas();
            int x =map.getCarro().getX();
            int y =map.getCarro().getY();
            map.moveRight();
            map.moveRight();
            map.moveRight();
            map.moveDown();
            map.moveDown();
            map.moveDown();
            map.moveLeft();
            map.moveLeft();
            map.moveLeft();
            map.moveUP();
            map.moveUP();
            map.moveUP();
            int x1 =map.getCarro().getX();
            int y1 =map.getCarro().getY();
            System.out.println(x+ " "+y+ " "+x1 +" "+y1);
        }catch(BlindWayException ex){
            
        }
    }
}
class Pair{
    int x,y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
