/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
salasDisponibles = [];

function enter(){
    window.location.href='sala.html';
}
refrescar = function () {

    //actualizar la presentación
    total=0;
    $("#contenido table").empty();
    $("#contenido table").append("<th>ID Sala</th><th>Nombre creador</th><th>Jugadores</th>"); 
    $.get("http://localhost:8080/salas", function(data,status){
        
        salasDisponibles = data;
        $("#contenido table").append("<th>ID Sala 1</th><th>Nombre Leonardo</th><th>Jugadores 2</th>");
        for(i = 0; i < data.length; i++){
        $("#contenido table").append("<th>ID Sala 1</th><th>Nombre Leonardo</th><th>Jugadores 2</th>");
        }
        
    });

};

$(document).ready(
    function () {
    }
);
