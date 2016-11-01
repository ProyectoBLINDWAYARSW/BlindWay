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
        public void buildMaze(int n, int m){      
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
        public void moveUp() throws BlindWayException{
            if(carro.getY()+1>=m) throw new BlindWayException("No se puede mover arriba");
            carro.moverseY(1);
        }
        public void moveDown()throws BlindWayException{
            carro.moverseY(-1);
        }
        public void moveLeft()throws BlindWayException{
            carro.moverseX(-1);
        }
        public void moveRight()throws BlindWayException{
            if(carro.getX()+1>=n) throw new BlindWayException("No se puede mover a la derecha");
            carro.moverseX(1);
        }
}
