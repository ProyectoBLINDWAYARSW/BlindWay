//grid width and height
var bw = 400;
var bh = 400;
//padding around grid
var p = 10;
//size of canvas
var cw = bw + (p * 2) + 1;
var ch = bh + (p * 2) + 1;
var y = 6;
var x = 7;
var px=0;
var py=0;
var moveOk=true;
var maze=null;
var myGamePiece=null;
var myObstacles = [];
var myScore;
var carro=null;
var gameid=1;
var Keys = {
        up: false,
        down: false,
        left: false,
        right: false
    };
var stompClient = null;
var myGameArea = {
    canvas : document.createElement("canvas"),
    start : function() {
        this.canvas.width = bw;
        this.canvas.height = bh;
        this.context = this.canvas.getContext("2d");
        document.body.insertBefore(this.canvas, document.body.childNodes[0]);
        this.frameNo = 0;
        
    },
    clear : function() {
        this.context.clearRect(0, 0, this.canvas.width, this.canvas.height);
    }
};

var moveObject = function(event) {
    
    myGamePiece.clear();
    check(event);
    
    //setTimeout(moveObject, 100);
    
};
function start(){
    
    console.log("Entro a dibujar 1asdasdasdasdasda");
    
    $.get("/blindway/maze/"+gameid+"/"+x+"/"+y, function(data){
        myGameArea.start();
        
        
        myGameArea.context;
        //console.log("Entro "+data);
        maze=data;
        //console.log(maze[0][0]);
        //console.log(maze);
        
    }).then($.get("/blindway/maze/"+gameid+"/"+x+"/"+y+"/car",function(data){
        myGamePiece = new component(30, 40, "red", 15+((data[0])*40), 15+((data[1])*50));
        drawBoard();
        myGamePiece.update();
        setInterval(updateGameArea(), 11);
    }));
    
   
    
}

function component(width, height, color, x, y) {
    this.score = 0;
    this.width = width;
    this.height = height;
    this.speedX = 0;
    this.speedY = 0;    
    this.x = x;
    this.y = y;
    this.gravity = 0;
    this.gravitySpeed = 0;
    this.update = function() {
        //console.log("Entro a dibujar");
        ctx = myGameArea.context;
        ctx.fillStyle = color;
        ctx.fillRect(this.x, this.y, this.width, this.height);
    };
    this.newPos = function() {
    };
    this.hitBottom = function() {
        var rockbottom = myGameArea.canvas.height - this.height;
        if (this.y > rockbottom) {
            this.y = rockbottom;
            this.gravitySpeed = 0;
        }
    };
    this.crashWith = function(otherobj) {
        var myleft = this.x;
        var myright = this.x + (this.width);
        var mytop = this.y;
        var mybottom = this.y + (this.height);
        var otherleft = otherobj.x;
        var otherright = otherobj.x + (otherobj.width);
        var othertop = otherobj.y;
        var otherbottom = otherobj.y + (otherobj.height);
        var crash = true;
        if ((mybottom < othertop) || (mytop > otherbottom) || (myright < otherleft) || (myleft > otherright)) {
            crash = false;
        }
        return crash;
    };
    /*this.move = function(){
        this.clear();
        /*for (var direction in Keys) {
            if (!Keys.hasOwnProperty(direction)) continue;
            if (direction === 37) {
                this.x+=30;
            }
            if (direction === 38) {
                this.y+=30;
            }
            if (direction === 39) {
                this.x-=30;
            }
            if (direction === 40) {
                this.y-=30;
            }
        }*/
        /*this.update();
    };*/
    this.clear = function(){
        ctx = myGameArea.context;
        ctx.fillStyle = "white";
        ctx.fillRect(this.x, this.y, this.width, this.height);
    };
}


