/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//grid width and height
var bw = 400;
var bh = 400;
//padding around grid
var p = 10;
//size of canvas
var cw = bw + (p * 2) + 1;
var ch = bh + (p * 2) + 1;
var y = 4;
var x = 5;
var canvas = $('<canvas/>').attr({
  width: cw,
  height: ch
}).appendTo('body');
var maze = [
  [4,6,3,5],
  [10,9,4,12],
  [6,7,9,12],
  [12,8,6,3],
  [10,3,11,1]
]
var context = canvas.get(0).getContext("2d");

function drawBoard() {
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

      if ((maze[j][i] & 1) == 0) {
        console.log("Entro 1 " +j +" "+i);
        context.moveTo(0.5 + xx + p, p * (i + 1));
        context.lineTo(0.5 + (yy*(j+1)) + p, p * (i + 1));
        console.log(0.5 + xx + p + " x ,y "+ p * (i + 1));
        console.log(0.5 + (yy*(j+1)) + p + " x ,y "+ p * (i + 1));
      } else {
        console.log("Entro 2 " +j +" "+i);
        context.moveTo(0.5 + xx + p, p * (i + 1));
      }
      xx += 40;
    }
    // draw the west edge
    /*for (var j = 0; j < x; j++) {
        		if(j==0 && i==0)System.out.print("    ");
        		else System.out.print((maze[j][i] & 8) == 0? "|   " : "    ");
      	}
      	if(i==y-1) System.out.println(" ");
      	else System.out.println("|");*/
  }
  // draw the bottom line
  /*for (var j = 0; j < x; j++) {
    	System.out.print("+---");
  }*/

  context.strokeStyle = "black";
  context.stroke();
}

drawBoard();
