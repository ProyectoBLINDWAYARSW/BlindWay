package edu.eci.arsw.blindway.entities;

import edu.eci.arsw.blindway.maze.KruskalAlgorithmMaze;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 * 
 * @author Hugo Alvarez
 */
public class Mapa {

	private Posicion inicio;

	private Posicion fin;

	private List<List<Posicion>> celdas;
        
        private List<Posicion> listceldas;
        
        private int sizeN;
        
        private int sizeM;
        
        private KruskalAlgorithmMaze kam;
        
        /**
         * 
         * @param sizeM filas
         * @param sizeN columnas
         */
        public Mapa(int sizeM, int sizeN){
            this.sizeM=sizeM;
            this.sizeN=sizeN;
            celdas = new ArrayList<>();
            listceldas = new LinkedList<>();
            for (int i = 0; i < this.sizeM; i++) {
                celdas.add(new ArrayList<>());
                for (int j = 0; j < this.sizeN; j++) {
                    celdas.get(i).add(new Posicion(i,j));
                    listceldas.add(new Posicion(i, j));
                }
            }
        }
        
        public void buildMaze(){
            System.out.println("Entro aqui tambien 1");
            kam=new KruskalAlgorithmMaze(listceldas,sizeM,sizeN);
            System.out.println("Entro aqui tambien 2");
            kam.kruskal();
            System.out.println("Entro aqui tambien 3");
            kam.print();
        }

}
