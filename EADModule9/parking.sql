create database parkingSystem;

use parkingSystem;


CREATE TABLE employeeDetails (
empId INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(200) NOT NULL,
gender VARCHAR(10) CHECK (gender IN ('Male','Female')),
email VARCHAR(200) NOT NULL UNIQUE,
password VARCHAR(200) NOT NULL,
phoneNumber VARCHAR(25) NOT NULL,
organization VARCHAR(200) NOT NULL
);

CREATE TABLE vehicleDetails (
empId INT,
name VARCHAR(200) NOT NULL,
type VARCHAR(20) NOT NULL,
vehicleNumber VARCHAR(200) PRIMARY KEY,
identification VARCHAR(200),
FOREIGN KEY(empId) REFERENCES employeeDetails(empId) ON DELETE SET NULL
);


SET FOREIGN_KEY_CHECKS=0;
DROP TABLE vehicleDetails;


CREATE TABLE plan_details (
    empId INT,
    vehicleNumber VARCHAR(200),
    plan VARCHAR(20) CHECK ( plan IN ('daily','monthly','yearly')),
    price INT NOT NULL,
    FOREIGN KEY(vehicleNumber) REFERENCES vehicleDetails(vehicleNumber) ON DELETE SET NULL,
    FOREIGN KEY(empId) REFERENCES employeeDetails(empId) ON DELETE SET NULL    
);


CREATE TABLE images(
    email VARCHAR(200),
    name VARCHAR(200),
    FOREIGN KEY(email) REFERENCES employeeDetails(email) ON DELETE SET NULL
);


DELIMITER ||

CREATE PROCEDURE InfoLatest(emailParm VARCHAR(200), passwordParm VARCHAR(20))
BEGIN
    SELECT E.email, E.password, E.empId, V.vehicleNumber,I.name
    FROM employeeDetails E
    left JOIN vehicleDetails V
    ON V.empId = E.empId
    left Join images I
    ON I.email = E.email
    WHERE E.email = emailParm AND E.password= passwordParm;
END||



DELIMITER &&

CREATE PROCEDURE Friends(emailParam VARCHAR(150))
BEGIN

DECLARE org VARCHAR(50);

SELECT organization INTO org
FROM employeeDetails
WHERE email = emailParam;

SELECT email
FROM employeeDetails
WHERE organization = org;

END &&
DELIMITER ;


 
 DELIMITER &&
CREATE PROCEDURE getProfileByEmail(email VARCHAR(150))
BEGIN
SELECT E.name, E.email, E.phoneNumber, IFNULL(V.vehicleNumber,"Not Available") As vehicleNumber , E.organization
FROM employeeDetails E
LEFT JOIN vehicleDetails V
ON E.empId = V.empId
WHERE E.email = email ;

END &&