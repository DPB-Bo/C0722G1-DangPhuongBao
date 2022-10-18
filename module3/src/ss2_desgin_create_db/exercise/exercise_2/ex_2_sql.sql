DROP DATABASE IF EXISTS quanlybanhang;

CREATE DATABASE quanlybanhang;

USE QuanLyBanHang;

CREATE TABLE customer(
cid INT AUTO_INCREMENT,
cname VARCHAR(45),
cage INT DEFAULT(18),
PRIMARY KEY(cid)
);

CREATE TABLE orders(
oid INT AUTO_INCREMENT,
cid INT NOT NULL,
odate DATE NOT NULL,
ototalprice INT,
PRIMARY KEY(oid),
FOREIGN KEY(cid) REFERENCES customer(cid)
);

CREATE TABLE product(
pid INT AUTO_INCREMENT,
pname VARCHAR(45) NOT NULL,
pprice INT NOT NULL,
PRIMARY KEY(pid)
);

CREATE TABLE order_detail(
oid INT NOT NULL,
pid INT NOT NULL,
odqty INT DEFAULT(1),
PRIMARY KEY(oid,pid),
FOREIGN KEY(oid) REFERENCES orders(oid),
FOREIGN KEY(pid) REFERENCES product(pid)
);