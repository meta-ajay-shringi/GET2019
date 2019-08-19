USE newdatabase;

DROP TABLE order_details;
DROP TABLE cart;
DROP TABLE images;
DROP TABLE product;
DROP TABLE product_category;
DROP TABLE address;
DROP TABLE shopper;
DROP TABLE admin;
DROP TABLE user;



--  User DETAILS TABLE -----------------------------------------
CREATE TABLE user (
user_id INT PRIMARY KEY AUTO_INCREMENT not null,
password VARCHAR(20)
);


--  Admin DETAILS TABLE -----------------------------------------
CREATE TABLE admin (
admin_id INT PRIMARY KEY not null, 
admin_name VARCHAR(20) NOT NULL,
admin_password VARCHAR(20) NOT NULL,
FOREIGN KEY(admin_id) REFERENCES user(user_id) 
);


--  Shopper DETAILS TABLE -----------------------------------------
CREATE TABLE shopper (
shopper_id INT PRIMARY KEY not null,
shopper_name VARCHAR(20) NOT NULL,
shopper_address VARCHAR(20) NOT NULL,
FOREIGN KEY(shopper_id) REFERENCES user(user_id)
);


--  Address DETAILS TABLE -----------------------------------------
CREATE TABLE address (
shopper_id INT,
shopper_address VARCHAR(20),
PRIMARY KEY(shopper_id,shopper_address),
FOREIGN KEY(shopper_id) REFERENCES user(user_id)
);

--  Category DETAILS TABLE -----------------------------------------
CREATE TABLE product_category(
category_id INT PRIMARY KEY AUTO_INCREMENT,
parent_id INT,
category_name VARCHAR(20) NOT NULL,
FOREIGN KEY(parent_id) REFERENCES product_category(category_id)
);

--  Product DETAILS TABLE -----------------------------------------
CREATE TABLE product(
product_id INT PRIMARY KEY AUTO_INCREMENT,
product_name VARCHAR(20) NOT NULL,
product_price INT NOT NULL,
stock INT NOT NULL,
category_id INT NOT NULL,
FOREIGN KEY(category_id) REFERENCES product_category(category_id)
);
ALTER TABLE Product
ADD COLUMN is_active bool default true;

--  Image TABLE ---------------------------------------------------
CREATE TABLE images(
product_id INT,
product_image VARCHAR(20),
PRIMARY KEY(product_id,product_image),
FOREIGN KEY(product_id) REFERENCES product(product_id)
);



--  CART DETAILS TABLE -----------------------------------------
CREATE TABLE cart(
cart_id INT not null,
product_id INT not null, 
quantity INT not null,
PRIMARY KEY (cart_id, product_id),
FOREIGN KEY(product_id) REFERENCES product(product_id),
FOREIGN KEY(cart_id) REFERENCES shopper(shopper_id)
);


--  ORDER DETAILS TABLE -----------------------------------------
CREATE TABLE order_details(
cart_id INT not null,
product_id INT not null,
order_id INT NOT NULL,
status VARCHAR(20),
date DATE not null,
price INT not null,
PRIMARY KEY (order_id,cart_id,product_id),
saddress VARCHAR(20) REFERENCES address(shopper_address),
FOREIGN KEY(product_id) REFERENCES product(product_id),
FOREIGN KEY(cart_id) REFERENCES cart(cart_id)
);



