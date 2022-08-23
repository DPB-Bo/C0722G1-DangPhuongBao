let valueSelected = document.getElementById("selectEx");
let valueget;
let br = '<br>';

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
        case "3":
            bai3();
            break;
        case "4":
            bai4();
            break;
        case "5":
            bai5();
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

function createArrayElementNumber() {
    let arrLength = +prompt('Nhập vào số lượng phần tử trong mảng: ');
    let arr = new Array(arrLength);
    for (let i = 0; i < arr.length; i++) {
        arr[i] = +prompt('Nhập vào phần tử tại vị trí thứ ' + (i + 1) + ' của mảng: ');
    }
    return arr;
}

function bai1() {
    let arrA = createArrayElementNumber();
    let arrB = new Array(arrA.length);
    for (let i = 0; i < arrB.length; i++) {
        arrB[i] = 0;
        for (let j = 0; j < i + 1; j++) {
            arrB[i] += arrA[j];
        }
    }
    document.write('Mảng đã nhập là: ' + arrA.join(', ') + '<br>');
    document.write('Mảng prefixSum của mảng đã nhập là: ' + arrB.join(', '));
    inputBtnReloadEx();
}

function bai2() {
    let arrA = createArrayElementNumber();
    let arrB = createArrayElementNumber();
    let arrC = [];
    for (const value of arrB) {
        if (!arrA.includes(value)) {
            arrC.push(value);
        }
    }
    arrC.length
        ? document.write('Những phần tử xuất hiện trong mảng B mà không có trong mảng A là: ' + arrC.join(','))
        : document.write('Không có phần tử xuất hiện trong mảng B mà không có trong mảng A');
}

function bai3() {
    let arrNumberators = createArrayElementNumber();
    let arrDenominators = createArrayElementNumber();
    document.write('Mảng chứa các tử số trong phân số là: ' + arrNumberators.join(',') + br);
    document.write('Mảng chứa các mẫu số trong phân số là: ' + arrDenominators.join(',') + br);
    maxFraction(arrNumberators, arrDenominators);
    inputBtnReloadEx();
}

function maxFraction(arrNumberators, arrDenominators) {
    let maxFraction = arrNumberators[0] / arrDenominators[0];
    let indexMaxFraction = 0;
    for (const index in arrNumberators) {
        if (maxFraction < arrNumberators[index] / arrDenominators[index]) {
            maxFraction = arrNumberators[index] / arrDenominators[index];
            indexMaxFraction = index;
        }
    }
    document.write('Phân số lớn nhất tạo từ 2 mảng đã nhập là: ' + arrNumberators[indexMaxFraction] + '/' + arrDenominators[indexMaxFraction] + br);
    document.write('Chỉ số của phân số lớn nhất tạo từ 2 mảng đã nhập là: ' + indexMaxFraction);
}

function bai4() {
    let randomNumber = prompt('Nhập vào 1 số bất kì: ');
    let arrCovertNumberToStringNumber = []
    for (let i = 0; i < randomNumber.length; i++) {
        arrCovertNumberToStringNumber.push(convertNumberToStringNumber(randomNumber.charAt(i)));
    }
    document.write(arrCovertNumberToStringNumber.join(' '));
    inputBtnReloadEx();
}

function convertNumberToStringNumber(number) {
    let stringNumber = {
        '-': ['Âm'],
        0: ['Không'],
        1: ['Một'],
        2: ['Hai'],
        3: ['Ba'],
        4: ['Bốn'],
        5: ['Năm'],
        6: ['Sáu'],
        7: ['Bảy'],
        8: ['Tám'],
        9: ['Chín'],
    }
    return stringNumber[number];
}