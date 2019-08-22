USE newdatabase;

-- DROP FUNCTION order_in_month;
-- DROP FUNCTION maximum_orders_in_month;

#1.Function to calculate number of orders in a month.
DELIMITER $$
CREATE FUNCTION order_in_month(month INT, year INT) RETURNS INT
   BEGIN
       DECLARE order_count INT;
       SELECT COUNT(*) INTO order_count
       FROM order_details o
       WHERE MONTH(o.date) = month AND YEAR(o.date) = year
       GROUP BY MONTH(o.date);
       RETURN (order_count);
   END $$
DELIMITER ;

SELECT order_in_month(07,2019),order_in_month(08,2019) ;

#2.Function to return month in a year having maximum orders.
DELIMITER $$
CREATE FUNCTION maximum_orders_in_month(year INT) RETURNS INT
       BEGIN
           DECLARE month_of_max_orders int;
           SELECT MONTH(o.date) INTO month_of_max_orders
           FROM order_details o
           WHERE YEAR(o.date) = year
           ORDER BY MONTH(o.date) DESC
           LIMIT 1;
           RETURN (month_of_max_orders);
       END$$
DELIMITER ;


SELECT maximum_orders_in_month(2019);






