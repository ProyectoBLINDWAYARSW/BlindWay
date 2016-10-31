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
            if(getJugador2()==null){
                if(!expulsados.contains(jugador) && !jugador1.getBloqueados().contains(jugador)){
                    setJugador2(jugador);
                    verificacion=true;
                }
            }
            return verificacion;
        }

    /**
     * @return the jugador1
     */
    public Usuario getJugador1() {
        return jugador1;
    }

    /**
     * @param jugador1 the jugador1 to set
     */
    public void setJugador1(Usuario jugador1) {
        this.jugador1 = jugador1;
    }

    /**
     * @return the jugador2
     */
    public Usuario getJugador2() {
        return jugador2;
    }

    /**
     * @param jugador2 the jugador2 to set
     */
    public void setJugador2(Usuario jugador2) {
        this.jugador2 = jugador2;
    }

    /**
     * @return the expulsados
     */
    public List<Usuario> getExpulsados() {
        return expulsados;
    }

    /**
     * @param expulsados the expulsados to set
     */
    public void setExpulsados(List<Usuario> expulsados) {
        this.expulsados = expulsados;
    }

    /**
     * @return the contraseña
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * @param contraseña the contraseña to set
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

}
