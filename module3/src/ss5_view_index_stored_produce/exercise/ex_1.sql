DROP DATABASE IF EXISTS ss5_ex_db;

CREATE DATABASE ss5_ex_db;

CREATE TABLE products(
id INT PRIMARY KEY,
product_code VARCHAR(50) NOT NULL UNIQUE,
product_name VARCHAR(50) NOT NULL,
product_price INT NOT NULL,
product_amount INT DEFAULT(1),
product_des TEXT DEFAULT('không có'),
product_status BOOLEAN DEFAULT(FALSE)
);

INSERT INTO products
-- (id,product_code,product_name,product_price,product_amount,product_des,product_status)
(id,product_code,product_name,product_price,product_amount)
VALUES
(1,'XE01','Xe dap',100,1),
(2,'XE02','Xe dap dien',150,1),
(3,'XE03','Xe may',300,1),
(4,'XE04','Xe cau',1500,1),
(5,'XE05','Oto',3000,1),
(6,'XE06','Xe tai',3000,1),
(7,'XE07','Xe ui',2000,1),
(8,'XE08','Xe bo',1000,1);

--- STEP 3 ---
CREATE INDEX i_code ON products(product_code);

ALTER TABLE products ADD INDEX i_name_price(product_name,product_price);

EXPLAIN SELECT * FROM products WHERE product_code=1;

EXPLAIN SELECT * FROM products WHERE product_name='xe dap';

--- STEP 4 ---
CREATE VIEW w_product AS
    SELECT 
        p.product_code,
        p.product_name,
        p.product_price,
        p.product_status
    FROM
        products p;

SELECT 
    *
FROM
    w_product;
    
CREATE OR REPLACE VIEW w_product AS
    SELECT 
        p.product_code,
        p.product_name,
        p.product_price,
        p.product_status
    FROM
        products p;
        
DROP VIEW w_product;

--- STEP 5 ---
DELIMITER //
CREATE PROCEDURE getProductInfor()
BEGIN
SELECT * FROM products;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE addProduct(
IN p_id INT,
IN p_code VARCHAR(50),
IN p_name VARCHAR(50),
IN p_price INT
)
BEGIN
INSERT INTO products
(id,product_code,product_name,product_price)
VALUE(p_id,p_code,p_name,p_price);
END //
DELIMITER ;

DROP PROCEDURE addProduct;
CALL addProduct(9,'XE09','Xe so 9','123');

DELIMITER //
CREATE PROCEDURE editById(
IN p_id INT,
IN p_name VARCHAR(50),
IN p_price INT
)
BEGIN
UPDATE products p
SET p.product_name = p_name, p.product_price = p_price
WHERE p.id = p_id;
END //
DELIMITER ;

CALL editById(9,'xe da sua','456');

DELIMITER //
CREATE PROCEDURE deleteById(
IN p_id INT
)
BEGIN
DELETE FROM products p WHERE p.id=p_id;
END //
DELIMITER ;

CALL deleteById(9);