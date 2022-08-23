//Test từng giá trị string nhập vào -> day

// let dateStr = prompt('Nhập 1 ngày');
// let monthStr = prompt('Nhập 1 tháng');
// let yearStr = prompt('Nhập 1 year');
// let date = new Date(yearStr, monthStr, dayStr);
// console.log('Đây là ngày: ' + date);
// console.log('Đây là day: ' + date.getDate());
// console.log('Đây là month: ' + date.getMonth());
// console.log('Đây là year: ' + date.getFullYear());
// let checkDayValid = dayStr == date.getDate();
// let checkMonthValid = monthStr == date.getMonth();
// let checkYearValid = yearStr == date.getFullYear();
// console.log('checkDayValid: ' + checkDayValid);
// console.log('checkMonthValid: ' + checkMonthValid);
// console.log('checkYearValid: ' + checkYearValid);

//Test chuỗi nhập vào chuyển sang day

// let strDay = prompt('Nhập vào 1 chuỗi ngày: ');
// let strDayPart = strDay.split('/');
// console.log('strDayPart0 : ' + strDayPart[0]);
// console.log('strDayPart1 : ' + (strDayPart[1] - 1));
// console.log('strDayPart2 : ' + strDayPart[2]);
// let day = new Date(strDayPart[2], strDayPart[1] - 1, strDayPart[0]);
// console.log('Đây là ngày: ' + day);
// console.log('Đây là day: ' + day.getDate());
// console.log('Đây là month: ' + day.getMonth());
// console.log('Đây là year: ' + day.getFullYear());
// console.log('Kiểu dữ liệu của getyear là: ' + typeof day.getFullYear());
// console.log('Kiểu dữ liệu của DayPartYear là: ' + typeof strDayPart[2]);

//Test trực tiếp

// let strDate = prompt('Nhập vào')
// function isValidDate(strDate) {
//     if (strDate.length != 10) { return false };
//     let dateParts = strDate.split("/");
//     let date = new Date(dateParts[2], (dateParts[1] - 1), dateParts[0]);
//     return date.getDate() == dateParts[0]
//         && date.getMonth() == (dateParts[1] - 1)
//         && date.getFullYear() == dateParts[2]
//         ? true : false;
// }
// console.log(isValidDate(strDate));
let date = new Date('22/08/2022 ' + '07:05:45 PM');
console.log(date);