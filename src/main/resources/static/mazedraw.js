
var myGamePiece;
var myObstacles = [];
var myScore;

var myGameArea = {
    canvas : document.createElement("canvas"),
    start : function() {
        this.canvas.width = bw;
        this.canvas.height = bh;
        this.context = this.canvas.getContext("2d");
        document.body.
        document.body.insertBefore(this.canvas, document.body.childNodes[0]);
        this.frameNo = 0;
    },
    clear : function() {
        this.context.clearRect(0, 0, this.canvas.width, this.canvas.height);
    }
};

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
myGameArea.start();
console.log(myGameArea);
var maze;
var context = myGameArea.context;


function drawBoard() {
	console.log("Entra a dibujar");
  var xx = 0,
    yy = 0;
  /*for (var xm = 0; xm <= bw; xm += 40) {
      context.moveTo(p, 0.5 + xm + p);
      context.lineTo(bw + p, 0.5 + xm + p);
  }
  for (var xm = 0; xm <= bh; xm += 40) {
      context.moveTo(0.5 + xm + p,p);
      context.lineTo(0.5 + xm + p,bw + p);
  }*/
  for (var i = 0; i < y; i++) {
    // draw the north edge
    xx = 0;
    yy = 40;
    for (var j = 0; j < x; j++) {

      if ((maze[j][i] & 1) === 0) {
        context.moveTo(0.5 + xx + p,(p * (i + 1) + (yy*i)));
        context.lineTo(0.5 + (yy*(j+1)) + p,(p * (i + 1) + (yy*i)));
      } else {
        context.moveTo(0.5 + xx + p, (p * (i + 1) + (yy*i)));
      }
      xx += 40;
    }
    // draw the west edge
    xx = 0;
    yy = 50;
    console.log(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><");
    for (var j = 0; j < x; j++) {
      if((maze[j][i]&8)===0 && (i!==0 || j!==0)){
      	console.log("Entro a 1");
        context.moveTo(0.5 + xx + p, (p + (yy*i)));
        context.lineTo(0.5 + xx + p,(p+ (yy*(i+1))+0.5));
        console.log(0.5 + xx + p + " x ,y "+(p + (yy*i)));
        console.log(0.5 + xx + p+ " x ,y "+  (p+ (yy*(i+1))+0.5));
        
      }
      else {
      console.log("Entro a 2");
        context.moveTo(0.5 + xx + p, (p + (yy*(j+1)) + 0.5));
        console.log(0.5 + xx + p + " x ,y "+ (p + (yy*(j+1)) + 0.5));
      }
      xx += 40;
  	}
    
  }
  // draw the bottom line
  context.moveTo(0.5 + p, (p + (yy*y)));
	context.lineTo(0.5 + (x*40) + p,(p+ (yy*y)+0.5));
  // draw the right line
  context.moveTo(0.5 + (x*40) + p, 0.5 + p);
	context.lineTo(0.5 + (x*40) + p,(p+ (yy*(y-1))+0.5));
  context.strokeStyle = "black";
  context.stroke();
}

$.get("/blindway/maze/"+x+"/"+y, function(data){
    console.log("Entro "+data);
    maze=data;
}).then(drawBoard());