function drawBoard() {
  //console.log("Entra a dibujar");
  //console.log(maze);
  console.log(myGameArea.context);
  if(maze!==null){
  var xx = 0,yy = 0;
  for (var i = 0; i < y; i++) {
    // draw the north edge
    xx = 0;
    yy = 40;
    for (var j = 0; j < x; j++) {

      if ((maze[j][i] & 1) === 0) {
        myGameArea.context.moveTo(0.5 + xx + p,(p * (i + 1) + (yy*i)));
        myGameArea.context.lineTo(0.5 + (yy*(j+1)) + p,(p * (i + 1) + (yy*i)));
      } else {
        myGameArea.context.moveTo(0.5 + xx + p, (p * (i + 1) + (yy*i)));
      }
      xx += 40;
    }
    // draw the west edge
    xx = 0;
    yy = 50;
    //console.log(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");
    for (var j = 0; j < x; j++) {
      if((maze[j][i]&8)===0 && (i!==0 || j!==0)){
      	//console.log("Entro a 1");
        myGameArea.context.moveTo(0.5 + xx + p, (p + (yy*i)));
        myGameArea.context.lineTo(0.5 + xx + p,(p+ (yy*(i+1))+0.5));
        //console.log(0.5 + xx + p + " x ,y "+(p + (yy*i)));
        //console.log(0.5 + xx + p+ " x ,y "+  (p+ (yy*(i+1))+0.5));
        
      }
      else {
      //console.log("Entro a 2");
        myGameArea.context.moveTo(0.5 + xx + p, (p + (yy*(j+1)) + 0.5));
        //console.log(0.5 + xx + p + " x ,y "+ (p + (yy*(j+1)) + 0.5));
      }
      xx += 40;
    }
    
  }
  // draw the bottom line
  myGameArea.context.moveTo(0.5 + p, (p + (yy*y)));
  myGameArea.context.lineTo(0.5 + (x*40) + p,(p+ (yy*y)+0.5));
  // draw the right line
  myGameArea.context.moveTo(0.5 + (x*40) + p, 0.5 + p);
  myGameArea.context.lineTo(0.5 + (x*40) + p,(p+ (yy*(y-1))+0.5));
  myGameArea.context.strokeStyle = "black";
  myGameArea.context.stroke();
}}

function updateGameArea() {
    var x, height, gap, minHeight, maxHeight, minGap, maxGap;
    for (i = 0; i < myObstacles.length; i += 1) {
        /*if (myGamePiece.crashWith(myObstacles[i])) {
            return;
        } */
    }
    myGameArea.clear();
    myGameArea.frameNo += 1;
    if (myGameArea.frameNo === 1 || everyinterval(150)) {
        /*x = myGameArea.canvas.width;
        minHeight = 20;
        maxHeight = 200;
        height = Math.floor(Math.random()*(maxHeight-minHeight+1)+minHeight);
        minGap = 50;
        maxGap = 200;
        gap = Math.floor(Math.random()*(maxGap-minGap+1)+minGap);
        myObstacles.push(new component(10, height, "green", x, 0));
        myObstacles.push(new component(10, x - height - gap, "green", x, height + gap));*/
    }
    /*for (i = 0; i < myObstacles.length; i += 1) {
        myObstacles[i].x += -1;
        myObstacles[i].update();
    }*/
    context=myGameArea.context;
    drawBoard();
    //myGamePiece.move();
    myGamePiece.update();
}

function check(event){
    
    if (event.which===38) {
        stompClient.send("/app/move."+gameid, {}, "Up");
    }
    else if (event.which===40) {
        stompClient.send("/app/move."+gameid, {}, "Down");
        
    }
    if (event.which===37) {
        stompClient.send("/app/move."+gameid, {}, "Left");
    }
    else if (event.which===39) {
        stompClient.send("/app/move."+gameid, {}, "Right");
    }
}


//document.addEventListener('keydown', moveObject,true);
$(document).ready(function(){
    connect();
    $(document).keydown(moveObject);
});



function sendRequest() {
    
}
function connect() {
    var socket = new SockJS('/stompendpoint');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        
        stompClient.subscribe('/topic/move.'+gameid, function (data) {
            
            var arr =data.body.split(" "); 
            moveOk=arr[1]==='true';
            var event = arr[0];
            console.log(moveOk);
            console.log(typeof moveOk);
            myGamePiece.clear();
            if (event==="Up" && moveOk) {
                py-=1;
                myGamePiece.y-=50;
            }
            else if (event==="Down" && moveOk) {  // both up and down does not work so check excl.
                py+=1;
                myGamePiece.y+=50;
            }
            if (event==="Left" && moveOk) {
                px-=1;
                myGamePiece.x-=40;
            }
            else if (event==="Right" && moveOk) {
                px+=1;
                myGamePiece.x+=40;
                
            }myGamePiece.update();
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
