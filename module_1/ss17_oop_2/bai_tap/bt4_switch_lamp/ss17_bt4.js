class ElectricLamp {
    constructor(status) {
        this.status = status;
    }
    setStatus(status) {
        this.status = status;
    }
}

class SwitchBtn {
    constructor(status, lamp) {
        this.status = status;
        this.lamp = lamp;
    }
    getstatus() {
        return this.status;
    }
    connectToLamp(lamp) {
        this.lamp = lamp;
    }
    switchOn() {
        alert('Công tắc bật!');
        this.lamp.setStatus(true);
        this.status = true;
    }
    switchOff() {
        alert('Công tắc tắt!');
        this.lamp.setStatus(false);
        this.status = false;
    }
}


let lamp = new ElectricLamp(false);
let switchBtn = new SwitchBtn(false, lamp);

function turnOnSwitch() {
    switchBtn.switchOn();
    document.write('Đèn đang bật! <br>');
    document.write('<button type="button" onclick="turnOffSwitch()">Tắt đèn</button><br>');

}

function turnOffSwitch() {
    switchBtn.switchOff();
    document.write('Đèn đang tắt!<br>');
    document.write('<button type="button" onclick="turnOnSwitch()">Bật đèn</button><br>');

}