DROP DATABASE IF EXISTS furama_db;

--- Tạo cơ sở dữ liệu furama ---
CREATE DATABASE furama_db;

USE furama_db;

--- Tạo bảng vị tri ---
CREATE TABLE vi_tri(
ma_vi_tri INT AUTO_INCREMENT,
ten_vi_tri VARCHAR(45) NOT NULL,
PRIMARY KEY(ma_vi_tri)
);

--- Tạo bảng trình độ ---
CREATE TABLE trinh_do(
ma_trinh_do INT AUTO_INCREMENT,
ten_trinh_do VARCHAR(45) NOT NULL,
PRIMARY KEY(ma_trinh_do)
);

--- Tạo bảng bộ phận ---
CREATE TABLE bo_phan(
ma_bo_phan INT AUTO_INCREMENT,
ten_bo_phan VARCHAR(45) NOT NULL,
PRIMARY KEY(ma_bo_phan)
);

--- Tạo bảng nhân viên ---
CREATE TABLE nhan_vien(
ma_nhan_vien INT AUTO_INCREMENT,
ho_ten VARCHAR(45) NOT NULL,
ngay_sinh DATE DEFAULT(1999-06-15),
so_cmnd VARCHAR(45) UNIQUE NOT NULL,
luong DOUBLE DEFAULT(0),
so_dien_thoai VARCHAR(45) DEFAULT("(chưa có)"),
email VARCHAR(45) UNIQUE NOT NULL,
dia_chi VARCHAR(45) DEFAULT("(chưa có)"),
ma_vi_tri INT NOT NULL,
ma_trinh_do INT NOT NULL,
ma_bo_phan INT NOT NULL,
is_del BIT(1) DEFAULT 0,
PRIMARY KEY(ma_nhan_vien),
FOREIGN KEY(ma_vi_tri) REFERENCES vi_tri(ma_vi_tri),
FOREIGN KEY(ma_trinh_do) REFERENCES trinh_do(ma_trinh_do),
FOREIGN KEY(ma_bo_phan) REFERENCES bo_phan(ma_bo_phan)
);

--- Tạo bảng loại khách --- 
CREATE TABLE loai_khach(
ma_loai_khach INT AUTO_INCREMENT,
ten_loai_khach VARCHAR(45) NOT NULL,
PRIMARY KEY(ma_loai_khach)
);

--- Tạo khách hàng ---
CREATE TABLE khach_hang(
ma_khach_hang INT AUTO_INCREMENT,
ma_loai_khach INT NOT NULL,
ho_ten VARCHAR(45) NOT NULL,
ngay_sinh DATE DEFAULT(1999-06-15),
gioi_tinh BIT(1) DEFAULT(1),
so_cmnd VARCHAR(45) UNIQUE NOT NULL,
so_dien_thoai VARCHAR(45) DEFAULT("(chưa có)"),
email VARCHAR(45) UNIQUE NOT NULL,
dia_chi VARCHAR(45),
is_del BIT(1) DEFAULT 0,
PRIMARY KEY (ma_khach_hang),
FOREIGN KEY(ma_loai_khach) REFERENCES loai_khach(ma_loai_khach)
);

--- Tạo loại dịch vụ ---
CREATE TABLE loai_dich_vu(
ma_loai_dich_vu INT AUTO_INCREMENT,
ten_loai_dich_vu VARCHAR(45) NOT NULL,
PRIMARY KEY(ma_loai_dich_vu)
);

--- Tạo kiểu thuế ---
CREATE TABLE kieu_thue(
ma_kieu_thue INT AUTO_INCREMENT,
ten_kieu_thue VARCHAR(45) NOT NULL,
PRIMARY KEY(ma_kieu_thue)
);

--- Tạo dịch vụ ---
CREATE TABLE dich_vu(
ma_dich_vu INT AUTO_INCREMENT,
ten_dich_vu VARCHAR(45) NOT NULL,
dien_tich INT NOT NULL,
chi_phi_thue DOUBLE NOT NULL,
so_nguoi_toi_da INT DEFAULT(1),
ma_kieu_thue INT NOT NULL,
ma_loai_dich_vu INT NOT NULL,
tieu_chuan_phong VARCHAR(45) DEFAULT("(Phòng thường)"),
mo_ta_tien_nghi_khac VARCHAR(45) DEFAULT("(Chưa có)"),
dien_tich_ho_boi DOUBLE DEFAULT(0),
so_tang INT DEFAULT(1),
dich_vu_mien_phi_di_kem TEXT DEFAULT("(Không có)"),
is_del BIT(1) DEFAULT 0,
PRIMARY KEY(ma_dich_vu),
FOREIGN KEY(ma_kieu_thue) REFERENCES kieu_thue(ma_kieu_thue),
FOREIGN KEY(ma_loai_dich_vu) REFERENCES loai_dich_vu(ma_loai_dich_vu)
);

--- Tạo bảng dịch vụ đi kèm ---
CREATE TABLE dich_vu_di_kem(
ma_dich_vu_di_kem INT AUTO_INCREMENT,
ten_dich_vu_di_kem VARCHAR(45) NOT NULL,
gia DOUBLE NOT NULL,
don_vi VARCHAR(10) NOT NULL,
trang_thai VARCHAR(45),
PRIMARY KEY(ma_dich_vu_di_kem)
);

--- Tạo bảng hợp đồng ---
CREATE TABLE hop_dong(
ma_hop_dong INT AUTO_INCREMENT,
ngay_lam_hop_dong DATETIME NOT NULL,
ngay_ket_thuc DATETIME NOT NULL,
tien_dat_coc DOUBLE DEFAULT(0),
ma_nhan_vien INT NOT NULL,
ma_khach_hang INT NOT NULL,
ma_dich_vu INT NOT NULL,
is_del BIT(1) DEFAULT 0,
PRIMARY KEY(ma_hop_dong),
FOREIGN KEY(ma_nhan_vien) REFERENCES nhan_vien(ma_nhan_vien),
FOREIGN KEY(ma_khach_hang) REFERENCES khach_hang(ma_khach_hang),
FOREIGN KEY(ma_dich_vu) REFERENCES dich_vu(ma_dich_vu)
);

--- Tạo bảng hợp đồng chi tiết ---
CREATE TABLE hop_dong_chi_tiet(
ma_hop_dong_chi_tiet INT AUTO_INCREMENT,
ma_hop_dong INT NOT NULL,
ma_dich_vu_di_kem INT NOT NULL,
so_luong INT NOT NULL,
is_del BIT(1) DEFAULT 0,
PRIMARY KEY(ma_hop_dong_chi_tiet),
FOREIGN KEY(ma_hop_dong) REFERENCES hop_dong(ma_hop_dong),
FOREIGN KEY(ma_dich_vu_di_kem) REFERENCES dich_vu_di_kem(ma_dich_vu_di_kem)
);

--- Tạo bảng chứa Error Log ---
CREATE TABLE error_log(
el_id INT AUTO_INCREMENT PRIMARY KEY,
el_log VARCHAR(100),
el_date DATE NOT NULL
);

--- Tạo bảng history_detail chứa Success Action detail ---
CREATE TABLE history_detail(
his_id INT AUTO_INCREMENT PRIMARY KEY,
his_log VARCHAR(100) NOT NULL,
his_date DATE NOT NULL 
-- Muốn tạo thêm 2 cột chứa mã người thực hiện và role của người thực hiện
)