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
    $("#contenido table").append("<tr><th>ID Sala</th><th>Nombre creador</th><th>Jugadores</th></tr>"); 
    $.get("http://localhost:8080/salas", function(data,status){  
        salasDisponibles = data;
        $("#contenido table").append("<tr><th>1</th><th>Emiya</th><th>2</th></tr>");
        for(i = 0; i < data.length; i++){
        $("#contenido table").append("<tr><th>1</th><th>Emiya</th><th>2</th></tr>");
        }
        
    });

};


$(document).ready(
    function () {
        $('tr').click(function() {
            $('.selected').removeClass('selected');
            $(this).addClass('selected');
        });

        $('#elegir').click(function() {    
            $('.selected').children().each(function() {
                alert($(this).html());
            });
        });
    }
);
