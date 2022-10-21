USE furama_db;

--- Task 2 ---
SELECT 
    *
FROM
    nhan_vien
WHERE
    ho_ten REGEXP ('^[HKT]')
        AND (CHAR_LENGTH(ho_ten) < 16);

--- Task 3 ---
SELECT 
    *
FROM
    khach_hang
WHERE
    (TIMESTAMPDIFF(YEAR, ngay_sinh, NOW()) BETWEEN 18 AND 50)
        AND dia_chi REGEXP ('(Quảng trị|Đà Nẵng)');

--- Task 4 ---
SELECT 
    khach_hang.ma_khach_hang,
    khach_hang.ho_ten,
    COUNT(hop_dong.ma_khach_hang) AS so_lan_dat_phong
FROM
    khach_hang
        INNER JOIN
    hop_dong ON hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
WHERE
    ma_loai_khach = 1
GROUP BY ma_khach_hang
ORDER BY so_lan_dat_phong ASC;

--- Task 5 ---
SELECT 
    khach_hang.ma_khach_hang,
    khach_hang.ho_ten,
    loai_khach.ten_loai_khach,
    hop_dong.ma_hop_dong,
    dich_vu.ten_dich_vu,
    hop_dong.ngay_lam_hop_dong,
    hop_dong.ngay_ket_thuc,
    dich_vu.chi_phi_thue,
    hop_dong_chi_tiet.so_luong,
    dich_vu_di_kem.gia,
    (IFNULL(dich_vu.chi_phi_thue, 0) + IFNULL(SUM(IFNULL(hop_dong_chi_tiet.so_luong, 0) * IFNULL(dich_vu_di_kem.gia, 0)),
            0)) AS tong_tien
FROM
    khach_hang
        INNER JOIN
    loai_khach ON loai_khach.ma_loai_khach = khach_hang.ma_loai_khach
        LEFT JOIN
    hop_dong ON khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
        LEFT JOIN
    hop_dong_chi_tiet ON hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
        LEFT JOIN
    dich_vu ON hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
        LEFT JOIN
    dich_vu_di_kem ON hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
GROUP BY ma_khach_hang , ma_hop_dong
ORDER BY ma_khach_hang ASC , ma_hop_dong DESC;

--- Task 6 ---
SELECT 
    dv.ma_dich_vu,
    dv.ten_dich_vu,
    dv.dien_tich,
    dv.chi_phi_thue,
    loai_dich_vu.ten_loai_dich_vu,
    hop_dong.ma_hop_dong,
    hop_dong.ngay_lam_hop_dong
FROM
    dich_vu dv
        JOIN
    loai_dich_vu ON loai_dich_vu.ma_loai_dich_vu = dv.ma_loai_dich_vu
        JOIN
    hop_dong ON dv.ma_dich_vu = hop_dong.ma_dich_vu
WHERE
    dv.ma_dich_vu NOT IN (SELECT 
            ma_dich_vu
        FROM
            hop_dong
        WHERE
            (MONTH(hop_dong.ngay_lam_hop_dong) IN (1 , 2, 3))
                AND (YEAR(hop_dong.ngay_lam_hop_dong) = 2021))
GROUP BY dv.ma_dich_vu;

--- Task 7 ---
SELECT 
    dv.ma_dich_vu,
    dv.ten_dich_vu,
    dv.dien_tich,
    dv.so_nguoi_toi_da,
    dv.chi_phi_thue,
    loai_dich_vu.ten_loai_dich_vu
FROM
    dich_vu dv
        JOIN
    loai_dich_vu ON loai_dich_vu.ma_loai_dich_vu = dv.ma_loai_dich_vu
        JOIN
    hop_dong ON dv.ma_dich_vu = hop_dong.ma_dich_vu
WHERE
    YEAR(hop_dong.ngay_lam_hop_dong) = 2020
        AND (dv.ma_dich_vu NOT IN (SELECT 
            ma_dich_vu
        FROM
            hop_dong
        WHERE
            YEAR(hop_dong.ngay_lam_hop_dong) = 2021))
GROUP BY dv.ma_dich_vu;

--- Task 8 ---

	--- Task 8 EX 1 ---
SELECT kh.ho_ten
FROM khach_hang kh
GROUP BY ho_ten;

	--- Task 8 EX 2 ---
SELECT kh.ho_ten
FROM khach_hang kh
UNION
SELECT kh.ho_ten
FROM khach_hang kh;

	--- Task 8 EX 3 ---
SELECT DISTINCT kh.ho_ten
FROM khach_hang kh;

--- Task 9 ---
SELECT 
    MONTH(hd.ngay_lam_hop_dong) AS thang,
    COUNT(hd.ngay_lam_hop_dong) AS so_luong_khach_hang
FROM
    hop_dong hd
        JOIN
    khach_hang kh ON kh.ma_khach_hang = hd.ma_khach_hang
