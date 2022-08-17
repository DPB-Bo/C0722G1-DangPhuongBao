function createDimensionalArray() {
    let sizeArray = +prompt('Nhập vào độ dài của mảng: ');
    let arrUnChecked = [];
    for (let i = 0; i < sizeArray; i++) {
        arrUnChecked[i] = prompt('Nhập và phần tử thứ ' + (i + 1) + ' của mảng');
    }
    document.write('Các phần tử trong mảng vừa nhập là: ' + arrUnChecked.join(', ') + '<br>');
    return arrUnChecked;
}

function checkValidNumber(arrUnChecked) {
    // arrUnChecked = +arrUnChecked;
    let arrCheckedValid = [];
    let countNotValid = 0;
    for (const indexArrChecked in arrUnChecked) {
        if (arrUnChecked[indexArrChecked] < 2 ||
            isNaN(arrUnChecked[indexArrChecked])) {
            countNotValid++;
        } else {
            arrCheckedValid.push(arrUnChecked[indexArrChecked]);
        }
    }
    if (countNotValid >= arrUnChecked.length) {
        document.write('Hàm vừa nhập không hợp lệ');
        return false;
    } else {
        document.write('Hàm có ' + countNotValid + ' phần tử không hợp lệ <br>');
        document.write('Hàm sau khi lược bỏ các giá trị không hợp lệ: ' + arrCheckedValid.join(',') + '<br>');
        return arrCheckedValid;
    }
}

function checkElementNumbers(arrCheckedValid) {
    let countCheckIsElementNumber = 0;
    let arrElementNumbers = [];
    for (let i = 0; i < arrCheckedValid.length; i++) {
        for (let j = 2; j <= Math.sqrt(arrCheckedValid[i]); j++) {
            if (arrCheckedValid[i] % j == 0) {
                countCheckIsElementNumber++;
            }
        }
        if (countCheckIsElementNumber == 0) {
            arrElementNumbers.push(arrCheckedValid[i]);
        }
        countCheckIsElementNumber = 0;
    }
    return arrElementNumbers;
}

function writeEleNumInArray() {
    let arrUnChecked = createDimensionalArray();
    let arrCheckedValid = checkValidNumber(arrUnChecked);
    let arrElementNumbers = checkElementNumbers(arrCheckedValid);
    for (let i = 0; i < arrElementNumbers.length; i++) {
        document.write('Số nguyên tố thứ ' + (i + 1) + ' trong mảng đã nhập là: ' + arrElementNumbers[i] + '<br>');
    }
}

writeEleNumInArray();