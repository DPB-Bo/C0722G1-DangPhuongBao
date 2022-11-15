<%--
  Created by IntelliJ IDEA.
  User: baobo
  Date: 10/11/2022
  Time: 08:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link rel="stylesheet" href="/datatables/css/dataTables.bootstrap5.min.css">
  <script src="/jquery/jquery-3.5.1.min.js"></script>
  <script src="/datatables/js/jquery.dataTables.min.js"></script>
  <script src="/datatables/js/dataTables.bootstrap5.min.js"></script>
  <script>
    function updateCustomer(id, name, birthday, gender, idCard, phoneNumber, email, address, customerTypeId) {
    document.getElementById("updateCustomerName").value = name;
    document.getElementById("updateCustomerBirth").value=birthday;
    document.getElementById("updateCustomerIdCard").value = idCard;
    document.getElementById("updateCustomerPhone").value=phoneNumber;
    document.getElementById("updateCustomerEmail").value=email;
    document.getElementById("updateCustomerAddress").value=address;
    document.getElementById("updateCustomerRank").value=customerTypeId;
    if (gender === "true"){
      document.getElementById("updateCustomerGenderMale").checked = true;
    }else {
      document.getElementById("updateCustomerGenderFemale").checked = true;
    }
    document.getElementById("updateConfirm").value= id;
  }

  $(document).ready(function() {
      $('#tableCustomer').dataTable( {
        "dom": 'lrtip',
        "lengthChange": false,
        "pageLength": 5,
      } );
    } );

    function deleteCustomer(id,name){
      document.getElementById("deleteName").innerText=name;
      document.getElementById("deleteConfirm").value= id;
    }
  </script>
  <link
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
          crossorigin="anonymous">

  <script
          src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
          integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
          crossorigin="anonymous"></script>
</head>
<body>
<c:import url="/header.jsp"></c:import>
<div class="container mt-4 content">
  <form class="d-flex" action="/customers?action=search" method="post">
    <input class="form-control me-2" type="search" name="search" placeholder="Bảo Đại Ca"
           aria-label="Search" value="${search}">
    <button class="btn btn-dark" type="submit">Tìm kiếm</button>
  </form>
  <div class="row">
    <h1 class="text-center text-decoration-underline
                    col">DANH SÁCH KHÁCH HÀNG</h1>
    <button type="button" class="btn btn-primary
                    col-sm-1 ms-auto mb-4"
            data-bs-toggle="modal"
            data-bs-target="#modalAdd">THÊM MỚI</button>
  </div>
  <table id="tableCustomer" class="table mb-5 table-striped table-borderless
                table-hover text-center">
    <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Tên khách hàng</th>
      <th scope="col">Ngày sinh</th>
      <th scope="col">Giới Tính</th>
      <th scope="col">Chứng minh nhân dân</th>
      <th scope="col">Số điện thoại</th>
      <th scope="col" class="text-center">Email</th>
      <th scope="col">Địa chỉ</th>
      <th scope="col">Loại khách hàng</th>
      <th class="" scope="col">Cập nhật</th>
      <th class="" scope="col">Xoá</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="customer" items="${customers}" varStatus="status">
    <tr>
        <th scope="row">${status.count}</th>
        <td>${customer.getName()}</td>
        <td>${customer.getBirthday()}</td>
        <td>${customer.isGender() == true ? "Nam" : "Nữ"}</td>
        <td>${customer.getIdCard()}</td>
        <td>${customer.getPhoneNumber()}</td>
        <td>${customer.getEmail()}</td>
        <td>${customer.getAddress()}</td>
        <td>${customer.getCustomerTypeId()}</td>

      <td><button type="button" class="btn btn-success"
                  data-bs-toggle="modal"
                  data-bs-target="#modalUpdate"
      onclick="updateCustomer('${customer.getId()}','${customer.getName()}','${customer.getBirthday()}','${customer.isGender()}','${customer.getIdCard()}','${customer.getPhoneNumber()}','${customer.getEmail()}','${customer.getAddress()}','${customer.getCustomerTypeId()}')">Sửa</button></td>
      <td>
        <button type="button" class="btn btn-danger"
                data-bs-toggle="modal"
                data-bs-target="#modalAlertDelete" onclick="deleteCustomer('${customer.getId()}','${customer.getName()}')">Xoá</button>
      </td>
    </tr>
    </c:forEach>
    </tbody>
  </table>
