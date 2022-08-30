function bai2() {
    let randomStr = prompt('Nhập vào 1 chuỗi kí tự cần viết tắt: ');
    checkValidString(randomStr) ? randomStr = checkValidString(randomStr) : alert('Chuỗi chỉ có 1 từ nên không cần viết tắc!');
    let result = '';
    for (let i = 0; i < randomStr.length; i++) {
        result += randomStr[i][0].toUpperCase();
    }
    document.write(result);
}

function checkValidString(randomStr) {
    randomStr = randomStr.split(' ');
    for (let i = 0; i < randomStr.length; i++) {
        if (randomStr[i].length == 0) {
            randomStr.splice(i, 1);
            i = -1;
        }
    }
    if (randomStr.length < 2) {
        return false;
    }
    return randomStr;
}

bai2();