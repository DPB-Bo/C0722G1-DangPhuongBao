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
SET SQL_SAFE_UPDATES = 0;
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
SET SQL_SAFE_UPDATES = 1;

--- Task 20 --- 
--- Hiển thị thông tin của tất cả các nhân viên và khách hàng có trong hệ thống, thông tin hiển thị bao gồm id (ma_nhan_vien, ma_khach_hang), ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi ---
SELECT nv.ma_nhan_vien id,nv.ho_ten,nv.email,nv.so_dien_thoai,nv.ngay_sinh,nv.dia_chi FROM nhan_vien nv
UNION
SELECT kh.ma_khach_hang,kh.ho_ten,kh.email,kh.so_dien_thoai,kh.ngay_sinh,kh.dia_chi FROM khach_hang kh;

--- Task 21 ---
--- Tạo khung nhìn có tên là v_nhan_vien để lấy được thông tin của tất cả các nhân viên có địa chỉ là “Đà Nẵng” và đã từng lập hợp đồng cho một hoặc nhiều khách hàng bất kì với tháng lập hợp đồng là 4 ---
CREATE OR REPLACE VIEW v_nhan_vien AS
    SELECT 
        nv.*
    FROM
        nhan_vien nv
            JOIN
        hop_dong hd ON hd.ma_nhan_vien = nv.ma_nhan_vien
    WHERE
        nv.dia_chi REGEXP ('Đà Nẵng')
            AND MONTH(ngay_lam_hop_dong) = 4
    GROUP BY nv.ma_nhan_vien;
    
--- Task 22 ---
--- Thông qua khung nhìn v_nhan_vien thực hiện cập nhật địa chỉ thành “Liên Chiểu” đối với tất cả các nhân viên được nhìn thấy bởi khung nhìn này. ---
UPDATE nhan_vien
SET 
    dia_chi = 'Liên Chiểu'
WHERE
    ma_nhan_vien IN (SELECT 
            ma_nhan_vien
        FROM
            v_nhan_vien);

--- Task 23 ---
---	Tạo Stored Procedure sp_xoa_khach_hang dùng để xóa thông tin của một khách hàng nào đó với ma_khach_hang được truyền vào như là 1 tham số của sp_xoa_khach_hang ---
DELIMITER // 
CREATE PROCEDURE sp_xoa_khach_hang (
IN kh_id INT)
BEGIN
DELETE FROM khach_hang kh
WHERE kh.ma_khach_hang = kh_id;
END //
DELIMITER ;
;

SET SQL_SAFE_UPDATES = 1;

SELECT * FROM hop_dong;
--- Task 24 ---
--- Tạo Stored Procedure sp_them_moi_hop_dong dùng để thêm mới vào bảng hop_dong với yêu cầu sp_them_moi_hop_dong phải thực hiện kiểm tra tính hợp lệ của dữ liệu bổ sung, với nguyên tắc không được trùng khóa chính và đảm bảo toàn vẹn tham chiếu đến các bảng liên quan. ---
DROP PROCEDURE IF EXISTS sp_them_moi_hop_dong;
DELIMITER // 
CREATE PROCEDURE sp_them_moi_hop_dong(
IN hd_id INT,
IN hd_nlhd DATE,
IN hd_nkt DATE,
IN hd_tdc INT,
IN hd_mnv INT,
IN hd_mkh INT,
IN hd_mdv INT
)
BEGIN
	-- CHỈ MỚI KIỂM TRA CÁC KHOÁ, CHƯA KIỂM TRA TÍNH ĐÚNG ĐẮN CỦA CÁC TRƯỜNG KHÁC @@!
	IF EXISTS (SELECT * FROM v_ma_hop_dong WHERE ma_hop_dong = hd_id) THEN 
    INSERT INTO error_log (el_log,el_date) VALUE ('ma hop dong da ton tai',NOW());
    ELSEIF NOT EXISTS(SELECT * FROM v_ma_nhan_vien WHERE ma_nhan_vien = hd_mnv) THEN 
    INSERT INTO error_log (el_log,el_date) VALUE ('khong tim thay ma nhan vien',NOW());
    ELSEIF NOT EXISTS(SELECT * FROM v_ma_khach_hang WHERE ma_khach_hang = hd_mkh) THEN
    INSERT INTO error_log (el_log,el_date) VALUE ('khong tim thay ma khach hang',NOW());
    ELSE
    INSERT INTO hop_dong (ma_hop_dong,ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc,ma_nhan_vien,ma_khach_hang,ma_dich_vu) VALUE(hd_id,hd_nlhd,hd_nkt,hd_tdc,hd_mnv,hd_mkh,hd_mdv);
    INSERT INTO history_detail (his_log,his_date) VALUE(CONCAT('Thêm mới thành công hợp đồng có mã ',hd_id),NOW());
    END IF;
