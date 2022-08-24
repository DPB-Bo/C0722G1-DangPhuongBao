let menuSelect = document.getElementById('menuSelect');
let displayPrice = document.getElementById('displayPrice');
let br = '<br>';
let displayBill = document.getElementById('displayBill');

let arrPriceDrink = {
    0: 15000,
    1: 45000,
    2: 25000,
    3: 35000,
    4: 5000,
    5: 15000,
    6: 15000,
    7: 12000,
}

let arrMenu = ['Cafe', 'Cam vắt', 'Nước ép cà rốt', 'Nước ép cà chua', 'Nước lọc', 'Nước dừa', 'Nước mía', 'Sting'];

function displayMenuSelect(arrMenu) {
    let display = '<select id="selectDrink" ><option disabled selected>Chọn đồ uống: </option>';
    for (let i = 0; i < arrMenu.length; i++) {
        display += '<option value="' + i + '">' + arrMenu[i] + '</option>';
    }
    display += '</select>';
    return display;
}

menuSelect.innerHTML = displayMenuSelect(arrMenu);
let selectDrink = document.getElementById('selectDrink');


function getValueDrink() {
    let display = '<p>Giá của 1 ly ' + arrMenu[selectDrink.value] + ' là: '
        + arrPriceDrink[selectDrink.value] + 'VND</p>'
        + ' <label for="amountDrink">Nhập số lượng cần mua:</label><input type="number" id="amountDrink" oninput="getBill()"> ';
    displayPrice.innerHTML = display;
}


function getBill() {
    let amountDrink = document.getElementById('amountDrink');
    let billCheck = amountDrink.value * arrPriceDrink[selectDrink.value];
    displayBill.innerHTML = '<p>Tổng số tiền bạn phải trả là: ' + billCheck + ' VND</p>' + br + '<button type="button" onclick="confirmTransaction()">Xác Nhận</button>';
}

function confirmTransaction() {
    let checkConfirm = confirm('Xác nhận thanh toán?');
    if (checkConfirm) {
        alert('Giờ thì cầm chừng đó tiền ra quán mà mua thôi :v');
        alert('Ủa chứ đang mong đợi gì ?');
    }
}