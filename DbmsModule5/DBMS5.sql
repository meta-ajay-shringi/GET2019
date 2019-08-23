USE newdatabase;

/*
* Given the id of a user, fetch all orders (Id, Order Date, Order Total) 
* of that user which are in shipped state. Orders should be sorted by 
* order date column in chronological order.
*/
DELIMITER $$
CREATE PROCEDURE shipped_State(shopperId INT, orderStatus VARCHAR(20))
   BEGIN
        SELECT o.order_id, o.date, SUM(o.price) AS total_price 
        FROM order_details o 
        INNER JOIN shopper s ON s.shopper_id = o.cart_id 
        WHERE s.shopper_id = shopperId AND o.status = orderStatus;
			   END $$;
DELIMITER ;

CALL shipped_State(3,'Shipped');


/*
* Insert five or more images of a product using batch insert technique.
*/
DELIMITER $$
CREATE PROCEDURE show_image()
  BEGIN
      SELECT * 
      FROM images 
      WHERE product_id = 105;
  END $$;
DELIMITER ;


CALL show_image();

/*
* Delete all those products which were not ordered by any Shopper in last 1 year. 
* Return the number of products deleted.
*/

DELIMITER $$
CREATE PROCEDURE delete_product()
BEGIN
     SET FOREIGN_KEY_CHECKS = 0;
     DELETE FROM product 
     WHERE product.product_id NOT IN(SELECT o.product_id
     FROM order_details o 
     LEFT JOIN cart c 
     ON c.cart_id = o.cart_id
     WHERE o.product_id = c.product_id AND DATEDIFF(CURDATE(),o.date) <= 365);
END $$;
DELIMITER ;

CALL delete_product();

/*
* Select and display the category title of all top parent categories sorted 
* alphabetically and the count of their child categories.
*/
DELIMITER $$
CREATE PROCEDURE category_title()
BEGIN 
SELECT parent.category_name, COUNT(child.category_id) AS numberOfChildren 
					FROM product_category parent 
					LEFT JOIN product_category child 
					ON parent.category_id = child.parent_id
					WHERE parent.parent_id IS NULL 
					GROUP BY parent.category_id 
					ORDER BY parent.category_name;
END $$;
DELIMITER ;

CALL category_title();



               