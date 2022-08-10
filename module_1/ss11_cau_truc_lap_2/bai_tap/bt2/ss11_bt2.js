function findElementNumber(number) {
  let countElementNumer = 0;
  let isElementNumber = 0;
  let elementNumber = 2;
  while (countElementNumer < number) { // Nên tìm cách dùng chỉ dùng 1 lặp (vì phát hiện nhập nhiều số là nó xoay vòng vòng) - idea thử dùng (do - while) như thằng fibonacci ss11_bt3_bai4
    for (let i = 1; i <= elementNumber; i++) {
      // kiểm tra số có phải SNT k
      if (elementNumber % i == 0) {
        isElementNumber++;
      }
    }
    if (isElementNumber == 2) {
      // nếu là SNT thì in rồi tăng cho count
      document.write(elementNumber + "<br>");
      countElementNumer++;
    }
    isElementNumber = 0; // reset check SNT trước khi vào vòng mới
    elementNumber++; // tăng số được check
  }
  //   console.log(elementNumber + " " + countElementNumer);
}

let number1 = +prompt("Nhập vào số lượng số nguyên tố cần hiển thị: ");
findElementNumber(number1);