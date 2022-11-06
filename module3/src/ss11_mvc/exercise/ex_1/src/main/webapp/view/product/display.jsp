<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>HIỂN THỊ NÈ</title>
    <link rel="stylesheet"
          href="../../bootstrap-5.2.2-dist/css/bootstrap.css">
    <script src="../../bootstrap-5.2.2-dist/js/bootstrap.js"></script>
</head>
<body>
<div class="container">
    <h1 class="text-center">List nè</h1>
    <button type="button" class="btn btn-primary"
            data-bs-toggle="modal"
            data-bs-target="#add">
        Thêm mới
    </button>
    <div class="modal fade" id="add" tabindex="-1"
         aria-labelledby="exampleModalLabel" aria-hidden="true"
         data-bs-backdrop="static">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5">EDIT</h1>
                    <button type="button" class="btn-close"
                            data-bs-dismiss="modal"
                            aria-label="Close"></button>
                </div>
                <form action="/productServlet?action=add"
                      method="post">
                    <div class="modal-body">
                        <div class="container">
                            <div class="mb-3">
                                <div class="d-flex gap-3">
                                    <label for="addProductName"
                                           class="form-label">PRODUCT
                                        NAME: </label>
                                    <div>
                                        <input required
                                               type="text"
                                               id="addProductName"
                                               name="addProductName">
                                    </div>
                                </div>
                            </div>
                            <div class="mb-3">
                                <div class="d-flex gap-3">
                                    <label for="addProductPrice"
                                           class="form-label">PRODUCT
                                        PRICE: </label>
                                    <div>
                                        <input required
                                               id="addProductPrice"
                                               name="addProductPrice">
                                    </div>
                                </div>
                            </div>
                            <div class="mb-3">
                                <div class="d-flex gap-3">
                                    <label for="addProductDes"
                                           class="form-label">PRODUCT
                                        DESCRIPTION: </label>
                                    <div>
                                        <input required
                                               type="text"
                                               id="addProductDes"
                                               name="addProductDes">
                                    </div>
                                </div>
                            </div>
                            <div class="mb-3">
                                <div class="d-flex gap-3">
                                    <label
                                            for="addProductProducer"
                                            class="form-label">PRODUCT
                                        PRODUCER: </label>
                                    <div>
                                        <input required
                                               type="text"
                                               name="addProductProducer"
                                               id="addProductProducer">
                                    </div>
                                </div>
                            </div>

                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn
                                                btn-secondary"
                                    data-bs-dismiss="modal">Huỷ
                            </button>
                            <input type="submit" value="Xác nhận"
                                   class="btn btn-primary">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <table class="table">
        <thead>
        <tr>
            <th>
                #
            </th>
            <th>
                TÊN SẢN PHẨM
            </th>
            <th>
                GIÁ SẢN PHẨM
            </th>
            <th>DETAILS</th>
            <th>DELETE</th>
            <th>EDIT</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${products}"
                   varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${product.getName()}</td>
                <td>${product.getProductPrice()}</td>
                <td>
                    <button type="button" class="btn
                                            btn-success"
                            data-bs-toggle="modal"
                            data-bs-target="#showDetails${product.getId()}">DETAILS
                    </button>
                </td>
                <td>
                    <button type="button" class="btn
                                            btn-danger"
                            data-bs-toggle="modal"
                            data-bs-target="#deleteProduct${product.getId()}">
                        Delete
                    </button>
                </td>
                <td>
                    <button type="button" class="btn
                                            btn-success"
                            data-bs-toggle="modal"
                            data-bs-target="#editProduct${product.getId()}">
                        Edit
                    </button>
                </td>
            </tr>
            <div class="modal fade"
                 id="deleteProduct${product.getId()}"
                 tabindex="-1"
                 aria-labelledby="exampleModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5"
                                id="exampleModalLabel">CẢNH
                                BÁO</h1>
                            <button type="button"
                                    class="btn-close"
                                    data-bs-dismiss="modal"
                                    aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            XÁC NHẬN XOÁ ?
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn
                                                    btn-secondary"
                                    data-bs-dismiss="modal">KHÔNG
                            </button>
                            <a
                                    href="/productServlet?action=delete&productId=${product.getId()}"
                                    type="button"
                                    class="btn btn-primary">CÓ</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal fade"
                 id="editProduct${product.getId()}"
                 tabindex="-1"
                 aria-labelledby="exampleModalLabel"
                 aria-hidden="true"
                 data-bs-backdrop="static">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5">EDIT</h1>
                            <button type="button"
                                    class="btn-close"
                                    data-bs-dismiss="modal"
                                    aria-label="Close"></button>
                        </div>
                        <form
                                action="/productServlet?action=edit&productId=${product.getId()}"
                                method="post">
                            <div class="modal-body">
                                <div class="container">

                                    <div class="mb-3">
                                        <div class="d-flex
                                                                gap-3">
                                            <label
                                                    for="editProductName"
                                                    class="form-label">PRODUCT
                                                NAME:
                                            </label>
                                            <div>
                                                <input
                                                        value="${product.getName()}"
                                                        type="text"
                                                        id="editProductName"
                                                        name="productName">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="mb-3">
                                        <div class="d-flex
                                                                gap-3">
                                            <label
                                                    for="editProductPrice"
                                                    class="form-label">PRODUCT
                                                PRICE:
                                            </label>
                                            <div>
                                                <input
                                                        value="${product.getProductPrice()}"
                                                        id="editProductPrice"
                                                        name="productPrice">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="mb-3">
                                        <div class="d-flex
                                                                gap-3">
                                            <label
                                                    for="editProductDes"
                                                    class="form-label">PRODUCT
                                                DESCRIPTION:
                                            </label>
                                            <div>
                                                <input
                                                        value="${product.getDescription()}"
                                                        type="text"
                                                        id="editProductDes"
                                                        name="productDes">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="mb-3">
                                        <div class="d-flex
                                                                gap-3">
                                            <label
                                                    for="editProductProducer"
                                                    class="form-label">PRODUCT
                                                PRODUCER:
                                            </label>
                                            <div>
                                                <input
                                                        value="${product.getProducer()}"
                                                        type="text"
                                                        name="productProducer"
                                                        id="editProductProducer">
                                            </div>
                                        </div>
                                    </div>

                                </div>
                                <div class="modal-footer">
                                    <button type="button"
                                            class="btn
                                                            btn-secondary"
                                            data-bs-dismiss="modal">Huỷ
                                    </button>
                                    <input type="submit"
                                           value="Xác nhận"
                                           class="btn
                                                            btn-primary">
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="modal fade"
                 id="showDetails${product.getId()}"
                 tabindex="-1"
                 aria-labelledby="exampleModalLabel"
                 aria-hidden="true"
                 data-bs-backdrop="static">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5">DETAILS</h1>
                            <button type="button" class="btn
                                                    btn-success"
                                    data-bs-dismiss="modal"
                                    aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <div class="container">
                                <form>
                                    <div class="mb-3">
                                        <div class="d-flex
                                                                gap-3">
                                            <label
                                                    for="productName"
                                                    class="form-label">PRODUCT
                                                NAME:
                                            </label>
                                            <div>
                                                <b
                                                        id="productName">
                                                        ${product.getName()}
                                                </b>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="mb-3">
                                        <div class="d-flex
                                                                gap-3">
                                            <label
                                                    for="productPrice"
                                                    class="form-label">PRODUCT
                                                PRICE:
                                            </label>
                                            <div>
                                                <b
                                                        id="productPrice">
                                                        ${product.getProductPrice()}
                                                </b>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="mb-3">
                                        <div class="d-flex
                                                                gap-3">
                                            <label
                                                    for="productDes"
                                                    class="form-label">PRODUCT
                                                DESCRIPTION:
                                            </label>
                                            <div>
                                                <b
                                                        id="productDes">
                                                        ${product.getDescription()}
                                                </b>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="mb-3">
                                        <div class="d-flex
                                                                gap-3">
                                            <label
                                                    for="productProducer"
                                                    class="form-label">PRODUCT
                                                PRODUCER:
                                            </label>
                                            <div>
                                                <b
                                                        id="productProducer">
                                                        ${product.getProducer()}
                                                </b>
                                            </div>
                                        </div>
                                    </div>

                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button"
                                        class="btn
                                                        btn-secondary"
                                        data-bs-dismiss="modal">Close
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <%--            <div class="modal fade" id="deleteSucceeded" aria-hidden="true"--%>
            <%--                 aria-labelledby="exampleModalToggleLabel2" tabindex="-1" data-bs-backdrop="static">--%>
            <%--                <div class="modal-dialog modal-dialog-centered">--%>
            <%--                    <div class="modal-content">--%>
            <%--                        <div class="modal-header">--%>
            <%--                            <h1 class="modal-title fs-5" id="exampleModalToggleLabel2">THÔNG BÁO</h1>--%>
            <%--                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>--%>
            <%--                        </div>--%>
            <%--                        <div class="modal-body">--%>
            <%--                            XOÁ THÀNH CÔNG--%>
            <%--                        </div>--%>
            <%--                        <div class="modal-footer">--%>
            <%--                            <button href="/productServlet" type="button" class="btn btn-primary">--%>
            <%--                                OK--%>
            <%--                            </button>--%>
            <%--                        </div>--%>
            <%--                    </div>--%>
            <%--                </div>--%>
            <%--            </div>--%>

        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>