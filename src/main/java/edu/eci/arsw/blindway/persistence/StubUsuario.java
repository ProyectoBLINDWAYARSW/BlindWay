/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blindway.persistence;

import edu.eci.arsw.blindway.entities.Usuario;
import java.util.ArrayList;

/**
 *
 * @author 2107262
 */
public class StubUsuario {
    
    private static StubUsuario instance;
    
    private static ArrayList<Usuario> usuarios = new ArrayList();
    
    private static ArrayList<Usuario> conectados = new ArrayList();

    private StubUsuario() {
        
    }
    
    public static StubUsuario getInstance() {
        if(instance==null){
            instance = new StubUsuario();
        }
        return instance;
    }
    public ArrayList<Usuario> usuariosConectados(){
        return conectados;
    }

    public void registroUsuario(String nombre, int edad, String genero, String nickname, String contraseña, String correo) throws RegistroUsuarioException {
        int contNick=0;
        int contCorreo=0;
        boolean contra =true;
        if(contraseña.length()<6){
                contra = false;
        }
        synchronized(instance){
            for(Usuario u:usuarios){
                if(u.getNickname().equals(nickname)){
                    contNick=1;
                }
                if(u.getCorreoElectronico().equals(correo)){
                    contCorreo=1;
                }
            }
            if(contNick==0 && contCorreo==0 && contra){
                Usuario u = new Usuario(nombre,edad,genero,nickname,contraseña,correo);
                usuarios.add(u);
            }
            else if(contNick==1 && contCorreo==0){
                throw new RegistroUsuarioException("Nickname ya se encuentra en uso.");
            }
            else if (contCorreo==1 && contNick==0){
                throw new RegistroUsuarioException("Correo ya se encuentra en uso.");
            }
            else if (contCorreo==1 && contNick==1){
                throw new RegistroUsuarioException("Correo y Nickname ya se encuentran en uso.");
            }
            else if (!contra){
                throw new RegistroUsuarioException("La contraseña debe de tener minimo 6 caracteres.");
            }
            else{           
                throw new RegistroUsuarioException("Error al crear un usuario.");
            }
        }
        
        
    }

    public Usuario cargarUsuarioPorNick(String nick) throws RegistroUsuarioException {
        Usuario u = null;
        for(Usuario us: usuarios){
            if(us.getNickname().equals(nick)){
                u=us;
            }
        }
        if (u==null){
            throw new RegistroUsuarioException("Usuario con nick pedido no existe.");
        }
        return u;
    }
    public boolean cargarUsuarioLogeado(String nick, String contrasena) throws RegistroUsuarioException {
        boolean u = false;
        for(Usuario us: usuarios){
            if(us.getNickname().equals(nick)){
                if(us.getContrasena().equals(contrasena)){
                    u=true;
                }
            }
        }
        if (!u){
            throw new RegistroUsuarioException("Usuario inexistente.");
        }
        return u;
    }

    public void vaciarUsuarios() {
       usuarios.clear();
    }
    public void cargarUsuariosEstaticos(){
        Usuario u = new Usuario("Usuario Prueba",20,"Masculino","Admin","admin123","admin@gmail.com");
        usuarios.add(u);   
    }
}
