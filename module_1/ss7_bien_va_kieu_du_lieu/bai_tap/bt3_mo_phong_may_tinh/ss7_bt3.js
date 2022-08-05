var number1= document.getElementById('number1');
var number2= document.getElementById('number2');

function plus() {
    tong= number1.value*1 + number2.value*1;
    document.getElementById('Result').value = tong;
};
function minus() {
    hieu= number1.value*1 - number2.value*1;
    document.getElementById('Result').value = hieu;
};
function mutiple() {
    nhan= (number1.value*1)*(number2.value*1);
    document.getElementById('Result').value = nhan;
};
function divide() {
    thuong= ((number1.value*1)/(number2.value*1)).toFixed(4);
    document.getElementById('Result').value = thuong;
};