END //
DELIMITER ;
;

CREATE VIEW v_ma_hop_dong AS
SELECT hd.ma_hop_dong
FROM hop_dong hd;

CREATE VIEW v_ma_nhan_vien AS
SELECT nv.ma_nhan_vien
FROM nhan_vien nv;

CREATE VIEW v_ma_khach_hang AS
SELECT kh.ma_khach_hang
FROM khach_hang kh;

CALL sp_them_moi_hop_dong(13,'1999-06-15','1999-06-15',0,1,1,1); --- THỬ THÊM LỖI

--- TASK 25 ---
-- Tạo Trigger có tên tr_xoa_hop_dong khi xóa bản ghi trong bảng hop_dong thì hiển thị tổng số lượng bản ghi còn lại có trong bảng hop_dong ra giao diện console của database --
DROP TRIGGER IF EXISTS tr_xoa_hop_dong;
DELIMITER //
CREATE TRIGGER tr_xoa_hop_dong AFTER DELETE ON hop_dong FOR EACH ROW
BEGIN
INSERT INTO history_detail (his_log,his_date) VALUE(CONCAT('Số lượng hợp đồng còn lại sau khi xoá là ',(SELECT count(ma_hop_dong) FROM hop_dong)),NOW());
END //
DELIMITER ;
;

--- TASK 26 ---
-- Tạo Trigger có tên tr_cap_nhat_hop_dong khi cập nhật ngày kết thúc hợp đồng, cần kiểm tra xem thời gian cập nhật có phù hợp hay không, ---
-- với quy tắc sau: Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày. Nếu dữ liệu hợp lệ thì cho phép cập nhật
-- nếu dữ liệu không hợp lệ thì in ra thông báo “Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày” trên console của database
DROP TRIGGER IF EXISTS tr_cap_nhat_hop_dong;
DELIMITER //
CREATE TRIGGER tr_cap_nhat_hop_dong BEFORE UPDATE ON hop_dong FOR EACH ROW
BEGIN
IF TIMESTAMPDIFF(DATE,OLD.ngay_lam_hop_dong,NEW.ngay_ket_thuc) <2 THEN
INSERT INTO error_log (el_log,el_date) VALUE ('Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày',NOW());
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày';
END IF;
END //
DELIMITER ;
;

--- TASK 27 ---
-- Tạo Function thực hiện yêu cầu sau:
-- 1. Tạo Function func_dem_dich_vu: Đếm các dịch vụ đã được sử dụng với tổng tiền là > 2.000.000 VNĐ
-- 2. Tạo Function func_tinh_thoi_gian_hop_dong: Tính khoảng thời gian dài nhất tính từ lúc bắt đầu làm hợp đồng đến lúc kết thúc hợp đồng mà khách hàng đã thực hiện thuê dịch vụ 
-- (lưu ý chỉ xét các khoảng thời gian dựa vào từng lần làm hợp đồng thuê dịch vụ, không xét trên toàn bộ các lần làm hợp đồng). Mã của khách hàng được truyền vào như là 1 tham số của function này
CREATE OR REPLACE VIEW v_tong_tien AS
    SELECT 
        hop_dong.ma_hop_dong mhd,
        (IFNULL(dich_vu.chi_phi_thue, 0) + IFNULL(SUM(IFNULL(hop_dong_chi_tiet.so_luong, 0) * IFNULL(dich_vu_di_kem.gia, 0)),
                0)) AS tong_tien
    FROM
        hop_dong
            LEFT JOIN
        hop_dong_chi_tiet ON hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
            LEFT JOIN
        dich_vu ON hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
            LEFT JOIN
        dich_vu_di_kem ON hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
    GROUP BY hop_dong.ma_hop_dong
