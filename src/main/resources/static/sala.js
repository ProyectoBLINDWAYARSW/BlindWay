/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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

function creacion(){
    if(sessionStorage.iden!==null || sessionStorage.iden.length > 0){
        $.get("/room/creacion/"+sessionStorage.name,function(data){
            console.log(data);
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
