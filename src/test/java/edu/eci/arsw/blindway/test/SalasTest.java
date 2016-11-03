/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blindway.test;

import edu.eci.arsw.blindway.entities.Sala;
import edu.eci.arsw.blindway.entities.Usuario;
import edu.eci.arsw.blindway.persistence.StubSala;
import edu.eci.arsw.blindway.persistence.StubUsuario;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 *
 * @author 2107262
 */
public class SalasTest {
    
    
    /*
    Clase utilizada para comprobar el funcionamiento correcto de creación, ingreso y metodos de las salas.
    */
    //1. Permitir a un usuario crear una sala sin contraseña
    //@Test
    public void primerTest(){
        try{
            StubUsuario.getInstance().registroUsuario("Leonardo Herrera",20,"Masculino","Saiga","contraseña123","leonardo.ft3@gmail.com");
            Usuario u=StubUsuario.getInstance().cargarUsuarioPorNick("Saiga");
            int id = StubSala.getInstance().crearSala(u);
            System.out.println(id);
            StubUsuario.getInstance().vaciarUsuarios();
            String sala=StubSala.getInstance().obtenerSala(id).toString();
            assertEquals("Error en la creación de una sala sin contraseña (1)","Saiga, null, null",sala);
        }catch(Exception ex){
            StubUsuario.getInstance().vaciarUsuarios();
            fail("Error en la creacion de sala: " + ex.getMessage());
        }
        
    }
    //2. Permitir a un usuario unirse a una sala existente que no contenga un segundo jugador ni contraseña
    //@Test
    public void segundoTest(){
        try{
            StubUsuario.getInstance().registroUsuario("Leonardo Herrera",20,"Masculino","Saiga","contraseña123","leonardo.ft3@gmail.com");
            StubUsuario.getInstance().registroUsuario("Hugo Alvares",18,"Masculino","masterHugo","contraseña154","hugo@gmail.com");
            Usuario jugador1=StubUsuario.getInstance().cargarUsuarioPorNick("Saiga");
            Usuario jugador2=StubUsuario.getInstance().cargarUsuarioPorNick("masterHugo");
            int id = StubSala.getInstance().crearSala(jugador1);
            StubSala.getInstance().ingresarSala(id,jugador2,null);
            StubUsuario.getInstance().vaciarUsuarios();
            assertEquals("Error al ingresar a una sala sin contraseña ni segundo jugador(2)","Saiga, masterHugo, null",StubSala.getInstance().obtenerSala(id).toString());
        }catch(Exception ex){
            StubUsuario.getInstance().vaciarUsuarios();
            fail("Error en el ingreso a sala: " + ex.getMessage());
        }
        
    }
}