WHERE
    YEAR(hd.ngay_lam_hop_dong) = 2021
GROUP BY thang
ORDER BY thang;

--- Task 10 ---
SELECT 
    hd.ma_hop_dong,
    hd.ngay_lam_hop_dong,
    hd.ngay_ket_thuc,
    hd.tien_dat_coc,
    SUM(hdct.so_luong) so_luong_dich_vu_di_kem
FROM
    hop_dong hd
        LEFT JOIN
    hop_dong_chi_tiet hdct ON hd.ma_hop_dong = hdct.ma_hop_dong
        LEFT JOIN
    dich_vu_di_kem dvdk ON dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
GROUP BY hd.ma_hop_dong
ORDER BY hd.ma_hop_dong;

--- Task 11 ---
SELECT 
    dvdk.ma_dich_vu_di_kem, dvdk.ten_dich_vu_di_kem
FROM
    dich_vu_di_kem dvdk
        JOIN
    hop_dong_chi_tiet hdct ON hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
        JOIN
    hop_dong hd ON hd.ma_hop_dong = hdct.ma_hop_dong
        JOIN
    khach_hang kh ON kh.ma_khach_hang = hd.ma_khach_hang
        JOIN
    loai_khach lk ON lk.ma_loai_khach = kh.ma_loai_khach
WHERE
    kh.dia_chi REGEXP ('(Vinh|Quảng Ngãi)')
        AND lk.ten_loai_khach REGEXP ('Diamond')
ORDER BY dvdk.ma_dich_vu_di_kem;

--- Task 12 ---
SELECT 
    hd.ma_hop_dong,
    nv.ho_ten AS ho_ten_nhan_vien,
    kh.ho_ten AS ho_ten_khach_hang,
    kh.so_dien_thoai,
    dv.ten_dich_vu,
    SUM(hdct.so_luong) AS so_luong_dich_vu_di_kem,
    SUM(hd.tien_dat_coc) tien_dat_coc,
    hd.ngay_lam_hop_dong
FROM
    khach_hang kh
        JOIN
    hop_dong hd ON hd.ma_khach_hang = kh.ma_khach_hang
        JOIN
    nhan_vien nv ON hd.ma_nhan_vien = nv.ma_nhan_vien
        JOIN
    dich_vu dv ON hd.ma_dich_vu = dv.ma_dich_vu
        LEFT JOIN
    hop_dong_chi_tiet hdct ON hdct.ma_hop_dong = hd.ma_hop_dong
        LEFT JOIN
    dich_vu_di_kem dvdk ON dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
GROUP BY ma_hop_dong
HAVING (YEAR(hd.ngay_lam_hop_dong) = 2020
    AND MONTH(hd.ngay_lam_hop_dong) IN (10 , 11, 12))
    AND NOT (YEAR(hd.ngay_lam_hop_dong) = 2021
    AND MONTH(hd.ngay_lam_hop_dong) IN (1 , 2, 3, 4, 5, 6))
ORDER BY hd.ma_hop_dong;

--- Task 13 ---
SELECT
	hdct.ma_dich_vu_di_kem,
    dvdk.ten_dich_vu_di_kem,
    sum(hdct.so_luong) AS so_luong_dich_vu_di_kem
FROM
	hop_dong_chi_tiet hdct JOIN dich_vu_di_kem dvdk ON hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
GROUP BY
	hdct.ma_dich_vu_di_kem, dvdk.ten_dich_vu_di_kem
HAVING 
	sum(hdct.so_luong) >= ALL ( -- Xét trên chính nó chỉ lấy bằng và lớn hơn -- 
		SELECT sum(hop_dong_chi_tiet.so_luong) 
        FROM hop_dong_chi_tiet
        GROUP BY hop_dong_chi_tiet.ma_dich_vu_di_kem
		);
        
--- Task 14 ---
SELECT 
    hd.ma_hop_dong,
    ldv.ten_loai_dich_vu,
    dvdk.ten_dich_vu_di_kem,
    COUNT(hdct.ma_dich_vu_di_kem)
FROM
    hop_dong hd
        JOIN
    dich_vu dv ON hd.ma_dich_vu = dv.ma_dich_vu
        JOIN
    loai_dich_vu ldv ON dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
        JOIN
    hop_dong_chi_tiet hdct ON hd.ma_hop_dong = hdct.ma_hop_dong
        JOIN
    dich_vu_di_kem dvdk ON dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
GROUP BY hdct.ma_dich_vu_di_kem
HAVING COUNT(hdct.ma_dich_vu_di_kem) = 1
ORDER BY hd.ma_hop_dong;

--- Task 15 ---
SELECT 
    nv.ma_nhan_vien,
    nv.ho_ten,
    td.ten_trinh_do,
    bp.ten_bo_phan,
    nv.so_dien_thoai,
    nv.dia_chi
