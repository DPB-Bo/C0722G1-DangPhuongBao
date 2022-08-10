// function onEvent(){
//     document.getElementById("g").checked= true;
// }

// const FAST = document.getElementById("f");
// const CHEAP = document.getElementById("c");
// const GOOD = document.getElementById("g");
// var checkedFast = document.getElementById("f").checked;
// var checkedCheap = document.getElementById("c").checked;
// var checkedGood = document.getElementById("g").checked;

// Tại sao phải bỏ ở trong
//Sau khi ss xong thì tại sao k thay đổi giá trị của biến đó được

function onEvent(pos){
const FAST = document.getElementById("f");
const CHEAP = document.getElementById("c");
const GOOD = document.getElementById("g");
let checkedFast = document.getElementById("f").checked;
let checkedCheap = document.getElementById("c").checked;
let checkedGood = document.getElementById("g").checked;
    switch(pos){
        case '1':
            if( checkedCheap && checkedGood ){
                if (Math.random() > 0.5){
                    // CHEAP.setAttribute("checked",false);
                    // document.getElementById("c").checked= false;
                    CHEAP.checked=false;
                } else {
                    // GOOD.setAttribute("checked",false);
                    // document.getElementById("g").checked= false;
                    GOOD.checked=false;
                }
            }
            break;
        case '2':
            if( checkedFast && checkedGood){
                if (Math.random() < 0.5){
                    // FAST.setAttribute("checked",false);
                    FAST.checked=false;
                } else {
                    // GOOD.setAttribute("checked",false);
                    GOOD.checked=false;
                }
            }
            break;
        case '3':
            if( checkedCheap && checkedFast){
                if (Math.random() < 0.5){
                    // CHEAP.setAttribute("checked",false);
                    CHEAP.checked=false;
                } else {
                    // FAST.setAttribute("checked",false);
                    FAST.checked=false;
                }
            }
            break;
        
    };
}
// function onEvent(pos){
//     console.log(checkedFast);
// }