let valueSelected = document.getElementById("selectEx");
let valueget;

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
      //   window.location.reload();
      break;
    case "2":
      bai2();
      break;
  }
}

function bai1() {
  let value = 0;
  do {
    value = prompt("Nhập vào số từ 1 -> 10");
  } while (value < 1 || value > 10);
  alert("Số bạn vừa nhập là " + value);
}
