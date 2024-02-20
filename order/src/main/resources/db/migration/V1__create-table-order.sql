CREATE TABLE tb_order (
    id varchar(255) NOT NULL,
    order_number varchar(255) NOT NULL,
    CONSTRAINT order_pk PRIMARY KEY (id)
);

CREATE TABLE order_line_items (
    id varchar(255) NOT NULL,
    sku_code varchar(255) NOT NULL,
    price NUMERIC(10, 2) NOT NULL,
    quantity int DEFAULT 0,
    order_id varchar(255) NOT NULL,
    CONSTRAINT order_line_items_pk PRIMARY KEY (id),
    CONSTRAINT order_fk FOREIGN KEY (order_id)
        REFERENCES tb_order(id)
);