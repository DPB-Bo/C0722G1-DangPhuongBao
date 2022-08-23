class Rat {
    constructor(name, weight, speed, status) {
        this.name = name;
        this.weight = weight;
        this.speed = speed;
        this.status = status;
    }
    getName() { return this.name; };
    getWeight() { return this.weight; };
    getSpeed() { return this.speed; };
    getStatus() { return this.status; };
    setWeight(value) { this.status = value; };
    setSpeed(value) { this.speed = value; };
    setStatus(value) { this.status = value; };
    setName(value) { this.name = value; };
}

class Cat {
    constructor(name, weight, speed) {
        this.name = name;
        this.weight = weight;
        this.speed = speed;
    }
    getSpeed() { return this.speed; };
    catch(rat) {
        if (rat.getSpeed() >= this.speed) {
            document.write(this.name + ' béo chậm quá rượt không kịp, tập thể dục đê!' + br);
        } else {
            document.write(this.name + ' bắt được con ' + rat.getName() + ' lấm lắt này rồi! ' + br);
        }
    }
    trainSpeed() {
        this.weight++;
    }
    eat(rat) {
        if (rat.getStatus()) {
            document.write(rat.getName() + ' còn sống, ăn nó thôi!' + br);
            this.weight += rat.getWeight();
            rat.setStatus(false);
        } else {
            document.write('Con chuột này chết rồi! Chê!' + br);
        }
    }
    getWeight() { return this.weight; };
    getName() { return this.name; };
    getSpeed() { return this.speed; };
}

let jerry = new Rat('Jerry', 5, 10, true);
let tom = new Cat('Tom', 7, 12);
let br = '<br>';
document.write('Có 1 mèo Tom và 1 mèo Jerry' + br);
document.write('Mèo Tom có cân nặng là: ' + tom.getWeight() + 'kg và tốc độ là: ' + tom.getSpeed() + br);
document.write('Chuột Jerry có cân nặng là: ' + jerry.getWeight() + 'kg và tốc độ là: ' + jerry.getSpeed() + br);
document.write('Mèo ' + tom.getName() + ' muốn bắt chuột ' + jerry.getName() + br);
tom.catch(jerry);
document.write(tom.getName() + ' đang kiểm tra thử chuột này ăn được không! ' + br);
tom.eat(jerry);