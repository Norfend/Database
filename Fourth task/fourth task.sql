BEGIN;
SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;
DO $$
DECLARE
owner_exists BOOLEAN;
BEGIN
SELECT EXISTS (
SELECT 1
FROM "Clients"
WHERE "client_ID" = 13
) INTO owner_exists;
IF NOT owner_exists THEN
RAISE EXCEPTION 'Owner with client_ID 13 does not exist';
END IF;
END $$;

CREATE OR REPLACE FUNCTION check_total_cost()
RETURNS TRIGGER AS $$
BEGIN
IF NEW."totalCost" <= -1 THEN
RAISE EXCEPTION 'totalCost must be greater than -1. Given: %',
NEW."totalCost";
END IF;
RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER check_total_cost_trigger
BEFORE INSERT OR UPDATE ON "Invoice"
FOR EACH ROW
EXECUTE FUNCTION check_total_cost();

CREATE VIEW "CarsWithOwnerStartingA" AS
SELECT
c."VIN",
c."manufacturer",
c."model",
c."year",
cl."firstName" || ' ' || cl."secondName" AS "ownerName"
FROM
"Cars" c
JOIN
"Clients" cl ON c."owner" = cl."client_ID"
WHERE
cl."firstName" LIKE 'A%';

CREATE INDEX idx_cars_vin ON "Cars" ("VIN");
