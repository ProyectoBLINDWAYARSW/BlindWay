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
        
        @Autowired
        private MazeGenerator kam;
        
        /**
         * 
         * @param sizeM filas
         * @param sizeN columnas
         */
        public Mapa(){
            inicioX = 0;
            inicioY = 0;
        }
        
        public void buildMaze(int n, int m){      
            this.n=n;
            this.m=m;
            celdas = new int [n][m];
            kam.build(n,m);
            System.out.println("Entro aqui tambien 3");
            celdas=kam.getMaze();
        }
        public String display(){
            return kam.display();
        }
        

}
