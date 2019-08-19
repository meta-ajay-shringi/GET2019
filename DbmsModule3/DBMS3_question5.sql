USE newdatabase;


#1.Create a view displaying the order information 
# (Id, Title, Price, Shopper’s name, Email, Orderdate, Status) 
# with latest ordered items should be displayed first for last 60 days.--------------

CREATE VIEW Order_Information AS SELECT o.order_id,c.product_id,p.product_name AS product_name,c.quantity,p.product_price * c.quantity AS total_price,s.shopper_name,o.date,o.status
                                 FROM order_details o INNER JOIN cart c ON o.cart_id = c.cart_id
                                      INNER JOIN product p ON c.product_id = p.product_id
                                      INNER JOIN shopper s ON o.cart_id = s.shopper_id
                                 WHERE DATEDIFF(CURDATE(),o.date) <= 60
                                 ORDER BY o.date DESC;
                                 
SELECT * FROM Order_Information;


#2.Use the above view to display the Products(Items) which are in ‘shipped’ state.
SELECT order_id,product_id,product_name,quantity,total_price,shopper_name,date,status
FROM Order_Information
WHERE status IN('shipped');




#3.Use the above view to display the top 5 most selling products.
SELECT product_id,product_name,SUM(quantity) AS total_ordered_quantity
FROM Order_Information
WHERE status NOT IN('returned')
GROUP BY product_id
ORDER BY total_ordered_quantity DESC
LIMIT 5;