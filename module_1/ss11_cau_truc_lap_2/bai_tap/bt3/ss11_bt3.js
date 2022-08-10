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
  for (let i = 1; i <= 100; i++) {
    document.write(i + "<br>");
    if (i == 99) {
      document.write("Vòng lặp hoàn thành!");
      break;
    }
  }
  inputBtnReloadEx();
}

function bai2() {
  let n = +prompt("Nhập vào nhiệt độ của phòng:");
  let isChecked = n < 20 || n > 100;
  while (isChecked) {
    n = +prompt(
      "Bạn nên tăng hoặc giảm nhiệt độ! Hãy nhập lại đã sữa tại đây: "
    );
  }
  while (!isChecked) {
    alert("Nhiệt độ ổn rồi đó! ");
  }
}

function bai3() {
  let n = +prompt("NHẬP VÀO SỐ LƯỢNG SỐ LƯỢNG FIBONACCI CẦN HIỂN THỊ:");
  let countFibonacci = 1;
  let a = 1; // tính fibonacci == a + b
  let b = 0;
  let fibonacciNumber;
  while (countFibonacci <= n) {
    fibonacciNumber = a + b;
    b = a; // phải để nó trước vì để sau thì biến a đi trước nên bị sai số
    a = fibonacciNumber;
    document.write("Số FIBONACCI thứ " + countFibonacci + " là: " + fibonacciNumber + "<br>");
    countFibonacci++;
  }
  inputBtnReloadEx();
}

