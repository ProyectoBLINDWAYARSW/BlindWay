
nick="";
function nicki(){
    sessionStorage.name=nick;
    window.location.href='partidas.html';
}

function check1(){
    nick=$("#Nick").val();
    var pw=$("#Pass").val();
    check2(pw);
    
}

function check2(pw){
    return $.get("/usuario/login/"+nick+"/"+pw, function(data){
            if(data){
                nicki();
            }else{
                alert("Algo salio mal");
            }
    }).fail(function (data){
                alert("Los datos ingresados son incorrectos.");
    } );
}
function devolver(){
    window.location.href='index.html';
}

$(document).ready(
        function () {
            sessionStorage.name="";
        }
);