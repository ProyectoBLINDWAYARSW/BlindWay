/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blindway.test;

import edu.eci.arsw.blindway.entities.BlindWayException;
import edu.eci.arsw.blindway.entities.Carro;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 *
 * @author Hugo Alvarez
 */
public class CarroTest {
    @Test
    public void CE1DeberiaMoverElCarroALaIzquierda(){
        try{
            Carro c = new Carro(10, 10, "");
            c.moverseX(-5);
            assertEquals("No se movio debidamente en la prueba CE1DeberiaMoverElCarroALaIzquierda",5, c.getX());
        }catch(BlindWayException ex){
            fail("Error en la creacion del carro test 1: " + ex.getMessage());
        }
    }
    @Test
    public void CE2DeberiaMoverElCarroALaDerecha(){
        try{
            Carro c = new Carro(10, 10, "");
            c.moverseX(5);
            assertEquals("No se movio debidamente en la prueba CE2DeberiaMoverElCarroALaDerecha",15, c.getX());
        }catch(BlindWayException ex){
            fail("Error en la creacion del carro test 2: " + ex.getMessage());
        }
    }
    @Test
    public void CE3DeberiaMoverElCarroArriba(){
        try{
            Carro c = new Carro(10, 10, "");
            c.moverseY(-5);
            assertEquals("No se movio debidamente en la prueba CE3DeberiaMoverElCarroArriba",5, c.getY());
        }catch(BlindWayException ex){
            fail("Error en la creacion del carro test 3: " + ex.getMessage());
        }
    }
    @Test
    public void CE4DeberiaMoverElCarroAbajo(){
        try{
            Carro c = new Carro(10, 10, "");
            c.moverseY(5);
            assertEquals("No se movio debidamente en la prueba CE4DeberiaMoverElCarroAbajo",15, c.getY());
        }catch(BlindWayException ex){
            fail("Error en la creacion del carro test 4: " + ex.getMessage());
        }
    }
    @Test
    public void CE5NoDeberiaCrearUnCarro(){
        try{
            Carro c = new Carro(-1, 10, "");
            fail("No debio haber creado el carro");
        }catch(BlindWayException ex){
            assertEquals("No lanzo la excepcion esperada en la prueba CE5NoDeberiaCrearUnCarro",ex.getMessage(), "El carro no puede estar ubicado en una posicion con coordenadas negativas");
        }
    }
}
