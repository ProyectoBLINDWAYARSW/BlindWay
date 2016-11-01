package edu.eci.arsw.blindway.entities;



public class Carro {

    private int x;

    private int y;

    private String direccion;

    public Carro(int x, int y, String direccion)throws BlindWayException{
        if(x<0 || y < 0) throw new BlindWayException("El carro no puede estar ubicado en una posicion con coordenadas negativas");
        this.x = x;
        this.y = y;
        this.direccion = direccion;
    }
        

    public int moverseX(int x)throws BlindWayException{
        if(this.x+x<0) throw new BlindWayException("El carro no puede dirigirse a una posicion negativa");
        this.x+=x;
        return this.x;
    }
    
    public int moverseY(int y) throws BlindWayException{
        if(this.y+y<0) throw new BlindWayException("El carro no puede dirigirse a una posicion negativa");
        this.y+=y;
        return this.y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
	

}