;

CREATE OR REPLACE VIEW v_hop_dong_co_dich_vu_di_kem AS
    SELECT 
        hop_dong.ma_hop_dong mhd,
        khach_hang.ma_khach_hang mkh,
        hop_dong.ngay_lam_hop_dong nlhd,
        hop_dong.ngay_ket_thuc nkt
    FROM
        hop_dong
            JOIN
        hop_dong_chi_tiet ON hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
            JOIN
            khach_hang ON hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
    GROUP BY hop_dong.ma_hop_dong
;

SELECT * FROM v_tong_tien;
SELECT * FROM v_hop_dong_co_dich_vu_di_kem;

DROP FUNCTION IF EXISTS func_dem_dich_vu;
DELIMITER //
CREATE FUNCTION func_dem_dich_vu ()
RETURNS INT
DETERMINISTIC
READS SQL DATA
BEGIN
DECLARE count_sl INT DEFAULT 0;
SET count_sl = (SELECT count(mhd) FROM v_tong_tien WHERE tong_tien >2000000);
RETURN count_sl;
END //
DELIMITER ; 
;

SELECT func_dem_dich_vu() AS dem_tong_tien;

DROP FUNCTION IF EXISTS func_tinh_thoi_gian_hop_dong;
DELIMITER //
CREATE FUNCTION func_tinh_thoi_gian_hop_dong (ma_kh INT)
RETURNS INT
DETERMINISTIC
READS SQL DATA
BEGIN
DECLARE start_date DATE;
DECLARE end_date DATE;
DECLARE result INT;
IF NOT EXISTS (SELECT mkh FROM v_hop_dong_co_dich_vu_di_kem WHERE mkh=ma_kh) THEN
INSERT INTO error_log (el_log,el_date) VALUE ('ma_hop_dong_khong_hop_le',NOW());
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'KHÔNG TỒN TẠI MÃ HỢP ĐỒNG';
RETURN -1;
END IF;
SET start_date = (SELECT nlhd FROM v_hop_dong_co_dich_vu_di_kem WHERE mkh=ma_kh);
SET end_date = (SELECT nkt FROM v_hop_dong_co_dich_vu_di_kem WHERE mkh=ma_kh) ;
SET result = DATEDIFF(end_date,start_date);
RETURN result;
END //
DELIMITER ;

SELECT func_tinh_thoi_gian_hop_dong(3);

--- TASK 28 ---
--- Tạo Stored Procedure sp_xoa_dich_vu_va_hd_room để tìm các dịch vụ được thuê bởi khách hàng với loại dịch vụ là “Room” từ đầu năm 2015 đến hết năm 2019 để xóa thông tin của các dịch vụ đó 
--- (tức là xóa các bảng ghi trong bảng dich_vu) và xóa những hop_dong sử dụng dịch vụ liên quan (tức là phải xóa những bản gi trong bảng hop_dong) và những bản liên quan khác

-- SỬ DỤNG DELETE ON CASADE SẼ DỄ HƠNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN RẤT NHIỀUUUUUUUUUUUUUUUUUUUUUUUUUUU BUT IDGAF

-- THÊM CỘT IS_DEL ĐỂ THAY ĐỔI VALUE KHI "XOÁ" 
UPDATE dich_vu dv
SET is_del = 1
WHERE dv.ma_loai_dich_vu = 3 AND dv.ma_dich_vu IN (SELECT dv.ma_dv FROM dich_vu dv JOIN hop_dong hd ON dv.ma_dich_vu = hd.ma_dich_vu WHERE YEAR(hd.ngay_lam_hop_dong) IN (2015,2016,2017,2018,2019));