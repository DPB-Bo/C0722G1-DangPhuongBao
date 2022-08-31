let soN = 0;
do {
    alert("Nhập vào n phải là số nguyên và lớn hơn 0! ");
    soN = +prompt('Nhập vào n: ');
} while (soN < 1 || isNaN(soN)); //|| Number.isInteger(parseFloat(soN.toString()))
let mangChiaHetChoN = [];
for (let i = 1; i <= soN; i++) {
    if (!(soN % i)) mangChiaHetChoN.push(i);
}
document.write('Số vừa nhập là: ' + soN + '<br>');
document.write('Các ước của số vừa nhập là : ' + mangChiaHetChoN.join(' '));