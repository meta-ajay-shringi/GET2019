--  Insert DETAILS In TABLES -----------------------------------------

USE newdatabase;


--  Insert DETAILS In USER TABLES -----------------------------------------

INSERT INTO user(password) VALUES('ajay@1234');
INSERT INTO user(password) VALUES('sharma');
INSERT INTO user(password) VALUES('ya#ahdhi');
INSERT INTO user(password) VALUES('ajay@1234');
INSERT INTO user(password) VALUES('shri');
INSERT INTO user(password) VALUES('aj#ahdhi');
INSERT INTO user(password) VALUES('vatsal@1234');
INSERT INTO user(password) VALUES('goyal');
INSERT INTO user(password) VALUES('va#ahdhi');
INSERT INTO user(password) VALUES('shobhit@1234');
INSERT INTO user(password) VALUES('bhatnagar');
INSERT INTO user(password) VALUES('sh#ahdhi');
INSERT INTO user(password) VALUES('mahendra@1234');
INSERT INTO user(password) VALUES('verma');
INSERT INTO user(password) VALUES('ma#ahdhi');
INSERT INTO user(password) VALUES('ram');
INSERT INTO user(password) VALUES('ra#ahdhi');


--  Insert DETAILS In Admin TABLES -----------------------------------------

INSERT INTO admin VALUES(1,'Ajay','Shringi');
INSERT INTO admin VALUES(2,'Yash','yash1234');




--  Insert DETAILS In Shopper TABLES -----------------------------------------

INSERT INTO shopper VALUES(3,'mahendre','jaipur');
INSERT INTO shopper VALUES(4,'mahendre2','kota');
INSERT INTO shopper VALUES(6,'vatsal','kota');
INSERT INTO shopper VALUES(10,'goyal','jaipur');



--  Insert DETAILS In Address TABLES -----------------------------------------

INSERT INTO address VALUES(2,'jaipur');
INSERT INTO address VALUES(2,'kota');
INSERT INTO address VALUES(3,'indor');
INSERT INTO address VALUES(3,'delhi');


--  Insert DETAILS In Product Category TABLES -----------------------------------------


INSERT INTO product_category VALUES(101,null,'electonics');
INSERT INTO product_category VALUES(201,101,'mobile');
INSERT INTO product_category VALUES(202,101,'tv');
INSERT INTO product_category VALUES(301,201,'mi');
INSERT INTO product_category VALUES(302,201,'asus');
INSERT INTO product_category VALUES(303,201,'nokia');
INSERT INTO product_category VALUES(304,201,'Samsung');
INSERT INTO product_category VALUES(102,null,'home appliance');
INSERT INTO product_category VALUES(203,102,'vaccum');
INSERT INTO product_category VALUES(103,null,'sports');
INSERT INTO product_category VALUES(104,null,'cloths');
INSERT INTO product_category VALUES(204,104,'jeans');
INSERT INTO product_category VALUES(205,104,'shirt');




--  Insert DETAILS In Product TABLES -----------------------------------------

INSERT INTO product VALUES(101,'Mobile',1000,20,201,true);
INSERT INTO product(product_name, product_price, stock , category_id) VALUES('Jeans', 100, 300,204);
INSERT INTO product(product_name, product_price, stock , category_id) VALUES('asus', 1000, 10 ,302);
INSERT INTO product(product_name, product_price, stock , category_id) VALUES('Ball', 100, 40,103);
INSERT INTO product(product_name, product_price, stock , category_id) VALUES('Bat', 1000, 70,103);
INSERT INTO product(product_name, product_price, stock , category_id) VALUES('shoes', 100,50 ,104);
INSERT INTO product(product_name, product_price, stock , category_id) VALUES('Shirt', 1000, 200,205);
INSERT INTO product(product_name, product_price, stock , category_id) VALUES('Nokia', 1000, 25,303);
INSERT INTO product(product_name, product_price, stock , category_id) VALUES('Samsung', 100, 75,304);
INSERT INTO product(product_name, product_price, stock , category_id) VALUES('home appliance', 1000, 300,102);
INSERT INTO product(product_name, product_price, stock , category_id) VALUES('vaccum', 100, 10,203);
INSERT INTO product(product_name, product_price, stock , category_id) VALUES('TV', 1000, 10,202);
INSERT INTO product(product_name, product_price, stock , category_id) VALUES('TV2', 25, 10,202);





--  Insert DETAILS In Images TABLES -----------------------------------------

INSERT INTO images VALUES(101,'image1');
INSERT INTO images VALUES(101,'image2');
INSERT INTO images VALUES(102,'image3');
INSERT INTO images VALUES(103,'image1');
INSERT INTO images VALUES(104,'image1');
INSERT INTO images VALUES(104,'image2');
INSERT INTO images VALUES(106,'image1');
INSERT INTO images VALUES(108,'image1');
INSERT INTO images VALUES(108,'image2');
INSERT INTO images VALUES(109,'image3');
INSERT INTO images VALUES(109,'image1');
INSERT INTO images VALUES(110,'image2');




--  Insert DETAILS In Cart TABLES -----------------------------------------

INSERT INTO cart VALUES (3,101,3),
(3,103,2),
(3,110,25),
(4,102,5),
(4,110,5),
(4,109,2),
(10,102,5),
(10,112,100),
(10,104,10),
(6,104,5);
INSERT INTO cart VALUES(6,113,1);


--  Insert DETAILS In Order Details TABLES -----------------------------------------

INSERT INTO order_details VALUES (3,101,0001,'placed','2019-08-12', 3000,'jaipur'),
(3,103,0001,'returned','2019-08-12', 2000,'jaipur'),
(3,110,0001,'shipped','2019-08-12', 25000,'jaipur'),
(4,102,0002,'placed','2019-06-11', 500,'kota'),
(4,110,0003,'placed','2019-07-12',5000,'delhi'),
(4,109,0002,'returned','2019-07-11', 200,'kota'),
(6,104,0004,'shipped','2019-08-15', 500,'kota'),
(10,104,0005,'not-shipped','2019-08-16', 1000,'kota');
INSERT INTO order_details VALUES (6,113,0004,'shipped','2019-08-15',25,'jaipur');





