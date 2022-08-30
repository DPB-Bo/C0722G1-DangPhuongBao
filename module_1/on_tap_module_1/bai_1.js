let br = '<br>';

function createArray(sizeArray) {
    let arr = [];
    for (var i = 0; i < sizeArray; i++) {
        arr[i] = +prompt('Nhập vào phần tử tại chỉ số thứ ' + (i + 1) + ' của mảng: ');
    }
    return arr;
}

function bai1() {
    let sizeArray;
    do {
        sizeArray = +prompt('Nhập vào số lượng phần tử của mảng(<=50): ');
    } while (sizeArray > 50 || sizeArray < 1);
    let arr = createArray(sizeArray);
    let sum = 0;
    let count = 0;
    document.write('Mảng bạn vừa nhập là: ' + arr.join(', ') + br);
    for (let i = 0; i < arr.length; i++) {
        if (!(arr[i] % 5) && !(i % 3)) {
            sum += arr[i];
            count++;
        }
    }
    sum ? document.write('Trung bình cộng của các phần tử chia hết cho 5 trong mảng là: ' + (sum / count))
        : document.write('Không có phần tử chia hết cho 5 trong mảng');
}

bai1();