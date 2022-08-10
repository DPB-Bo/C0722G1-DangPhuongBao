let valueSelected = document.getElementById("selectEx");
let valueget;

function bai1(){
    let i = 0;
    let text = "";
    for (;i<5;i++){
        text += "The number is " + i + "<br>";
    } ;
    console.log(text);
}
function bai2(){
    let num = +prompt("Nhập vào 1 số bất kì: ");
    let sum = 0;
    for (let i=0;i<num;i++){
        sum += i;
    };
    console.log(sum);
}

function getValue() {
    valueget = valueSelected.value;
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
    }
  }