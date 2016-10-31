package edu.eci.arsw.blindway.entities;

import java.util.List;

public class Sala {

	private Usuario jugador1;

	private Usuario jugador2;

	private List<Usuario> expulsados;

	private String contraseña;

	public void invitacionGlobal() {

	}

	public void InvitacionAmigos() {

	}
        
        public void InvitacionAmigo(Usuario amigo) {

	}
        
        public boolean ingresarSala(Usuario jugador){
            boolean verificacion=false;
            if(jugador2==null){
                if(!expulsados.contains(jugador)){
                    jugador2=jugador;
                    verificacion=true;
                }
            }
            return verificacion;
        }

}
