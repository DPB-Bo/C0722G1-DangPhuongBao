let valueSelected = document.getElementById("selectEx");
let valueget;

function getValue() {
    valueget = valueSelected.value;
    console.log(valueget);
    // console.log(valueget);
}

function playEx() {
    check = valueget;
    // console.log(typeof check);
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
        case "6":
            bai6();
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

function createDimensionalArray() {
    let sizeArray = +prompt('Nhập vào số lượng phần tử của mảng: ');
    let arr = [];
    for (let i = 0; i < sizeArray; i++) {
        arr[i] = +prompt('Nhập vào phần tử tại chỉ số thứ ' + (i + 1) + ' của mảng: ');
    };
    return arr;
}

function bai1() {
    let arrBai1 = [];
    let r = +prompt('Nhập vào số chiều của mảng đa chiều này: ');
    let d = +prompt('Nhập vào chiều dài của 1 mảng trong mảng đa chiều này: ');
    for (let i = 0; i < r; i++) {
        arrBai1[i] = [];
        for (let j = 0; j < d; j++) {
            arrBai1[i][j] = +prompt('Nhập vào phần tự tại vị trí ' + i + j);
        }
    }
    document.write(arrBai1);
    inputBtnReloadEx();
}

function bai2() {
    let arrBai2 = createDimensionalArray();
    document.write(arrBai2.reverse());
    inputBtnReloadEx();
}

function bai3() {
    let arrBai3 = createDimensionalArray();
    let count = 0;
    for (let i = 0; i < arrBai3.length; i++) {
        if (arrBai3[i] !== NaN) {
            count++;
        }
    }
    document.write('Số kí tự số có trong mảng là: ' + count);
}

function bai4() {
    let arrBai4 = createDimensionalArray();
    let count = 0;
    for (let i = 0; i < arrBai4.length; i++) {
        if (arrBai4[i] == NaN) {
            count++;
        }
    }
    document.write('Số kí tự không phải số có trong mảng là: ' + count);
}

function bai5() {
    alert('Nhập mảng A:')
    let arrA = createDimensionalArray();
    alert('Nhập mảng B:')
    let arrB = createDimensionalArray();
    let count = 0;
    for (let i = 0; i < arrA.length; i++) {
        if (arrA[i] == arrB[i]) {
            count++;
        }
    }
    if (count == arrA.length) {
        alert('2 mảng này bằng nhau:');
    } else {
        alert('2 mảng này không bằng nhau');
    }
    inputBtnReloadEx();
}

function bai6() {
    let arrBai6 = createDimensionalArray();
    for (let i = 0; i < arrBai6.length; i++) {
        if (arrBai6[i] == '-') {
            arrBai6[i] = '_'
        }
    }
    document.write(arrBai6);
    inputBtnReloadEx();
}