/* global CryptoJS */

nick="";
function nicki(){
    sessionStorage.name=nick;
    window.location.href='salas.html';
};

function check1(){
    nick=$("#Nick").val();
    var pw=CryptoJS.MD5($("#passwd").val());
    check2(pw);
    
}

function check2(pw){
    return $.get("/seguridad/"+username+"/"+passw, function(data){
            if(data){
                setName();
            }else{
                $("#mensaje").show();
            }
    }).fail(function (){
                $("#mensaje").show();
    } );
}
function log(){
    window.location.href='login.html';
}
function reg(){
    window.location.href='RegistrarUsuario.html';
}
$(document).ready(
        function () {
            sessionStorage.name="";
        }
);