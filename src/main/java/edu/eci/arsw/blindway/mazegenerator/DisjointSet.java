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
public class DisjointSet {
    private int p[];
    private int rank[];
    private int n;
    public DisjointSet(int N){
        n = N;
        rank  = new int[N];
        p = new int[N];
        for (int i = 0; i < N; i++) {
            p[i]=i;
            rank[i]=0;
        }
    }
    int findSet(int i){
        if(p[i] == i) return i;
        else {
            p[i] = findSet(p[i]);
            return p[i];
        }
    }
    boolean isSameSet(int i, int j){
        return findSet(i)==findSet(j);
    }
    void unionSet(int i, int j){
        if(!isSameSet(i, j)){
            int x = findSet(i), y = findSet(j);
            if(rank[x] > rank[y]) p[y]=x;
            else{
                p[x]=y;
                if(rank[x] == rank[y]) rank[y]++;
            }
            n--;
        }
    }
    int numDisjointSets(){
        return n;
    }
    
}
