/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var sal = null;

function game(){
    window.location.href='game.html';
}

function validar() {
    if (sessionStorage.name == null || sessionStorage.name.length == 0) {
        signOut();
    }
}
function signOut(){
    window.location.href = 'index.html';
}
isObject = function(a) {
    return (!!a) && (a.constructor === Object);
};
isArray = function(a) {
    return (!!a) && (a.constructor === Array);
};
function creacion(){
    if(sessionStorage.iden!==null && sessionStorage.iden.length > 0){
        $.get("/room/creacion/"+sessionStorage.name,function(data){
            var usu1 = null;
            var usu2 = null;
            var id = null;
            var expulsados = null;
            var cons = null;
            $.each(data,function(ind,val){
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
            sal = new Sala(id,usu1,usu2,expulsados,cons);
            var SD = JSON.parse(sessionStorage.SD);
            var SDN = new Salas();
            console.log(SD);
            SD.salasDisponibles.push(sal);
            console.log(SD);
            sessionStorage.SD = JSON.stringify(SD);
        });
    }
}
function connect() {
    var socket = new SockJS('/stompendpoint');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        
        stompClient.subscribe('/topic/move.'+gameid, function (data) {
         
        });
    });
}
function disconnect() {
    if (stompClient != null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}
$(document).ready(
    function () {
        validar();
        creacion();
    }
);
