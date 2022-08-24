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

function bai1() {
    let randomName = prompt("Nhập vào 1 tên: ");
    document.write('Tên bạn vừa nhập là: ' + randomName + br);
    document.write('Tên chuyển hoá tên bạn vừa nhập là: ' + setRightName(randomName) + br);
    document.write('Từ dài nhất trong tên bạn vừa nhập là: ' + getLongestWord(randomName) + br);
    inputBtnReloadEx();
}

function setRightName(randomName) {
    let randomNameSplit = randomName.split(' ');
    let rightName = '';
    for (let i = 0; i < randomNameSplit.length; i++) {
        rightName += randomNameSplit[i].charAt(0).toUpperCase();
        for (let j = 1; j < randomNameSplit[i].length; j++) {
            rightName += randomNameSplit[i].charAt(j).toLowerCase();
        }
        rightName += ' ';
    }
    return rightName;
}

function getLongestWord(randomName) {
    let randomNameSplit = randomName.split(' ');
    let longestWord = '';
    for (let i = 0; i < randomNameSplit.length; i++) {
        if (longestWord.length < randomNameSplit[i].length) {
            longestWord = randomNameSplit[i];
        }
    }
    return longestWord;
}

function bai2() {
    let randomString = prompt('Nhập 1 chuỗi bất kì: ');
    document.write('Chuỗi kí tự vừa nhập là: ' + randomString + br);
    document.write('Các kí tự khác nhau trong chuỗi bạn vừa nhập là vừa nhập là: ' + getDiffCharacter(randomString).join(','));
    inputBtnReloadEx();
}

function getDiffCharacter(randomString) {
    let arrCvertToArr = Array.from(randomString);
    let objectNoDuplicated = new Set(arrCvertToArr);
    let arrDiffCharacter = Array.from(objectNoDuplicated);
    return arrDiffCharacter;
}

function bai3() {
    let randomString1 = prompt('Nhập 1 chuỗi bất kì: ');
    let randomString2 = prompt('Nhập 1 chuỗi bất kì: ');
    document.write('Chuỗi 1 bạn vừa nhập là: ' + randomString1 + br);
    document.write('Chuỗi 2 bạn vừa nhập là: ' + randomString2 + br);
    document.write('Số lượng kí tự chung của chúng là: ' + getTimeDuplicated(randomString1, randomString2));
    inputBtnReloadEx();
}

function getTimeDuplicated(randomString1, randomString2) {
    let arrString1 = Array.from(randomString1);
    let arrString2 = Array.from(randomString2);
    let arrString3 = [];
    for (let i = 0; i < arrString1.length; i++) {
        for (let j = 0; j < arrString2.length; j++) {
            if (arrString1[i] == arrString2[j]) {
                arrString3.push(arrString1[i]);
                arrString2.splice(j, 1);
            }
        }
    }
    // arrString3 = Array.from(new Set(arrString3));
    return arrString3.length;
}