let enterSomeString = prompt('Nhập vào từ cần kiểm tra: ');
function isPalindrome(checkString) {
    for (let i = 0; i < checkString.length; i++) {
        if (checkString[i] !== checkString[checkString.length - 1 - i]) {
            return false;
        }
    }
    return true;
}
alert(isPalindrome(enterSomeString));
// console.log(enterSomeString[0]);