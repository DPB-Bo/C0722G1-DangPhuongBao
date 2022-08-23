let bangKhong = 0;
let bangRong = '';
console.log(bangKhong || 'Không bằng không');
console.log(bangRong || 'Không bằng rỗng');
console.log(bangKhong ?? 'Không bằng không');
console.log(bangRong ?? 'Không bằng rỗng');
// check nhanh giá trị có phải là hợp lệ - Tức là không phải NaN Null Undefinded,... Tuy nhiên :
// Đối với ?? thì tính 0 và '' vẫn là hợp lệ
// Đối với || thì không tính 0 và '';
//Cú pháp :
//nameVariable ?? doWhenTrigger
//nameVariable || doWhenTrigger
//Nếu biến đó hợp lệ thì trả về giá trị của biến đó, không thì trả về doWhenTrigger
function checkValidate() {
    return bangKhong ?? false;
}
console.log(checkValidate());