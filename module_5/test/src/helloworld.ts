let x=0;
async function r5() {
    console.log('X bắt đầu vào r5 :'+x)
    x += 1;
    console.log('X sau khi vào r5 :'+x);
    return 5;
}
(async () => {
    console.log('X trước khi await vào r5 :'+x)
    x = await r5();
    console.log('X sau khi await vào r5 :'+x);
})();

console.log(x+=1);
