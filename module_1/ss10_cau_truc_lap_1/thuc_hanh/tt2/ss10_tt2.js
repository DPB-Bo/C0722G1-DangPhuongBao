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
  let num = +prompt("Nhập vào một số - Vòng lặp sẽ kết thúc nếu nhập vào -1: ");
  let total = 0;
  while (num != -1) {
    total += num;
    num = +prompt("Nhập vào một số - Vòng lặp sẽ kết thúc nếu nhập vào -1: ");
    alert(num);
  }
  alert("Tổng các số đã nhập vào là: " + total);
}

function bai2() {
  let i = 1;
  while (i < 100) {
    //phân thân vòng lặp
    document.write("<hr width = " + i + "%>");
    i++;
  }
}
