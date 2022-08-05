// Bài 1
// Viết chương trình nhập điểm của một sinh viên cho các môn: Vật lý, Hóa học, và Sinh học. Sau đó hiển thị điểm trung bình và tổng của những điểm này.
vatly = prompt("Nhập điểm vatly:");
hoahoc = prompt("Nhập điểm hoahoc:");
sinhhoc = prompt("Nhập điểm sinhhoc:");
tong = vatly*1 + hoahoc*1 + sinhhoc*1;
trungbinh = tong/3;
document.write('Tổng là: ' + tong + ' và Trung bình là: ' + trungbinh );
document.write('<br/>');
// Bài 2
// Viết chương trình nhập một giá trị là độ 0C (Celsius) và chuyển nó sang độ 0F (Fahrenheit). [Hướng dẫn: C/5 = (F-32)/9]
C = prompt("Nhập độ C:");
F = (C*1/5)*9 + 32;
document.write('Độ C là ' + C + ' vậy độ F là ' + F);
document.write('<br/>');
//Bài 3
//Viết chương trình tính diện tích hình tròn
r = prompt("Nhập bán kính r của hình tròn: ");
r = r*1;
dientichhinhtron = r*r*3.14;
document.write('Diện tích của hình tròn có r = ' + r + ' là: ' + dientichhinhtron);
document.write('<br/>');
//Bài 4
//Viết chương trình chu vi hình tròn
chuvihinhtron = r*2*3.14;
document.write('Chu vi hình tròn có r = ' + r + ' là ' +chuvihinhtron);
document.write('<br/>');
