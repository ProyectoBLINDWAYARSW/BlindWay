package edu.eci.arsw.blindway.entities;



public class Carro {

    private int x;

    private int y;

    private String direccion;

    public Carro(int x, int y, String direccion) {
        this.x = x;
        this.y = y;
        this.direccion = direccion;
    }
        

    public void moverseX(int x) {
        this.x+=x;
    }
    
    public void moverseY(int y) {
        this.y+=y;
    }

	

}
