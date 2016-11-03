package edu.eci.arsw.blindway.test;


import edu.eci.arsw.blindway.entities.Usuario;
import edu.eci.arsw.blindway.persistence.StubUsuario;
import static org.junit.Assert.*;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hugo Alvarez
 */
public class UsuarioTest {
    
    /*
    Clase utilizada para comprobar el funcionamiento correcto de registro de usuarios y consultar usuarios
    */
    //1. Permitir crear un usuario con un nickname no encontrado en la base de datos
    @Test
    public void primerTest(){
        try{
            StubUsuario.getInstance().registroUsuario("Leonardo Herrera",20,"Masculino","Saiga","contraseña123","leonardo.ft3@gmail.com");
            String u=StubUsuario.getInstance().cargarUsuarioPorNick("Saiga").toString();
            StubUsuario.getInstance().vaciarUsuarios();
            assertEquals("Error en el registro de un usuario con nickname unico (1)","Leonardo Herrera, Saiga, leonardo.ft3@gmail.com",u);
        }catch(Exception ex){
            System.out.println("Error en la creacion de usuario: " + ex.getMessage());
        }
        
    }
    //2. No permitir crear un usuario con un nickname encontrado en la base de datos
    @Test
    public void segundoTest(){
        //Creación de usuario
        try{
            StubUsuario.getInstance().registroUsuario("Leonardo Herrera",20,"Masculino","Saiga","contraseña123","leonardo.ft3@gmail.com");
            StubUsuario.getInstance().registroUsuario("Santiago Prado",16,"Masculino","Saiga","contraseña123","algo@gmail.com");
            StubUsuario.getInstance().vaciarUsuarios();
            fail("Error en el registro de un usuario con nickname repetido, permitio el registro (2)");
        }catch(Exception ex){
            StubUsuario.getInstance().vaciarUsuarios();
            assertEquals("Error al permitir crear un usuario con un nickname encontrado en la base de datos","Nickname ya se encuentra en uso.",ex.getMessage());
            
        }
        
    }
    //3. No permitir crear un usuario con un nickname no encontrado en la base de datos pero con un correo repetido
    @Test
    public void tercerTest(){
        //Creación de usuario
        try{
            StubUsuario.getInstance().registroUsuario("Leonardo Herrera",20,"Masculino","Saiga","contraseña123","leonardo.ft3@gmail.com");
            StubUsuario.getInstance().registroUsuario("Santiago Prado",16,"Masculino","Leo","contraseña123","leonardo.ft3@gmail.com");
            StubUsuario.getInstance().vaciarUsuarios();
            fail("Error en el registro de usuario con nickname único pero con correo repetido (3)");
        }catch(Exception ex){
            StubUsuario.getInstance().vaciarUsuarios();
            assertEquals("Error al permitir crear un usuario con un nickname no encontrado en la base de datos pero con un correo repetido ","Correo ya se encuentra en uso.",ex.getMessage());
        }
        
    }
    //4. No permitir crear un usuario con un nickname encontrado en la base de datos y con un correo repetido
    @Test
    public void cuartoTest(){

        try{
            StubUsuario.getInstance().registroUsuario("Leonardo Herrera",20,"Masculino","Saiga","contraseña123","leonardo.ft3@gmail.com");
            StubUsuario.getInstance().registroUsuario("Santiago Prado",16,"Masculino","Saiga","contraseña123","leonardo.ft3@gmail.com");
            StubUsuario.getInstance().vaciarUsuarios();
            fail("Error en el registro de usuario con nickname repetido y con correo repetido (4)");
        }catch(Exception ex){
            StubUsuario.getInstance().vaciarUsuarios();
            assertEquals("Error al crear un usuario con nickname encontrado en la base de datos y correo repetido","Correo y Nickname ya se encuentran en uso.",ex.getMessage());
        }

    }
    //5. No permitir crear un usuario con una contraseña menor a 6 caracteres
    @Test
    public void quintoTest(){
        
        try{
            StubUsuario.getInstance().registroUsuario("Leonardo Herrera",20,"Masculino","Saiga","123","leonardo.ft3@gmail.com");
            StubUsuario.getInstance().vaciarUsuarios();
            fail("Error en el registro de usuario con contraseña de longitud menor a 6 (5)");
        }catch(Exception ex){
            StubUsuario.getInstance().vaciarUsuarios();
            assertEquals("Error quintoTest, al permitir crear un usuario con una contraseña menor a 6 caracteres","La contraseña debe de tener minimo 6 caracteres.",ex.getMessage());                            
        }
    }
    //1. Consultar alguno de los usuarios ya existentes en la base de datos
    @Test
    public void primerConsultarTest(){
        try{
            StubUsuario.getInstance().cargarUsuariosEstaticos();
            String u = StubUsuario.getInstance().cargarUsuarioPorNick("Admin").toString();
            StubUsuario.getInstance().vaciarUsuarios();
            assertEquals("Error en la consulta de un usuario existente (1)","Usuario Prueba, Admin, admin@gmail.com",u);
        }catch(Exception ex){
            StubUsuario.getInstance().vaciarUsuarios();
            System.out.println("Error en la consulta de usuario test 1 : " + ex.getMessage());   
        }       
    }
    //2. Consultar algun usuario no existentes en la base de datos
    @Test
    public void segundoConsultarTest(){
        try{
            StubUsuario.getInstance().cargarUsuariosEstaticos();
            Usuario prueba = StubUsuario.getInstance().cargarUsuarioPorNick("Admon"); 
            StubUsuario.getInstance().vaciarUsuarios();
            fail("Error en la consulta de un usuario no existente (2)");
        }catch(Exception ex){
            StubUsuario.getInstance().vaciarUsuarios();
            assertEquals("Error al consultar un usuario no existentes en la base de datos","Usuario con nick pedido no existe.",ex.getMessage());    
        }
    }
}
