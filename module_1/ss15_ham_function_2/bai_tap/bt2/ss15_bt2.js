function convertFeetToMeter(feet) {
    let meter = feet * 0.305;
    return meter;
}

function convertMeterToFeet(meter) {
    let feet = 3.279 * meter;
    return feet;
}

let enterMeter = +prompt('Nhập vào số meter muốn đổi thành foot');
let enterFeet = +prompt('Nhập vào số feet muốn đổi thành meter');
// convertFeetToMeter(enterFeet);
document.write('Metet là: ' + convertFeetToMeter(enterFeet) + '<br');
document.write('Feet là: ' + convertMeterToFeet(enterMeter) + '<br');
// convertMeterToFeet(enterMeter);