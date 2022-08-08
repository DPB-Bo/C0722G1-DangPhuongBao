btnYes = document.getElementById('btnYes');
btnNo = document.getElementById('btnNo');
// randomWidth = Math.round(Math.random() * window.innerWidth);
// randomHeight = Math.round(Math.random() * window.innerHeight);
function clickYes(){
    // alert('Kém!');
    // confirm('Nó bên cạnh kìa! Cố lên');
    if (confirm('Nó bên cạnh kìa! Bắt nó') == false) {
        alert('Kém!');
        window.location.reload();
    }
}
function returnNoPos(){
    btnNo.style.left = "900px";
    btnNo.style.top = "100px";
}
function runAway(){
    btnNo.style.left = Math.round(Math.random() * window.innerWidth) + "px";
    btnNo.style.top = Math.round(Math.random() * window.innerHeight) + "px";
}