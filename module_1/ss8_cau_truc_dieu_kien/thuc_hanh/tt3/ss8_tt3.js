var validuser = prompt("Nhập vào username") == "admin" || "Admin";
if(validuser){
    var validpassword = prompt("Nhập vào password");
    if(validpassword == ""){
        alert("Cancel login");
    } if(validpassword == "TheMaster"){
        alert("Login successful");
    } else {
        alert("Wrong password");
    }
} else {
    alert("Wrong username");
}