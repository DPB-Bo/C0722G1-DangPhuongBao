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
    case "9":
      bai9();
    case "10":
      bai10();
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

// function inputn(){
//     let n = +prompt("Nhập vào số n: ");
// }

function bai1() {
  let n = +prompt("Nhập vào số n: ");
  let i = 1;
  let sum = 0;
  while (i <= n) {
    sum += 1 / i;
    i++;
  }
  document.write("Tổng các số 1 + 1/2 +...+1/n là: " + sum);
  inputBtnReloadEx();
}

function bai2() {
  let n = +prompt("Nhập vào số n: ");
  let i = 1; // phần tử lặp while 1
  let j = 1; // phần tử lặp while 2
  let z = 1; // n!
  let x = -1; // x = (-1) mũ n
  let y = 0; // y = 1/n! = 1/z
  let sum = 0; // kết quả : (-1) mũ n + 1/n! = x+y
  while (i <= n) {
    while (j <= n) {
      z *= j;
      j++;
    }
    x = Math.pow(x, i);
    y = 1 / z;
    sum += x + y;
    i++;
  }
  document.write("Kết quả của phép toán là: " + sum);
  inputBtnReloadEx();
}

function bai3() {
  let n = +prompt("Nhập vào số n: ");
  //   let x;
  //   let giaiThua = 1;
  //   let sum = 0;
  //   console.log(n);
  let i = 1;
  let y = 0;
  let j = 1;
  let mau = 1;
  let sum = 0;
  while (i <= n) {
    // console.log(n);
    y = 2 * i - 1;
    while (j <= y) {
      //   console.log(n);
      mau *= j;
      j++;
    }
    sum += 1 / mau;
    // sum += 1 / y;
    i++;
  }
  sum = sum.toFixed(5);
  document.write(sum);
  inputBtnReloadEx();
}

// function bai4(n) { Cách tính luỹ thừa nhanh -  cách lấy biến sau khi tính toán ở 1 function khác
//   let i = 1;
//   let sum = 1;
//   while (i <= n) {
//     sum *= i;
//     i++;
//   }
//   return sum;
// }

// function bai5() {
//   let a = bai4(5);
//   console.log(a);
// }
