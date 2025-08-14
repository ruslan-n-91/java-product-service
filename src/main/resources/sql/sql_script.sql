CREATE DATABASE java_product_service_db;

DROP TABLE IF EXISTS product CASCADE;

CREATE SEQUENCE IF NOT EXISTS product_id_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS product (
    id BIGINT PRIMARY KEY DEFAULT nextval('product_id_seq'),
    product_name VARCHAR(255) NOT NULL,
	description VARCHAR(255) NOT NULL,
    quantity INTEGER NOT NULL,
	created_at TIMESTAMP NOT NULL
);

ALTER SEQUENCE product_id_seq OWNED BY product.id;

-- INSERT INTO Book (title, quantity)
-- VALUES ('Java The Complete Reference 9th Edition', 40),
--        ('Design Patterns: Elements of Reusable Object-Oriented Software', 30),
--        ('Grokking Algorithms', 25),
--        ('War and Peace', 30),
--        ('Adventures of Huckleberry Finn', 50),
--        ('Dune', 45);

