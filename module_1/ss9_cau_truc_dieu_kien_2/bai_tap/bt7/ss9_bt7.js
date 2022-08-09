let valueSelected = document.getElementById("selectEx");
let valueget;

function bai1() {
  let a = +prompt("Nhập và số a:");
  let b = +prompt("Nhập và số b:");
  if (!(a % b)) {
    alert(a + " chia hết cho " + b);
  } else {
    alert(a + " không chia hết cho " + b);
  }
}

function bai2() {
  let tuoi = +prompt("Nhập vào số tuổi của bạn");
  if (tuoi < 0) {
    alert("Vui lòng nhập lại số tuổi hợp lệ: ");
    window.location.reload();
  } else if (tuoi >= 15) {
    alert(tuoi + " tuổi đã đủ tuổi vào lớp 10");
  }
}

function bai3() {
  let a = +prompt("Nhập vào một số nguyên bất kì:");
  if ((a = 0)) {
    alert(a + " bằng 0");
  } else if (a < 0) {
    alert(a + " là số nhỏ hơn 0");
  } else {
    alert(a + " là số lớn hơn 0");
  }
}

function bai4() {
  let a = +prompt("Nhập và số thứ nhất:");
  let b = +prompt("Nhập và số thứ hai:");
  let c = +prompt("Nhập và số thứ ba:");
  let d = Math.max(a, b, c);
  alert(d + " là số lớn nhất");
}

function bai5() {
  let kiemTra = +prompt("Nhập vào điểm kiểm tra: ");
  let giuaKy = +prompt("Nhập vào điểm giữa kỳ: ");
  let cuoiKy = +prompt("Nhập vào điểm cuối kỳ:");
  if (kiemTra < 0 || giuaKy < 0 || cuoiKy < 0 || (kiemTra >10) || (giuaKy > 10) ||(cuoiKy > 10)) {
    alert("NHẬP ĐIỂM SAI! VUI LÒNG NHẬP LẠI");
    window.location.reload();
  } else {
    let trungbinh = Math.average(kiemTra, giuaKy, cuoiKy);
    if (trungbinh <= 3) {
        alert(trungbinh + " là điểm trung bình của bạn, đạt xếp loại học lực: Kém");
    } else if (trungbinh <= 6){
        alert(trungbinh + " là điểm trung bình của bạn, đạt xếp loại học lực: Trung bình");
    } else if (trungbinh <=8){
        alert(trungbinh + " là điểm trung bình của bạn, đạt xếp loại học lực: Khá");
    }else{
        alert(trungbinh + " là điểm trung bình của bạn, đạt xếp loại học lực: Giỏi");
    }
  }
}

function bai6(){
    soldProduct = +prompt("Nhập vào doanh số đã bán được tháng này");
    valueProduct = 500000;
    valueSold = soldProduct * valueProduct;
    if (soldProduct > 0){
        if(soldProduct <20){
            bouns = +valueSold / 100 * 2;
            alert("Hoa hồng của bạn là: " + bouns + "VND");
        } else if (soldProduct<40) {
            bouns = +valueSold / 100 * 6;
            alert("Hoa hồng của bạn là: " + bouns + "VND");
        } else {
            bouns = +valueSold / 100 * 10;
            alert("Hoa hồng của bạn là: " + bouns + "VND");
        }
    } else {
        alert ("Doanh số nhập vào không chính xác");
    }
}

function bai7(){
    callTime = +prompt("Nhập thời gian đã gọi trong tháng (tính theo phút) ");
    money = callTime *760 *30;
    alert("money");
    //không tìm thấy công thức cụ thể nên làm 1 công thức tự suy nghĩ được
}

function getValue(){
    valueget = valueSelected.value;
    // console.log(valueget);
}

function playEx(){
    check = valueget;
    // console.log(typeof check);
    switch(check){
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
    }
}