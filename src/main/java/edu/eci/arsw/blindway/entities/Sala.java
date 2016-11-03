package edu.eci.arsw.blindway.entities;

import edu.eci.arsw.blindway.persistence.StubUsuario;
import java.util.List;

public class Sala {

        private int id;
    
	private Usuario jugador1;

	private Usuario jugador2;

	private List<Usuario> expulsados;

	private String contraseña;
        
        private StubUsuario dataUsuario = StubUsuario.getInstance();       
        
        public Sala(Usuario jugador1, String contraseña, int id) {
            this.jugador1 = jugador1;
            this.contraseña = contraseña;
            this.id=id;
        }
        
        @Override
        public String toString(){
            return this.jugador1.getNickname() + ", " + this.jugador2.getNickname() + ", " + this.contraseña;
        }
        
	public void invitacionGlobal() {
                for(Usuario u:dataUsuario.usuariosConectados()){
                    Invitacion i = new Invitacion(jugador1,u,this);
                    //enviar invitación
                }
	}

	public void InvitacionAmigos() {
                for(Usuario u:jugador1.getAmigos()){
                    //A cada amigo conectado que tenga el usuario 1(dueño de la sala se le envia una invitación)
                    if(u.isConectado()){
                        Invitacion i = new Invitacion(jugador1,u,this);
                        //enviar invitación
                    }
                }
	}
        
        public void InvitacionAmigo(Usuario amigo) {
                if(amigo.isConectado()){
                    Invitacion i = new Invitacion(jugador1,amigo,this);
                    //enviar invitación
                }
                else{
                    //Mensajes.mostrarMensaje("El usuario no se encuentra conectado.", "Error al invitar a " + amigo.getNickname() + ":");
                }
	}
        
        public boolean ingresarSala(Usuario jugador, String contraseña){
            boolean verificacion=false;
            if(getJugador2()==null){
                if(contraseña.equals(this.contraseña)){
                    if(!expulsados.contains(jugador) && !jugador1.getBloqueados().contains(jugador)){
                        setJugador2(jugador);
                        verificacion=true;
                    }
                }
                else{
                    //Mensajes.mostrarMensaje("Contraseña incorrecta.", "Error al ingresar a la sala:");
                }                
            }
            return verificacion;
        }
        public void expulsarJugadorSala(){
            if(jugador2!=null){
                //Mensajes.mostrarMensaje("El jugador "+jugador2.getNickname()+" a sido expulsado de la sala.", "Expulsion de jugador:");
                expulsados.add(jugador2);
                jugador2=null;
            }
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

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

}