</div>

<div class="modal fade" id="modalUpdate" tabindex="-1"
     aria-labelledby="exampleModalLabel" aria-hidden="true"
     data-bs-backdrop="static">
  <div class="modal-dialog">
    <form action="/customers?action=update" method="post">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5">Chỉnh sửa</h1>
        <button type="button" class="btn-close"
                data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <div class="container">
          <form>
            <div class="mb-3">
              <div class="d-flex gap-3">
                <label for="updateCustomerName"
                       class="form-label">Tên khách hàng:
                </label>
                <div>
                  <input type="text"
                         class="form-control form-control-sm"
                         id="updateCustomerName"
                  name="updateCustomerName">
                </div>
              </div>
            </div>
            <div class="mb-3 ">
              <div class="d-flex gap-3">
                <label for="updateCustomerBirth"
                       class="form-label">Ngày sinh:
                </label>
                <div class="">
                  <input type="date"
                         class="form-control form-control-sm"
                  id="updateCustomerBirth"
                  name="updateCustomerBirth">
                </div>
              </div>
            </div>
            <div class="mb-3 ">
              <div class="d-flex gap-3">
                <label
                       class="form-label">Giới tính: </label>
                <div class="">
                  <div class="form-check form-check-inline mb-0 me-4">
                    <input class="form-check-input" type="radio" value="true" name="updateCustomerGender" id="updateCustomerGenderMale"/>
                    <label class="form-check-label" for="updateCustomerGenderMale">Nam</label>
                  </div>
                  <div class="form-check form-check-inline mb-0 me-4">
                    <input class="form-check-input" type="radio" value="false" name="updateCustomerGender" id="updateCustomerGenderFemale"/>
                    <label class="form-check-label" for="updateCustomerGenderFemale">Nữ</label>
                  </div>
                </div>
              </div>
            </div>
            <div class="mb-3 ">
              <div class="d-flex gap-3">
                <label
                       class="form-label">CHỨNG MINH NHÂN DÂN:
                </label>
                <div class="">
                  <input type="text"
                         class="form-control form-control-sm"
                  id="updateCustomerIdCard"
                  name="updateCustomerIdCard">
                </div>
              </div>
            </div>
            <div class="mb-3 ">
              <div class="d-flex gap-3">
                <label
                       class="form-label">Số điện thoại:
                </label>
                <div class="">
                  <input type="text"
                         class="form-control form-control-sm"
                  id="updateCustomerPhone"
                  name="updateCustomerPhone">
                </div>
              </div>
            </div>
            <div class="mb-3 ">
              <div class="d-flex gap-3">
                <label
                       class="form-label">Email: </label>
                <div class="">
                  <input type="text"
                         class="form-control form-control-sm"
                  id="updateCustomerEmail"
                  name="updateCustomerEmail">
                </div>
              </div>
            </div>
            <div class="mb-3 ">
              <div class="d-flex gap-3">
                <label
                       class="form-label">Địa chỉ: </label>
                <div class="">
                  <input type="text"
                         class="form-control form-control-sm"
                  id="updateCustomerAddress"
                  name="updateCustomerAddress">
                </div>
              </div>
            </div>
            <div class="mb-3 ">
              <div class="d-flex gap-3">
                <label
                       class="form-label">Loại khách:
                </label>
                <div class="">
                  <select class="form-select form-control-sm"
                          aria-label="Default select example" id="updateCustomerRank" name="updateCustomerRank">
                    <c:forEach var="customerRank" items="${customerRanks}">
                      <option value="${customerRank.getId()}">${customerRank.getName()}</option>
                    </c:forEach>
                  </select>
                </div>
              </div>
            </div>

          </form>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary"
                data-bs-dismiss="modal">Đóng</button>
        <button type="submit" id="updateConfirm" class="btn btn-primary" name="updateConfirm">Lưu</button>
      </div>
    </div>
    </form>
  </div>
