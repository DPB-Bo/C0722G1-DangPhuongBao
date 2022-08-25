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

function create2DimensionalArr() {
    let m = +prompt('Nhập vào độ dài của mảng 2 chiều: ');
    let n = +prompt('Nhập vào độ dài của phần tử trong mảng 2 chiều: ');
    let arr = [];
    for (let i = 0; i < m; i++) {
        arr[i] = [];
        for (let j = 0; j < n; j++) {
            arr[i][j] = +prompt('Nhập vào phần tử ở mảng con thứ ' + (i + 1) + ' vị trí thứ ' + (j + 1) + ' trong mảng:');
        }
    }
    return arr;
}

function bai1() {
    let arr2D = create2DimensionalArr();
    let sum = 0;
    for (const value of arr2D) {
        for (const value1 of value) {
            if (!(value1 % 2)) {
                sum += value1;
            }
        }
    }
    document.write('Mảng 2 chiều vừa nhập là: ' + arr2D.join(', ') + br);
    document.write('Tổng các phần tử chẵn trong mảng 2 chiều vừa nhập là: ' + sum);
}

function bai2() {
    let arr2D = create2DimensionalArr();
    let count = 0;
    for (let i = 0; i < arr2D.length; i++) {
        for (let j = 0; j < arr2D[i].length; j++) {
            if (isPrime(arr2D[i][j])) {
                count++;
            }
        }
    }
    document.write('Mảng 2 chiều vừa nhập là: ' + arr2D.join(', ') + br);
    document.write('Số lượng phần tử là số nguyên tố trong mảng đó là: ' + count);
}

function isPrime(n) {
    if (n < 2 || isNaN(n)) {
        return false;
    } else {
        for (let i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}

function bai3() {
    let arr2D = create2DimensionalArr();
    let max = arr2D[0][0];
    for (let i = 0; i < arr2D.length; i++) {
        if (max < Math.max(...arr2D[i])) {
            max = Math.max(...arr2D[i]);
        }
    }
    document.write('Mảng 2 chiều vừa nhập là: ' + arr2D.join(', ') + br);
    document.write('Số lớn nhất trong mảng 2 chiều vừa nhập là: ' + max + br);
}