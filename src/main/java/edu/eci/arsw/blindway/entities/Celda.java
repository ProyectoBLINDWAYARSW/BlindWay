package edu.eci.arsw.blindway.entities;

/**
 * 
 * @author Hugo Alvarez
 */
public class Celda {
    public Posicion a,b;

    public Celda(Posicion a, Posicion b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return a + " " + b;
    }
    
}
