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

function tamgiacTrai() {
  let u = "";
  for (let i = 1; i <= 5; i++) {
    // for (let j = 1; j <= i; j++) {
    //   document.write("*");
    // }
    document.write((u += "*"));
    document.write("<br>");
  }
}
// let u = "*";
// let t = document.write(u+=u);
// console.log(t);

function tamgiacNguocTrai() {
  let n = parseInt(
    prompt("Chiều dài cạnh tối đa của tam giác ngược bạn muốn là: ")
  );
  let count = 0;
  let u = "";
  while (count <= n) {
    u += "*";
    count++;
  }
  count = 0;
  for (; count <= n; count++) {
    document.write((u = u.slice(0, -1)));
    document.write("<br>");
  }
}

function tamgiacPhai() {
  // let n="     |     | ";
  // let m = n.slice(1) + "*";
  // console.log(m);
  let n = parseInt(
    prompt("Chiều dài tối đa của tam giác bên phải bạn muốn là: ")
  );
  let count = 0;
  let u = "";
  while (count < n) {
    u += "&ensp;";
    count++;
  }
  count = 0;
  for (; count < n; count++) {
    // document.write("<p>");
    document.write((u = u.slice(6) + "*"));
    console.log(u);
    // document.write("</p>");
    document.write("<br>");
  }
}

function tamgiacNguocPhai() {
  let n = parseInt(
    prompt("Chiều dài tối đa của tam giác ngược bên phải bạn muốn là: ")
  );
  let count = 0;
  let u = "";
  while (count <= n) {
    u += "*";
    count++;
  }
  count = 0;
  for (; count < n; count++) {
    // document.write("<p>");
    document.write((u = "&ensp;" + u.slice(0, -1)));
    console.log(u);
    // document.write("</p>");
    document.write("<br>");
  }
}

function bai4() {
  let d = parseInt(prompt("Chiều dài của hình chữ nhật: "));
  let r = parseInt(prompt("Chiều rộng của hình chữ nhật: "));
  let down = "<br>";
  let count = 0;
  let lineFirstAndLast = "";
  let lineMiddle = "*";
  while (count < d) {
    lineFirstAndLast += "*";
    count++;
  }
  // console.log(lineFirstAndLast);
  count = 0;
  while (count < d) {
    if (count == d - 2) {
      lineMiddle += "*";
      break;
    }
    lineMiddle += "&ensp;";
    count++;
  }
  // console.log(lineMiddle);
  count = 0;
  let hinhChuNhat = lineFirstAndLast + down;
  // let draw = lineFirstAndLast + down;
  // document.write(draw);
  // console.log(draw);
  while (count < r) {
    if (count == r - 2) {
      hinhChuNhat += lineFirstAndLast;
      break;
    }
    hinhChuNhat += lineMiddle + down;
    // draw = lineMiddle + down;
    count++;
  }
  document.write(hinhChuNhat);
  inputBtnReloadEx();
  // // console.log(draw);
  // // document.write(lineMiddle);
}

function bai1() {
  // Thay vì làm 20 số thì làm N số luôn
  let n = +prompt("NHẬP VÀO SỐ LƯỢNG SỐ LƯỢNG FIBONACCI CẦN HIỂN THỊ:");

  let countFibonacci = 1;
  let a = 1; // tính fibonacci == a + b
  let b = 0;
  let fibonacciNumber;
  while (countFibonacci <= n) {
    fibonacciNumber = a + b;
    b = a; // phải để nó trước vì để sau thì biến a đi trước nên bị sai số
    a = fibonacciNumber;
    document.write(
      "Số FIBONACCI thứ " + countFibonacci + " là: " + fibonacciNumber + "<br>"
    );
    countFibonacci++;
  }
  inputBtnReloadEx();
}

function bai2() {
  let n = +prompt("Nhập vào số nguyên dương bạn cần tính giai thừa: ");
  let mutiple = 1;
  let i = 1;
  while (i <= n) {
    mutiple *= i;
    i++;
  }
  document.write("Giai thừa của " + n + " là: " + mutiple);
  inputBtnReloadEx();
}

function bai3() {
  let down = document.write("<br>");
  // document.write("Hình tam giác bên trái:" + down);
  tamgiacTrai();
  down;
  down;
  // document.write("Hình tam giác ngược bên trái:" + down);
  tamgiacNguocTrai();
  down;
  down;
  // document.write("Hình tam giác bên phải:" + down);
  tamgiacPhai();
  down;
  down;
  // document.write("Hình tam giác bên phải:" + down);
  tamgiacNguocPhai();
  down;
  down;
  // document.write("Hình tam giác ngược bên phải:" + down);
  // hinhChuNhat();
  // down;
  // down;
  inputBtnReloadEx();
}

// function bai4() {}
function bai5() {
  //không biết công thức tính ~~
  let mutipleBouns = +prompt("Nhập vào lãi suất cho vay(%): ");
  let baseMoney = +prompt("Nhập vào số tiền phải trả(VND): ");
  let timePayMoney = +prompt("Nhập vào số tháng cần trả: ");
  let bounsPayMoney = Math.round(baseMoney * mutipleBouns);
  alert("Số tiền lãi bạn phải trả cho ngân hàng là: " + bounsPayMoney);
  document.write("không biết công thức tính ~~");
  inputBtnReloadEx();
}

function bai6() {
  document.write(
    "Không có logic chỉ có ngồi if else nên anh Tutor Chánh cho giảm tải!"
  );
  inputBtnReloadEx();
}
