--  Display DETAILS In TABLES -----------------------------------------
USE newdatabase;

--  Display The Products Info -----------------------------------------
select * 
from product;


-- Display All the product info of products which don't have images.
SELECt product.product_id, product.product_name, product.product_price, product.stock, product.category_id
FROM product
WHERE product.product_id NOT IN (SELECT images.product_id
FROM images);
             
             


--  Display all Id, Title and Parent Category Title for all the Categories listed, 
-- sorted by Parent Category Title and then Category Title.-----------------------------------------
SELECT c1.category_id,c1.category_name,
       IFNULL(c2.category_name,'top category')as parent
FROM product_category c1 
LEFT JOIN product_category c2
     ON c1.parent_id = c2.category_id
ORDER BY c1.parent_id, c1.category_name;




-- Display Id, Title, Parent Category Title of all the leaf 
-- Categories (categories which are not parent of any other category)--------------------------------
SELECT c1.category_id, c1.category_name,c1.parent_id
FROM product_category c1
WHERE c1.category_id NOT IN (SELECT c2.parent_id
                    FROM product_category c2
                    WHERE c2.parent_id IS NOT NULL);
            


-- Display Product Title, Price which falls into particular category Title --------------------
SELECT p.product_name,p.product_price,p.stock
FROM product p, product_category c
WHERE (c.category_id = p.category_id OR c.parent_id = p.category_id) AND c.category_name = 'mobile';



-- Display the list of Products whose Quantity on hand (Inventory) is under 50. -----------------------------
SELECT p.product_name,p.product_price,p.stock
From product p
WHERE p.stock < 50;

