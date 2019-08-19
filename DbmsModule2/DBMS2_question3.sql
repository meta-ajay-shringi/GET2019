USE newdatabase;

-- 1.Display Recent 10 Orders placed (Id, Order Date, Order Total). -------------------------------------
SELECT order_id,date,price
FROM order_details
ORDER BY date DESC
LIMIT 10;



-- 2.Display 10 most expensive Orders. -------------------------------------------------------------------
SELECT order_id,date,price
FROM order_details
ORDER BY price DESC
LIMIT 10;


-- Display all the Orders which are placed more than 10 days old and 
-- one or more items from those orders are still not shipped. ---------------------------------------------
SELECT o.order_id, o.date, o.price, o.product_id
FROM order_details o
WHERE o.status = 'not-shipped' AND DATEDIFF(CURDATE(),o.date)<=10;



-- Display list of shoppers which haven't ordered anything since last month. -------------------------------
SELECT s1.shopper_id,s1.shopper_name
FROM shopper s1
WHERE s1.shopper_id NOT IN(SELECT o.cart_id
                       FROM order_details o
                       WHERE s1.shopper_id = o.cart_id AND DATEDIFF(CURDATE(),o.date)<=30);

                       
 

-- Display list of shopper along with orders placed by them in last 15 days. --------------------------------
SELECT s.shopper_id,o.order_id,o.date
FROM shopper s,order_details o
WHERE s.shopper_id = o.cart_id AND DATEDIFF(CURDATE(),o.date)<=15;



-- Display list of order items which are in “shipped” state for particular Order Id --------------------------
SELECT op.order_id, op.product_id, p.product_name
FROM order_details op, product p
WHERE op.product_id = p.product_id AND status IN('shipped') AND order_id = 0004;



-- Display list of order items along with order placed date which fall between Rs 20 to Rs 50 price.
SELECT o.product_id, p.product_name, o.date
FROM  product p, order_details o
WHERE p.product_id = o.product_id AND p.product_price <= 50 AND p.product_price >= 20;