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

function bai4() {
  // thay vì số đầu tiên trong dãy thì tính n số trong dãy chia hết cho 5
  let n = +prompt(
    "NHẬP VÀO SỐ LƯỢNG SỐ LƯỢNG FIBONACCI CHIA HẾT CHO 5 CẦN HIỂN THỊ:"
  );
  let countFibonacci = 1;
  let a = 1; // tính fibonacci == a + b
  let b = 0;
  let fibonacciNumber;
  // while (countFibonacci <= n) {
  //   while (fibonacciNumber % 5 != 0) {
  // fibonacciNumber = a + b;
  // b = a; // phải để nó trước vì để sau thì biến a đi trước nên bị sai số
  // a = fibonacciNumber;
  //   }
  //   countFibonacci++;
  // document.write(
  //   "Số FIBONACCI chia hết cho 5 thứ " +
  //     countFibonacci +
  //     " là: " +
  //     fibonacciNumber +
  //     "<br>"
  // );
  //   // fibonacciNumber = a + b;
  // };
  do {
    fibonacciNumber = a + b;
    b = a; // phải để nó trước vì để sau thì biến a đi trước nên bị sai số
    a = fibonacciNumber;
    if (fibonacciNumber % 5 == 0) {
      countFibonacci++;
      document.write(
        "Số FIBONACCI chia hết cho 5 thứ " +
          countFibonacci +
          " là: " +
          fibonacciNumber +
          "<br>"
      ); // count
    }
  } while (countFibonacci <= n);
  inputBtnReloadEx();
}

function bai5() {
  let n = +prompt("NHẬP VÀO SỐ LƯỢNG SỐ LƯỢNG FIBONACCI CẦN TÍNH TỔNG:");
  let countFibonacci = 1;
  let a = 1; // tính fibonacci == a + b
  let b = 0;
  let fibonacciNumber;
  let sumFibonacci = 0;
  while (countFibonacci < n) {
    fibonacciNumber = a + b;
    b = a; // phải để nó trước vì để sau thì biến a đi trước nên bị sai số
    a = fibonacciNumber;
    sumFibonacci += fibonacciNumber;
    countFibonacci++;
  }
  document.write("Tổng của " + n + " số Fibonacci là: " + +sumFibonacci);
  inputBtnReloadEx();
}

function bai6() {
  let n = +prompt("Nhập vào số lượng số chia hết cho 7 cần tính tổng: ");
  let isDivided7 = 7;
  let sum = 0;
  for (let i = 0; i < n; i++) {
    isDivided7 += 7;
    // isDivided7 *= i; sai
    sum += isDivided7;
  }
  document.write(sum);
  inputBtnReloadEx();
}

function bai7() {
  // let i = 0;
  // let isDivided3And5 = (i % 3 ==0) && (i % 5 == 0);
  // let isOnlyDivided3 = (i % 3 ==0);
  // let isOnlyDivided5 = (i % 5 ==0);
  // for(; i <100; i++) {
  //   switch(true){
  //     case isDivided3And5:
  //       document.write('FizzBuzz <br>');
  //       break;
  //     case isOnlyDivided3:
  //       document.write('Fizz <br>');
  //       break;
  //     case isOnlyDivided5:
  //       document.write('Buzz <br>');
  //       break;
  //     default:
  //       document.write(i +'<br>');
  //   };
  //   i++;
  // }
  let n = +prompt("Nhập vào số lượng số cần in: ");
  let i = 1;
  let writeFizz = "Fizz";
  let writeBuzz = "Buzz";
  let writeBr = "<br>";
  while (i <= n) {
    let isDivided3And5 = i % 3 == 0 && i % 5 == 0;
    let isOnlyDivided3 = i % 3 == 0;
    let isOnlyDivided5 = i % 5 == 0;
    switch (true) {
      case isDivided3And5:
        document.write(writeFizz + writeBuzz + writeBr);
        break;
      case isOnlyDivided3:
        document.write(writeFizz + writeBr);
        break;
      case isOnlyDivided5:
        document.write(writeBuzz + writeBr);
        break;
      default:
        document.write(i + writeBr);
    }
    // document.write( i + writeBr);
    i++;
  }
  inputBtnReloadEx();
}

function bai8() {
  alert("GAME HÃY ĐOÁN SỐ ĐÚNG!");
  let rangeNumber = parseInt(
    prompt("Nhập vào số lớn nhất trong khoảng muốn đoán là: ")
  );
  let trueNumber = Math.round(Math.random() * rangeNumber);
  let isOverRange = "Số bạn đoán ở ngoài phạm vi bạn cho rồi";
  let isLessThan = "Số bạn đoán nhỏ hơn số đúng";
  let isGreaterThan = "Số bạn đoán lớn hơn số đúng";
  let isTrue = "Bạn đã đoán đúng";
  let isFalse = "Rất đáng tiếc! số đúng là: ";
  let isWin =
    "Bạn đã chiến thắng! <br> Có thể chơi lại bằng cách chọn lại bài 8 nhé!";
  let i = 0;
  alert("Trò chơi bắt đầu! Hãy nhớ rằng bạn chỉ có 3 lượt đoán thôi đấy");
  do {
    let guessNumber = parseInt(prompt("Nhập vào số bạn nghĩ là: "));
    if (guessNumber > rangeNumber) {
      alert(isOverRange);
      i++;
    } else if (guessNumber < trueNumber) {
      alert(isLessThan);
      i++;
    } else if (guessNumber > trueNumber) {
      alert(isGreaterThan);
      i++;
    } else {
      alert(isTrue);
      document.write(isWin);
      break;
    }
  } while (i < 3);
  if (i == 3) {
    document.write(isFalse + trueNumber);
  }
  inputBtnReloadEx();
}
