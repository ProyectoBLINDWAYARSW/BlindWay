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


function Usuario(nombre, edad, genero,nick, pass, correo){
    this.nombre=nombre;
    this.edad =edad;
    this.genero = genero;
    this.nick = nick;
    this.pass = pass;
    this.correo = correo;    
}