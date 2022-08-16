let valueSelected = document.getElementById("selectEx");
let valueget;

function getValue() {
    valueget = valueSelected.value;
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

function bai1() {
    let myColors = ["Red", "Green", "Black", "White"];
    console.log(myColors.join(',')); // in các kí tự của mảng ra dùng , .join(' ') kí tự trong () sẽ là kí tự xen kẽ  giữa các phần tử trong mảng
    myColors.forEach(function (color) {
        if (myColors[myColors.length - 1] != color) {
            document.write(color + ",");
        } else {
            document.write(color);
        }
    });
}
// bai1();

function bai2() {
    let num = prompt("Nhập vào dãy số bất kì:");
    let str = num.toString();
    let result = [str[0]];
    let i = 0;
    while (i < str.length) {
        if ((str[i - 1] % 2 == 0) && (str[i] % 2 == 0)) {
            result.push('-', str[i]);
        } else {
            result.push(str[i]);
        }
        i++;
    }
    document.write(result.join(''));
    inputBtnReloadEx();
}

function bai3() {
    let n = prompt('Nhập vào một chuỗi: ');
    let str = n.toString();
    let result = [];
    let i = 0;
    while (i < str.length) {
        if (str[i] === str[i].toLowerCase()) {
            result.push(str[i].toUpperCase());
        } else {
            result.push(str[i].toLowerCase());
        }
        i++;
    }
    document.write(result.join('') + '<br>');
    inputBtnReloadEx();
}
// let a = [1, 2, 3];
// a[3] = 4;
// console.log(a);
// let myEvenNumbers = [];
    // const NUM = window.prompt();
    // const STR = NUM.toString();
    // const RESULT = [STR[0], STR[4]];
    // console.log('Chuỗi STR: ' + STR);
    // console.log('loại của STR: ' + typeof STR);
    // console.log('ĐỘ DÀI Chuỗi STR: ' + STR.length);
    // console.log('Chuỗi RESULT: ' + RESULT);
    // console.log('loại của RESULT: ' + typeof RESULT);
// let randomArray = [1, 2, 3, 4, 5, 6, 6, 6, 6, 124, 123];   // Test join với toString
// let randomArray2 = [8, 9, 2, 34, 5, 6, 7];
// let concatArray = randomArray.concat(randomArray2);
// console.log('Array concat: ' + concatArray);
// console.log('Kiểu Array concat: ' + typeof concatArray);
// randomArray.join(',');
// let randomVar = randomArray.join(';');
// console.log('join: ' + randomArray.join('haha'));
// console.log('kiểu join: ' + typeof randomArray.join('haha'));
// console.log('Thử tính tổng bằng join: ' + eval(randomArray.join('+'))); // có thể ứng dụng để tính tổng nè
// console.log(randomVar[3]);
// console.log('toString: ' + randomArray.toString());

// let obj1 = {   // Tìm hiểu gán đối tượng Object.assign
//     name: 'Văn A',
//     tuoi: '22',
//     gender: 'Nam',
// }
// console.log(typeof obj1);
// let obj2 = [1, 2, 3, 4, 5, 56, 6, 7, 89,];
// console.log(typeof obj2);
// let obj2 = {
//     name: 'Văn B',
//     tuoi: '23',
//     gender: 'Nữ',
// }
// let a = Object.assign(obj1, obj2);
// console.log(a);