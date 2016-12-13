/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var salasDisponibles = new Salas();
sessionStorage.iden="";
sessionStorage.SD= JSON.stringify(new Salas());
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
    $("#contenido table").append("<thead><tr><th>ID Sala</th><th>Nombre creador</th><th>Jugadores</th></tr></thead><tbody></tbody>");
    $.get("/salas", function(data,status){
        console.log(data);
        var SD = JSON.parse(sessionStorage.SD);
        SD.salasDisponibles = [];
        $.each(data,function(index,value){
            var usu1 = null;
            var usu2 = null;
            var id = null;
            var expulsados = null;
            var cons = null;
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
            console.log(sessionStorage.SD.constructor);
            
            
            SD.salasDisponibles.push(sal);
            
        });
        sessionStorage.SD = JSON.stringify(SD);
        $.each(SD.salasDisponibles,function(ind,val){
            console.log(ind+"!!!!!!!!!!!!!!!!!!!!!!!!!!11 "+val.jugador1.nick);
        });
        
        $.each(SD.salasDisponibles,function(index,value){
            var cont = (value.jugador2 !== null) ? 2 : 1;
            $("#tablasalas tbody").append("<tr><td>"+value.id+"</td><td>"+value.jugador1.nick+"</td><td>"+cont+"</td></tr>");
        });
        $("#tablasalas tbody").on('click','tr',function(){
            $("#tablasalas tbody tr").removeClass("selected");
              $(this).toggleClass('selected');
         });

         $('#elegir').click(function(){
             var id = $("#tablasalas tr.selected td:first").html();
             
             $.get("/salas/choose/"+sessionStorage.name+"/"+id).done(function(data){
                 if(data){
                    console.log(sessionStorage.iden.length);
                    window.location.href='sala.html';
                 }else{
                    alert("No se pudo ingresar a la sala");
                 }
             }).fail(function(){
                 alert("No se pudo ingresar a la sala");
             });
         });
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
        
    }
);
