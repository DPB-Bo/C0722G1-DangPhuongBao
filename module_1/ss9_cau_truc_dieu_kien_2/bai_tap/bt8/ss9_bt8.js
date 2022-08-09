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
    case "9":
      bai9();
      break;
    case "10":
      bai10();
      break;
    case "11":
      bai11();
      break;
    case "12":
      bai12();
      break;
  }
}

function bai1() {
  let c = +prompt("Nhập vào độ C cần chuyển đổi:");
  let f = c * (9 / 5) + 32;
  alert(c + " độ C tương với " + f + "độ F");
}

function bai2() {
  let m = +prompt("Nhập vào số mét: ");
  let ft = m * 3.2808;
  alert(m + " mét tương với " + ft + "feet");
}

function bai3() {
  let a = +prompt("Nhập vào độ dài a của hình vuông:");
  let s = a * a;
  alert("diện tích hình vuông có cạnh a = " + a + " là" + s);
}

function bai4() {
  let a = +prompt("Nhập vào cạnh dài a của hình chữ nhật: ");
  let b = +prompt("Nhập và cạnh rộng b của hình chữ nhật: ");
  let s = a * b;
  alert("diện tích hình chữ nhật là: " + s);
}

function bai5() {
  let a = +prompt("Nhập vào cạnh a tam giác vuông: ");
  let b = +prompt("Nhập vào cạnh b tam giác vuông: ");
  let s = (a * b) / 2;
  alert("diện tích hình tam giác vuông là: " + s);
}

function bai6() {
  let a = +prompt("Nhập vào số a: ");
  let b = +prompt("Nhập vào số b: ");
  switch (a) {
    case 0:
      switch (b) {
        case 0:
          alert("Phương trình có vô số nghiệm");
          break;
        default:
          alert("Phương trình không có nghiệm");
          break;
      }
      break;
    default:
      let x = Math.round(-b / a);
      alert("Phương trình có nghiệm là: " + x);
      break;
  }
}

function bai7() {
  let a = +prompt("Nhập vào số a: ");
  let b = +prompt("Nhập vào số b: ");
  let c = +prompt("Nhập vào số c: ");
  let d = Math.pow(b, 2) - 4 * (a * c);
  isLessThan0 = d <= 0;
  switch (isLessThan0) {
    case true:
      alert("Phương trình vô nghiệm");
      break;
    case false:
      switch (d) {
        case 0:
          let x = -(b / (2 * a));
          alert("Phương trình có nghiệm kép là: " + x);
          break;
        default:
          let x1 = Math.round((-b + Math.sqrt(d)) / (2 * a));
          let x2 = Math.round((-b - Math.sqrt(d)) / (2 * a));
          alert(
            "Phương trình có nghiệm x1 là: " + x1 + "và nghiệm x2 là:" + x2
          );
      }
  }
}

function bai8() {
  let a = +prompt("Nhập vào số tuổi của bạn : ");
  let isAge = a < 120 && a > 0;
  switch (isAge) {
    case true:
      alert(a + " là tuổi của một người");
      break;
    case false:
      alert(a + " không là tuổi của một người");
      break;
  }
}

function bai9() {
  let a = +prompt("Nhập vào a : ");
  let b = +prompt("Nhập vào b : ");
  let c = +prompt("Nhập vào c : ");
  let check0 = a > 0 && b > 0 && c > 0;
  let checkA = a > b + c;
  let checkB = b > c + a;
  let checkC = c > a + b;
  if (check0 && checkA && checkB && checkC) {
    alert(a + "" + b + "" + c + " là 3 cạnh của tam giác");
  } else {
    alert(a + "" + b + "" + c + " không là 3 cạnh của tam giác");
  }
}

function bai10() {
  let a = +prompt("Nhập vào số điện:");
  let isLess3000 = a < 3000;
  let isLess5000 = a < 5000;
  let isLess7000 = a < 7000;
  let isLess9000 = a < 9000;
  let valueMutiple;
  let cashOut;
  if (isLess3000) {
    valueMutiple = 3000;
    cashOut = a * valueMutiple;
  } else if (isLess5000) {
    valueMutiple = 5000;
    cashOut = a * valueMutiple;
  } else if (isLess7000) {
    valueMutiple = 7000;
    cashOut = a * valueMutiple;
  } else if (isLess9000) {
    valueMutiple = 9000;
    cashOut = a * valueMutiple;
  } else {
    valueMutiple = 15000;
    cashOut = a * valueMutiple;
  }
  alert("Số tiền điện bạn phải đóng là: " + cashOut + "VND");
}

function bai11() {
    let a = +prompt("Nhập vào thu nhập hàng tháng (theo VND):");
  let isLess3000 = a < 3000000;
  let isLess5000 = a < 5000000;
  let isLess7000 = a < 7000000;
  let isLess9000 = a < 9000000;
  let valueMutiple;
  let cashOut;
  if (isLess3000) {
    valueMutiple = Math.round(3/100);
    cashOut = a * valueMutiple;
  } else if (isLess5000) {
    valueMutiple = Math.round(5/100);
    cashOut = a * valueMutiple;
  } else if (isLess7000) {
    valueMutiple = Math.round(7/100);
    cashOut = a * valueMutiple;
  } else if (isLess9000) {
    valueMutiple = Math.round(9/100);
    cashOut = a * valueMutiple;
  } else {
    valueMutiple = Math.round(15/100);
    cashOut = a * valueMutiple;
  }
  alert("Thuế thu nhập có nhân của bạn là: " + cashOut + "VND");
}

function bai12() {
    let mutipleBouns = +prompt("Nhập vào lãi suất cho vay(%): ");
    let baseMoney = +prompt("Nhập vào số tiền phải trả(VND): ");
    let timePayMoney = +prompt("Nhập vào số tháng cần trả: ");
    let bounsPayMoney = Math.round((baseMoney*mutipleBouns));
    alert("Số tiền lãi bạn phải trả cho ngân hàng là: " + bounsPayMoney);
}
