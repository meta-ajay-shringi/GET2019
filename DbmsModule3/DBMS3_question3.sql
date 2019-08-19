USE newdatabase;

#1.Display Shopper’s information along with number of orders he/she placed during last 30 days.
SELECT s.shopper_id,s.shopper_name,COUNT(*) AS number_of_order
FROM shopper s INNER JOIN order_details o ON s.shopper_id = o.cart_id
WHERE DATEDIFF(CURDATE(),o.date) <= 30
GROUP BY s.shopper_id;


#2.Display the top 10 Shoppers who generated maximum number of revenue in last 30 days.
SELECT s.shopper_id,s.shopper_name,SUM(p.product_price * c.quantity) AS generated_revenue
FROM shopper s INNER JOIN order_details o ON s.shopper_id = o.cart_id
     INNER JOIN cart c ON o.cart_id = c.cart_id
     INNER JOIN product p ON c.product_id = p.product_id
WHERE DATEDIFF(CURDATE(),o.date) <= 30 AND o.status NOT IN('returned')
GROUP BY s.shopper_id
ORDER BY generated_revenue DESC
LIMIT 10;



#3.Display top 20 Products which are ordered most in last 60 days along with numbers.
SELECT p.product_id,p.product_name, SUM(op.quantity) AS ordered_product_quantity
FROM product p INNER JOIN cart op ON p.product_id = op.product_id 
     INNER JOIN order_details o ON op.cart_id = o.cart_id
WHERE DATEDIFF(CURDATE(),o.date) <= 60
GROUP BY p.product_id
ORDER BY ordered_product_quantity DESC
LIMIT 20;


#4.Display Monthly sales revenue of the StoreFront for last 6 months. It should display each month’s sale.
SELECT MONTHNAME(order_details.date) AS month , SUM(order_details.price) AS total_revenue
FROM order_details
WHERE order_details.date > CURRENT_TIMESTAMP - INTERVAL 6 month 
GROUP BY month(order_details.date);


#5.Mark the products as Inactive which are not ordered in last 90 days.
SET SQL_SAFE_UPDATES = 0;
UPDATE product p
SET is_active = false
WHERE p.product_id NOT IN(SELECT p.product_id
                FROM order_details o LEFT JOIN cart c ON c.cart_id = o.cart_id
                WHERE p.product_id = c.product_id AND DATEDIFF(CURDATE(),o.date) <= 90);
SELECT * FROM product;



#6.Given a category search keyword, display all the Products present in this category/categories. 
SELECT p.product_id,p.product_name ,pc.category_name AS category_title
FROM product p INNER JOIN product_category pc ON p.category_id = pc.category_id 
WHERE pc.category_name IN('asus','mobile');


#7.Display top 10 Items which were cancelled most.
SELECT p.product_id,p.product_name,COUNT(*) AS cancelled_count
FROM product p INNER JOIN order_details o ON p.product_id = o.product_id
WHERE o.status IN('returned')
GROUP BY p.product_id
ORDER BY cancelled_count DESC
LIMIT 10;
