var year = parseInt(prompt("Nhập số năm cần kiểm tra"));
var nhuan = false;
var chiahetcho4 = year % 4 == 0;
if (chiahetcho4) {
    var chiahetcho100 = year % 100 == 0;
    if (chiahetcho100) {
        var chiahetcho400 = year % 400 == 0;
        if (chiahetcho400) {
            nhuan = true;
        }
    }
    nhuan = true;
}
if (nhuan) {
    alert(year + " là năm nhuận");
}else{
    alert(year + " là năm không nhuận");

}