/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blindway.entities;

/**
 *
 * @author 2107262
 */
public class Invitacion {
    private boolean decision;
    private Usuario creador;
    private Usuario destino;
    private Sala sala;
    public Invitacion(Usuario creador, Usuario destino, Sala sala) {
        this.creador = creador;
        this.destino = destino;
        this.sala = sala;
        this.decision=false;
    }

    /**
     * @return the decision
     */
    public boolean isDecision() {
        return decision;
    }

    /**
     * @param decision the decision to set
     */
    public void setDecision(boolean decision) {
        this.decision = decision;
    }

    /**
     * @return the creador
     */
    public Usuario getCreador() {
        return creador;
    }

    /**
     * @param creador the creador to set
     */
    public void setCreador(Usuario creador) {
        this.creador = creador;
    }

    /**
     * @return the destino
     */
    public Usuario getDestino() {
        return destino;
    }

    /**
     * @param destino the destino to set
     */
    public void setDestino(Usuario destino) {
        this.destino = destino;
    }

    /**
     * @return the sala
     */
    public Sala getSala() {
        return sala;
    }

    /**
     * @param sala the sala to set
     */
    public void setSala(Sala sala) {
        this.sala = sala;
    }
    
}
