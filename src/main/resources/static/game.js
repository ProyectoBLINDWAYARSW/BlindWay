/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var myGamePiece;
var myObstacles = [];
var myScore;
var Keys = {
        up: false,
        down: false,
        left: false,
        right: false
    };

function startGame() {
    myGamePiece = new component(30, 30, "red", 10, 120);
    myGamePiece.gravity = 0.05;
    
    myScore = new component("30px", "Consolas", "black", 280, 40, "text");
    myGameArea.start();
    myGamePiece.update();
    setInterval(updateGameArea(), 10);
}

var myGameArea = {
    canvas : document.createElement("canvas"),
    start : function() {
        this.canvas.width = 480;
        this.canvas.height = 270;
        this.context = this.canvas.getContext("2d");
        document.body.insertBefore(this.canvas, document.body.childNodes[0]);
        this.frameNo = 0;
    },
    clear : function() {
        this.context.clearRect(0, 0, this.canvas.width, this.canvas.height);
    }
};
function component(width, height, color, x, y, type) {
    this.type = type;
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
        ctx = myGameArea.context;
        if (this.type === "text") {
            ctx.font = this.width + " " + this.height;
            ctx.fillStyle = color;
            ctx.fillText(this.text, this.x, this.y);
        } else {
            ctx.fillStyle = color;
            ctx.fillRect(this.x, this.y, this.width, this.height);
        }
    };
    this.newPos = function() {
        this.gravitySpeed += this.gravity;
        this.x += this.speedX;
        this.y += this.speedY + this.gravitySpeed;
        this.hitBottom();
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
    this.move = function(){
        ctx = myGameArea.context;
        for (var direction in Keys) {
            console.log("Entro");
            if (!Keys.hasOwnProperty(direction)) continue;
            if (direction === 37) {
                myGamePiece.x+=30;
            }
            if (direction === 38) {
                myGamePiece.y+=30;
            }
            if (direction === 39) {
                myGamePiece.x-=30;
            }
            if (direction === 40) {
                myGamePiece.y-=30;
            }
            ctx.fillStyle = color;
            ctx.fillRect(this.x, this.y, this.width, this.height);
        }
    };
}

function updateGameArea() {
    var x, height, gap, minHeight, maxHeight, minGap, maxGap;
    for (i = 0; i < myObstacles.length; i += 1) {
        if (myGamePiece.crashWith(myObstacles[i])) {
            return;
        } 
    }
    myGameArea.clear();
    myGameArea.frameNo += 1;
    if (myGameArea.frameNo === 1 || everyinterval(150)) {
        x = myGameArea.canvas.width;
        minHeight = 20;
        maxHeight = 200;
        height = Math.floor(Math.random()*(maxHeight-minHeight+1)+minHeight);
        minGap = 50;
        maxGap = 200;
        gap = Math.floor(Math.random()*(maxGap-minGap+1)+minGap);
        myObstacles.push(new component(10, height, "green", x, 0));
        myObstacles.push(new component(10, x - height - gap, "green", x, height + gap));
    }
    for (i = 0; i < myObstacles.length; i += 1) {
        myObstacles[i].x += -1;
        myObstacles[i].update();
    }
    myScore.text="SCORE: " + myGameArea.frameNo;
    myScore.update();
    myGamePiece.newPos();
    myGamePiece.update();
}

function everyinterval(n) {
    if ((myGameArea.frameNo / n) % 1 === 0) {return true;}
    return false;
}

function accelerate(n) {
    myGamePiece.gravity = n;
}
window.onkeydown = function(e) {
    console.log("entro al presionar "+e);
    var kc = e.keyCode;
    e.preventDefault();

    if      (kc === 37) Keys.left = true;  // only one key per event
    else if (kc === 38) Keys.up = true;    // so check exclusively
    else if (kc === 39) Keys.right = true;
    else if (kc === 40) Keys.down = true;
    myGamePiece.move()
};

window.onkeyup = function(e) {
    console.log("entro al levatnar "+e);
    var kc = e.keyCode;
    e.preventDefault();

    if      (kc === 37) Keys.left = false;
    else if (kc === 38) Keys.up = false;
    else if (kc === 39) Keys.right = false;
    else if (kc === 40) Keys.down = false;
};
document.addEventListener('keydown', function(event) {
    if (Keys.up) {
        myGamePiece.y-=3;
    }
    else if (Keys.down) {  // both up and down does not work so check excl.
        myGamePiece.y+=3;
    }

    if (Keys.left) {
        myGamePiece.x-=3;
    }
    else if (Keys.right) {
        myGamePiece.x+=3;
    }
});
