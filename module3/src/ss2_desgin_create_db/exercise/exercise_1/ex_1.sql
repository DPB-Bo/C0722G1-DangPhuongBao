DROP DATABASE IF EXISTS ss1_ex1;

CREATE DATABASE ss1_ex1;

USE ss1_ex1;

CREATE TABLE phieu_xuat(
so_px INT AUTO_INCREMENT,
ngay_xuat DATE NOT NULL,
PRIMARY KEY(so_px)
);

CREATE TABLE vat_tu(
ma_vtu INT AUTO_INCREMENT,
ten_vtu VARCHAR(50) NOT NULL,
PRIMARY KEY(ma_vtu)
);

CREATE TABLE chi_tiet_phieu_xuat(
ma_vtu INT,
so_px INT,
dg_xuat INT NOT NULL,
sl_xuat INT NOT NULL DEFAULT(1),
PRIMARY KEY(ma_vtu,so_px),
FOREIGN KEY(ma_vtu) REFERENCES vat_tu(ma_vtu),
FOREIGN KEY(so_px) REFERENCES phieu_xuat(so_px)
);

CREATE TABLE phieu_nhap(
so_pn INT AUTO_INCREMENT,
ngay_nhap DATE NOT NULL,
PRIMARY KEY(so_pn)
);

CREATE TABLE chi_tiet_phieu_nhap(
so_pn INT,
ma_vtu INT,
dg_nhap INT NOT NULL,
sl_nhap INT NOT NULL DEFAULT(1),
PRIMARY KEY(so_pn,ma_vtu),
FOREIGN KEY(so_pn) REFERENCES phieu_nhap(so_pn),
FOREIGN KEY(ma_vtu) REFERENCES vat_tu(ma_vtu)
);


CREATE TABLE nhacc(
ma_ncc INT AUTO_INCREMENT,
ten_ncc VARCHAR(50) NOT NULL,
dia_chi VARCHAR(50) NOT NULL,
PRIMARY KEY(ma_ncc)
);

CREATE TABLE sdt_ncc(
ma_ncc INT,
sdt_ncc VARCHAR(12) NOT NULL,
PRIMARY KEY(sdt_ncc),
FOREIGN KEY(ma_ncc) REFERENCES nhacc(ma_ncc)
);

CREATE TABLE don_dh(
so_dh INT AUTO_INCREMENT,
ngay_dh DATE NOT NULL,
ma_ncc INT,
PRIMARY KEY(so_dh),
FOREIGN KEY(ma_ncc) REFERENCES nhacc(ma_ncc)
);

CREATE TABLE chi_tiet_don_dh(
so_dh INT,
ma_vtu INT,
PRIMARY KEY(so_dh,ma_vtu),
FOREIGN KEY(so_dh) REFERENCES don_dh(so_dh),
FOREIGN KEY(ma_vtu) REFERENCES vat_tu(ma_vtu)
);