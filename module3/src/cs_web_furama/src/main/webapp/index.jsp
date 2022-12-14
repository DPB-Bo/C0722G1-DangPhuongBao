<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FURAMA HOME PAGE</title>
    <link
            href="/bootstrap-5.2.2-dist/css/bootstrap.css"
            rel="stylesheet">
    <script
            src="/bootstrap-5.2.2-dist/js/bootstrap.js"></script>

</head>
<body>
<c:import url="header.jsp"></c:import>


<div class="container-fluid" style="padding: 0;">
    <div id="carouselExampleCaptions" class="carousel slide"
         data-bs-ride="false">
        <div class="carousel-indicators">
            <button type="button"
                    data-bs-target="#carouselExampleCaptions"
                    data-bs-slide-to="0" class="active" aria-current="true"
                    aria-label="Slide 1"></button>
            <button type="button"
                    data-bs-target="#carouselExampleCaptions"
                    data-bs-slide-to="1" aria-label="Slide 2"></button>
            <button type="button"
                    data-bs-target="#carouselExampleCaptions"
                    data-bs-slide-to="2" aria-label="Slide 3"></button>
        </div>
        <div class="carousel-inner ">
            <div class="carousel-item active">
                <img
                        src="https://furamavietnam.com/wp-content/uploads/2018/07/Vietnam_Danang_Furama_Resort_Exterior_Courtyard.jpg"
                        style="max-height: 520px;" class="d-block w-100
                            h-100" alt="...">
            </div>
            <div class="carousel-item">
                <img
                        src="https://furamavietnam.com/wp-content/uploads/2019/07/Vietnam_Danang_Furama_Resort_Exterior_Ocean-Pool-6.jpg"
                        style="max-height: 520px;" class="d-block w-100"
                        alt="...">
            </div>
            <div class="carousel-item">
                <img
                        src="https://furamavietnam.com/wp-content/uploads/2018/07/Vietnam_Danang_Furama_Resort_Exterior-Furama-girl-with-pink-hat.jpg"
                        style="max-height: 520px;" class="d-block w-100"
                        alt="...">
            </div>
        </div>
        <button class="carousel-control-prev" type="button"
                data-bs-target="#carouselExampleCaptions"
                data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button"
                data-bs-target="#carouselExampleCaptions"
                data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>
</div>
<div class="container mt-4 content">
    <div class="container-fluid" style="font-family: Playfair;">
        <div class="row row-cols-3 mb-5">
            <div class="col">
                <p class="h3" style=" color:
                            #cbbe73;">
                    KHU NGH??? D?????NG ?????NG C???P TH??? GI???I, FURAMA ???? N???NG,
                    N???I TI???NG L?? KHU NGH??? D?????NG ???M TH???C T???I VI???T NAM.
                </p>
            </div>
            <div class="col">
                <a href="https://www.youtube.com/watch?v=IjlT_4mvd-c">
                    <img style="max-width: 100%; max-height: 520px;"
                         src="https://furamavietnam.com/wp-content/uploads/2018/07/Vietnam_Danang_Furama_Resort_Exterior_Beach.jpg"
                         alt="">
                </a>
            </div>
            <div class="col">
                <p>H?????ng ra b??i bi???n ???? N???ng tr???i d??i c??t tr???ng, Furama
                    Resort ???? N???ng l?? c???a ng?? ?????n v???i 3 di s???n v??n ho??
                    th??? gi???i: H???i An (20 ph??t), M??? S??n (90 ph??t) v?? Hu???
                    (2 ti???ng. 196 ph??ng h???ng sang c??ng v???i 70 c??n bi???t
                    th??? t??? hai ?????n b???n ph??ng ng??? c?? h??? b??i ri??ng ?????u
                    ???????c trang tr?? trang nh??, theo phong c??ch thi???t k???
                    truy???n th???ng c???a Vi???t Nam v?? ki???n tr??c thu???c ?????a c???a
                    Ph??p, bi???n Furama th??nh khu ngh??? d?????ng danh gi?? nh???t
                    t???i Vi???t Nam - vinh d??? ???????c ????n ti???p nhi???u ng?????i n???i
                    ti???ng, gi???i ho??ng gia, ch??nh kh??ch, ng??i sao ??i???n
                    ???nh v?? c??c nh?? l??nh ?????o kinh doanh qu???c t???.</p>
            </div>
        </div>
        <div class="row row-cols-3 mb-3 justify-content-center">
            <div class="col">
                <h3 class="text-center" style="color: #cbbe73;">C??C LO???I
                    PH??NG</h3>
                <p>Khu ngh??? d?????ng c?? 196 ph??ng ???????c thi???t k??? theo phong
                    c??ch truy???n th???ng Vi???t Nam k???t h???p v???i phong c??ch
                    Ph??p, 2 t??a nh?? 4 t???ng c?? h?????ng nh??n ra bi???n, nh??n
                    ra h??? b??i trong xanh v?? nh???ng khu v?????n nhi???t ?????i
                    xanh t????i m??t. Ngo??i ra, khu ngh??? d?????ng Furama c??n
                    cung c???p ca??c li????u ph??p spa, ph??ng x??ng h??i ??????t,
                    ph??ng x??ng h??i kh??, di??ch vu?? ma??t-xa ca??nh h???? b??i,
                    c??c d???ch v??? th??? thao d?????i n?????c v?? ca??c l????p t????p
                    yoga v?? Tha??i C????c Quy????n tr??n b??i bi???n.</p>
            </div>
        </div>
    </div>
</div>
<c:import url="/footer.jsp"></c:import>
</body>
</html>