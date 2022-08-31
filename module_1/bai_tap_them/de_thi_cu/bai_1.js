function checkTsunamiArray(arrNumber) {
    for (let i = 0; i < arrNumber.length; i++) {
        if (arrNumber[i] == arrNumber[i + 1]) return false;
        if (arrNumber[i] > arrNumber[i + 1] && arrNumber[i] < arrNumber[i - 1]) return false;
        if (arrNumber[i] < arrNumber[i + 1] && arrNumber[i] > arrNumber[i - 1]) return false;
    }
    return true;
}

function getResult() {
    let sizeArr = 0;
    do {
        sizeArr = +prompt('Nhập độ dài của mảng: ');
    } while (sizeArr < 1);
    let arrNumber = new Array(sizeArr);
    for (let i = 0; i < arrNumber.length; i++) {
        arrNumber[i] = +prompt('Nhập vào phần tử tại chỉ số thứ ' + (i + 1) + ' của mảng: ');
    }
    document.write('Mảng vừa nhập là: ' + arrNumber.join(',') + '<br>');
    return checkTsunamiArray(arrNumber) ? 'Đây là mảng dạng sóng' : 'Không phải là mảng dạng sóng';
}

document.write(getResult());