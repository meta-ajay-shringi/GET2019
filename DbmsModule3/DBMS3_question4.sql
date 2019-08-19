USE newdatabase;

CREATE TABLE Zipcode(
zipcode INT NOT NULL,
city VARCHAR(100) NOT NULL,
state VARCHAR(100) NOT NULL,
PRIMARY KEY(zipcode)
);

INSERT INTO Zipcode(zipcode, city, state)
            VALUES(313001, 'udaipur', 'rajasthan'),
                  (302001, 'jaipur', 'rajasthan'),
                  (305001, 'ajmer', 'rajasthan'),
                  (282001, 'agra', 'madhya pradesh'),
                  (411001, 'pune', 'maharashtra'),
                  (321001, 'bharatpur', 'rajasthan'),
                  (400008, 'mumbai', 'maharashtra');


# Zipcode ordered by State Name and City Name.
SELECT zipcode,city,state
FROM Zipcode
ORDER BY state,city;