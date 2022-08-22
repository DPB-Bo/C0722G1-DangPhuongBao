class Apple {
    constructor(amount) {
        this.amount = amount;
    }
    getAmount() {
        return this.amount;
    }
    isEmpty() {
        return this.amount < 1;
    }
    decrease() {
        this.amount--;
    }
    setAmount(amount) {
        this.amount = amount;
    }
}

class Humnan {
    constructor(name, gender, weight) {
        this.name = name;
        this.gender = gender;
        this.weight = weight;
    }
    isMale() {
        return this.gender === 'Male' ? true : false;
    }
    setGender(gender) {
        this.gender = gender;
    }
    eatApple(apple) {
        if (apple.isEmpty() != true) {
            {
                this.weight += 1;
                apple.decrease();
            }
        } else {
            document.write('Không còn táo');
        }
    }
    saySth(sthToSay) {
        alert(sthToSay);
    }
    setName(name) {
        this.name = name;
    }
    getName() {
        return this.name;
    }
    setWeight(weight) {
        this.weight = weight;
    }
    getWeight() {
        return this.weight;
    }
}

let adam = new Humnan('ADAM', 'Male', 80);
let eva = new Humnan('EVA', 'Female', 60);
let treeApple = new Apple(10);
let br = '<br>';
// document.write('Con rắn xuất hiện và dụ dỗ 2 con người khờ khạo ăn táo trên cây <br>');
// console.log(treeApple.isEmpty());
// while (treeApple.isEmpty() != true) {
//     adam.eatApple(treeApple);
//     document.write('Adam đã ăn quả táo thứ ' + (10 - treeApple.getAmount()) + ' của cây táo' + br);
//     eva.eatApple(treeApple);
//     document.write('Eva đã ăn quả táo thứ ' + (10 - treeApple.getAmount()) + ' của cây táo' + br);
// }
function eatApple() {
    if (treeApple.isEmpty()) {
        alert('Còn táo đâu nữa mà ăn!');
        alert('Thượng đế đã phát hiện ra sự thay đổi cân nặng của bạn!!!!!');
        alert('Ông ấy rất tức giận vì 2 bạn đã không nghe theo sự dặn dò của ông ấy!!');
    } else {
        adam.eatApple(treeApple);
        document.write('Adam đã ăn quả táo thứ ' + (10 - treeApple.getAmount()) + ' của cây táo' + br);
        document.write('Adam đã tăng cân! Cân nặng của Adam là: ' + adam.getWeight() + 'kg' + br + br);
        eva.eatApple(treeApple);
        document.write('Eva đã ăn quả táo thứ ' + (10 - treeApple.getAmount()) + ' của cây táo' + br);
        document.write('Eva đã tăng cân! Cân nặng của Adam là: ' + eva.getWeight() + 'kg' + br + br);
        document.write('<button type="button" onclick="eatApple()">Tiếp tục</button> <span><button type="button" onclick="happy4Ever()">Dừng lại</button></span><br><br>');
    }
}