function createArrNumbers(size) {
    let arrNumbers = new Array(size);
    for (var i = 0; i < size; i++) {
        arrNumbers[i] = +prompt('Nhập vào phần tử tại thứ ' + (i + 1) + ' của mảng: ');
    }
    return arrNumbers;
}

function findAmountElementDividedByNumber(arrNumbers, numberN) {
    arrNumbers = Array.from(new Set(arrNumbers));
    let count = 0;
    for (const value of arrNumbers) {
        if (!(value % numberN)) count++;
    }
    return count;
}

function getResult() {
    let size = +prompt('Nhập vào độ dài của mảng: ');
    let arrNumbers = createArrNumbers(size);
    let numberN = +prompt('Nhập vào số nguyên n: ');
    document.write('Mảng vừa nhập là: ' + arrNumbers.join(', ') + '<br>');
    document.write('Số nguyên n vừa nhập là: ' + numberN + '<br>');
    document.write('Số lượng phần tử khác nhau trong mảng chia hết cho n là: ' + findAmountElementDividedByNumber(arrNumbers, numberN));
}

getResult();