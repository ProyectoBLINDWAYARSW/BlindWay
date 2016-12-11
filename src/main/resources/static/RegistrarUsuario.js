/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var stompClient = null;
registrados = [];

function datosResgistrarUsuario(){
    //var datos=Array();
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
        } 
    else {  
         genero = "m";
        }  
    console.log("Recogio datos");
    //datos["nombre"]=nombre;
    //datos["edad"]=edad;
    //datos["genero"]= genero;
    //datos["nick"]=nick;
    //datos["password"]= password; 
    //datos["correoElectronico"]= correoElectronico;
    
    //datos[]=(f=="")?"m":"f";
    //registrados.push(datos);
    //stompClient.send("/app/usuario", {}, nombre+','+edad+','+genero+','+nick+','+password+','+correoElectronico);
     $.ajax({
            url: '/usuario',
            type: 'post',
            dataType: 'json',
            data:  'nombre='+nombre+'edad='+edad+'genero='+genero+'nickname='+nick+'contrasena='+password+'correoElectronico='+correoElectronico
        });
}
function connect() {
    var socket = new SockJS('/stompendpoint');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        
        console.log('Connected: ' + frame);

    });
}

