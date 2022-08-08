var number1= document.getElementById('number1');
var number2= document.getElementById('number2');
function caculator(){
    
    // toantu = document.getElementById('').value;
    // // result= eval('number1.value + toantu.value + number2.value');
    // // document.getElementById('result').value = result;
    // document.getElementById('result').value=toantu;
    let a = parseFloat(number1.value);
    let b = parseFloat(number2.value);
    alert(a + b);
}