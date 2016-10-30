package edu.eci.arsw.blindway.entities;


/**
 * 
 * @author Hugo Alvarez
 */
public class Posicion {
    
    private int x,y;

    public Posicion() {
    }

    public Posicion(int x, int y) {
        this.x = x;
        this.y = y;
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

    @Override
    public String toString() {
        return "x: "+x+" y: "+y;
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if(o==null) return false;
        Posicion p = (Posicion)o;
        return x == p.getX() && y == p.getY();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.x;
        hash = 53 * hash + this.y;
        return hash;
    }
    
    

}
