/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var sal = null;
var SalId;
var stompClient = null;
var usu2 = null;
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
                    SalId = val;
                }
                if(ind === "expulsados"){
                    expulsados = val;
                }
                if(ind === "contraseña"){
                    cons = val;
                }
            });
            $("#tablasala tbody").append("<tr><td>"+usu1.nick+"</td><td id=\"crol\">Controlador</td></tr>");
            sal = new Sala(id,usu1,usu2,expulsados,cons);
            var SD = JSON.parse(sessionStorage.SD);
            var SDN = new Salas();
            console.log(SD);
            SD.salasDisponibles.push(sal);
            console.log(SD);
            sessionStorage.SD = JSON.stringify(SD);
            if(SalId!==null){
                console.log("Entro");
                var form = document.createElement('form');
                form.id="formula";
                var input1 = document.createElement('input');
                input1.id="obs";
                input1.name="rol";
                input1.value="obs";
                input1.type="radio";
                input1.onclick=0;
                input1.checked=false;
                form.appendChild(input1);
                form.appendChild(document.createTextNode("Observador"));
                var br = document.createElement('br');
                form.appendChild(br);
                var input2 = document.createElement('input');
                input2.id="con";
                input2.name="rol";
                input2.value="con";
                input2.type="radio";
                input2.onclick=0;
                input2.checked=true;
                form.appendChild(input2);
                form.appendChild(document.createTextNode("Controlador"));
                var br1 = document.createElement('br');
                form.appendChild(br1);
                var span = document.createElement('span');
                span.innerHTML = '<button id="but" onclick="change(this.form)" type="button">Choose</button>';
                form.appendChild(span);
                document.body.insertBefore(form,document.body.childNodes[0]);
            }
        }).then(connect);
    }
}
function connect() {
    var socket = new SockJS('/stompendpoint');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        
        stompClient.subscribe('/topic/load.'+SalId, function (data) {
            var bod = JSON.parse(data.body);
            console.log("Maldita sea "+bod.nickname);
            usu2 = new Usuario(bod.nombre, bod.edad, bod.genero, bod.nickname, bod.contrasena, bod.correoElectronico);
            var ck ="";
            if($("#obs").is(":checked")){
                ck = "Controlador";
            }else{
                ck = "Observador";
            }
            $("#tablasala tbody").append("<tr><td>"+usu2.nick+"</td><td id=\"crol2\">"+ck+"</td></tr>");
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
function change(form){
    if($("#obs").is(":checked")){
        console.log("Entro 1");
        document.getElementById("crol").innerHTML = "Observador";
        document.getElementById("crol2").innerHTML = "Controlador";
    }else{
        console.log("Entro 2");
        document.getElementById("crol").innerHTML = "Controlador";
        document.getElementById("crol2").innerHTML = "Observador";
    }
}
$(document).ready(
    function () {
        validar();
        creacion()
        
    }
);
