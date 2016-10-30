/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blindway.mazegenerator;

/**
 *
 * @author Hugo Alvarez
 */
import java.util.Collections;
import java.util.Arrays;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
 
/*
 * recursive backtracking algorithm
 * shamelessly borrowed from the ruby at
 * http://weblog.jamisbuck.org/2010/12/27/maze-generation-recursive-backtracking
 * http://rosettacode.org/wiki/Maze_generation#Java
 */
@Component
public class RecursiveMazeGenerator implements MazeGenerator{
    private int x;
    private int y;
    private int[][] maze;

    public RecursiveMazeGenerator() {
      
    }
    

    public String display() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < y; i++) {
            // draw the north edge
            for (int j = 0; j < x; j++) {
                System.out.print((maze[j][i] & 1) == 0 ? "+---" : "+   ");
                sb.append((maze[j][i] & 1) == 0 ? "+---" : "+   ");
            }
            System.out.println("+");
            // draw the west edge
            for (int j = 0; j < x; j++) {
                if(j==0 && i==0)System.out.print("    ");
                else System.out.print((maze[j][i] & 8) == 0? "|   " : "    ");
                if(j==0 && i==0)sb.append("    ");
                else sb.append((maze[j][i] & 8) == 0? "|   " : "    ");
            }
            if(i==y-1) System.out.println(" ");
            else System.out.println("|");
            if(i==y-1) sb.append(" ");
            else sb.append("|");
        }
        // draw the bottom line
        for (int j = 0; j < x; j++) {
            System.out.print("+---");
            sb.append("+---");
        }
        System.out.println("+");
        sb.append("+");
        return sb.toString();
    }
    
    public void print(){
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                System.out.print(maze[i][j]+" ");
            }
            System.out.println("");
        }
    }
    private void generateMaze(int cx, int cy) {
        DIR[] dirs = DIR.values();
        Collections.shuffle(Arrays.asList(dirs));
        for (DIR dir : dirs) {
            int nx = cx + dir.dx;
            int ny = cy + dir.dy;
            if (between(nx, x) && between(ny, y) && (maze[nx][ny] == 0)) {
                maze[cx][cy] |= dir.bit;
                maze[nx][ny] |= dir.opposite.bit;
                generateMaze(nx, ny);
            }
        }
    }

    private static boolean between(int v, int upper) {
        return (v >= 0) && (v < upper);
    }
    
    @Override
    public void build(int x, int y){
        this.x = x;
        this.y = y;
        maze = new int[this.x][this.y];
        generateMaze(0, 0);
    }

    @Override
    public int[][] getMaze() {
        return maze;
    }
    
    

    private enum DIR {
        N(1, 0, -1), S(2, 0, 1), E(4, 1, 0), W(8, -1, 0);
        private final int bit;
        private final int dx;
        private final int dy;
        private DIR opposite;

        // use the static initializer to resolve forward references
        static {
            N.opposite = S;
            S.opposite = N;
            E.opposite = W;
            W.opposite = E;
        }

        private DIR(int bit, int dx, int dy) {
            this.bit = bit;
            this.dx = dx;
            this.dy = dy;
        }
    };
}