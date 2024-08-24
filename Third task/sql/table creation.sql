CREATE TYPE address AS (
"city" varchar,
"street" varchar
);

CREATE TYPE "orderDate" AS (
"day" int4,
"month" int4,
"year" int4
);

CREATE TABLE "Accounts" (
"login" varchar NOT NULL,
"password" varchar NOT NULL,
PRIMARY KEY("login")
);

CREATE TABLE "Person" (
"firstName" varchar NOT NULL,
"secondName" varchar NOT NULL,
"phoneNumber" varchar NOT NULL,
"Accounts_login" varchar NOT NULL,
PRIMARY KEY("firstName","secondName"),
CONSTRAINT "phoneNumber" UNIQUE("phoneNumber"),
CONSTRAINT "control" FOREIGN KEY ("Accounts_login")
REFERENCES "Accounts"("login")
MATCH SIMPLE
ON DELETE CASCADE
ON UPDATE CASCADE
NOT DEFERRABLE
);

CREATE TABLE "Clients" (
"client_ID" BIGSERIAL NOT NULL,
"loyaltyPoints" int4 DEFAULT '0',
PRIMARY KEY("client_ID")
)
INHERITS ("Person");
CREATE TABLE "Employees" (
"employee_ID" BIGSERIAL NOT NULL,
"salary" int4,
"address" address,
PRIMARY KEY("employee_ID")
)
INHERITS ("Person");

CREATE TABLE "Cars" (
"VIN" varchar NOT NULL,
"manufacturer" varchar NOT NULL,
"model" varchar NOT NULL,
"year" int8 NOT NULL,
"owner" int8 NOT NULL,
PRIMARY KEY("VIN"),
CONSTRAINT "owner" FOREIGN KEY ("owner")
REFERENCES "Clients"("client_ID")
MATCH SIMPLE
ON DELETE RESTRICT
ON UPDATE CASCADE
NOT DEFERRABLE
);

CREATE TABLE "Orders" (
"orderNumber" BIGSERIAL NOT NULL,
"date" "orderDate" NOT NULL,
"payer" int8 NOT NULL DEFAULT '-1',
"subject" varchar,
PRIMARY KEY("orderNumber"),
CONSTRAINT "payer" FOREIGN KEY ("payer")
REFERENCES "Clients"("client_ID")
MATCH SIMPLE
ON DELETE SET DEFAULT
ON UPDATE CASCADE
NOT DEFERRABLE,
CONSTRAINT "subject" FOREIGN KEY ("subject")
REFERENCES "Cars"("VIN")
MATCH SIMPLE
ON DELETE SET NULL
ON UPDATE CASCADE
NOT DEFERRABLE
);

CREATE TABLE "Invoice" (
"orderNumber" int8 NOT NULL,
"number" BIGSERIAL NOT NULL,
"totalCost" money NOT NULL,
PRIMARY KEY("orderNumber","number"),
CONSTRAINT "has" FOREIGN KEY ("orderNumber")
REFERENCES "Orders"("orderNumber")
MATCH SIMPLE
ON DELETE CASCADE
ON UPDATE CASCADE
NOT DEFERRABLE);