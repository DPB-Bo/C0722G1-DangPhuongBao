<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: baobo
  Date: 11/11/2022
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
            crossorigin="anonymous">

    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
            crossorigin="anonymous"></script>
    <script>
        function displayAdd(value) {
            if(value == 1){
                document.getElementById("inputVilla").style.display="block";
                document.getElementById("inputPoolAreaAndLabel").style.display="block";
                document.getElementById("inputRoom").style.display="none";
            }
            if(value == 2){
                document.getElementById("inputVilla").style.display="block";
                document.getElementById("inputPoolAreaAndLabel").style.display="none";
                document.getElementById("inputRoom").style.display="none";
            }
            if (value == 3){
                document.getElementById("inputVilla").style.display="none";
                document.getElementById("inputRoom").style.display="block";
            }
        }
        function displayUpdate(id, name,area,cost,maxPeople,standardRoom,description,poolArea,floors,free,rentType,facilityType,facilityTypeName){
            document.getElementById("editFacilityType").value = facilityTypeName;
            document.getElementById("hiddenFacilityType").value = facilityType;
            document.getElementById("hiddenFacilityType").style.display = "none";
            document.getElementById("confirmUpdate").value = id;
            document.getElementById("editFacilityName").value = name;
            document.getElementById("editFacilityArea").value = area;
            document.getElementById("editFacilityPrice").value = cost;
            document.getElementById("editFacilityMaxUsers").value = maxPeople;
            document.getElementById("editFacilityRoomStandard").value = standardRoom;
            document.getElementById("editFacilityPoolArea").value = poolArea;
            document.getElementById("editFacilityOtherDescription").value = description;
            document.getElementById("editFacilityFloors").value = floors;
            document.getElementById("editFacilityFreeServices").value = free;
            document.getElementById("editFacilityRentalType").value = rentType;
            if(facilityType == 1){
                document.getElementById("editVilla").style.display="block";
                document.getElementById("editPoolAreaAndLabel").style.display="block";
                document.getElementById("editRoom").style.display="none";
            }
            if(facilityType == 2){
                document.getElementById("editVilla").style.display="block";
                document.getElementById("editPoolAreaAndLabel").style.display="none";
                document.getElementById("editRoom").style.display="none";
            }
            if (facilityType == 3){
                document.getElementById("editVilla").style.display="none";
                document.getElementById("editRoom").style.display="block";
            }

        }

        function getIdDelete(id){
            document.getElementById("confirmDelete").value=id;
        }
    </script>
