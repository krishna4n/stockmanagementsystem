drop table if exists warranty;
drop table if exists item;

create table if not exists item(itemid SERIAL PRIMARY KEY ,itemType VARCHAR,itemSerialNumber VARCHAR,itemName VARCHAR,itemModel VARCHAR,itemCapacity VARCHAR,itemSource VARCHAR);

create table if not exists warranty(warrantyid SERIAL PRIMARY KEY , itemPrice DOUBLE PRECISION,invoiceNumber VARCHAR,invoiceDate VARCHAR,
warrantyPeriod VARCHAR,vendorName VARCHAR,vendorContact VARCHAR,vendorAddress VARCHAR,itemid INT, foreign KEY(itemid) references item(itemid));
