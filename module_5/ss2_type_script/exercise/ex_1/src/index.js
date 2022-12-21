"use strict";
exports.__esModule = true;
console.log("Tính tổng dãy số Fibonacci trong 1 số cho trước");
var sum = 0;
var fibonacci = function (n) {
    if (n == 0 || n == 1) {
        return n;
    }
    else {
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
};
var sumFibonacci = function (n) {
    console.log(n + " số đầu tiên của dãy số fibonacci");
    for (var i = 0; i < n; i++) {
        var tempFibonacci = fibonacci(i);
        console.log(tempFibonacci);
        sum += tempFibonacci;
    }
    console.log("Tổng của " + n + " số fibonacci đó là: ");
    return sum;
};
console.log(sumFibonacci(10));
