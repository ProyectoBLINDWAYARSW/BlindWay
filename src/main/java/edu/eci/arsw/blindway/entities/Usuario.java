package edu.eci.arsw.blindway.entities;


import java.util.List;

public class Usuario {

    private String nombre;

    private int edad;

    private String genero;

    private String nickname;

    private String contraseña;

    private String correoElectronico;

    private List<Usuario> bloqueados;

    private List<Usuario> amigos;
        
    private List<Integer> estadisticas;
    
    private List<Invitacion> invitaciones;
    
    private boolean conectado;
    
    public Usuario(String nombre, int edad, String genero, String nickname, String contraseña, String correoElectronico) {
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.nickname = nickname;
        this.contraseña = contraseña;
        this.correoElectronico = correoElectronico;
        this.conectado=false;
    }
    
    @Override
    public String toString(){
        return this.getNombre() + ", " + this.getNickname() + ", " + this.getCorreoElectronico();
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * @return the nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname the nickname to set
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
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
     * @return the correoElectronico
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * @param correoElectronico the correoElectronico to set
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    /**
     * @return the bloqueados
     */
    public List<Usuario> getBloqueados() {
        return bloqueados;
    }

    /**
     * @param bloqueados the bloqueados to set
     */
    public void setBloqueados(List<Usuario> bloqueados) {
        this.bloqueados = bloqueados;
    }

    /**
     * @return the amigos
     */
    public List<Usuario> getAmigos() {
        return amigos;
    }

    /**
     * @param amigos the amigos to set
     */
    public void setAmigos(List<Usuario> amigos) {
        this.amigos = amigos;
    }

    /**
     * @return the estadisticas
     */
    public List<Integer> getEstadisticas() {
        return estadisticas;
    }

    /**
     * @param estadisticas the estadisticas to set
     */
    public void setEstadisticas(List<Integer> estadisticas) {
        this.estadisticas = estadisticas;
    }

    /**
     * @return the conectado
     */
    public boolean isConectado() {
        return conectado;
    }

    /**
     * @param conectado the conectado to set
     */
    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }
    
    public void bloquearUsuario(Usuario bloquear) {
        this.bloqueados.add(bloquear);
    }
    
    public void desbloquearUsuario(Usuario bloquear) {
        if(this.bloqueados.contains(bloquear)){
            this.bloqueados.remove(bloquear);
        }
    }
    public void añadirInvitacion(Invitacion i){
        this.invitaciones.add(i);
        //Mostrar invitación
    }
    
}