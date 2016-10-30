/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blindway;

import edu.eci.arsw.blindway.entities.Mapa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author Hugo Alvarez
 */
//@SpringBootApplication
public class BlindWay {
    public static void main(String[] args) {
        int x = args.length >= 1 ? (Integer.parseInt(args[0])) : 20;
        int y = args.length == 2 ? (Integer.parseInt(args[1])) : 20;
        MazeGenerator maze = new MazeGenerator(x, y);
        maze.display();
        maze.print();
        System.out.println("Entro");
        //Mapa map = new Mapa(3, 3);
        //map.buildMaze();
        //SpringApplication.run(BlindWay.class, args); 
    }
}
