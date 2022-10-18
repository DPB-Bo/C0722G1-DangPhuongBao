USE quanlybanhang;

INSERT INTO `quanlybanhang`.`customer` (`cid`, `cname`, `cage`) VALUES ('1', 'Minh Quan', '10');
INSERT INTO `quanlybanhang`.`customer` (`cid`, `cname`, `cage`) VALUES ('2', 'Ngoc Oanh', '20');
INSERT INTO `quanlybanhang`.`customer` (`cid`, `cname`, `cage`) VALUES ('3', 'Hong Ha', '50');

INSERT INTO `quanlybanhang`.`orders` (`oid`, `cid`, `odate`, `ototalprice`) VALUES ('1', '1', '2006/3/21', NULL);
INSERT INTO `quanlybanhang`.`orders` (`oid`, `cid`, `odate`, `ototalprice`) VALUES ('2', '2', '2006/3/23', NULL);
INSERT INTO `quanlybanhang`.`orders` (`oid`, `cid`, `odate`, `ototalprice`) VALUES ('3', '1', '2006/3/16', NULL);

INSERT INTO `quanlybanhang`.`product` (`pid`, `pname`, `pprice`) VALUES ('1', 'May Giat', '3');
INSERT INTO `quanlybanhang`.`product` (`pid`, `pname`, `pprice`) VALUES ('2', 'Tu Lanh', '5');
INSERT INTO `quanlybanhang`.`product` (`pid`, `pname`, `pprice`) VALUES ('3', 'Dieu Hoa', '7');
INSERT INTO `quanlybanhang`.`product` (`pid`, `pname`, `pprice`) VALUES ('4', 'Quat', '1');
INSERT INTO `quanlybanhang`.`product` (`pid`, `pname`, `pprice`) VALUES ('5', 'Bep Dien', '2');

INSERT INTO `quanlybanhang`.`order_detail` (`oid`, `pid`, `odqty`) VALUES ('1', '1', '3');
INSERT INTO `quanlybanhang`.`order_detail` (`oid`, `pid`, `odqty`) VALUES ('1', '3', '7');
INSERT INTO `quanlybanhang`.`order_detail` (`oid`, `pid`, `odqty`) VALUES ('1', '4', '2');
INSERT INTO `quanlybanhang`.`order_detail` (`oid`, `pid`, `odqty`) VALUES ('2', '1', '1');
INSERT INTO `quanlybanhang`.`order_detail` (`oid`, `pid`, `odqty`) VALUES ('3', '1', '8');
INSERT INTO `quanlybanhang`.`order_detail` (`oid`, `pid`, `odqty`) VALUES ('2', '5', '4');
INSERT INTO `quanlybanhang`.`order_detail` (`oid`, `pid`, `odqty`) VALUES ('2', '3', '3');

-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
SELECT oid,odate,ototalprice
FROM orders;

-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
SELECT customer.cname, product.pname, COUNT(pname)
FROM customer
JOIN orders ON customer.cid = orders.cid
JOIN order_detail ON orders.oid = order_detail.oid
JOIN product ON product.pid = order_detail.pid
GROUP BY cname,pname;

-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
SELECT customer.cname
FROM customer
LEFT JOIN orders ON customer.cid = orders.cid
WHERE orders.cid IS NULL;

-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. Giá bán của từng loại được tính = odQTY*pPrice)
SELECT orders.oid,orders.odate, SUM(order_detail.odqty*product.pprice) AS tong_tien
FROM orders
JOIN order_detail ON order_detail.oid = orders.oid
JOIN product ON product.pid = order_detail.pid
GROUP BY oid