// EM CÓ THỂ SỬ DỤNG LẶP ĐỂ TẠO BẢNG NHƯNG ĐANG THỬ DỤNG FUNCTION ĐỂ QUẢN LÝ 1 CÁI BẢNG




let inputNewProduct = document.getElementById('inputNewProduct');
let arrProductName = [];
let amountTdInRow = 6;
let tableDisplayAllProducts = document.getElementById('tableDisplayAllProducts');
let alertAddedNewProduct = document.getElementById('alertAddedNewproduct');
let displayAmountProduct = document.getElementById('displayAmountProduct');

function addProductNameToArray(valueInput) {
    arrProductName.push(valueInput);
    return arrProductName.length;
}

function addProductNameToTableDisplay(locationRowAdd, nameProduct) {
    let rowAdd = tableDisplayAllProducts.insertRow(locationRowAdd);
    rowAdd.id = 'rowIndex' + locationRowAdd;
    for (let i = 0; i < amountTdInRow; i++) {
        switch (i) {
            case 0:
                rowAdd.insertCell(i).innerHTML = nameProduct;
                break;
            case 3:
                rowAdd.insertCell(i).innerHTML = '<button type="button" onclick="editNameDisplayProduct(' + locationRowAdd + ');">Edit</button>';
                break;
            case 5:
                rowAdd.insertCell(i).innerHTML = '<button type="button" onclick="deleteDisplayProduct(' + locationRowAdd + ');">Delete</button>';
                break;
            default:
                rowAdd.insertCell(i).innerHTML = '';
                break;
        }
    }
}

function alertAdded(productName) {
    alertAddedNewProduct.innerHTML = 'Đã thêm sản phẩm <b>' + productName + '</b> vào list!';
}

function showAmountProduct(lengthArr) {
    displayAmountProduct.innerHTML = lengthArr + ' sản phẩm';
}

function addNewProduct() {
    let valueInput = inputNewProduct.value;
    let alertNoInputValue = 'Bạn chưa nhập tên sản phẩm cần thêm!';
    if (valueInput == '') {
        return alert(alertNoInputValue);
    }
    let lengthArrAtThisTime = addProductNameToArray(valueInput);
    addProductNameToTableDisplay(lengthArrAtThisTime, valueInput);
    alertAdded(valueInput);
    showAmountProduct(lengthArrAtThisTime);
    inputNewProduct.value = '';
}

function deleteDisplayProduct(locationRow) {
    let rowRemove = document.getElementById('rowIndex' + locationRow);
    // for (let i = 0; i < arrProductName.length; i++) {
    //     if (arrProductName[i] == columnChange.innerHTML) {
    //         arrProductName.splice(i, 1);
    //     } else {
    //         return alert('Lỗi không tìm thấy tên sản phẩm trong mảng danh sách');
    //     }
    // }
    rowRemove.parentNode.removeChild(rowRemove);
    // tableDisplayAllProducts.deleteRow(locationRow);
    showAmountProduct(arrProductName.length);
}

function editNameDisplayProduct(locationRow) {
    let changevalue = +prompt('Đổi tên sản phẩm thành: ');
    let makeSure = confirm('Bạn chắc chắn thay đổi ')
}
