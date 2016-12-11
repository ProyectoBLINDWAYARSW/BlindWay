/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function Usuarios(){
       this.registrados = [];
}

Usuarios.prototype.agregarUsuario= function(usuario){
    this.registrados.push(usuarios);
};
function Salas(){
    this.salasDisponibles = []
}
Salas.prototype.agregarSala=function(sala){
    this.salasDisponibles.push(sala);
}
function Usuario(nombre, edad, genero,nick, pass, correo){
    this.nombre=nombre;
    this.edad =edad;
    this.genero = genero;
    this.nick = nick;
    this.pass = pass;
    this.correo = correo;    
}
function Sala(id, jugador1, jugador2, expulsados, contrasena){
    this.id=id;
    this.jugador1=jugador1;
    this.jugador2=jugador2;
    this.expulsados=expulsados;
    this.contrasena=contrasena;
}
function Carro(x,y,direccion){
    this.x=x;
    this.y=y;
    this.direccion=direccion;
}
$(document).ready(
        function () {
        }
);