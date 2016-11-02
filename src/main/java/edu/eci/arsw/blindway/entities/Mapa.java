package edu.eci.arsw.blindway.entities;


import edu.eci.arsw.blindway.mazegenerator.MazeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 
 * @author Hugo Alvarez
 */
@Service
public class Mapa {

    private final int inicioX;
    private final int inicioY;

    private int finX;
    private int finY;

    private int[][] celdas;

    private int n;

    private int m;

    private final Carro carro;

    @Autowired
    private MazeGenerator kam;

    public Mapa()throws BlindWayException{
        inicioX = 0;
        inicioY = 0;
        carro = new Carro(0, 0, "Fijo");
    }
    /**
     * 
     * @param n filas
     * @param m columnas
     */
    public void buildMaze(int n, int m)throws BlindWayException{
        if(n <= 3 || m <= 3)throw new BlindWayException("El laberinto no pueder ser muy pequeño o con datos negativos");
        this.n=n;
        this.m=m;
        finX=n-1;
        finY=m-1;
        celdas = new int [n][m];
        kam.build(n,m);
        System.out.println("Entro aqui tambien 3");
        celdas=kam.getMaze();
    }
    public String display(){
        return kam.display();
    }
    public boolean moveDown(){
        if(carro.getY()+1>=m || (celdas[carro.getX()][carro.getY()+1] & 1) ==0) return false;
        return carro.moverseY(1);
    }
    public boolean moveUP(){
        if((celdas[carro.getX()][carro.getY()] & 1) ==0) return false;
        return carro.moverseY(-1);
    }
    public boolean moveLeft(){
        if((celdas[carro.getX()][carro.getY()] & 8) ==0) return false;
        return carro.moverseX(-1);
    }
    public boolean moveRight(){
        if(carro.getX()+1>=n || (celdas[carro.getX()+1][carro.getY()] & 8) ==0) return false;
        return carro.moverseX(1);
    }

    public int getFinX() {
        return finX;
    }

    public void setFinX(int finX) {
        this.finX = finX;
    }

    public int getFinY() {
        return finY;
    }

    public void setFinY(int finY) {
        this.finY = finY;
    }

    public int getInicioX() {
        return inicioX;
    }

    public int getInicioY() {
        return inicioY;
    }

    public int[][] getCeldas() {
        return celdas;
    }

    public void setKam(MazeGenerator kam) {
        this.kam = kam;
    }

    public Carro getCarro() {
        return carro;
    }
    
    
}
