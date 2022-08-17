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

//Viết hàm tính bình phương của một số bất kỳ được đưa vào. Gọi hàm vừa xây dựng được.
function bai1() {
    let enterNumber = +prompt('Nhập vào một số bất kỳ:');
    document.write('Bình phương của ' + enterNumber + ' là ' + caculateSquare(enterNumber));
}

function caculateSquare(number) {
    number *= number;
    return number;
}

//Viết hàm tính diện tích, hàm tính chu vi hình tròn. Gọi hàm vừa xây dựng được
function bai2() {
    let enterRadius = +prompt('Nhập vào chu vi hình tròn: ');
    document.write('Chu vi hình tròn đó là: ' + caculatePerimeterCircle(enterRadius) + '<br>');
    document.write('Diện tích hình tròn đó là: ' + caculateAreaCircle(enterRadius) + '<br>');
    inputBtnReloadEx();
}

function caculateAreaCircle(radiusCircle) {
    let areaCircle = radiusCircle * radiusCircle * Math.PI;
    return areaCircle;
}

function caculatePerimeterCircle(radiusCircle) {
    let perimeterCircle = radiusCircle * Math.PI;
    return perimeterCircle;
}

//Viết hàm tính giai thừa của một số nguyên bất kỳ được đưa vào. Gọi hàm vừa xây dựng được.
function bai3() {
    let enterNumber = +prompt('Nhập vào 1 số: ');
    document.write('Giai thừa của ' + enterNumber + ' là ' + caculateFactorial(enterNumber));
    inputBtnReloadEx();
}

function caculateFactorial(number) {
    if (number == 2) {
        return 2;
    } else {
        return number * caculateFactorial(number - 1);
    }
}

function bai4() { //Viết hàm kiểm tra xem ký tự nhập vào có phải là ký tự số không. Nếu là ký tự số hàm trả về true, ngược lại trả về false.
    let enterNumber = prompt('Nhập vào 1 số: ');
    if (checkIsNumber(enterNumber)) {
        document.write(enterNumber + ' là 1 số');
    } else {
        document.write(enterNumber + ' không phải là 1 số');
    }
    inputBtnReloadEx();
}

function checkIsNumber(number) {
    if (!isNaN(+number)) {
        return true;
    } else {
        return false;
    }
}

function bai5() { //Viết hàm nhận vào 3 số nguyên bất kỳ, trả về số nguyên có giá trị nhỏ nhất.
    let number1 = +prompt('Nhập vào số thứ 1: ');
    let number2 = +prompt('Nhập vào số thứ 2: ');
    let number3 = +prompt('Nhập vào số thứ 3: ');
    document.write('Số nhỏ nhất là: ' + checkIsMin(number1, number2, number3));
    inputBtnReloadEx();
}

function checkIsMin(number1, number2, number3) {
    let numberisMin = Math.min(number1, number2, number3);
    return numberisMin;
}

function bai6() {//Viết hàm nhận vào một số, kiểm tra xem nếu số đưa vào có phải là nguyên dương không. Nếu là nguyên dương trả về true, ngược lại trả về false.
    let number = +prompt('Nhập vào một số:');
    document.write(checkHighThan0(number));
    inputBtnReloadEx();
}

function checkHighThan0(number) {
    return number > 0 ? true : false;
}

function bai7() {//Viết hàm truyền vào 2 số nguyên bất kì, thực hiện đổi chỗ hai số nguyên đó.
    let number1 = +prompt('Nhập vào số thứ nhất: ');
    let number2 = +prompt('Nhập vào số thứ hai:');
    document.write('Số thứ nhất là: ' + number1 + ' và Số thứ hai là: ' + number2);
    // b = a + (a = b) - b;
    // console.log(a + ' ' + b);
    swapTwoNumber(number1, number2);
    inputBtnReloadEx();
}

function swapTwoNumber(number1, number2) {
    // let saveNumber = number1;
    number2 = number1 + (number1 = number2) - number2;
    // number2 = saveNumber;
    document.write('Sau khi hoán đổi : Số thứ nhất là: ' + number1 + ' và Số thứ 2 là: ' + number2);
}

function bai8() {//Viết hàm truyền vào mảng số nguyên bất kỳ, sau đó đảo ngược mảng số nguyên đó.
    reverseArray(createDimensionalArray());
    inputBtnReloadEx();
}

function createDimensionalArray() {
    let sizeArray = +prompt('Nhập vào độ dài của mảng: ');
    let arrUnChecked = [];
    for (let i = 0; i < sizeArray; i++) {
        arrUnChecked[i] = prompt('Nhập và phần tử thứ ' + (i + 1) + ' của mảng');
    }
    // document.write('Các phần tử trong mảng vừa nhập là: ' + arrUnChecked.join(', ') + '<br>');
    return arrUnChecked;
}

function reverseArray(arr) {
    arr = arr.reverse();
    document.write(arr.join(','));
}

function bai9() {//Viết hàm truyền vào một mảng ký tự, và một ký tự bất kỳ, kiểm tra xem ký tự bất kỳ đó có nằm trong mảng không. Nếu có trả về số lần xuất hiện của ký tự đó, nếu không trả về -1. 
    let arr = createDimensionalArray();
    let randomString = prompt('Nhập vào 1 ký tự bất kì: ');
    document.write(checkHasInArray(arr, randomString));
    inputBtnReloadEx();
}

function checkHasInArray(arr, randomString) {
    let countHasInArrayTimes = 0;
    for (const value of arr) {
        if (value === randomString) {
            countHasInArrayTimes++;
        }
    }
    return countHasInArrayTimes > 0 ? countHasInArrayTimes : -1;
}