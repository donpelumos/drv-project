DROP TABLE IF EXISTS STOCK;
DROP TABLE IF EXISTS REVIEW_ITEMS;
DROP TABLE IF EXISTS REVIEWS;
DROP TABLE IF EXISTS EMAIL;
DROP TABLE IF EXISTS ORDER_ITEMS;
DROP TABLE IF EXISTS ORDERS;
DROP TABLE IF EXISTS CART_ITEMS;
DROP TABLE IF EXISTS CARTS;
DROP TABLE IF EXISTS ITEMS;
DROP TABLE IF EXISTS CATEGORIES;
DROP TABLE IF EXISTS USERS;


-- -----------------------------------------------------
-- Table user
-- -----------------------------------------------------
CREATE TABLE USERS (
  USER_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  USERNAME VARCHAR(45) NOT NULL UNIQUE,
  GENDER VARCHAR(6) NOT NULL,
  ADDRESS VARCHAR(100) NOT NULL,
  COUNTY VARCHAR(45) NOT NULL,
  PHONE VARCHAR(45) NOT NULL,
  EMAIL VARCHAR(45) NOT NULL,
  Status INT NOT NULL
);
CREATE INDEX user_id_index ON USERS(USER_ID);


-- -----------------------------------------------------
-- Table category
-- -----------------------------------------------------


CREATE TABLE CATEGORIES (
  CATEGORY_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  CATEGORY_NAME VARCHAR(45) NOT NULL
);


-- -----------------------------------------------------
-- Table item
-- -----------------------------------------------------


CREATE TABLE ITEMS (
  ITEM_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  ITEM_NAME VARCHAR(45) NOT NULL,
  ITEM_PRICE FLOAT NOT NULL,
  DESCRIPTION VARCHAR(200) NOT NULL,
  CATEGORY_ID INT NOT NULL,
  CONSTRAINT CategoryIDFKCategory
    FOREIGN KEY (CATEGORY_ID)
    REFERENCES CATEGORIES (CATEGORY_ID)
);
CREATE INDEX item_id_idx ON ITEMS (ITEM_ID);
CREATE INDEX category_id__idx ON ITEMS (CATEGORY_ID);


-- -----------------------------------------------------
-- Table cart
-- -----------------------------------------------------


CREATE TABLE CARTS (
  CART_PRICE FLOAT NOT NULL,
  USER_ID INT NOT NULL UNIQUE,
  CART_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  CONSTRAINT UserIDFKCart
    FOREIGN KEY (USER_ID)
    REFERENCES USERS (USER_ID)
);
CREATE INDEX fk_Cart_User1_idx ON CARTS (USER_ID);


-- -----------------------------------------------------
-- Table cartitems
-- -----------------------------------------------------


CREATE TABLE CART_ITEMS (
  USER_ID INT NOT NULL,
  ITEM_ID INT NOT NULL,
  CART_ITEM_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  QUANTITY INT NOT NULL DEFAULT 1,
  UNIT_PRICE FLOAT NOT NULL,
  CONSTRAINT ItemIDFKCartItems
    FOREIGN KEY (ITEM_ID)
    REFERENCES ITEMS (ITEM_ID),
  CONSTRAINT UserIDFKCartItems
    FOREIGN KEY (USER_ID)
    REFERENCES USERS (USER_ID)
);
CREATE INDEX item_id_cart_items_idx ON CART_ITEMS (ITEM_ID);
CREATE INDEX user_id_cart_items_idx ON CART_ITEMS (USER_ID);


-- -----------------------------------------------------
-- Table orders
-- -----------------------------------------------------


CREATE TABLE ORDERS (
  ORDER_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  ORDER_DATE DATETIME(6) NOT NULL,
  USER_ID INT NOT NULL,
  ORDER_PRICE FLOAT NOT NULL,
  CONSTRAINT USER_ID
    FOREIGN KEY (USER_ID)
    REFERENCES USERS (USER_ID)
);
CREATE INDEX user_id_orders_idx ON ORDERS (USER_ID);


-- -----------------------------------------------------
-- Table orderitems
-- -----------------------------------------------------


CREATE TABLE ORDER_ITEMS (
  ORDER_ITEM_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  ITEM_COUNT TINYINT NOT NULL,
  ORDER_PRICE FLOAT NOT NULL,
  ORDER_ID INT NOT NULL,
  ITEM_ID INT NOT NULL,
  CONSTRAINT ItemIDFKUserOrderItems
    FOREIGN KEY (ITEM_ID)
    REFERENCES ITEMS (ITEM_ID),
  CONSTRAINT OrderIDFKUserOrderItems
    FOREIGN KEY (ORDER_ID)
    REFERENCES ORDERS (ORDER_ID)
);
CREATE INDEX order_id_user_order_items_id_idx ON ORDER_ITEMS (ORDER_ID);
CREATE INDEX item_id_user_order_items_id_idx ON ORDER_ITEMS (ITEM_ID);


-- -----------------------------------------------------
-- Table emails
-- -----------------------------------------------------


CREATE TABLE EMAIL (
  EMAIL_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  TITLE VARCHAR(200) NOT NULL,
  BODY VARCHAR(200) NOT NULL,
  USER_ID INT NOT NULL,
  ORDER_ID INT NOT NULL,
  CONSTRAINT OrderIDEmails
    FOREIGN KEY (ORDER_ID)
    REFERENCES ORDERS (ORDER_ID),
  CONSTRAINT UserIDEmails
    FOREIGN KEY (USER_ID)
    REFERENCES USERS (USER_ID)
);
CREATE INDEX user_id_emails_idx ON EMAIL (USER_ID);
CREATE INDEX order_id_emails_idx ON EMAIL (ORDER_ID);


-- -----------------------------------------------------
-- Table review
-- -----------------------------------------------------


CREATE TABLE REVIEWS (
  REVIEW_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  REVIEW_TEXT VARCHAR(200) NULL DEFAULT NULL,
  REVIEW_DATE DATETIME(6) NOT NULL,
  RATING BIT(10) NOT NULL,
  USER_ID INT NOT NULL,
  CONSTRAINT UserIDFKReview
    FOREIGN KEY (USER_ID)
    REFERENCES USERS (USER_ID)
);
CREATE INDEX user_id_review_idx ON REVIEWS (USER_ID);


-- -----------------------------------------------------
-- Table reviewitems
-- -----------------------------------------------------


CREATE TABLE REVIEW_ITEMS (
  REVIEW_ID INT NOT NULL,
  ITEM_ID INT NOT NULL,
  REVIEW_ITEM_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  CONSTRAINT ItemIDFKReviewItems
    FOREIGN KEY (ITEM_ID)
    REFERENCES ITEMS (ITEM_ID),
  CONSTRAINT ReviewIDFKReviewItems
    FOREIGN KEY (REVIEW_ID)
    REFERENCES REVIEWS (REVIEW_ID)
);
CREATE INDEX item_id_review_items_idx ON REVIEW_ITEMS (ITEM_ID);
CREATE INDEX review_id_review_items_idx ON REVIEW_ITEMS (REVIEW_ID);


-- -----------------------------------------------------
-- Table stock
-- -----------------------------------------------------


CREATE TABLE STOCK (
  ITEM_PRICE FLOAT NOT NULL,
  QUANTITY INT NOT NULL,
  STOCK_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  ITEM_ID INT NOT NULL UNIQUE,
  CONSTRAINT ItemIDFKItem
    FOREIGN KEY (ITEM_ID)
    REFERENCES ITEMS (ITEM_ID)
);
CREATE INDEX item_id_stock_idx ON STOCK (ITEM_ID);