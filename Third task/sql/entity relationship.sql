CREATE TABLE "orderOperations" (
"NMID" BIGSERIAL NOT NULL,
"orderNumber" int8 NOT NULL,
"operation" varchar NOT NULL,
PRIMARY KEY("NMID"),
CONSTRAINT "orderOpeations" FOREIGN KEY ("orderNumber")
REFERENCES "Orders"("orderNumber")
MATCH SIMPLE
ON DELETE CASCADE
ON UPDATE CASCADE
NOT DEFERRABLE
);

CREATE TABLE "orderItems" (
"orderItem_ID" BIGSERIAL NOT NULL,
"item" varchar NOT NULL,
PRIMARY KEY("orderItem_ID")
);

CREATE TABLE "Order contain orderItems" (
"NMID" BIGSERIAL NOT NULL,
"orderNumber" int8 NOT NULL,
"orderItem_ID" int8 NOT NULL,
PRIMARY KEY("NMID"),
CONSTRAINT "orderItems to Order" FOREIGN KEY ("orderNumber")
REFERENCES "Orders"("orderNumber")
MATCH SIMPLE
ON DELETE CASCADE
ON UPDATE CASCADE
NOT DEFERRABLE,
CONSTRAINT "Order to orderItems" FOREIGN KEY ("orderItem_ID")
REFERENCES "orderItems"("orderItem_ID")
MATCH SIMPLE
ON DELETE CASCADE
ON UPDATE CASCADE
NOT DEFERRABLE
);

CREATE TABLE "supervisor" (
"NMID" BIGSERIAL NOT NULL,
"employee" int8,
"supervisor" int8,
PRIMARY KEY("NMID"),
CONSTRAINT "supervisorUNIQUE" UNIQUE("employee"),
CONSTRAINT "employee to supervisor" FOREIGN KEY ("employee")
REFERENCES "Employees"("employee_ID")
MATCH SIMPLE
ON DELETE SET NULL
ON UPDATE CASCADE
NOT DEFERRABLE,
CONSTRAINT "supervisor to employee" FOREIGN KEY ("supervisor")
REFERENCES "Employees"("employee_ID")
MATCH SIMPLE
ON DELETE SET NULL
ON UPDATE CASCADE
NOT DEFERRABLE
);

CREATE TABLE "worker" (
"NMID" BIGSERIAL NOT NULL,
"orderNumber" int8,
"employee_ID" int8 NOT NULL DEFAULT '-1',
PRIMARY KEY("NMID"),
CONSTRAINT "Employee to Order" FOREIGN KEY ("orderNumber")
REFERENCES "Orders"("orderNumber")
MATCH SIMPLE
ON DELETE CASCADE
ON UPDATE CASCADE
NOT DEFERRABLE,
CONSTRAINT "Order to Employee" FOREIGN KEY ("employee_ID")
REFERENCES "Employees"("employee_ID")
MATCH SIMPLE
ON DELETE SET DEFAULT
ON UPDATE CASCADE
NOT DEFERRABLE
);

CREATE TABLE "items" (
"item_ID" BIGSERIAL NOT NULL,
"item" varchar NOT NULL,
PRIMARY KEY("item_ID")
);

CREATE TABLE "Invoice_has_items" (
"NMID" BIGSERIAL NOT NULL,
"Invoice_orderNumber" int8 NOT NULL,
"Invoice_number" int8 NOT NULL,
"items_item_ID" int8 NOT NULL,
PRIMARY KEY("NMID"),
CONSTRAINT "items to Invoice" FOREIGN KEY ("Invoice_orderNumber",
"Invoice_number")
REFERENCES "Invoice"("orderNumber", "number")
MATCH SIMPLE
ON DELETE CASCADE
ON UPDATE CASCADE
NOT DEFERRABLE,
CONSTRAINT "Invoice to items" FOREIGN KEY ("items_item_ID")
REFERENCES "items"("item_ID")
MATCH SIMPLE
ON DELETE CASCADE
ON UPDATE CASCADE
NOT DEFERRABLE
);
