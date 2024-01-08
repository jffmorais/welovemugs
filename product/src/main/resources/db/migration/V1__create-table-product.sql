CREATE TABLE product (
    id varchar(255) NOT NULL,
    name varchar(255) NOT NULL,
    description varchar(255),
    price NUMERIC(10, 2) NOT NULL,
    CONSTRAINT product_pk PRIMARY KEY (id)
);