FROM
    nhan_vien nv
        JOIN
    trinh_do td ON td.ma_trinh_do = nv.ma_trinh_do
        JOIN
    bo_phan bp ON bp.ma_bo_phan = nv.ma_bo_phan
        JOIN
    hop_dong hd ON hd.ma_nhan_vien = nv.ma_nhan_vien
GROUP BY nv.ma_nhan_vien
HAVING COUNT(hd.ma_nhan_vien) <= 3;


--- CÂU LỆNH ON/OFF SAFE MOD ---
SET SQL_SAFE_UPDATES = 0;
SET SQL_SAFE_UPDATES = 1;


--- Task 16 ---
--- Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021 ---
SET SQL_SAFE_UPDATES = 0;
DELETE FROM nhan_vien
WHERE ma_nhan_vien NOT IN (
SELECT hd.ma_nhan_vien
FROM hop_dong hd
GROUP BY hd.ma_nhan_vien
);
SET SQL_SAFE_UPDATES = 1;

--- Task 17 ---
---	Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum lên Diamond, chỉ cập nhật những khách hàng đã từng đặt phòng với Tổng Tiền thanh toán trong năm 2021 là lớn hơn 1.000.000 VNĐ ---
UPDATE khach_hang kh 
SET 
    kh.ma_loai_khach = 1
WHERE
    kh.ma_khach_hang IN (SELECT
    b.mkh
    FROM
    (SELECT 
            a.mkh mkh, SUM(a.tong_tien) tong
        FROM
            (SELECT 
                hop_dong.ma_khach_hang mkh,
                    (IFNULL(dich_vu.chi_phi_thue, 0) + IFNULL(SUM(IFNULL(hop_dong_chi_tiet.so_luong, 0) * IFNULL(dich_vu_di_kem.gia, 0)), 0)) AS tong_tien
            FROM
                hop_dong
            LEFT JOIN hop_dong_chi_tiet ON hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
            LEFT JOIN dich_vu ON hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
            LEFT JOIN dich_vu_di_kem ON hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
            LEFT JOIN khach_hang kh ON kh.ma_khach_hang = hop_dong.ma_khach_hang
            WHERE
                YEAR(hop_dong.ngay_lam_hop_dong) = 2021
            GROUP BY hop_dong.ma_hop_dong) a
                JOIN
            khach_hang kh ON a.mkh = kh.ma_khach_hang
        WHERE
            ma_loai_khach = 2
        GROUP BY mkh)b WHERE tong>1000000);
--- Task 18 ---
--- Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng). ---
DELETE FROM hop_dong , hop_dong_chi_tiet USING hop_dong
        JOIN
    hop_dong_chi_tiet 
WHERE
    YEAR(hop_dong.ngay_lam_hop_dong) < 2021
    AND hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong;
--- CÓ THỂ CHÈN CASADE VÀO KHOÁ PHỤ THÌ DELETE BÌNH THƯỜNG MÀ KHÔNG CẦN LÀM NHƯ TRÊN ---

--- Task 19 ---
---	Cập nhật giá cho các dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2020 lên gấp đôi ---
UPDATE dich_vu_di_kem dvdk 
SET 
    gia = gia * 2
WHERE
    dvdk.ma_dich_vu_di_kem = (SELECT 
            a.mdvdk
        FROM
            (SELECT 
                hdct.ma_dich_vu_di_kem mdvdk , SUM(hdct.so_luong) tsl
            FROM
                hop_dong hd
            JOIN hop_dong_chi_tiet hdct ON hd.ma_hop_dong = hdct.ma_hop_dong
            WHERE
                YEAR(hd.ngay_lam_hop_dong) = 2020
            GROUP BY ma_dich_vu_di_kem) a WHERE a.tsl >10);

--- Task 20 --- 
--- Hiển thị thông tin của tất cả các nhân viên và khách hàng có trong hệ thống, thông tin hiển thị bao gồm id (ma_nhan_vien, ma_khach_hang), ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi ---
SELECT nv.ma_nhan_vien id,nv.ho_ten,nv.email,nv.so_dien_thoai,nv.ngay_sinh,nv.dia_chi FROM nhan_vien nv
UNION
SELECT kh.ma_khach_hang,kh.ho_ten,kh.email,kh.so_dien_thoai,kh.ngay_sinh,kh.dia_chi FROM khach_hang kh;

--- Task 21 ---
--- Tạo khung nhìn có tên là v_nhan_vien để lấy được thông tin của tất cả các nhân viên có địa chỉ là “Hải Châu” và đã từng lập hợp đồng cho một hoặc nhiều khách hàng bất kì với ngày lập hợp đồng là “12/12/2019” ---
CREATE VIEW v_nhan_vien AS
SELECT * 