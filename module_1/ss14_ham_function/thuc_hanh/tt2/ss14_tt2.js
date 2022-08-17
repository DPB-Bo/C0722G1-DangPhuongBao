// function hha(abc) {
//     console.log(typeof abc);
// }
// console.log(typeof hha);
function temperatureConverter(valNum) {
    valNum = parseFloat(valNum);
    document.getElementById("outputCelsius").innerHTML = (valNum - 32) / 1.8;
}