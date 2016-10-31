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
    public static StubUsuario instance;
    public static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    public static ArrayList<Usuario> conectados = new ArrayList<Usuario>();
    public static StubUsuario getInstance() {
        if(instance==null){
            instance = new StubUsuario();
        }
        return instance;
    }

    public void registroUsuario(String nombre, int edad, String genero, String nickname, String contraseña, String correo) throws RegistroUsuarioException {
        int cont=0;
        boolean contra =true;
        for(Usuario u:usuarios){
            if(u.getNickname().equals(nickname)){
                cont=1;
            }
            else if(u.getCorreoElectronico().equals(correo)){
                cont=2;
            }
        }
        if(contraseña.length()<6){
            contra = false;
        }
        if(cont==0 && contra){
            Usuario u = new Usuario(nombre,edad,genero,nickname,contraseña,correo);
            usuarios.add(u);
        }
        else if(cont==1){
            throw new RegistroUsuarioException("Nickname ya se encuentra en uso.");
        }
        else if (cont==2){
            throw new RegistroUsuarioException("Correo ya se encuentra en uso.");
        }
        else if (!contra){
            throw new RegistroUsuarioException("La contraseña debe de tener minimo 6 caracteres.");
        }
        else{           
            throw new RegistroUsuarioException("Error al crear un usuario.");
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

    public void vaciarUsuarios() {
       usuarios.clear();
    }
    public void cargarUsuariosEstaticos(){
        usuarios.clear();
        Usuario u = new Usuario("Usuario Prueba",20,"Masculino","Admin","admin123","admin@gmail.com");
        usuarios.add(u);   
    }



    
}
