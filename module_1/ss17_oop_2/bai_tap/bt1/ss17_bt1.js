let c = document.getElementById("myCanvas");
let ctx = c.getContext("2d");
let showValue = document.getElementById("showValue");
class Rectangle {
    constructor(width, height) {
        this.width = width;
        this.height = height;
    }
    caculateAre() {
        return this.width * this.height;
    }
    caculatePerimeter() {
        return (this.width + this.height) * 2;
    }
    setWidth(width) {
        this.width = width;
    }
    setHeight(height) {
        this.height = height;
    }
    draw() {
        // return ctx.rect(20, 20, this.width, this.height);
        ctx.rect(20, 20, this.width, this.height);
        ctx.stroke();
    }
    // clearDraw() {
    //     ctx.clearRect(20, 20, 700, 500);
    // }

}


let width = +prompt('Nhập vào chiều dài hình chữ nhật: ');
let height = +prompt('Nhập vào chiều rộng hình chữ nhật: ');
let rectangle = new Rectangle(width, height);
// rectangle.clearDraw();
rectangle.draw();


function setWidthHeight() {
    this.location.reload();
}

function caculate() {
    showValue.innerHTML = 'Diện tích = ' + rectangle.caculateAre() + 'px. <br> Chu vi = ' + rectangle.caculatePerimeter() + 'px';
}

// drawRectangle();