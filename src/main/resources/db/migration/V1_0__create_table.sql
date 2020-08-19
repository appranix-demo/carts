CREATE TABLE IF NOT EXISTS cart (
    id varchar(255) PRIMARY KEY,
    customer_id varchar(255),
    items JSON
);

CREATE TABLE IF NOT EXISTS item (
    id varchar(255) PRIMARY KEY,
    item_id varchar(255),
    quantity int,
    unit_price float
);