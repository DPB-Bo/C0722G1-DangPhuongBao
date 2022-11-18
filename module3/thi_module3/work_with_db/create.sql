DROP DATABASE IF EXISTS quanlybenhnhan_db;
CREATE DATABASE quanlybenhnhan_db;
USE quanlybenhnhan_db;

CREATE TABLE benhan(
benhan_id VARCHAR(10) PRIMARY KEY,
benhan_ten VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE benhnhan (
benhnhan_id VARCHAR(10) PRIMARY KEY,
benhan_id VARCHAR(10) NOT NULL,
benhnhan_ten VARCHAR(45) NOT NULL,
ngay_nhap_vien DATE NOT NULL,
ngay_ra_vien DATE NOT NULL,
ly_do VARCHAR(255) NOT NULL,
is_delete BIT(1) DEFAULT(0),
FOREIGN KEY (benhan_id)
        REFERENCES benhan (benhan_id)
);

INSERT INTO `quanlybenhnhan_db`.`benhan` (`benhan_id`, `benhan_ten`) VALUES ('BA-001', 'Bệnh án 1');
INSERT INTO `quanlybenhnhan_db`.`benhan` (`benhan_id`, `benhan_ten`) VALUES ('BA-002', 'Bệnh án 2');
INSERT INTO `quanlybenhnhan_db`.`benhnhan` (`benhnhan_id`, `benhan_id`, `benhnhan_ten`, `ngay_nhap_vien`, `ngay_ra_vien`, `ly_do`, `is_delete`) VALUES ('BN-001', 'BA-001', 'benh nhan mot', '2016-08-07', '2016-08-09', 'tai nan', b'0');

SELECT * FROM benhnhan JOIN benhan ON benhnhan.benhan_id = benhan.benhan_id WHERE is_delete = 0;
SELECT * FROM benhan