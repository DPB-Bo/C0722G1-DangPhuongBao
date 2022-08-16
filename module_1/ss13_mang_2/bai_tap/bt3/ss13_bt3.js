// document.write('hahahha');
// console.log('hahahah');
let batXO = true;
let x;
let board = [];
let countAvailableTd = 0;
let alertStatus = document.getElementById('alertStatus');
let drawText = "<br><p>Hoà rồi!</p>";
let drawTableDiv = document.getElementById('drawTableDiv');


do {
    x = +prompt('Tạo hình vuông chơi caro với cạnh là (phải lớn hơn 2x2): ');
} while (x < 3);

drawTable();
console.log(board.join('.'));

function drawTable() {
    let drawTable = "<center><table border='1px solid black' width ='50%' height ='200px'>";
    // let rowBoard = [];
    // let blank = '0';
    for (let i = 0; i < x + 2; i++) {
        board[i] = new Array(x + 2);
        for (let j = 0; j < x + 2; j++) {
            board[i][j] = '';
        }
    }
    for (let r = 2; r < x + 2; r++) {
        drawTable += '<tr>';
        for (let d = 2; d < x + 2; d++) {
            drawTable += "<td><button id='" + r + d + "' onclick='change(" + r + "," + d + ")'>" + board[r][d] + "</button></td>"; // có thể thêm tham số 'This' nhưng k biết lạm dụng 'this' có vấn đề gì k
        }
        drawTable += '</tr>';
    }
    drawTable += '</table></center><br>';
    // j = 0;
    // console.log(board);
    drawTableDiv.insertAdjacentHTML('beforebegin', drawTable);
}

function change(r, d) {
    // let row = r;
    // let col = d;
    // let isX = 'X';
    // let isO = 'O';
    // // console.log(isDraw);  Cách này bí ý tưởng đổi phần tử của arrBoard
    // if (batXO == 1) {
    //     idAo.innerHTML = "X";
    //     idAo.onclick = null;
    //     countAvailableTd++;
    //     // console.log(countAvailableTd);
    //     batXO = 0;
    // } else if (batXO == 0) {
    //     idAo.innerHTML = "O";
    //     idAo.onclick = null;
    //     countAvailableTd++;
    //     // console.log(countAvailableTd);
    //     batXO = 1;
    // }'
    let idSum = r.toString() + d.toString();
    let btnThis = document.getElementById(idSum);
    // console.log('r là:' + row);
    // console.log('d là:' + col);
    // console.log(btnThis.innerHTML);
    // console.log(btnThis.id);
    // console.log(board[r][d]);
    if (batXO) {
        btnThis.innerHTML = 'X';
        board[r][d] = 'X';
        countAvailableTd++;
        // console.log(countAvailableTd);
    } else {
        btnThis.innerHTML = 'O';
        board[r][d] = 'O';
        countAvailableTd++;
        // console.log(countAvailableTd);
    }
    // console.log(idSum);
    // console.log(btnThis.innerHTML);
    // checkWin();
    // checkWin(r, d);
    checkWin();
    checkDraw();
    batXO = !batXO;
    btnThis.onclick = null;
}

function checkDraw() {
    let isDraw = board.length * x;
    // console.log(isDraw);
    if (isDraw == countAvailableTd) {
        alertStatus.innerHTML = drawText;
    }
    // console.log(board[1][1]);
}

function checkWin() {

    // try {
    for (let r = 0; r < x + 2; r++) {
        for (let d = 0; d < x + 2; d++) {
            // if((j+1)>=x){
            //     continue;
            // }
            if (board[r][d] === 'X' && board[r][d + 1] === 'X' && board[r][d + 2] === 'X' ||
                board[r][d] === 'X' && board[r + 1][d] === 'X' && board[r + 2][d] === 'X' ||
                board[r][d] === 'X' && board[r + 1][d + 1] === 'X' && board[r + 2][d + 2] === 'X'
                || board[r][d] === 'X' && board[r + 1][d - 1] === 'X' && board[r + 2][d - 2] === 'X'
            ) {
                alertStatus.innerHTML = ("Bên X Thắng");
            } else if (board[r][d] === 'O' && board[r][d + 1] === 'O' && board[r][d + 2] === 'O' ||
                board[r][d] === 'O' && board[r + 1][d] === 'O' && board[r + 2][d] === 'O' ||
                board[r][d] === 'O' && board[r + 1][d + 1] === 'O' && board[r + 2][d + 2] === 'O'
                || board[r][d] === 'O' && board[r + 1][d - 1] === 'O' && board[r + 2][d - 2] === 'O'
            ) {
                alertStatus.innerHTML = ("Bên O Thắng");
            }
        }
    }
    // } catch (error) {
    // }
}


