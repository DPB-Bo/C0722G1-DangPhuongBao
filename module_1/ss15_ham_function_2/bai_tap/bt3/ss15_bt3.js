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

function bai1() { //Tạo hàm alertMessage() hiển thị hộp thoại chứa chuỗi  "Xin chao". Gọi hàm từ trong phần <body> của trang web.
    alertMessage();
    inputBtnReloadEx();
}

function alertMessage() {
    alert('Xin chào!');
}

//Tạo hàm nhận vào một đối số dạng số, 
//tăng giá trị đối số đó lên 1 và trả lại giá trị cho lời gọi hàm.
// Gọi hàm từ trong phần <body> của trang web và hiển thị kết quả lên màn hình.
function bai2() {
    let number2 = +prompt('Nhập vào 1 số: ');
    document.write(plusOne(number2));
    inputBtnReloadEx();
}

function plusOne(number) {
    number++;
    return number;
}

//Tạo hàm nhận vào hai tham số.
//Nếu giá trị của tham số thứ nhất lớn hơn tham số thứ hai, hiển thị hộp thoại thông báo cho người dùng
//Nếu giá trị của tham số thứ nhất nhỏ hơn hoặc bằng tham số thứ hai, trả về tổng của hai tham số.
function bai3() {
    let number1 = +prompt('Nhập vào số thứ nhất: ');
    let number2 = +prompt('Nhập vào số thứ hai: ');
    compare2Paramenter(number1, number2);
}

function compare2Paramenter(para1, para2) {
    if (para1 > para2) {
        alert('Số thứ nhất lớn hơn cho số thứ hai!');
    } else if (para1 < para2) {
        return para1 + para2;
    } else {
        alert('Hai số nhập vào bằng nhau!');
    }
}

function bai4() {
    let result = 0;
    alert(result);
    result = addNumbers();
    alert(result);
    inputBtnReloadEx();
}

function addNumbers() {
    firstNum = 4;
    secondNum = 8;
    result = firstNum + secondNum;
    return result;
}

// Tạo một mảng với bảy phần tử dạng chuỗi có giá trị là tên các ngôi sao sau: Polaris, Aldebaran, Deneb, Vega, Altair, Dubhe và Regulus. 
// Tạo một mảng khác với bảy phần tử dạng chuỗi có giá trị là tên các chòm sao tương ứng chứa các ngôi sao: Ursa Minor, Tarurus, Cygnus, Lyra, Aquila, Ursa Major và Leo. 
// Tiếp theo, tạo một hàm nhận vào một tham số dạng chuỗi duy nhất. Trong hàm này, duyệt qua mảng thứ nhất để tìm tên ngôi sao. 
// Nếu tìm thấy, trả lại giá trị tương ứng với chỉ số đó ở mảng thứ hai. 
// Nói cách khác, trả lại tên chòm sao của ngôi sao đó. 
// Trong phần <body> của trang web, dùng hộp thoại prompt để người dùng nhập vào tên của ngôi sao, sau đó gọi hàm với thông tin đầu vào. 
// Đừng quên xử lý trong trường hợp không tìm thấy ngôi sao nào. Cho kết quả hiển thị trên màn hình.
function bai5() {
    let enterStarName = prompt('Nhập vào tên ngôi sao muốn tìm: ');
    findStringInArray(enterStarName);
    inputBtnReloadEx();
}

let arrStar1 = ['Polaris', 'Aldebaran', 'Deneb', 'Vega', 'Altair', 'Dubhe', 'Regulus'];
let arrStar2 = ['Ursa Minor', 'Tarurus', 'Cygnus', 'Lyra', 'Aquila', 'Ursa Major', 'Leo'];

function findStringInArray(enterString) {
    document.write('Tên ngôi sao bạn muốn tìm kiếm là: ' + enterString + '<br>');
    for (const indexNameStar in arrStar1) {
        if (arrStar1[indexNameStar] == enterString) {
            return document.write('Phát hiện tên ngôi sao ở mảng đầu tiên ở vị trí: '
                + (indexNameStar + 1)
                + ' trong mảng <br> Ngôi sao tương ứng ở vị trí đó trong mảng thứ hai là: '
                + arrStar2[indexNameStar] + '<br>');
        }
    }
    return document.write('Không tìm thấy tên ngôi sao đã nhập');
}