</div>
<div class="modal fade" id="modalAdd" tabindex="-1"
     aria-labelledby="exampleModalLabel" aria-hidden="true"
     data-bs-backdrop="static">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5">Thêm mới</h1>
        <button type="button" class="btn-close"
                data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <form action="/customers?action=add" method="post">
      <div class="modal-body">
        <div class="container">
              <div class="mb-3">
                <div class="d-flex gap-3">
                  <label for="addCustomerName"
                         class="form-label">Tên khách hàng:
                  </label>
                  <div>
                    <input type="text"
                           class="form-control form-control-sm"
                           name="addCustomerName"
                           id="addCustomerName">
                  </div>
                </div>
              </div>
              <div class="mb-3 ">
                <div class="d-flex gap-3">
                  <label for="addCustomerBirth"
                         class="form-label">Ngày sinh:
                  </label>
                  <div class="">
                    <input type="date"
                           class="form-control form-control-sm"
                           name="addCustomerBirth"
                    id="addCustomerBirth">
                  </div>
                </div>
              </div>
              <div class="mb-3 ">
                <div class="d-flex gap-3">
                  <label
                         class="form-label">Giới Tính:
                  </label>
                  <div>
                    <div class="form-check form-check-inline mb-0 me-4">
                      <input class="form-check-input" type="radio" value="true" name="addCustomerGender"
                             id="maleGender"/>
                      <label class="form-check-label" for="maleGender">Nam</label>
                    </div>
                    <div class="form-check form-check-inline mb-0 me-4">
                      <input class="form-check-input" type="radio" value="false" name="addCustomerGender"
                             id="femaleGender"/>
                      <label class="form-check-label" for="femaleGender">Nữ</label>
                    </div>
                  </div>
                </div>
              </div>
              <div class="mb-3 ">
                <div class="d-flex gap-3">
                  <label for="addCustomerIdCard"
                         class="form-label">Chứng minh nhân dân:
                  </label>
                  <div class="">
                    <input type="text"
                           class="form-control form-control-sm"
                           name="addCustomerIdCard"
                    id="addCustomerIdCard">
                  </div>
                </div>
              </div>
              <div class="mb-3 ">
                <div class="d-flex gap-3">
                  <label for="addCustomerPhone"
                         class="form-label">Số điện thoại:
                  </label>
                  <div class="">
                    <input type="text"
                           class="form-control form-control-sm"
                           id="addCustomerPhone"
                           name="addCustomerPhone">
                  </div>
                </div>
              </div>
              <div class="mb-3 ">
                <div class="d-flex gap-3">
                  <label for="addCustomerEmail"
                         class="form-label">Email:
                  </label>
                  <div class="">
                    <input type="email"
                           class="form-control form-control-sm"
                           name="addCustomerEmail"
                    id="addCustomerEmail">
                  </div>
                </div>
              </div>
              <div class="mb-3 ">
                <div class="d-flex gap-3">
                  <label for="addCustomerAddress"
                         class="form-label">Địa chỉ:
                  </label>
                  <div class="">
                    <input type="text"
                           class="form-control form-control-sm"
                           id="addCustomerAddress"
                    name="addCustomerAddress">
                  </div>
                </div>
              </div>
              <div class="mb-3 ">
                <div class="d-flex gap-3">
                  <label
                         class="form-label">Loại khách hàng:
                  </label>
                  <div class="">
                    <select class="form-select form-control-sm"
                            aria-label="Default select example"
                            name="addCustomerRank">
                      <c:forEach var="customerRank" items="${customerRanks}">
                        <option value="${customerRank.getId()}">${customerRank.getName()}</option>
                      </c:forEach>
                    </select>
                  </div>
                </div>
              </div>
        </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary"
                data-bs-dismiss="modal">Đóng</button>
        <button type="submit" class="btn btn-primary">Lưu</button>
      </div>
    </div>
    </form>
  </div>
</div>
</div>
<div class="modal fade" id="modalAlertDelete" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Xoá khách hàng</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <div id="deleteName"></div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Huỷ</button>
        <form action="/customers?action=delete" method="post"><button type="submit" class="btn btn-primary" id="deleteConfirm" name="deleteConfirm">Xoá</button></form>
      </div>
    </div>
  </div>
</div>
<c:import url="/footer.jsp"></c:import>
</body>
</html>
