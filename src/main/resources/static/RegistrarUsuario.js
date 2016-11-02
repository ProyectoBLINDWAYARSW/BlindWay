/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

registrados = [];

function datosResgistrarUsuario(){
   var datos=Array();
    var nombre = $("#nombre").val();
    var edad = $("#edad").val();
    var f = $("#f").val();
    var m = $("#m").val();
    var nick= $("#nick").val();
    var password=$("#pass").val();
    var correoElectronico = $("#CorreoElectronico").val();
    var genero = "no definio genero";
    
    if($("#f").is(':checked')) {  
         genero = "f";
        } else {  
         genero = "m";
        }  
    datos["nombre"]=nombre;
    datos["edad"]=edad;
    datos["genero"]= genero;
    datos["nick"]=nick;
    datos["password"]= password; 
    datos["correoElectronico"]= correoElectronico;
    
    //datos[]=(f=="")?"m":"f";
    registrados.push(datos);
}

