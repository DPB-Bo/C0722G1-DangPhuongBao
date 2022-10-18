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