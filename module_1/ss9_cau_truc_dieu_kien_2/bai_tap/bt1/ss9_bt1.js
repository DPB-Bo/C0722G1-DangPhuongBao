height = +prompt("Nhập chiều cao của bạn (theo đơn vị m)");
weight = +prompt("Nhập cân nặng của bạn");
bmi = +(weight / Math.pow(height, 2));
if (bmi < 18.5) {
  alert("Ngươi bị suy dinh dưỡng rồi !");
} else {
  if (bmi < 25) {
    alert("Ngươi bình thường quá !");
  } else {
    if (bmi < 30) {
      alert("Ngươi hơi thừa mỡ rồi đó !");
    } else {
      alert("Bắt được 1 đứa bị ngãi heo =)))");
    }
  }
}
