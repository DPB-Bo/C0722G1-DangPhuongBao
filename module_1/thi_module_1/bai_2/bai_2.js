function createArrNumbers(size) {
    let arrNumbers = new Array(size);
    for (var i = 0; i < size; i++) {
        arrNumbers[i] = +prompt('Nhập vào phần tử tại thứ ' + (i + 1) + ' của mảng: ');
    }
    return arrNumbers;
}

function findIndexMinMax(arrNumbers) {
    let indexOfMax = arrNumbers.indexOf(Math.max(...arrNumbers));
    let indexOfMin = arrNumbers.indexOf(Math.min(...arrNumbers));
    let arrIndexMinMax = [indexOfMin, indexOfMax];
    return arrIndexMinMax;
}

function getResult() {
    let size = +prompt('Nhập vào độ dài của mảng: ');
    let arrNumbers = createArrNumbers(size);
    document.write('Mảng vừa nhập là: ' + arrNumbers.join(', ') + '<br>');
    document.write('Vị trí của phần tử nhỏ nhất và lớn nhất của mảng vừa nhập là: ' + findIndexMinMax(arrNumbers).join(' và '));
}

getResult();