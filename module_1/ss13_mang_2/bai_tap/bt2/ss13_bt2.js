let inputText = document.getElementById('inputText');
let outputText = document.getElementById('outputText');
let labelOutputText = document.getElementById('labelOutputText');
let arr_Eng = ["banana", "apple", "orange", "pen", "pencil", "book"];
let arr_Vie = ["chuối", "táo", "cam", "bút", "bút chì", "sách"];
let trHiddenAddWord = document.getElementById('trHiddenAddWord');
let meanVie = document.getElementById('meanVie');
let meanEng = document.getElementById('meanEng');

function getOutputText(arrSelected, arrTranslated) {
    // console.log(inputText.value);
    if (labelOutputText.innerHTML == "Tiếng Việt - Tiếng Anh") {
        arrSelected = arr_Vie;
        arrTranslated = arr_Eng;
    } else {
        arrSelected = arr_Eng;
        arrTranslated = arr_Vie;
    }
    for (let i = 0; i < arrSelected.length; i++) {
        if (arrSelected[i] == inputText.value) {
            outputText.value = arrTranslated[i];
        }
    }
    if (outputText.value == "") {
        outputText.value = "Không có từ này trong từ điển hiện có";
    }
}

function changeTranslateLanguage() {
    console.log(labelOutputText.innerHTML == "Tiếng Việt - Tiếng Anh");
    if (labelOutputText.innerHTML == "Tiếng Việt - Tiếng Anh") {
        labelOutputText.innerHTML = "Tiếng Anh - Tiếng Việt";
    } else {
        labelOutputText.innerHTML = "Tiếng Việt - Tiếng Anh";
    }
}

function changeHiddens() {
    trHiddenAddWord.hidden = !trHiddenAddWord.hidden;
}

function addWordToLibary() {
    if ((meanVie.value == "") || (meanEng.value == "")) {
        alert('Hãy nhập đủ!')
    } else {
        arr_Vie.push(meanVie.value);
        arr_Eng.push(meanEng.value);
        alert('Đã thêm từ vào từ điển!');
    }
}