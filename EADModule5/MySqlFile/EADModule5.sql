create database shoppingCart ;
use shoppingCart ;
set foreign_key_checks =0;

drop table cartItem;
drop table order_details;
drop table product;
drop table users;

-- product table , cart table  -use table


create table users (
userid INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
email VARCHAR(50),
password VARCHAR(20)
);

create table product (
productid INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
productname VARCHAR(20) ,
price FLOAT(10),
producttype VARCHAR(30)
);

CREATE TABLE order_details(
orderid INT PRIMARY KEY AUTO_INCREMENT,
userid INT,
total_cart_item INT,
total_price FLOAT(10),
FOREIGN KEY(userid) REFERENCES users(userid) ON DELETE SET NULL
);

create table cartItem(
cartid INT PRIMARY KEY AUTO_INCREMENT,
productid INT,
orderid INT,
productquantity INT,
FOREIGN KEY(productid) REFERENCES product(productid), 
FOREIGN KEY(orderid) REFERENCES order_details(orderid)
);


SELECT * From cartItem;
SELECT * From order_details;


INSERT into users(email,password) VALUES
('ajay','1234'),
('yash','2345'),
('mahendar','3456');


INSERT into product (productid,productname,price,producttype) VALUES
(1,'ladyfinger',50,'vegetable'),
(2,'RealMe',5000,'Mobile'),
(3,'USB Cable',500,'Accessories');
