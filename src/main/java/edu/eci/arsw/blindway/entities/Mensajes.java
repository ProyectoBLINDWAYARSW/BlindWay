/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blindway.entities;

import javax.swing.JOptionPane;

/**
 *
 * @author 2107262
 */
public class Mensajes {
    
     public static void mostrarMensaje(String mensaje, String titulo)
    {
        JOptionPane.showMessageDialog(null, mensaje,titulo, JOptionPane.INFORMATION_MESSAGE);
    }
}

