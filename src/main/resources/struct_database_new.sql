CREATE TABLE IF NOT EXISTS customer (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    cpf VARCHAR(11)
);

CREATE TABLE product (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    description VARCHAR(100),
    unit_price NUMERIC(20,2)
);

CREATE TABLE customer_order (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    customer_id INTEGER REFERENCES customer (id),
    date_order DATE,
    total NUMERIC(20,2)
);

CREATE TABLE item_order (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    order_id INTEGER REFERENCES `order`(id),
    product_id INTEGER REFERENCES product (id),
    amount INTEGER
);