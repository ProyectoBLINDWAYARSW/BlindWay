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
        

    public boolean moverseX(int x){
        if(this.x+x<0)return false;
        this.x+=x;
        return true;
    }
    
    public boolean moverseY(int y){
        if(this.y+y<0) return false;
        this.y+=y;
        return true;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return x+" "+y+" "+direccion;
    }
    
    

}
