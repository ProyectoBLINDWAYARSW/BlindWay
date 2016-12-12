/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var salasDisponibles = new Salas();
sessionStorage.iden="";
function enter(){
    window.location.href='sala.html';
}
isObject = function(a) {
    return (!!a) && (a.constructor === Object);
};
isArray = function(a) {
    return (!!a) && (a.constructor === Array);
};
refrescar = function () {

    //actualizar la presentación
    total=0;
    $("#contenido table").empty();
    $("#contenido table").append("<tr><th>ID Sala</th><th>Nombre creador</th><th>Jugadores</th></tr>"); 
    $.get("/salas", function(data,status){
        console.log(data);
        var usu1 = null;
        var usu2 = null;
        var id = null;
        var expulsados = null;
        var cons = null;
        $.each(data,function(index,value){
            $.each(value,function(ind,val){
                console.log(ind + " "+ val);
                if(isObject(val) && !isArray(val)){
                    if(usu1===null){
                        usu1 = new Usuario(val.nombre,val.edad,val.genero,val.nickname,val.contrasena,val.correoElectronico);
                        console.log(usu1);
                    }else{
                        usu2 = new Usuario(val.nombre,val.edad,val.genero,val.nickname,val.contrasena,val.correoElectronico);
                    }
                }
                if(ind === "id"){
                    id = val;
                }
                if(ind === "expulsados"){
                    expulsados = val;
                }
                if(ind === "contraseña"){
                    cons = val;
                }
            });
            var sal = new Sala(id,usu1,usu2,expulsados,cons);
            console.log(sal);
            salasDisponibles.agregarSala(sal);
        });
        $.each(salasDisponibles.salasDisponibles,function(ind,val){
            console.log(ind+"!!!!!!!!!!!!!!!!!!!!!!!!!!11 "+val);
        })
        
        $("#contenido table").append("<tr><th>1</th><th>Emiya</th><th>2</th></tr>");
        for(i = 0; i < data.length; i++){
        $("#contenido table").append("<tr><th>1</th><th>Emiya</th><th>2</th></tr>");
        }
        
    });

};
function crear(){
    var id = Math.floor((Math.random() * 20465234) + 1);
    sessionStorage.iden=id+"";
    window.location.href = 'sala.html';
}

function validar() {
    if (sessionStorage.name == null || sessionStorage.name.length == 0) {
        signOut();
    }
}
function signOut(){
    window.location.href = 'index.html';
}

$(document).ready(
    function () {
        validar();
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
