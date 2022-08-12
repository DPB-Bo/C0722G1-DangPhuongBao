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

function tinhgiaithua(n) {
  // Cách tính luỹ thừa nhanh -  cách lấy biến sau khi tính toán ở 1 function khác
  let i = 1;
  let sum = 1;
  while (i <= n) {
    sum *= i;
    i++;
  }
  return sum;
}

// function bai5() {
//   let a = bai4(5);
//   console.log(a);
// }

function bai4() {
  let n = +prompt('Tính n! chẵn lẽ. Nhập vào số n: ');
  let i = 1;
  let isEven = n % 2 == 0;
  if (isEven) {
    i = 2;
  }
  let mutiple = 1;
  let j = 1;
  while (i <= n) {
    j = tinhgiaithua(i);
    mutiple *= j;
    i += 2;
  }
  document.write('Đáp án là: ' + mutiple);
  inputBtnReloadEx();
  // let i = 1;
  // while (i <= n) {

  // }
}

function bai5() {
  document.write('Bài này áp dụng mãng - Chưa được học');
  inputBtnReloadEx();
}

function bai6() {
  let a = parseInt(prompt("Nhập vào số a: "));
  let b = parseInt(prompt("Nhập vào số b: "));
  let x = Math.max(a, b);
  let y = Math.min(a, b);
  let z;
  // let isDivided = x % y == 0; Tại sao khi bỏ !isDivided vào while lại bị vòng lặp vô hạn?
  while (x % y != 0) {
    z = x % y;
    x = y;
    y = z;
    // console.log(x);
    // console.log(y);
  };
  let bcnn = (a * b) / y;
  let down = '<br>';
  document.write('Ước chung lớn nhất của ' + a + ' và ' + b + ' là: ' + y + down);
  document.write('Bội chung nhỏ nhất của ' + a + ' và ' + b + ' là: ' + bcnn + down);
  inputBtnReloadEx();
}

function bai7() {
  document.write('Bài này áp dụng mãng - Chưa được học');
  inputBtnReloadEx();
}

function bai8() {
  document.write('Bài này áp dụng mãng - Chưa được học');
  inputBtnReloadEx();
}

function bai9() {
  document.write('Bài này áp dụng mãng - Chưa được học');
  inputBtnReloadEx();
}

function bai10() {
  document.write('Bài này áp dụng mãng - Chưa được học');
  inputBtnReloadEx();
}

function test2() { // tính gia thừa nhanh bằng
  let n = +prompt('n:');
  let gt = 1;
  let kq = 0;
  let j = 0;
  let mau;
  for (let i = 1; i <= n; i++) {
    // mau = 2 * i - 1;
    // j = tinhgiaithua(mau);
    gt *= (i * (i + 1));
    kq += 1 / gt;
  }
  kq = kq.toFixed(4);
  console.log(kq);
}

// function test() {
//   let n = +prompt('n:');
//   let gt = 1;
//   let kq = 0;
//   for (let i = 1; i <= n; i++) {
//     gt *= i;
//     kq += 1 / gt;
//   }
//   kq = kq.toFixed(4);
//   console.log(kq);

// }

// test();
// test2();
