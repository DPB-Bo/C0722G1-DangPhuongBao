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
    let d = parseInt(prompt("Chiều dài của hình chữ nhật: "));
    let r = parseInt(prompt("Chiều rộng của hình chữ nhật: "));
    let down = "<br>";
    let count = 0;
    let lineFirstAndLast = "";
    let lineMiddle = "*";
    while (count < d) {
        lineFirstAndLast += "*";
        count++;
    }
    count = 0;
    while (count < d) {
        if (count == d - 2) {
            lineMiddle += "*";
            break;
        }
        lineMiddle += "&ensp;";
        count++;
    }
    count = 0;
    let hinhChuNhat = lineFirstAndLast + down;
    while (count < r) {
        if (count == r - 2) {
            hinhChuNhat += lineFirstAndLast;
            break;
        }
        hinhChuNhat += lineMiddle + down;
        count++;
    }
    document.write(hinhChuNhat);
    inputBtnReloadEx();
}

function bai2() {
    let n = +prompt('Nhập vào chiều cao tam giác: ');
    for (let i = 1; i <= n; i++) {
        for (let j = 1; j <= i; j++) {
            if (j == 1 || j == i || i == n) {
                document.write('*');
            } else {
                document.write('&ensp;');
            }
        }
        document.write('<br>');
    }
    inputBtnReloadEx();
}

function bai3() {
    let n = +prompt('Nhập vào chiều cao của tam giác');
    let left = n;
    let right = n;
    for (let i = 1; i <= n; i++) {
        for (let j = 1; j <= 2 * n - 1; j++) {
            if (j >= left && j <= right) {
                document.write('*');
            } else {
                document.write('&ensp;');
            }
        }
        left--;
        right++;
        document.write('<br>');
    }
}

function bai4() {
    let n = +prompt('Nhập vào chiều cao của tam giác');
    let left = n;
    let right = n;
    for (let i = 1; i <= n; i++) {
        for (let j = 1; j <= 2 * n - 1; j++) {
            if (j == left || j == right || i == n) {
                document.write('*');
            } else {
                document.write('&ensp;');
            }
        }
        left--;
        right++;
        document.write('<br>');
    }
}