</head>
<body>
<c:import url="/header.jsp">
</c:import>
<div class="container mt-4 content">
    <div class="row">
        <h1 class="text-center text-decoration-underline
                    col">DANH SÁCH DỊCH VỤ</h1>
        <button type="button" class="btn btn-primary
                    col-sm-1 ms-auto mb-4"
                data-bs-toggle="modal"
                data-bs-target="#modalAdd">THÊM MỚI</button>
    </div>
    <table class="table mb-5 table-striped table-borderless
                table-hover text-center">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Tên dịch vụ</th>
            <th scope="col">Diện tích</th>
            <th scope="col">Giá</th>
            <th scope="col">Số người tối đa</th>
            <th scope="col">Tiêu chuẩn phòng</th>
            <th scope="col">Ghi chú</th>
            <th scope="col">Diện tích hồ bơi</th>
            <th scope="col">Số tầng</th>
            <th scope="col">Dịch vụ miễn phí đi kèm</th>
            <th scope="col">Tên kiểu thuê</th>
            <th scope="col">Tên loại dịch vụ</th>
            <th class="" scope="col">Sửa</th>
            <th class="" scope="col">Xoá</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="facility" items="${facilityList}" varStatus="status">
        <tr>
            <th scope="row">${status.count}</th>
            <td>${facility.getName()}</td>
            <td>${facility.getArea()} m2</td>
            <td>${facility.getCost()} VND</td>
            <td>${facility.getMaxPeople()}</td>
            <td>${facility.getStandardRoom()}</td>
            <td>${facility.getDescriptionOtherConvenience()}</td>
            <td>${facility.getPoolArea()} m2</td>
            <td>${facility.getNumberOfFloors()}</td>
            <td>${facility.getFacilityFree()}</td>
            <td>${facility.getRentTypeName()}</td>
            <td>${facility.getFacilityTyeName()}</td>
            <td><button type="button" class="btn btn-success"
                        data-bs-toggle="modal"
                        data-bs-target="#modalUpdate"
                        onclick="displayUpdate('${facility.getId()}','${facility.getName()}','${facility.getArea()}','${facility.getCost()}','${facility.getMaxPeople()}','${facility.getStandardRoom()}','${facility.getDescriptionOtherConvenience()}','${facility.getPoolArea()}','${facility.getNumberOfFloors()}','${facility.getFacilityFree()}','${facility.getRentTypeId()}','${facility.getFacilityTypeId()}','${facility.getFacilityTyeName()}')" >
                Sửa</button></td>
            <td>
                <button type="button" class="btn btn-danger"
                        data-bs-toggle="modal"
                        data-bs-target="#modalDelete" onclick="getIdDelete('${facility.getId()}')">Xoá</button>
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
        <form action="/facility?action=update" method="post">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5">CHỈNH SỬA</h1>
                <button type="button" class="btn-close"
                        data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="container">
                    <div class="mb-3 ">
                        <div class="d-flex gap-3">
                            <label for="editFacilityType"
                                   class="form-label">Loại dịch vụ:
                            </label>
                            <div class="">
                                <input type="text" readonly class="form-control form-control-sm" id="editFacilityType">
                                <input type="text" class="form-control form-control-sm" id="hiddenFacilityType" name="editFacilityType">
                            </div>
                        </div>
                    </div>
                        <div class="mb-3">
                            <div class="d-flex gap-3">
                                <label for="editFacilityName"
                                       class="form-label">Tên dịch vụ: </label>
                                <div>
                                    <input type="text"
                                           class="form-control
                                                form-control-sm"
                                           id="editFacilityName"
                                    name="editFacilityName">
                                </div>
                            </div>
                        </div>
                        <div class="mb-3 ">
                            <div class="d-flex gap-3">
                                <label for="editFacilityArea"
                                       class="form-label">Diện tích:
                                </label>
                                <div class="">
                                    <input type="text"
                                           class="form-control
                                                form-control-sm"
                                           id="editFacilityArea" name="editFacilityArea">
                                </div>
                            </div>
                        </div>
                        <div class="mb-3 ">
                            <div class="d-flex gap-3">
                                <label for="editFacilityPrice"
                                       class="form-label">Giá dịch vụ: </label>
                                <div class="">
                                    <input type="text"
                                           class="form-control
                                                form-control-sm"
                                    name="editFacilityPrice"
                                    id="editFacilityPrice">
                                </div>
                            </div>
                        </div>
                        <div class="mb-3 ">
                            <div class="d-flex gap-3">
                                <label for="editFacilityMaxUsers"
                                       class="form-label">Số lượng người tối đa:
                                </label>
                                <div class="">
                                    <input type="text"
                                           class="form-control
                                                form-control-sm"
                                           id="editFacilityMaxUsers"
                                    name="editFacilityMaxUsers">
                                </div>
                            </div>
                        </div>

                    <div id="editRoom">
                        <div class="mb-3 ">
                            <div class="d-flex gap-3">
                                <label for="editFacilityFreeServices"
                                       class="form-label">Dịch vụ miễn phí đi kèm: </label>
                                <div class="">
                                    <input type="text"
                                           class="form-control
                                                form-control-sm"
                                           id="editFacilityFreeServices"
                                    name="editFacilityFreeServices">
                                </div>
                            </div>
                        </div>
                        </div>
                        <div class="mb-3 ">
                            <div class="d-flex gap-3">
                                <label for="editFacilityRentalType"
                                       class="form-label">Kiểu thuê:
                                </label>
                                <div class="">
                                    <select class="form-select
                                                form-control-sm"
                                            aria-label="Default
                                                select example"
                                    id="editFacilityRentalType"
                                    name="editFacilityRentalType">
                                        <c:forEach var="type" items="${rentTypeList}">
                                            <option value="${type.getId()}">${type.getName()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>

                    <div id="editVilla">
                    <div class="mb-3 ">
                        <div class="d-flex gap-3">
                            <label for="editFacilityRoomStandard"
                                   class="form-label">Tiêu chuẩn phòng: </label>
                            <div class="">
                                <input type="text" class="form-control form-control-sm"
                                       id="editFacilityRoomStandard" name="editFacilityRoomStandard">
                            </div>
                        </div>
                    </div>
                    <div id="editPoolAreaAndLabel">
                        <div class="mb-3 ">
                            <div class="d-flex gap-3">
                                <label for="editFacilityPoolArea"
                                       class="form-label">Diện tích hồ bơi: </label>
                                <div class="">
                                    <input type="text"
                                           class="form-control
                                                form-control-sm"
                                           id="editFacilityPoolArea"
                                           name="editFacilityPoolArea">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="mb-3 ">
                        <div class="d-flex gap-3">
                            <label for="editFacilityFloors"
                                   class="form-label">Số tầng: </label>
                            <div class="">
                                <input type="text"
                                       class="form-control
                                                form-control-sm"
                                       name="editFacilityFloors"
                                       id="editFacilityFloors">
                        </div>
                    </div>
                        <div class="mb-3">
                            <div class="d-flex gap-3">
                                <label for="editFacilityOtherDescription"
                                       class="form-label">Mô tả tiện nghi khác:
                                </label>
                                <div class="">
                                    <input type="text"
                                           class="form-control
                                                form-control-sm"
                                           id="editFacilityOtherDescription"
                                    name="editFacilityOtherDescription">
                                </div>
                            </div>
                        </div>
                    </div>
                        </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary"
                        data-bs-dismiss="modal">Đóng</button>
                <button type="submit" id="confirmUpdate" name="confirmUpdate" class="btn btn-primary">Lưu</button>
            </div>
        </div>
        </form>
    </div>
</div>
<div class="modal fade" id="modalAdd" tabindex="-1"
     aria-labelledby="exampleModalLabel" aria-hidden="true"
     data-bs-backdrop="static">
    <div class="modal-dialog">
        <form method="post" action="/facility?action=add">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5">THÊM MỚI</h1>
                <button type="button" class="btn-close"
                        data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="container">

                        <div class="mb-3 ">
                            <div class="d-flex gap-3">
                                <label for="addFacilityType"
                                       class="form-label">Loại dịch vụ:
                                </label>
                                <div class="">
                                    <select onchange="displayAdd(this.value)" class="form-select
                                                form-control-sm"
                                            aria-label="Default
                                                select example" id="addFacilityType" required
                                    name="addFacilityType">
                                        <option selected disabled value="">
                                            --- CHỌN DỊCH VỤ ---
                                        </option>
                                        <c:forEach var="type" items="${facilityTypeList}">
                                            <option value="${type.getId()}">${type.getName()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="mb-3">
                            <div class="d-flex gap-3">
                                <label for="addFacilityName"
                                       class="form-label">Tên dịch vụ: </label>
                                <div>
                                    <input type="text"
                                           class="form-control
                                                form-control-sm"
                                           id="addFacilityName" name="addFacilityName">
                                </div>
                            </div>
                        </div>
                        <div class="mb-3 ">
                            <div class="d-flex gap-3">
                                <label for="addFacilityArea"
                                       class="form-label">Diện tích:
                                </label>
                                <div class="">
                                    <input type="text"
                                           class="form-control
                                                form-control-sm"
                                    id="addFacilityArea" name="addFacilityArea">
                                </div>
                            </div>
                        </div>
                        <div class="mb-3 ">
                            <div class="d-flex gap-3">
                                <label for="addFacilityPrice"
                                       class="form-label">Giá dịch vụ: </label>
                                <div class="">
                                    <input type="text"
                                           class="form-control
                                                form-control-sm"
                                           id="addFacilityPrice" name="addFacilityPrice">
                                </div>
                            </div>
                        </div>
                        <div class="mb-3 ">
                            <div class="d-flex gap-3">
                                <label for="addFacilityMaxUsers"
                                       class="form-label">Số người tối đa:
                                </label>
                                <div class="">
                                    <input type="text"
                                           class="form-control
                                                form-control-sm"
                                           id="addFacilityMaxUsers" name="addFacilityMaxUsers">
                                </div>
                            </div>
                        </div>

                        <div class="mb-3 ">
                            <div class="d-flex gap-3">
                                <label for="addFacilityRentalType"
                                       class="form-label">Kiểu thuê:
                                </label>
                                <div class="">
                                    <select class="form-select
                                                form-control-sm"
                                            aria-label="Default
                                                select example" id="addFacilityRentalType" name="addFacilityRentalType">
                                        <c:forEach var="type" items="${rentTypeList}">
                                            <option value="${type.getId()}">${type.getName()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div id="inputRoom">
                        <div class="mb-3 ">
                            <div class="d-flex gap-3">
                                <label for="addFacilityFreeServices"
                                       class="form-label">Dịch vụ miễn phí đi kèm: </label>
                                <div class="">
                                    <input type="text"
                                           class="form-control
                                                form-control-sm"
                                           id="addFacilityFreeServices" name="addFacilityFreeServices">
                                </div>
                            </div>
                        </div>
                        </div>
                        <div id="inputVilla">
                            <div id="inputPoolAreaAndLabel">
                        <div class="mb-3 ">
                            <div class="d-flex gap-3">
                                <label for="addFacilityPoolArea"
                                       class="form-label">Diện tích hồ bơi: </label>
                                <div class="">
                                    <input type="text"
                                           class="form-control
                                                form-control-sm"
                                           id="addFacilityPoolArea" name="addFacilityPoolArea">
                                </div>
                            </div>
                        </div>
                            </div>
                        <div class="mb-3 ">
                            <div class="d-flex gap-3">
                                <label for="addFacilityRoomStandard"
                                       class="form-label">Tiêu chuẩn phòng: </label>
                                <div class="">
                                    <input type="text"
                                           class="form-control form-control-sm"
                                           id="addFacilityRoomStandard" name="addFacilityRoomStandard">
                                </div>
                            </div>
                        </div>
                        <div class="mb-3 ">
                            <div class="d-flex gap-3">
                                <label for="addFacilityFloors"
                                       class="form-label">Số tầng: </label>
                                <div class="">
                                    <input type="text"
                                           class="form-control
                                                form-control-sm"
                                           id="addFacilityFloors" name="addFacilityFloors">
                                </div>
                            </div>
                        </div>
                        <div class="mb-3">
                            <div class="d-flex gap-3">
                                <label for="addFacilityOtherDescription"
                                       class="form-label">Mô tả tiện nghi khác :
                                </label>
                                <div class="">
                                    <input type="text"
                                           class="form-control
                                                form-control-sm"
                                           id="addFacilityOtherDescription" name="addFacilityOtherDescription">
                                </div>
                            </div>
                        </div>
                        </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary"
                        data-bs-dismiss="modal">Đóng</button>
                <button type="submit" class="btn btn-primary">Xác nhận</button>
            </div>
        </div>
        </form>
    </div>
</div>
<div class="modal fade" id="modalDelete" tabindex="-1"
     aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="/facility?action=delete" method="post">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">CẢNH
                    BÁO</h1>
                <button type="button" class="btn-close"
                        data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                XÁC NHẬN XOÁ ?
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
<c:import url="/footer.jsp">
</c:import>
</body>
</html>
