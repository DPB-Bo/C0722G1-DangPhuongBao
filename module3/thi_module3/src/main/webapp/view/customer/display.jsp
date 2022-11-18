<%--
  Created by IntelliJ IDEA.
  User: baobo
  Date: 16/11/2022
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/datatables/css/dataTables.bootstrap5.min.css">
    <script src="/jquery/jquery-3.5.1.min.js"></script>
    <script src="/datatables/js/jquery.dataTables.min.js"></script>
    <script src="/datatables/js/dataTables.bootstrap5.min.js"></script>
    <link rel="stylesheet" href="bootstrap-5.2.2-dist/css/bootstrap.css">
    <script src="bootstrap-5.2.2-dist/js/bootstrap.js"></script>
    <script>
        $(document).ready(function() {
            $('#tableEx').dataTable( {
                "dom": 'lrtip',
                "lengthChange": false,
                "pageLength": 3,
            } );
        } );
        function updateCustomer(sickTypeId,customerId,sickTypeName,customerName,dayIn,dayOut,description) {
            document.getElementById("updateSickTypeId").value = sickTypeId;
            document.getElementById("updateCustomerId").value = customerId;
            document.getElementById("updateSickName").value = sickTypeName
            document.getElementById("updateCustomerName").value = customerName;
            document.getElementById("updateDayIn").value = dayIn;
            document.getElementById("updateDayOut").value = dayOut;
            document.getElementById("updateDescription").value = description;
        }
        function deleteCustomer(sickTypeId,customerId){
            document.getElementById("deleteSickType").value=sickTypeId;
            document.getElementById("confirmDelete").value=customerId;
        }
    </script>
</head>
<body>
<div class="container">
    <div class="row">
        <h1 class="text-center text-decoration-underline
                    col">DANH SÁCH BỆNH ÁN</h1>
        <h2 style="text-align: center;color: red"><c:if test="${mess!=null}">
            <span>${mess}</span>
        </c:if></h2>
    </div>
    <table id="tableEx" class="table mb-5 table-striped table-borderless
                table-hover text-center">
        <thead>
        <tr>
            <th scope="col">STT</th>
            <th scope="col">Mã bệnh án</th>
            <th scope="col">Mã bệnh nhân</th>
            <th scope="col">Tên bệnh nhân</th>
            <th scope="col">Ngày nhập viện</th>
            <th scope="col">Ngày ra viện</th>
            <th scope="col">Lí do nhập viện</th>
            <th scope="col">Cập nhật</th>
            <th scope="col">Xoá</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="customer" items="${customerList}" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${customer.getSickTypeId()}</td>
                <td>${customer.getCustomerId()}</td>
                <td>${customer.getCustomerName()}</td>
                <td>${customer.getDayIn()}</td>
                <td>${customer.getDayOut()}</td>
                <td>${customer.getDescription()}</td>
                <td>
                    <button type="button" class="btn btn-success"
                            data-bs-toggle="modal"
                            data-bs-target="#modalUpdate" onclick="updateCustomer('${customer.getSickTypeId()}','${customer.getCustomerId()}','${customer.getSickTypeName()}','${customer.getCustomerName()}','${customer.getDayIn()}','${customer.getDayOut()}','${customer.getDescription()}')">Sửa</button>
                </td>
                <td>
                    <button type="button" class="btn btn-danger"
                            data-bs-toggle="modal"
                            data-bs-target="#modalDelete" onclick="deleteCustomer('${customer.getCustomerId()}','${customer.getSickTypeId()}')">Xoá</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div class="modal fade" id="modalDelete" tabindex="-1"
     aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="/customers?action=delete" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">CẢNH
                        BÁO</h1>
                    <button type="button" class="btn-close"
                            data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    XÁC NHẬN XOÁ BỆNH ÁN
                </div>
                <div id="deleteSickType">

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary"
                            data-bs-dismiss="modal">Huỷ</button>
                    <button type="submit" class="btn btn-primary" id="confirmDelete" name="confirmDelete">Xác nhận</button>
                </div>
            </div>
        </form>
    </div>
</div>

<div class="modal fade" id="modalUpdate" tabindex="-1"
     aria-labelledby="exampleModalLabel" aria-hidden="true"
     data-bs-backdrop="static">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5">Chỉnh sửa</h1>
                <button type="button" class="btn-close"
                        data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="/customers?action=update" method="post">
                <div class="modal-body">
                    <div class="container">
                        <div class="mb-3">
                            <div class="d-flex gap-3">
                                <label for="updateSickTypeId"
                                       class="form-label">Mã bệnh án:
                                </label>
                                <div>
                                    <input type="text"
                                           class="form-control form-control-sm"
                                           name="updateSickTypeId"
                                           id="updateSickTypeId" readonly>
                                </div>
                            </div>
                        </div>
                            <div class="mb-3">
                                <div class="d-flex gap-3">
                                    <label for="updateCustomerId"
                                           class="form-label">Mã bệnh nhân:
                                    </label>
                                    <div>
                                        <input type="text"
                                               class="form-control form-control-sm"
                                               name="updateCustomerId"
                                               id="updateCustomerId" readonly>
                                    </div>
                                </div>
                            </div>
                        <div class="mb-3">
                            <div class="d-flex gap-3">
                                <label for="updateCustomerName"
                                       class="form-label">Tên bệnh nhân:
                                </label>
                                <div>
                                    <input type="text"
                                           class="form-control form-control-sm"
                                           name="updateCustomerName"
                                           id="updateCustomerName" readonly>
                                </div>
                            </div>
                        </div>
                        <div class="mb-3">
                            <div class="d-flex gap-3">
                                <label for="updateSickName"
                                       class="form-label">Tên bệnh án:
                                </label>
                                <div>
                                    <input type="text"
                                           class="form-control form-control-sm"
                                           name="updateSickName"
                                           id="updateSickName" required>
                                </div>
                            </div>
                        </div>

                        <div class="mb-3">
                            <div class="d-flex gap-3">
                                <label for="updateDayIn"
                                       class="form-label">Ngày nhập viện:
                                </label>
                                <div>
                                    <input type="date"
                                           class="form-control form-control-sm"
                                           name="updateDayIn"
                                           id="updateDayIn">
                                </div>
                            </div>
                        </div>

                        <div class="mb-3">
                            <div class="d-flex gap-3">
                                <label for="updateDayOut"
                                       class="form-label">Ngày xuất viện:
                                </label>
                                <div>
                                    <input type="date"
                                           class="form-control form-control-sm"
                                           name="updateDayOut"
                                           id="updateDayOut">
                                </div>
                            </div>
                        </div>

                        <div class="mb-3">
                            <div class="d-flex gap-3">
                                <label for="updateDescription"
                                       class="form-label">Lý do nhập viện:
                                </label>
                                <div>
                                    <input type="text"
                                           class="form-control form-control-sm"
                                           name="updateDescription"
                                           id="updateDescription" required>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary"
                            data-bs-dismiss="modal">Đóng</button>
                    <button type="submit" class="btn btn-primary">Lưu</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
