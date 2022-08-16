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
        case "7":
            bai7();
            break;
        case "8":
            bai8();
            break;
        case "9":
            bai9();
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
    let n = +prompt('Nhập vào số lượng phần tử của mảng: ');
    let num = [];
    let x;
    let count = 0;
    for (let i = 0; i < n; i++) {
        x = +prompt('Nhập vào phần tử tại chỉ số thứ ' + i + ' của mảng: ');
        num.push(x);
    }
    for (const index in num) {
        if (num[index] >= 10) {
            document.write(num[index] + ' là phần tử lớn hơn 10 trong mảng tại chỉ số ' + index + '<br>');
            count++;
        }
    }
    if (count == 0) {
        document.write('Mảng không có phần tử lớn hơn 10');
    } else {
        document.write('Mảng có ' + count + ' phần tử lớn hơn 10');
    }
    inputBtnReloadEx();
}

function bai2() {
    let n = +prompt('Nhập vào số lượng phần tử của mảng: ');
    let num = [];
    let max = 0;
    let chiSoMax = 0;
    for (let i = 0; i < n; i++) {
        num[i] = +prompt('Nhập vào phần tử tại chỉ số thứ ' + (i + 1) + ' của mảng: ');
    }
    for (let i = 0; i < num.length; i++) {
        for (let j = 0; j < num.length; j++) {
            if (j == i) {
                continue;
            } else if (num[i] == num[j]) {
                alert('Phần tử tại chỉ số ' + i + ' trùng với phần tử tại chỉ số ' + j + ' = ' + num[i]);
                num[i] = +prompt('Nhập lại phần tử tại chỉ số ' + i);
            }
        }
    }
    for (let i = 0; i < num.length; i++) {
        if (max < num[i]) {
            max = num[i];
            chiSoMax = i;
        }
    }
    document.write('Phần tử lớn nhất có giá trị là: ' + max + ' tại chỉ số ' + (chiSoMax + 1));
    inputBtnReloadEx();
}

function bai3() {
    let n = +prompt('Nhập vào số lượng phần tử của mảng: ');
    let num = [];
    let max = 0;
    let chiSoMax = 0;
    let sum = 0;
    for (let i = 0; i < n; i++) {
        num[i] = +prompt('Nhập vào phần tử tại chỉ số thứ ' + (i + 1) + ' của mảng: ');
    }
    for (let i = 0; i < num.length; i++) {
        if (max < num[i]) {
            max = num[i];
            chiSoMax = i;
        }
    }
    for (let i = 0; i < num.length; i++) {
        sum += num[i];
    }
    document.write('Phần tử lớn nhất có giá trị là: ' + max + ' tại chỉ số ' + (chiSoMax + 1));
    document.write('Giá trị trung bình của mảng là:' + (sum / num.length));
    inputBtnReloadEx();
}

function bai4() {
    let n = +prompt('Nhập vào số lượng phần tử của mảng: ');
    let num = [];
    for (let i = 0; i < n; i++) {
        num[i] = +prompt('Nhập vào phần tử tại chỉ số thứ ' + (i + 1) + ' của mảng: ');
    }
    document.write('Đảo ngược của mảng :' + num.reverse());
    inputBtnReloadEx();
}

function bai5() {
    let arrBai5 = createDimensionalArray();
    let count = 0;
    for (let i = 0; i < arrBai5.length; i++) {
        if (arrBai5[i] < 0) {
            count++;
            document.write('Tìm thấy số nguyên âm tại chỉ số thứ ' + i + ' là: ' + arrBai5[i] + '<br>');
        }
    }
    document.write('Mảng có ' + count + ' số nguyên âm');
    inputBtnReloadEx();
}

function createDimensionalArray() {
    let sizeArray = +prompt('Nhập vào số lượng phần tử của mảng: ');
    let arr = [];
    for (let i = 0; i < sizeArray; i++) {
        arr[i] = +prompt('Nhập vào phần tử tại chỉ số thứ ' + (i + 1) + ' của mảng: ');
    };
    return arr;
}

function bai6() {
    let arrBai6 = createDimensionalArray();
    let n = +prompt('Nhập vào số muốn kiểm tra: ');
    let count = 0;
    document.write('Số đã nhập là: ' + n);
    for (let i = 0; i < arrBai6.length; i++) {
        if (arrBai6[i] == n) {
            document.write('Phát hiện phần tử tại chỉ số ' + i + ' trùng với số đã nhập <br>');
            count++;
        }
    }
    document.write('Có ' + count + ' phần tử trùng với số đã nhập');
    inputBtnReloadEx();
}

function bai7() { // idea 2 là tạo 1 mảng khác rồi duyệt mảng đó = với mảng sau nhưng k có số đã nhập rồi sau đó lại gán mảng đó về mảng đầu
    let arrBai7 = createDimensionalArray();
    let n = +prompt('Nhập vào số muốn kiểm tra: ');
    let count = 1;
    document.write('Số cần kiểm tra là: ' + n + '<br>');
    document.write('Mảng trước khi kiểm tra là: ' + arrBai7.join(',') + '<br>');
    for (let i = 0; i < arrBai7.length; i++) {
        if (arrBai7[i] == n) {
            for (let j = i; j < arrBai7.length - 1; j++) {
                arrBai7[j] = arrBai7[j + 1];
            }
            arrBai7[arrBai7.length - 1] = 0;
            i--;
        }
    }
    document.write('Số lần số cần kiểm tra xuất hiện trong mảng là: ' + n + '<br>');
    document.write('Mảng sau khi đã kiểm tra và xoá nếu tồn tại số đã nhập:' + arrBai7.join(','));
    inputBtnReloadEx();
}

function bai8() {
    let arrBai8 = createDimensionalArray();
    // let arr1 = ['a', 'b', 'c', 'd', 'e', 'f'];
    // document.write(arrBai8.sort());
    if ((typeof arrBai8[1]) == 'string') {
        arrBai8.sort().reverse();
    } else if ((typeof arrBai8[1]) == 'number') {
        arrBai8.sort(function (a, b) { return b - a; });
    }
    document.write(arrBai8.join(','));
}

function bai9() {
    alert('Nhập mảng A: ');
    let arrA = createDimensionalArray();
    alert('Nhập mảng B: ');
    let arrB = createDimensionalArray();
    let arrC = [];
    // console.log(arrA.toString());
    // console.log(arrB.toString());
    for (let i = 0; i < (arrA.length + arrB.length); i += 2) {
        arrC[i] = arrA[i];
        arrC[i + 1] = arrB[i];
    }
    document.write(arrC);
}
