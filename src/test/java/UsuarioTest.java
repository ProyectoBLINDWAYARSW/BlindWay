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
    //@Test
    public void primerTest(){
        //Creación de usuario
        /*BeanUsuario registrar = new BeanUsuario();
        try{
            registrar.registroUsuario("Leonardo Herrera",20,"Masculino","Saiga","contraseña123","leonardo.ft3@gmail.com");
            assertEquals("Error en el registro de un usuario con nickname unico (1)","Leonardo Herrera, Saiga, leonardo.ft3@gmail.com",registrar.cargarUsuarioPorNick("Saiga").toString());
        }catch(Exception ex){
            System.out.println("Error en la creacion de usuario: " + ex.getMessage());
        }
        */
    }
    //2. No permitir crear un usuario con un nickname encontrado en la base de datos
    //@Test
    public void segundoTest(){
        //Creación de usuario
        /*BeanUsuario registrar = new BeanUsuario();
        try{
            registrar.registroUsuario("Leonardo Herrera",20,"Masculino","Saiga","contraseña123","leonardo.ft3@gmail.com");
            registrar.registroUsuario("Santiago Prado",16,"Masculino","Saiga","contraseña123","algo@gmail.com");
            assertEquals("Error en el registro de un usuario con nickname repetido, permitio el registro (2)",true,false);
        }catch(Exception ex){
            System.out.println("Error en la creacion de usuario: " + ex.getMessage());
        }
        */
    }
    //3. No permitir crear un usuario con un nickname no encontrado en la base de datos pero con un correo repetido
    //@Test
    public void tercerTest(){
        //Creación de usuario
        /*BeanUsuario registrar = new BeanUsuario();
        try{
            registrar.registroUsuario("Leonardo Herrera",20,"Masculino","Saiga","contraseña123","leonardo.ft3@gmail.com");
            registrar.registroUsuario("Santiago Prado",16,"Masculino","Leo","contraseña123","leonardo.ft3@gmail.com");
            assertEquals("Error en el registro de usuario con nickname único pero con correo repetido (3)",true,false);
        }catch(Exception ex){
            System.out.println("Error en la creacion de usuario: " + ex.getMessage());
        }
        */
    }
    //4. No permitir crear un usuario con un nickname encontrado en la base de datos y con un correo repetido
    //@Test
    public void cuartoTest(){
        //Creación de usuario
        /*BeanUsuario registrar = new BeanUsuario();
        try{
            registrar.registroUsuario("Leonardo Herrera",20,"Masculino","Saiga","contraseña123","leonardo.ft3@gmail.com");
            registrar.registroUsuario("Santiago Prado",16,"Masculino","Saiga","contraseña123","leonardo.ft3@gmail.com");
            assertEquals("Error en el registro de usuario con nickname repetido y con correo repetido (4)",true,false);
        }catch(Exception ex){
            System.out.println("Error en la creacion de usuario: " + ex.getMessage());
        }
        */
    }
    //5. No permitir crear un usuario con una contraseña menor a 6 caracteres
    //@Test
    public void quintoTest(){
        //Creación de usuario
        /*BeanUsuario registrar = new BeanUsuario();
        try{
            registrar.registroUsuario("Leonardo Herrera",20,"Masculino","Saiga","123","leonardo.ft3@gmail.com");
            assertEquals("Error en el registro de usuario con contraseña de longitud menor a 6 (5)",true,false);
        }catch(Exception ex){
            System.out.println("Error en la creacion de usuario: " + ex.getMessage());
        }
        */
    }
    //1. Consultar alguno de los usuarios ya existentes en la base de datos
    //@Test
    public void primerConsultarTest(){
        /*try{
            assertEquals("Error en la consulta de un usuario existente (1)","Usuario Prueba, Admin, admin@gmail.com",StubUsuarios.getInstance().cargarUsuarioPorNick("Admin").toString());
        }catch(Exception ex){
            System.out.println("Error en la creacion de usuario: " + ex.getMessage());
        }
        */
    }
    //2. Consultar algun usuario no existentes en la base de datos
    //@Test
    public void segundoConsultarTest(){
        /*try{
            Usuario prueba = StubUsuarios.getInstance().cargarUsuarioPorNick("Admon"); 
            assertEquals("Error en la consulta de un usuario no existente (2)","Usuario Prueba, Admin, admin@gmail.com",StubUsuarios.getInstance().cargarUsuarioPorNick("Admon").toString());
        }catch(Exception ex){
            System.out.println("Error en la creacion de usuario: " + ex.getMessage());
        }
        */
    }
}
