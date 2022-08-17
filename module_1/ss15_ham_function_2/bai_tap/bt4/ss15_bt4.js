let valueSelected = document.getElementById("selectEx");
let valueget;

function getValue() {
    valueget = valueSelected.value;
    console.log(valueget);
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

//Viết hàm tính bình phương của một số bất kỳ được đưa vào. Gọi hàm vừa xây dựng được.
function bai1() {
    let enterNumber = +prompt('Nhập vào một số bất kỳ:');
    document.write('Bình phương của ' + enterNumber + ' là ' + caculateSquare(enterNumber));
}

function caculateSquare(number) {
    number *= number;
    return number;
}

//Viết hàm tính diện tích, hàm tính chu vi hình tròn. Gọi hàm vừa xây dựng được
function bai2() {
    let enterRadius = +prompt('Nhập vào chu vi hình tròn: ');
    document.write('Chu vi hình tròn đó là: ' + caculatePerimeterCircle(enterRadius) + '<br>');
    document.write('Diện tích hình tròn đó là: ' + caculateAreaCircle(enterRadius) + '<br>');
    inputBtnReloadEx();
}

function caculateAreaCircle(radiusCircle) {
    let areaCircle = radiusCircle * radiusCircle * Math.PI;
    return areaCircle;
}

function caculatePerimeterCircle(radiusCircle) {
    let perimeterCircle = radiusCircle * Math.PI;
    return perimeterCircle;
}

//Viết hàm tính giai thừa của một số nguyên bất kỳ được đưa vào. Gọi hàm vừa xây dựng được.
function bai3() {

}

function caculateFactorial(number) {
    if (number == 2) {
        return 2;
    } else {

    }
}