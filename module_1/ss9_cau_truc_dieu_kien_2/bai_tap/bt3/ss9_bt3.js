screenBox = document.getElementById("screenBox");
// thêm value vào chuỗi
function addToScreen(num){
    screenBox.value += num;
}
function allClear(){
    screenBox.value = "";
}

function del(){
    screenBox.value = screenBox.value.slice(0,-1);
}

function getResult(){
    try{
        screenBox.value = eval(screenBox.value);
    } catch(e){
        alert("Hãy nhập một biểu thức đúng!")
    }
}