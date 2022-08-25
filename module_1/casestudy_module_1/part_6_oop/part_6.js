let tickets = [];
let resultTicket = [];
let br = '<br>';
let addTickets = document.getElementById('addTickets');
let saveTicketsAdded = 0;
let amountTickets;
let btnGetResults = document.getElementById('btnGetResults');
let showResults = document.getElementById('showResults');
let btnGetFinalResult = document.getElementById('btnGetFinalResult');
let txtRewardAlert = document.getElementById('txtRewardAlert');
let btnButton = {
    0: document.getElementById('btnBuyTickets0'),
    1: document.getElementById('btnBuyTickets1'),
    2: document.getElementById('btnBuyTickets2'),
    3: document.getElementById('btnBuyTickets3'),
}
let obTicket = {
    0: document.getElementById('numberTickets0'),
    1: document.getElementById('numberTickets1'),
    2: document.getElementById('numberTickets2'),
    3: document.getElementById('numberTickets3'),
    4: document.getElementById('numberTickets4'),
    5: document.getElementById('numberTickets5')
}
let obResultTicket = {
    0: document.getElementById('resultTickets0'),
    1: document.getElementById('resultTickets1'),
    2: document.getElementById('resultTickets2'),
    3: document.getElementById('resultTickets3'),
    4: document.getElementById('resultTickets4'),
    5: document.getElementById('resultTickets5')
}
let rewards = {
    1: 'Chúc mừng bạn đã đạt giải đặc biệt !!',
    2: 'Chúc mừng bạn đã đạt giải nhất!',
    3: 'Chúc mừng bạn đã đạt giải nhì!',
    4: 'Thật may mắn! Bạn không đạt giải!'
}

function reloadEx() {
    window.location.reload();
}

function inputBtnReloadEx() {
    return "<br><input type='button' value='Chơi lại(F5)' onclick='reloadEx()'>"
}

function buyTickets() {
    amountTickets = +prompt('Mua nhiêu tờ đây bạn ơi! Tối đa 4 tờ nhé');
    if (amountTickets < 1 || amountTickets > 4) {
        alert('Chú ý nhập số vé số cần mua cho đúng!');
        buyTickets();
    } else { disableBtnBuyTicket(); }
    for (let i = 0; i < amountTickets; i++) {
        tickets[i] = [];
    }
    addTickets.hidden = false;
}

function disableBtnBuyTicket() {
    for (let i = 0; i < 4; i++) {
        btnButton[i].disabled = true;
    }
}

function confirmTickets() {
    for (let i = 0; i < 6; i++) {
        tickets[saveTicketsAdded][i] = obTicket[i].value;
    }
    alert('Mua thành công tờ vé số thứ ' + (saveTicketsAdded + 1));
    saveTicketsAdded++;
    checkAmountTickets();
}


function checkAmountTickets() {
    if (saveTicketsAdded >= amountTickets) {
        alert('Bạn đã nhập đủ số lượng vé số đã mua rồi!');
        addTickets.hidden = true;
        showTicketsBought();
    }
}

function autoTickets(checkNumber) {
    if (checkNumber == 1) {
        for (let i = 0; i < 6; i++) {
            obTicket[i].value = Math.round(Math.random() * 100);
        }
    } else if (checkNumber == 2) {
        for (let i = 0; i < 6; i++) {
            obResultTicket[i].value = Math.round(Math.random() * 100);
        }
        for (let i = 0; i < 6; i++) {
            resultTicket.push(obResultTicket[i].value);
        }
        btnGetResults.disabled = true;
        btnGetFinalResult.hidden = false;
    }
}

function delInputNumbersTickets() {
    for (let i = 0; i < 6; i++) {
        obTicket[i].value = '';
    }
}

function showTicketsBought() {
    let showTicketsHtml = '';
    for (let i = 0; i < amountTickets; i++) {
        showTicketsHtml += '<p> Tờ vé số thứ 1 là: ' + tickets[i].join('-') + '</p>';
    }
    showTickets.innerHTML = showTicketsHtml;
    showResults.hidden = false;
}

function getFinalResult() {
    txtRewardAlert.innerHTML = rewards[checkFinalResult()] + inputBtnReloadEx();
}

function checkValidNumber(position) {
    if (obTicket[position].value > 99) {
        alert('Nhập 2 số thôi! ');
        obTicket[position].value = '';
    }
}

function checkFinalResult() {
    let count = 0;
    for (let i = 0; i < tickets.length; i++) {
        for (let j = 5; j > -1; j--) {
            if (tickets[i][j] == resultTicket[j]) {
                count++;
            } else {
                if (count == 5) return 2;
                if (count == 3) return 3;
                count = -2;
            }
        }
        if (count == 6) return 1;
        count = 0;
    }
    return 4;
}