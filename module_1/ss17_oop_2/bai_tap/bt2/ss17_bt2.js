let inputCelsius = document.getElementById('inputCelsius');
let displayF = document.getElementById('displayF');
let displayK = document.getElementById('displayK');
let displayC = document.getElementById('displayC');

class Temperature {
    constructor(celsius) {
        this.celsius = celsius;
    }
    changeF() {
        return ((9 / 5) * this.celsius) + 32;
    }
    changeK() {
        return this.celsius + 273.15;
    }
    setCelsius(celsius) {
        this.celsius = celsius;
    }
}

let temperature = new Temperature();

function caculateFK(celsius) {
    temperature.setCelsius(celsius);
    displayC.innerHTML = temperature.celsius;
    displayF.value = Math.round(temperature.changeF());
    displayK.value = Math.round(temperature.changeK());
}