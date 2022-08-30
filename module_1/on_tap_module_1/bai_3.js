function createArr(sizeArray) {
    let arr = [];
    for (let i = 0; i < sizeArray; i++) {
        arr[i] = +prompt('Nhập vào phần tử tại chỉ số thứ ' + (i + 1) + ' của mảng: ');
    }
    return arr;
}

function bai3() {
    let sizeArray = +prompt('Nhập vào số lượng phần tử của mảng: ');
    while (sizeArray < 1) {
        sizeArray = +prompt('Nhập vào số lượng phần tử của mảng: ');
    }
    let arr = createArr(sizeArray);
    document.write('Mảng vừa nhập là: ' + arr.join(', ') + '<br>');
    let resultArr = findFiInArray(arr, createFibonacciArray(arr));
    if (resultArr) {
        resultArr.sort(function (a, b) { return a - b; });
        document.write('Mảng số Fibonacci sắp xếp tăng dần được tìm thấy trong mảng đã nhập là: ' + resultArr.join(','));
    } else {
        document.write('Không tìm thấy số Fibonacci trong mảng vừa nhập!');
    }
}

function createFibonacciArray(arr) {
    let arrFi = [0, 1];
    let number1 = 0;
    let number2 = 1;
    let numberFi = 0;
    while (numberFi <= Math.max(...arr)) {
        numberFi = number1 + number2;
        if (numberFi > Math.max(...arr)) break;
        arrFi.push(numberFi);
        number1 = number2;
        number2 = numberFi;
    }
    return arrFi;
}

function findFiInArray(arr, arrFi) {
    let resultArr = [];
    for (const index in arr) {
        if (arrFi.includes(arr[index])) resultArr.push(arr[index]);
    }
    return resultArr.length ? resultArr : false;
}

bai3();