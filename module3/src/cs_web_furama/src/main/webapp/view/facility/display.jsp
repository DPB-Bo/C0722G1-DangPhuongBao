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
</head>
<body>
<c:import url="/header.jsp"></c:import>
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
                        data-bs-target="#modalUpdate">Sửa</button></td>
            <td>
                <button type="button" class="btn btn-danger"
                        data-bs-toggle="modal"
                        data-bs-target="#modalDelete">Xoá</button>
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
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5">UPDATE</h1>
                <button type="button" class="btn-close"
                        data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="container">
                    <form>
                        <div class="mb-3">
                            <div class="d-flex gap-3">
                                <label for="FacilityName"
                                       class="form-label">Facility
                                    Name: </label>
                                <div>
                                    <input type="text"
                                           class="form-control
                                                form-control-sm"
                                           value=""
                                           id="FacilityName">
                                </div>
                            </div>
                        </div>
                        <div class="mb-3 ">
                            <div class="d-flex gap-3">
                                <label for="exampleInputEmail1"
                                       class="form-label">Area:
                                </label>
                                <div class="">
                                    <input type="text"
                                           class="form-control
                                                form-control-sm"
                                           value="">
                                </div>
                            </div>
                        </div>
                        <div class="mb-3 ">
                            <div class="d-flex gap-3">
                                <label for="exampleInputEmail1"
                                       class="form-label">Service
                                    Price: </label>
                                <div class="">
                                    <input type="text"
                                           class="form-control
                                                form-control-sm"
                                           value="">
                                </div>
                            </div>
                        </div>
                        <div class="mb-3 ">
                            <div class="d-flex gap-3">
                                <label for="exampleInputEmail1"
                                       class="form-label">Max User:
                                </label>
                                <div class="">
                                    <input type="text"
                                           class="form-control
                                                form-control-sm"
                                           value="">
                                </div>
                            </div>
                        </div>
                        <div class="mb-3 ">
                            <div class="d-flex gap-3">
                                <label for="exampleInputEmail1"
                                       class="form-label">Room
                                    Standard: </label>
                                <div class="">
                                    <select class="form-select
                                                form-control-sm"
                                            aria-label="Default
                                                select example">
                                        <option selected>-- Room
                                            Standard --</option>
                                        <option value="1">VIP</option>
                                        <option value="2">NORMAL</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="mb-3 ">
                            <div class="d-flex gap-3">
                                <label for="exampleInputEmail1"
                                       class="form-label">Floor
                                    Numbers: </label>
                                <div class="">
                                    <input type="text"
                                           class="form-control
                                                form-control-sm"
                                           value="">
                                </div>
                            </div>
                        </div>
                        <div class="mb-3 ">
                            <div class="d-flex gap-3">
                                <label for="exampleInputEmail1"
                                       class="form-label">Free
                                    Service: </label>
                                <div class="">
                                    <input type="text"
                                           class="form-control
                                                form-control-sm"
                                           value="">
                                </div>
                            </div>
                        </div>
                        <div class="mb-3 ">
                            <div class="d-flex gap-3">
                                <label for="exampleInputEmail1"
                                       class="form-label">Rental
                                    Type Name:
                                </label>
                                <div class="">
                                    <select class="form-select
                                                form-control-sm"
                                            aria-label="Default
                                                select example">
                                        <option selected>--
                                            RENTAL TYPE --</option>
                                        <option value="1">YEAR</option>
                                        <option value="2">MONTH</option>
                                        <option value="3">DAY</option>
                                        <option value="4">HOUR</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="mb-3 ">
                            <div class="d-flex gap-3">
                                <label for="exampleInputEmail1"
                                       class="form-label">Facility
                                    Type Name:
                                </label>
                                <div class="">
                                    <select class="form-select
                                                form-control-sm"
                                            aria-label="Default
                                                select example">
                                        <option selected>--
                                            FACILITY TYPE --</option>
                                        <option value="1">VILLA</option>
                                        <option value="2">HOUSE</option>
                                        <option value="3">ROOM</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="mb-3 ">
                            <div class="d-flex gap-3">
                                <label for="exampleInputEmail1"
                                       class="form-label">Pool
                                    Area: </label>
                                <div class="">
                                    <input type="text"
                                           class="form-control
                                                form-control-sm"
                                           value="">
                                </div>
                            </div>
                        </div>
                        <div class="">
                            <div class="d-flex gap-3">
                                <label for="exampleInputEmail1"
                                       class="form-label">Other
                                    Description:
                                </label>
                                <div class="">
                                    <input type="text"
                                           class="form-control
                                                form-control-sm"
                                           value="">
                                </div>
                            </div>

                        </div>
                </div>
                </form>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary"
                        data-bs-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="modalAdd" tabindex="-1"
     aria-labelledby="exampleModalLabel" aria-hidden="true"
     data-bs-backdrop="static">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5">ADD</h1>
                <button type="button" class="btn-close"
                        data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="container">
                    <form>
                        <div class="mb-3">
                            <div class="d-flex gap-3">
                                <label for="FacilityName"
                                       class="form-label">Facility
                                    Name: </label>
                                <div>
                                    <input type="text"
                                           class="form-control
                                                form-control-sm"
                                           value=""
                                           id="FacilityName">
                                </div>
                            </div>
                        </div>
                        <div class="mb-3 ">
                            <div class="d-flex gap-3">
                                <label for="exampleInputEmail1"
                                       class="form-label">Area:
                                </label>
                                <div class="">
                                    <input type="text"
                                           class="form-control
                                                form-control-sm"
                                           value="">
                                </div>
                            </div>
                        </div>
                        <div class="mb-3 ">
                            <div class="d-flex gap-3">
                                <label for="exampleInputEmail1"
                                       class="form-label">Service
                                    Price: </label>
                                <div class="">
                                    <input type="text"
                                           class="form-control
                                                form-control-sm"
                                           value="">
                                </div>
                            </div>
                        </div>
                        <div class="mb-3 ">
                            <div class="d-flex gap-3">
                                <label for="exampleInputEmail1"
                                       class="form-label">Max User:
                                </label>
                                <div class="">
                                    <input type="text"
                                           class="form-control
                                                form-control-sm"
                                           value="">
                                </div>
                            </div>
                        </div>
                        <div class="mb-3 ">
                            <div class="d-flex gap-3">
                                <label for="exampleInputEmail1"
                                       class="form-label">Room
                                    Standard: </label>
                                <div class="">
                                    <select class="form-select
                                                form-control-sm"
                                            aria-label="Default
                                                select example">
                                        <option selected>-- Room
                                            Standard --</option>
                                        <option value="1">VIP</option>
                                        <option value="2">NORMAL</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="mb-3 ">
                            <div class="d-flex gap-3">
                                <label for="exampleInputEmail1"
                                       class="form-label">Floor
                                    Numbers: </label>
                                <div class="">
                                    <input type="text"
                                           class="form-control
                                                form-control-sm"
                                           value="">
                                </div>
                            </div>
                        </div>
                        <div class="mb-3 ">
                            <div class="d-flex gap-3">
                                <label for="exampleInputEmail1"
                                       class="form-label">Free
                                    Service: </label>
                                <div class="">
                                    <input type="text"
                                           class="form-control
                                                form-control-sm"
                                           value="">
                                </div>
                            </div>
                        </div>
                        <div class="mb-3 ">
                            <div class="d-flex gap-3">
                                <label for="exampleInputEmail1"
                                       class="form-label">Rental
                                    Type Name:
                                </label>
                                <div class="">
                                    <select class="form-select
                                                form-control-sm"
                                            aria-label="Default
                                                select example">
                                        <option selected>--
                                            RENTAL TYPE --</option>
                                        <option value="1">YEAR</option>
                                        <option value="2">MONTH</option>
                                        <option value="3">DAY</option>
                                        <option value="4">HOUR</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="mb-3 ">
                            <div class="d-flex gap-3">
                                <label for="exampleInputEmail1"
                                       class="form-label">Facility
                                    Type Name:
                                </label>
                                <div class="">
                                    <select class="form-select
                                                form-control-sm"
                                            aria-label="Default
                                                select example">
                                        <option selected>--
                                            FACILITY TYPE --</option>
                                        <option value="1">VILLA</option>
                                        <option value="2">HOUSE</option>
                                        <option value="3">ROOM</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="mb-3 ">
                            <div class="d-flex gap-3">
                                <label for="exampleInputEmail1"
                                       class="form-label">Pool
                                    Area: </label>
                                <div class="">
                                    <input type="text"
                                           class="form-control
                                                form-control-sm"
                                           value="">
                                </div>
                            </div>
                        </div>
                        <div class="">
                            <div class="d-flex gap-3">
                                <label for="exampleInputEmail1"
                                       class="form-label">Other
                                    Description:
                                </label>
                                <div class="">
                                    <input type="text"
                                           class="form-control
                                                form-control-sm"
                                           value="">
                                </div>
                            </div>

                        </div>
                    </form>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary"
                        data-bs-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="modalDelete" tabindex="-1"
     aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
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
                        data-bs-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">SUBMIT</button>
            </div>
        </div>
    </div>
</div>
<c:import url="/footer.jsp"></c:import>
</body>
</html>
