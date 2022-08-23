let valueSelected = document.getElementById("selectEx");
let valueget;

function getValue() {
    valueget = valueSelected.value;
}

function playEx() {
    check = valueget;
    switch (check) {
        case "1":
            bai1();
            break;
        case "2":
            bai2();
            break;
        default:
            alert("Bạn chưa chọn bài nào cả");
    }
}

function reloadEx() {
    window.location.reload();
}

function inputBtnReloadEx() {
    document.write(
        "<br><input type='button' value='Quay lại(F5)' onclick='reloadEx()'>"
    );
}

function bai1() {
    let wage = +prompt('Nhập vào số lương của nhân viên (theo triệu): ');
    document.write(getRealWage(wage));
    inputBtnReloadEx();
}

function getRealWage(wage) {
    let arrTax = [10, 15, 20];
    let arrWage = [7, 15];
    for (let i = 0; i < arrWage.length; i++) {
        if (wage < arrWage[i]) return 'Thuế thu nhập là ' + arrTax[i] + '% và lương thực nhận được là: ' + (wage * (1 - (arrTax[i] / 100)));
    }
    return 'Thuế thu nhập là ' + arrTax[arrTax.length - 1] + '% và lương thực nhận được là: ' + (wage * (1 - (arrTax[arrTax.length - 1] / 100)));
}

function bai2() {
    let randomChar = prompt('Nhập vào kí tự cần kiểm tra: ');
    document.write(checkCharacter(randomChar));
    inputBtnReloadEx();
}

function checkCharacter(randomChar) {
    let arrCheckCharacters = ['o', 'u', 'i', 'a', 'e', 'O', 'U', 'I', 'A', 'E'];
    return arrCheckCharacters.includes(randomChar) ? randomChar + ' là nguyên âm' : randomChar + ' là phụ âm';
}