CREATE TABLE product_category (
  category_id  INTEGER PRIMARY KEY,
  category  VARCHAR(100),
  leavy double
);

CREATE TABLE product (
  id INTEGER PRIMARY KEY,
  productName VARCHAR(30),
  category_id INTEGER REFERENCES product_category(category_id),
  price double not null
);

