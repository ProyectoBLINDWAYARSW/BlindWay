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
    @Test
    public void primerTest(){
        try{
            StubUsuario.getInstance().registroUsuario("Leonardo Herrera",20,"Masculino","Saiga","contraseña123","leonardo.ft3@gmail.com");
            Usuario u=StubUsuario.getInstance().cargarUsuarioPorNick("Saiga");
            int id = StubSala.getInstance().crearSala(u);
            StubUsuario.getInstance().vaciarUsuarios();
            Sala s = StubSala.getInstance().obtenerSala(id);
            String sala=s.toString();
            StubSala.getInstance().vaciarSalas();
            assertEquals("Error en la creación de una sala sin contraseña (1)","Saiga, null, null",sala);
        }catch(Exception ex){
            StubUsuario.getInstance().vaciarUsuarios();
            StubSala.getInstance().vaciarSalas();
            fail("Error en la creacion de sala (1): " + ex.getMessage());
        }
        
    }
    //2. Permitir a un usuario unirse a una sala existente que no contenga un segundo jugador ni contraseña
    @Test
    public void segundoTest(){
        try{
            StubUsuario.getInstance().registroUsuario("Leonardo Herrera",20,"Masculino","Saiga","contraseña123","leonardo.ft3@gmail.com");
            StubUsuario.getInstance().registroUsuario("Hugo Alvares",18,"Masculino","masterHugo","contraseña154","hugo@gmail.com");
            Usuario jugador1=StubUsuario.getInstance().cargarUsuarioPorNick("Saiga");
            Usuario jugador2=StubUsuario.getInstance().cargarUsuarioPorNick("masterHugo");
            int id = StubSala.getInstance().crearSala(jugador1);
            StubSala.getInstance().ingresarSala(id,jugador2,"");
            String sala = StubSala.getInstance().obtenerSala(id).toString();
            StubUsuario.getInstance().vaciarUsuarios();
            StubSala.getInstance().vaciarSalas();
            assertEquals("Error al ingresar a una sala sin contraseña ni segundo jugador(2)","Saiga, masterHugo, null",sala);
        }catch(Exception ex){
            StubUsuario.getInstance().vaciarUsuarios();
            StubSala.getInstance().vaciarSalas();
            fail("Error en el ingreso a sala (2): " + ex.getMessage());
        }
        
    }
    //3. Permitir a un usuario unirse a una sala existente que no contenga un segundo jugador pero si contraseña
    @Test
    public void tercerTest(){
        try{
            StubUsuario.getInstance().registroUsuario("Leonardo Herrera",20,"Masculino","Saiga","contraseña123","leonardo.ft3@gmail.com");
            StubUsuario.getInstance().registroUsuario("Hugo Alvares",18,"Masculino","masterHugo","contraseña154","hugo@gmail.com");
            Usuario jugador1=StubUsuario.getInstance().cargarUsuarioPorNick("Saiga");
            Usuario jugador2=StubUsuario.getInstance().cargarUsuarioPorNick("masterHugo");
            int id = StubSala.getInstance().crearSala(jugador1,"contraseña");
            StubSala.getInstance().ingresarSala(id,jugador2,"contraseña");
            String sala = StubSala.getInstance().obtenerSala(id).toString();
            StubUsuario.getInstance().vaciarUsuarios();
            StubSala.getInstance().vaciarSalas();
            assertEquals("Error al ingresar a una sala con contraseña sin segundo jugador(3)","Saiga, masterHugo, contraseña",sala);
        }catch(Exception ex){
            StubUsuario.getInstance().vaciarUsuarios();
            StubSala.getInstance().vaciarSalas();
            fail("Error en el ingreso a sala (3): " + ex.getMessage());
        }    
    }
    //4. No permitir a un usuario unirse a una sala existente que contenga un segundo jugador
    @Test
    public void cuartoTest(){
        try{
            StubUsuario.getInstance().registroUsuario("Leonardo Herrera",20,"Masculino","Saiga","contraseña123","leonardo.ft3@gmail.com");
            StubUsuario.getInstance().registroUsuario("Hugo Alvares",18,"Masculino","masterHugo","contraseña154","hugo@gmail.com");
            StubUsuario.getInstance().registroUsuario("Stefany",21,"Femenino","Stefany288","contraseña182","stefany@gmail.com");
            Usuario jugador1=StubUsuario.getInstance().cargarUsuarioPorNick("Saiga");
            Usuario jugador2=StubUsuario.getInstance().cargarUsuarioPorNick("masterHugo");
            Usuario jugador3=StubUsuario.getInstance().cargarUsuarioPorNick("Stefany288");
            int id = StubSala.getInstance().crearSala(jugador1,"contraseña");
            StubSala.getInstance().ingresarSala(id,jugador2,"contraseña");
            StubSala.getInstance().ingresarSala(id,jugador3,"contraseña");
            StubUsuario.getInstance().vaciarUsuarios();
            StubSala.getInstance().vaciarSalas();
            fail("Error, permitio ingrersar mas de 1 usuario a una sala (4)");
        }catch(Exception ex){
            StubUsuario.getInstance().vaciarUsuarios();
            StubSala.getInstance().vaciarSalas();
            assertEquals("Error al ingresar a una sala con segundo jugador(4)","No fue posible ingresar al jugador a la sala seleccionada.",ex.getMessage());
            
        }
    }   
    //5. No permitir a un usuario unirse a una sala si tiene una contraseña incorrecta
    @Test
    public void quintoTest(){
        try{
            StubUsuario.getInstance().registroUsuario("Leonardo Herrera",20,"Masculino","Saiga","contraseña123","leonardo.ft3@gmail.com");
            StubUsuario.getInstance().registroUsuario("Hugo Alvares",18,"Masculino","masterHugo","contraseña154","hugo@gmail.com");
            Usuario jugador1=StubUsuario.getInstance().cargarUsuarioPorNick("Saiga");
            Usuario jugador2=StubUsuario.getInstance().cargarUsuarioPorNick("masterHugo");
            int id = StubSala.getInstance().crearSala(jugador1,"contraseña");
            StubSala.getInstance().ingresarSala(id,jugador2,"contra");
            StubUsuario.getInstance().vaciarUsuarios();
            StubSala.getInstance().vaciarSalas();
            fail("Error, permitio ingrersar a un usuario con contraseña incorrecta (5)");
        }catch(Exception ex){
            StubUsuario.getInstance().vaciarUsuarios();
            StubSala.getInstance().vaciarSalas();
            assertEquals("Error al ingresar a una sala con contraseña incorrecta(5)","No fue posible ingresar al jugador a la sala seleccionada.",ex.getMessage());
            
        }
    }
    //6. No permitir a un usuario unirse a una sala inexistente
    @Test
    public void sextoTest(){
        try{
            StubUsuario.getInstance().registroUsuario("Leonardo Herrera",20,"Masculino","Saiga","contraseña123","leonardo.ft3@gmail.com");
            StubUsuario.getInstance().registroUsuario("Hugo Alvares",18,"Masculino","masterHugo","contraseña154","hugo@gmail.com");
            Usuario jugador1=StubUsuario.getInstance().cargarUsuarioPorNick("Saiga");
            Usuario jugador2=StubUsuario.getInstance().cargarUsuarioPorNick("masterHugo");
            int id = StubSala.getInstance().crearSala(jugador1,"contraseña");
            StubSala.getInstance().ingresarSala(id+1,jugador2,"contra");
            StubUsuario.getInstance().vaciarUsuarios();
            StubSala.getInstance().vaciarSalas();
            fail("Error, permitio ingrersar a un usuario a una slaa inexistente (6)");
        }catch(Exception ex){
            StubUsuario.getInstance().vaciarUsuarios();
            StubSala.getInstance().vaciarSalas();
            assertEquals("Error al dejar ingresar a una sala inexistente(6)","La sala no fue encontrada.",ex.getMessage());
            
        }
    }
}