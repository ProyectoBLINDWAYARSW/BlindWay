/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blindway.persistence;

import edu.eci.arsw.blindway.entities.Sala;
import edu.eci.arsw.blindway.entities.Usuario;
import java.util.ArrayList;

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
            if (s.getJugador1()==u || s.getJugador2()==u){
                throw new CreacionSalaException("El jugador ya se encuentra en una sala, no puede estar en otra.");
            }
        }
        Sala sala = new Sala(u,contraseña, id);
        id+=1;
        salasActuales.add(sala);
        return id-1;
    }

    public int crearSala(Usuario u) throws CreacionSalaException {
        for(Sala s: salasActuales){
            if (s.getJugador1()==u || s.getJugador2()==u){
                throw new CreacionSalaException("El jugador ya se encuentra en una sala, no puede estar en otra.");
            }
        }
        
        Sala sala = new Sala(u,null, id);
        id+=1;
        System.out.println("No falla al crear "+ id);
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
            
            if(!s.ingresarSala(jugador2, contraseña)){
                System.out.println("Falla al ingresar"+ id);
                throw new CreacionSalaException("No fue posible ingresar al jugador a la sala seleccionada.");
            }
        }
    }

    public Sala obtenerSala(int id) throws CreacionSalaException {
        System.out.println("Entra a obtener");
        Sala s = null;
        for(Sala sala:salasActuales){
            System.out.println("sala id: "+ sala.getId());
            if(sala.getId()==id){
                s=sala;
            }
        }
        System.out.println("Falla al obtener sala");
        if(s==null){
            throw new CreacionSalaException("Sala no encontrada.");
        }
        return s;
    }
}
