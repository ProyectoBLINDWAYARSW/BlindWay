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

}
