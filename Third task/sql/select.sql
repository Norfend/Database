SELECT CONCAT("firstName", ' ', "secondName") AS name, COUNT("VIN") as
Cars_count
FROM "Clients"
LEFT JOIN "Cars" ON "Cars"."owner" = "Clients"."client_ID"
GROUP BY NAME;

SELECT worker."employee_ID"
FROM worker
JOIN "Employees" ON worker."employee_ID" = "Employees"."employee_ID"
GROUP BY worker."employee_ID";

SELECT CONCAT("Cars"."manufacturer", ' ', "Cars"."model") AS car,
"Cars"."year"
from "Cars"
where "Cars"."year" BETWEEN '2010' AND '2011';

SELECT "Cars"."VIN", CONCAT("Cars"."manufacturer", ' ', "Cars"."model") AS
car, "Cars"."year"
from "Cars"
where "Cars"."year" BETWEEN '2000' AND '2011'
LIMIT 10;

SELECT CONCAT("Clients"."firstName", ' ', "Clients"."secondName") AS NAME,
"Clients"."phoneNumber", "Clients"."loyaltyPoints"
FROM "Clients"
WHERE "loyaltyPoints" < 3000
EXCEPT
SELECT CONCAT("Clients"."firstName", ' ', "Clients"."secondName") AS NAME,
"Clients"."phoneNumber", "Clients"."loyaltyPoints"
FROM "Clients"
WHERE "firstName" LIKE 'A%'
ORDER BY NAME ASC;

SELECT CONCAT("Clients"."firstName", ' ', "Clients"."secondName") AS NAME,
"Clients"."loyaltyPoints" AS Bonuses
FROM "Clients"
WHERE "Clients"."loyaltyPoints" > (SELECT AVG("Clients"."loyaltyPoints") FROM
"Clients")
AND (SELECT length("Clients"."firstName") > 7)
LIMIT 15;