let valueSelected = document.getElementById("selectEx");
let valueget;

function getValue() {
    valueget = valueSelected.value;
    // console.log(valueget);
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
    let sizeArray = +prompt('Nhập vào số lượng phần tử của mảng số nguyên: ');
    let arr = [];
    for (let i = 0; i < sizeArray; i++) {
        arr[i] = +prompt('Nhập vào phần tử tại chỉ số thứ ' + (i + 1) + ' của mảng: ');
    };
    return arr;
}

function bai1() { //Viết 1 hàm nhận vào 1 số nguyên bất kì. Hiển thị các số KHÔNG phải số nguyên tố từ 0 đến số đấy.
    let enterNumber = +prompt('Nhập vào 1 số nguyên bất kì: ');
    document.write('Số vừa nhập là: ' + enterNumber + '<br>');
    document.write('Các số không phải là số nguyên từ 0 tới số vừa lập là:<br>');
    getNumberNotElement(enterNumber);
    inputBtnReloadEx();
}

function getNumberNotElement(randomNumber) {
    for (let i = 0; i < randomNumber; i++) {
        for (let j = 2; j < i; j++) {
            if (i % j === 0) {
                document.write(i + '<br>');
                i++;
            }
        }
    }
}


function bai2() {//Viết 1 hàm nhận vào 1 mảng các số nguyên. Đếm số lần xuất hiện của các phần tử trong mảng đó
    let arrRandomNumber = createDimensionalArray();
    document.write('Mảng đã nhập là: ' + arrRandomNumber.toString() + '<br>');
    countDupTimes(arrRandomNumber);
    inputBtnReloadEx();
}

function countDupTimes(randomArray) {
    let count = 1;
    for (let i = 0; i < randomArray.length; i++) {
        for (let j = i + 1; j < randomArray.length; j++) {
            if (randomArray[i] == randomArray[j]) {
                count++;
                randomArray.splice(j, 1);
                j--;
            }
        }
        document.write('Phần tử có giá trị: ' + randomArray[i] + ' có số lần xuất hiện là: ' + count + '<br>');
        count = 1;
    }
}

//Viết 1 hàm nhận vào 1 số nguyên duy nhất hàm trả về mảng số nguyên từ 0 đến số được truyền vào
//phải thỏa mãn 2 yêu cầu: thứ nhất số đó thuộc dãy fibonacci , thứ 2 số đó phải là số nguyên tố. In ra mảng đấy.

function bai3() {
    let enterNumber = +prompt('Nhập vào 1 số ngẫu nhiên');
    document.write('Số đã nhập vào là: ' + enterNumber + '<br>');
    document.write('Các số vừa là số Fibonacci vừa là số nguyên tố bắt đầu từ 0 đến số đã nhập là: <br>');
    // document.write(checkIsElementNumber(checkIsFibonacci(enterNumber)).join('<br>'));
    document.write(checkIsElementNumber(enterNumber).join('<br>'));
}


function checkIsFibonacci(number) {
    let a = 1;
    let b = 1;
    let sum = 0;
    let arr = [];
    for (let i = 0; i < number; i++) {
        // if (sum > number) {
        //     break;
        // } else {
        sum = a + b;
        if (sum > number) {
            break;
        }
        arr[i] = sum;
        a = b;
        b = sum;
    }
    return arr;
}

function checkIsElementNumber(arr) {
    // let arr = [];
    for (let i = 0; i < arr.length; i++) {
        for (let j = 2; j <= Math.sqrt(i); j++) {
            if (i % j === 0) {
                arr.push(i);
                break;
            }
        }
    }
    return arr;
}