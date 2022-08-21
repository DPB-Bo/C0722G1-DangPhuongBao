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

//Viết 1 hàm nhận vào 1 số nguyên bất kì. Hiển thị các số KHÔNG phải số nguyên tố từ 0 đến số đấy.

function bai1() {
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

//Viết 1 hàm nhận vào 1 mảng các số nguyên. Đếm số lần xuất hiện của các phần tử trong mảng đó

function bai2() {
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
    document.write(checkIsElementNumber(checkIsFibonacci(enterNumber)).join('<br>'));
    inputBtnReloadEx();
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
    for (let i = 0; i < arr.length; i++) {
        for (let j = 2; j <= Math.sqrt(arr[i]); j++) {
            if (arr[i] % j === 0) {
                arr.splice(i, 1);
                i--;
                j = 2;
            }
        }
    }
    return arr;
}

// Viết chương trình cho người dùng nhập vào 1 mảng số nguyên với độ dài cho người dùng tùy chọn tuy nhiên không được lớn hơn 50. Sau đó tiếp tục thực hiện 2 yêu cầu: 
// a)	In ra mảng người dùng vừa nhập.
// b)	Tính trung bình cộng của số chẵn tại vị trí lẻ trong mảng


function bai4() {
    let sizeArray = +prompt('Nhập vào số lượng phần tử của mảng số nguyên (không lớn hơn 50): ');
    if (sizeArray.length > 50) {
        alert('Không lớn hơn 50!');
        sizeArray = +prompt('Nhập vào số lượng phần tử của mảng số nguyên (không lớn hơn 50): ');
    }
    let arr = [];
    for (let i = 0; i < sizeArray; i++) {
        arr[i] = +prompt('Nhập vào phần tử tại chỉ số thứ ' + (i + 1) + ' của mảng: ');
    };
    document.write('Mảng vừa nhập là: <br>' + arr.join('<br>'));
    document.write('Tổng các số chẵn tại ví trí lẻ trong mảng là: ' + averageEvenNumberOddIndex(arr));
    inputBtnReloadEx();
}

function averageEvenNumberOddIndex(arr) {
    let sum = 0;
    for (let i = 1; i < arr.length; i += 2) {
        if (arr[i] % 2 == 0) {
            sum += arr[i];
        }
    }
    return sum;
}

// Xây dựng 1 hàm nhận vào 1 mảng số nguyên và 1 số nguyên number bất kì. Hàm trả về 1 mảng thỏa mãn điều kiện sau:
// Nếu number là số lẻ, thì tất cả số chẵn trong mảng sẽ tăng lên 1 đơn vị.
// Ngược lại nếu number là số chẵn thì tất cả số lẻ trong mảng tăng lên 1 đơn vị. 
// Ngoài ra tất cả các số trong mảng trùng với number sẽ được đổi thành -1.


function bai5() {
    let arrNumber = createDimensionalArray();
    let randomNumber = +prompt('Nhập 1 số ngẫu nghiên ');
    let checkRandomNumber = randomNumber % 2 == 0 ? true : false;
    document.write('Mảng bạn vừa nhập là: <br>' + arrNumber.join('<br>'));
    document.write('<br> Số bạn vừa nhập là: ' + randomNumber + '<br>');
    document.write('Mảng bạn sau khi chuyển đổi dựa theo số đã nhập (chẵn hoặc lẽ) là: <br>' + setArrBaseOnNumber(checkRandomNumber, randomNumber, arrNumber).join('<br>'));
    inputBtnReloadEx();
}

function setArrBaseOnNumber(isEven, randomNumber, arr) {
    for (const index in arr) {
        if (arr[index] === randomNumber) {
            arr[index] = -1;
        }
        if (isEven) {
            if (arr[index] % 2 != 0 && arr[index] % 2 != -1) {
                arr[index] += 1;
            }
        } else if (arr[index] % 2 == 0) {
            arr[index] += 1;
        }
    }
    return arr;
}

// Xây dựng 1 hàm nhận vào 2 mảng bất kì. Nếu mảng thứ 2 là con của mảng thứ nhất thì trả về true, ngược lại trả về false. Ví dụ: 
// •	Mảng thứ nhất [ 1, 2, 3, 4 ] mảng thứ 2 [2, 3] => true. 
// •	Mảng thứ nhất [ 1, 2, 3, 4 ] mảng thứ 2 [3, 2] => false.

function bai6() { // với điều kiện là  mảng cha k có phần tử lặp 
    let arrFather = createDimensionalArray();
    let arrSon = createDimensionalArray();
    let checkDuplicated = new Set(arrFather.concat(arrSon));
    let checkDuplicatedSize = checkDuplicated.size;
    document.write('Mảng 1 là: ' + arrFather.toString() + '<br>');
    document.write('Mảng 2 là: ' + arrSon.toString() + '<br>');
    checkIsSonArr2(arrFather, arrSon, checkDuplicatedSize) ? document.write('Mảng 2 là mảng con của Mảng 1') : document.write('Mảng 2 không là mảng con của Mảng 1');
    inputBtnReloadEx();
}

function checkIsSonArr1(arrFather, arrSon, checkDuplicatedSize) { // check k tính đúng vị trí .. hmmmmmmmm
    let count = 0;
    if (arrFather.length != checkDuplicatedSize) {
        return false;
    }
    for (let i = 0; i < arrSon.length; i++) {
        if (arrFather.some(function (elementFather) {
            return elementFather == arrSon[i];
        })) {
            count++;
        }
    }
    return count == arrSon.length ? true : false;
}

function checkIsSonArr2(arrFather, arrSon, checkDuplicatedSize) {
    let save = 0;
    if (arrFather.length != checkDuplicatedSize) {
        return false;
    }
    for (let i = 0; i < arrSon.length; i++) {
        for (let j = 0; j < arrFather.length; j++) {
            // save = j;
            if (j < save) {
                continue;
            }
            if (arrSon[i] == arrFather[j]) {
                count++;
                save = j;
            }
        }
    }
    return count == arrSon.length ? true : false;
}


// 1234 32
// s[0]!=a[0];
// s[0]!=a[1];
// s[0]==a[2];
// s[1]
// s[1]==a[3];