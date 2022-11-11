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
                    KHU NGHỈ DƯỠNG ĐẲNG CẤP THẾ GIỚI, FURAMA ĐÀ NẴNG,
                    NỔI TIẾNG LÀ KHU NGHỈ DƯỠNG ẨM THỰC TẠI VIỆT NAM.
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
                <p>Hướng ra bãi biển Đà Nẵng trải dài cát trắng, Furama
                    Resort Đà Nẵng là cửa ngõ đến với 3 di sản văn hoá
                    thế giới: Hội An (20 phút), Mỹ Sơn (90 phút) và Huế
                    (2 tiếng. 196 phòng hạng sang cùng với 70 căn biệt
                    thự từ hai đến bốn phòng ngủ có hồ bơi riêng đều
                    được trang trí trang nhã, theo phong cách thiết kế
                    truyền thống của Việt Nam và kiến trúc thuộc địa của
                    Pháp, biến Furama thành khu nghỉ dưỡng danh giá nhất
                    tại Việt Nam - vinh dự được đón tiếp nhiều người nổi
                    tiếng, giới hoàng gia, chính khách, ngôi sao điện
                    ảnh và các nhà lãnh đạo kinh doanh quốc tế.</p>
            </div>
        </div>
        <div class="row row-cols-3 mb-3 justify-content-center">
            <div class="col">
                <h3 class="text-center" style="color: #cbbe73;">CÁC LOẠI
                    PHÒNG</h3>
                <p>Khu nghỉ dưỡng có 196 phòng được thiết kế theo phong
                    cách truyền thống Việt Nam kết hợp với phong cách
                    Pháp, 2 tòa nhà 4 tầng có hướng nhìn ra biển, nhìn
                    ra hồ bơi trong xanh và những khu vườn nhiệt đới
                    xanh tươi mát. Ngoài ra, khu nghỉ dưỡng Furama còn
                    cung cấp các liệu pháp spa, phòng xông hơi ướt,
                    phòng xông hơi khô, dịch vụ mát-xa cạnh hồ bơi,
                    các dịch vụ thể thao dưới nước và các lớp tập
                    yoga và Thái Cực Quyền trên bãi biển.</p>
            </div>
        </div>
    </div>
</div>
<c:import url="/footer.jsp"></c:import>
</body>
</html>