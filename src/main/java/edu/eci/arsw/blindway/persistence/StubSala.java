/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blindway.persistence;

import edu.eci.arsw.blindway.entities.Sala;
import edu.eci.arsw.blindway.entities.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 2107262
 */
public class StubSala {
    
    private static int id = 0;
    
    private static StubSala instance;
    
    private static ArrayList<Sala> salasActuales = new ArrayList<Sala>();

    private StubSala() {
        
    }
    
    public static StubSala getInstance() {
        if(instance==null){
            instance = new StubSala();
        }
        return instance;
    }
    public void eliminarSala(Sala sala){
            if(salasActuales.contains(sala)){
                salasActuales.remove(sala);
            }
    }
    public int crearSala(Usuario u, String contraseña) throws CreacionSalaException{
        for(Sala s: salasActuales){
            if (s.getJugador1().getNickname().equals(u.getNickname()) || s.getJugador2().getNickname().equals(u.getNickname())){
                throw new CreacionSalaException("El jugador ya se encuentra en una sala, no puede estar en otra.");
            }
        }
        Sala sala = new Sala(u,contraseña, id);
        id+=1;
        salasActuales.add(sala);
        return id-1;
    }

    public int crearSala(Usuario u) throws CreacionSalaException {
        synchronized(instance){
            for(Sala s: salasActuales){
                if (s.getJugador1().getNickname().equals(u.getNickname()) || s.getJugador2().getNickname().equals(u.getNickname())){
                    throw new CreacionSalaException("El jugador ya se encuentra en una sala, no puede estar en otra.");
                }
            }
        }
        Sala sala = new Sala(u,"", id);
        id+=1;
        salasActuales.add(sala);
        return id-1;
    }

    public void ingresarSala(int id, Usuario jugador2, String contraseña) throws CreacionSalaException {
        Sala s = null;
        for(Sala sala:salasActuales){
            if(sala.getId()==id){
                s=sala;
            }
        }
        if(s!=null){
            synchronized(instance){
                if(!s.ingresarSala(jugador2, contraseña)){
                    throw new CreacionSalaException("No fue posible ingresar al jugador a la sala seleccionada.");
                }
            }   
        }
        else{
            throw new CreacionSalaException("La sala no fue encontrada.");
        }
    }

    public Sala obtenerSala(int id) throws CreacionSalaException {
        Sala s = null;
        for(Sala sala:salasActuales){
            if(sala.getId()==id){
                s=sala;           
            }
        }  
        if(s==null){
            throw new CreacionSalaException("Sala no encontrada.");
        }
        return s;
    }

    public void vaciarSalas() {
        salasActuales.clear();
    }

    public ArrayList<Sala> obtenerSalas() {
        return salasActuales;
    }
}
