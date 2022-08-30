class Laptop {
    constructor(code, name, producers, price) {
        this.code = code;
        this.name = name;
        this.producers = producers;
        this.price = price;
    }
    getCode() {
        return this.code;
    }
    getName() {
        return this.name;
    }
    getProducers() {
        return this.producers;
    }
    getPrice() {
        return this.price;
    }
    setCode(code) {
        this.code = code;
    }
    setName(name) {
        this.name = name;
    }
    setProducers(producers) {
        this.producers = producers;
    }
    setPrice(price) {
        this.price = price;
    }
    getToString() {
        document.write('Máy tính có mã máy là: ' + this.code + ' .Tên máy là: ' + this.name + ' .Nhà sản xuất là: ' + this.producers + ' .Giá là: ' + this.price);
    }
}

let lap1 = new Laptop('C07', 'ROG', 'Asus', 9);
let lap2 = new Laptop('C08', 'ROG', 'Asus', 7);
let lap3 = new Laptop('C09', 'ROG', 'Asus', 10);
let arrLaptops = [lap1, lap2, lap3];
let inputCode = document.getElementById('inputCode');
let inputName = document.getElementById('inputName');
let inputProducers = document.getElementById('inputProducers');
let inputPrice = document.getElementById('inputPrice');
let displayTable = document.getElementById('displayTable');
let arrAddNewLaptops = [inputCode, inputName, inputProducers, inputPrice];
let btnAdd = document.getElementById('btnAdd');
let btnEdit = document.getElementById('btnEdit');
let btnBackBtnAddNewLaptop = document.getElementById('btnBackBtnAddNewLaptop');
let saveIndexEdit;

drawTable(arrLaptops);

function drawTable(arrLaptops) {
    let table = '<table id="displayTable" style="margin:auto; width: 50%;padding: 10px;border-collapse: collapse" border="1px solid black">' +
        '<tr>' +
        '<th>STT</th>' +
        '<th>MÃ MÁY</th>' +
        '<th>TÊN MÁY</th>' +
        '<th>TÊN HÃNG SẢN XUẤT</th>' +
        '<th onclick="sortByPrice()">GIÁ BÁN</th>' +
        '<th>SỬA</th>' +
        '<th>XOÁ</th>' +
        '</tr>';
    for (let i = 0; i < arrLaptops.length; i++) {
        table += '<tr style="text-align:center">';
        table += '<td>' + (i + 1) + '</td>' +
            '<td>' + arrLaptops[i].getCode() + '</td>' +
            '<td>' + arrLaptops[i].getName() + '</td>' +
            '<td>' + arrLaptops[i].getProducers() + '</td>' +
            '<td>' + arrLaptops[i].getPrice() + '</td>' +
            '<td>' + '<button onclick="showEditLaptop(' + i + ')" type="button">EDIT</button>' + '</td>' +
            '<td>' + '<button onclick="deleteLaptop(' + i + ')" type="button">DELETE</button>' + '</td>';
        table += '</tr>';
    }
    table += '</table>';
    displayTable.innerHTML = table;
}

function addNewLaptop() {
    for (let i = 0; i < arrAddNewLaptops.length; i++) {
        if (!(arrAddNewLaptops[i].value || false)) return alert('Điền đầy đủ dữ liệu');
    }
    let confirmAdd = confirm('Chắc chắn thêm? ');
    if (confirmAdd) {
        for (let i = 0; i < arrLaptops.length; i++) {
            if (inputCode.value == arrLaptops[i].getCode()) {
                return alert('Đã có mã máy trong kho!');
            }
        }
        let newLaptop = new Laptop(inputCode.value, inputName.value, inputProducers.value, inputPrice.value);
        arrLaptops.push(newLaptop);
        drawTable(arrLaptops);
        for (let i = 0; i < arrAddNewLaptops.length; i++) {
            arrAddNewLaptops[i].value = '';
        }
    }
}

function showEditLaptop(position) {
    for (let i = 0; i < arrAddNewLaptops.length; i++) {
        arrAddNewLaptops[i].value = '';
    }
    inputCode.placeholder = arrLaptops[position].getCode();
    inputName.placeholder = arrLaptops[position].getName();
    inputProducers.placeholder = arrLaptops[position].getProducers();
    inputPrice.placeholder = arrLaptops[position].getPrice();
    btnAdd.hidden = true;
    btnEdit.hidden = false;
    btnBackBtnAddNewLaptop.hidden = false;
    saveIndexEdit = position;
}

function editLaptop() {
    let confirmEdit = confirm('Chắc chắn sửa? ');
    if (confirmEdit) {
        for (let i = 0; i < arrLaptops.length; i++) {
            if (i == saveIndexEdit) continue;
            if (inputCode.value == arrLaptops[i].getCode() || inputCode.placeholder == arrLaptops[i].getCode()) {
                return alert('Đã có mã máy trong kho!');
            }
        }
        inputCode.value ? arrLaptops[saveIndexEdit].setCode(inputCode.value) : arrLaptops[saveIndexEdit].setCode(inputCode.placeholder);
        inputName.value ? arrLaptops[saveIndexEdit].setName(inputName.value) : arrLaptops[saveIndexEdit].setName(inputName.placeholder);
        inputProducers.value ? arrLaptops[saveIndexEdit].setProducers(inputProducers.value) : arrLaptops[saveIndexEdit].setProducers(inputProducers.placeholder);
        inputPrice.value ? arrLaptops[saveIndexEdit].setPrice(inputPrice.value) : arrLaptops[saveIndexEdit].setPrice(inputPrice.placeholder);
        alert('Sửa thành công!');
    }
    drawTable(arrLaptops);
    for (let i = 0; i < arrAddNewLaptops.length; i++) {
        arrAddNewLaptops[i].placeholder = '';
        arrAddNewLaptops[i].value = '';
    }
    btnAdd.hidden = false;
    btnEdit.hidden = true;
    btnBackBtnAddNewLaptop.hidden = true;
}

function deleteLaptop(position) {
    let confirmDelete = confirm('Chắc chắn xoá? ');
    if (confirmDelete) {
        arrLaptops.splice(position, 1);
        alert('Xoá thành công!');
    }
    drawTable(arrLaptops);
}

function backBtnAddNewLaptop() {
    for (let i = 0; i < arrAddNewLaptops.length; i++) {
        arrAddNewLaptops[i].placeholder = '';
        arrAddNewLaptops[i].value = '';
    }
    btnAdd.hidden = false;
    btnEdit.hidden = true;
    btnBackBtnAddNewLaptop.hidden = true;
    drawTable(arrLaptops);
}

let sortIncrease = true;

function sortByPrice() {
    if (sortIncrease) {
        arrLaptops.sort(function (a, b) {
            return a.price - b.price;
        })
        drawTable(arrLaptops);
        sortIncrease = !sortIncrease;
    } else {
        arrLaptops.sort(function (a, b) {
            return b.price - a.price;
        })
        drawTable(arrLaptops);
        sortIncrease = !sortIncrease;
    }
}