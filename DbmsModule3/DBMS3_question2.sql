use newdatabase;

#1.Display the list of products (Id, Title, Count of Categories) which fall in more than one Categories.
SELECT p.product_id,p.product_name,COUNT(*) AS category_count
FROM product p INNER JOIN product_category pc ON p.category_id = pc.category_id
GROUP BY p.product_name
HAVING category_count > 1;


/*
2.Display Count of products as per below price range:
Range in Rs.
0 - 100
101 - 500
Above 500
*/
SELECT pr.price_range,COUNT(*) AS product_count
FROM(SELECT CASE
                WHEN product_price > 0 AND product_price <= 100 then '0-100'
                WHEN product_price > 100 AND product_price <= 500 then '101-500'
                ELSE 'Above 500'
            END AS price_range
     FROM product) pr
GROUP BY pr.price_range;



#3.Display the Categories along with number of products under each category.
SELECT c.category_id,c.category_name,COUNT(*) AS product_count
FROM product_category c INNER JOIN product p 
ON c.category_id = p.category_id
GROUP BY p.category_id;