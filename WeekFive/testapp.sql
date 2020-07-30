DROP TABLE IF EXISTS testapp.Orders;
DROP TABLE IF EXISTS testapp.RESTRICT;
CREATE SCHEMA testapp;

CREATE TABLE testapp.Orders
(
	ID SERIAL PRIMARY KEY,
	ORDER_NO VARCHAR(25) NOT NULL,
	PRODUCT_NAME VARCHAR(128) NOT NULL,
	PRICE MONEY NOT NULL,
	QUANTITY INTEGER NOT NULL
);
INSERT INTO testapp.Orders(ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) VALUES('0000000000', 'This is Product 1', 1.00, 1);
INSERT INTO testapp.Orders(ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) VALUES('0000000001', 'This is Product 2', 2.00, 2);
INSERT INTO testapp.Orders(ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) VALUES('0000000002', 'This is Product 3', 3.00, 3);
INSERT INTO testapp.Orders(ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) VALUES('0000000003', 'This is Product 4', 4.00, 4);
INSERT INTO testapp.Orders(ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) VALUES('0000000004', 'This is Product 5', 5.00, 5);
INSERT INTO testapp.Orders(ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) VALUES('0000000005', 'This is Product 6', 6.00, 6);
INSERT INTO testapp.Orders(ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) VALUES('0000000006', 'This is Product 7', 7.00, 7);
INSERT INTO testapp.Orders(ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) VALUES('0000000007', 'This is Product 8', 8.00, 8);
INSERT INTO testapp.Orders(ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) VALUES('0000000008', 'This is Product 9', 9.00, 9);
INSERT INTO testapp.Orders(ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) VALUES('0000000009', 'This is Product 10', 10.00, 10);
