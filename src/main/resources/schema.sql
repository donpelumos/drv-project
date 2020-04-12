DROP TABLE IF EXISTS USERORDERITEMS ;
DROP TABLE IF EXISTS STOCK ;
DROP TABLE IF EXISTS REVIEWITEMS ;
DROP TABLE IF EXISTS REVIEW ;
DROP TABLE IF EXISTS INVOICE ;
DROP TABLE IF EXISTS EMAILS ;
DROP TABLE IF EXISTS ORDERS ;
DROP TABLE IF EXISTS CARTITEMS ;
DROP TABLE IF EXISTS ITEM ;
DROP TABLE IF EXISTS CATEGORY ;
DROP TABLE IF EXISTS CART ;
DROP TABLE IF EXISTS USER ;

-- -----------------------------------------------------
-- Table user
-- -----------------------------------------------------
CREATE TABLE USER (
  UserID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  Username VARCHAR(45) NOT NULL UNIQUE,
  Gender CHAR(2) NOT NULL,
  Address VARCHAR(100) NOT NULL,
  County VARCHAR(45) NOT NULL,
  Phone VARCHAR(45) NOT NULL,
  Email VARCHAR(45) NOT NULL,
  Status TINYINT NOT NULL
);
CREATE INDEX user_id_index ON USER(UserID);


-- -----------------------------------------------------
-- Table cart
-- -----------------------------------------------------


CREATE TABLE CART (
  Price FLOAT NOT NULL,
  UserID INT NOT NULL PRIMARY KEY,
  CONSTRAINT UserIDFKCart
    FOREIGN KEY (UserID)
    REFERENCES USER (UserID)
);
CREATE INDEX fk_Cart_User1_idx ON CART(UserID);


-- -----------------------------------------------------
-- Table category
-- -----------------------------------------------------


CREATE TABLE CATEGORY (
  CategoryID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  CategoryName VARCHAR(45) NOT NULL
);


-- -----------------------------------------------------
-- Table item
-- -----------------------------------------------------


CREATE TABLE ITEM (
  ItemID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  Name VARCHAR(45) NOT NULL,
  Price FLOAT NOT NULL,
  Description VARCHAR(200) NOT NULL,
  CategoryID INT NOT NULL,
  CONSTRAINT CategoryIDFKCategory
    FOREIGN KEY (CategoryID)
    REFERENCES CATEGORY (CategoryID)
);
CREATE INDEX item_id_idx ON ITEM(ItemID);
CREATE INDEX category_id__idx ON ITEM(CategoryID);


-- -----------------------------------------------------
-- Table cartitems
-- -----------------------------------------------------


CREATE TABLE CARTITEMS (
  UserID INT NOT NULL,
  ItemID INT NOT NULL,
  CartItemsID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  Quantity INT NOT NULL DEFAULT 1,
  Price FLOAT NOT NULL,
  CONSTRAINT ItemIDFKCartItems
    FOREIGN KEY (ItemID)
    REFERENCES ITEM (ItemID),
  CONSTRAINT UserIDFKCartItems
    FOREIGN KEY (UserID)
    REFERENCES USER (UserID)
);
CREATE INDEX item_id_cart_items_idx ON CARTITEMS (ItemID);
CREATE INDEX user_id_cart_items_idx ON CARTITEMS (UserID);

-- -----------------------------------------------------
-- Table orders
-- -----------------------------------------------------


CREATE TABLE ORDERS (
  OrderID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  Date DATETIME(6) NOT NULL,
  UserID INT NOT NULL,
  Price FLOAT NOT NULL,
  CONSTRAINT UserID
    FOREIGN KEY (UserID)
    REFERENCES USER (UserID)
);
CREATE INDEX user_id_orders_idx ON ORDERS (UserID);

-- -----------------------------------------------------
-- Table emails
-- -----------------------------------------------------


CREATE TABLE EMAILS (
  EmailsID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  Topic VARCHAR(200) NOT NULL,
  Body VARCHAR(200) NOT NULL,
  UserID INT NOT NULL,
  OrderID INT NOT NULL,
  CONSTRAINT OrderIDEmails
    FOREIGN KEY (OrderID)
    REFERENCES ORDERS (OrderID),
  CONSTRAINT UserIDEmails
    FOREIGN KEY (UserID)
    REFERENCES USER (UserID)
);
CREATE INDEX user_id_emails_idx ON EMAILS (UserID);
CREATE INDEX order_id_emails_idx ON EMAILS (OrderID);


-- -----------------------------------------------------
-- Table invoice
-- -----------------------------------------------------


CREATE TABLE INVOICE (
  InvoiceID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  Status TINYINT NOT NULL,
  OrderID INT NOT NULL,
  UserID INT NULL DEFAULT NULL,
  CONSTRAINT OrderIDFKInvoice
    FOREIGN KEY (OrderID)
    REFERENCES ORDERS (OrderID),
  CONSTRAINT UserIDFKInvoice
    FOREIGN KEY (UserID)
    REFERENCES USER (UserID)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);
CREATE INDEX order_id_invoice_idx ON INVOICE (OrderID);
CREATE INDEX user_id_invoice_idx on INVOICE(UserID);


-- -----------------------------------------------------
-- Table review
-- -----------------------------------------------------


CREATE TABLE REVIEW (
  ReviewID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  ReviewText VARCHAR(200) NULL DEFAULT NULL,
  Date DATETIME(6) NOT NULL,
  Rating BIT(10) NOT NULL,
  UserID INT NOT NULL,
  CONSTRAINT UserIDFKReview
    FOREIGN KEY (UserID)
    REFERENCES USER (UserID)
);
CREATE INDEX user_id_review_idx ON REVIEW (UserID);


-- -----------------------------------------------------
-- Table reviewitems
-- -----------------------------------------------------


CREATE TABLE REVIEWITEMS (
  ReviewID INT NOT NULL,
  ItemID INT NOT NULL,
  ReviewItemsID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  CONSTRAINT ItemIDFKReviewItems
    FOREIGN KEY (ItemID)
    REFERENCES item (ItemID),
  CONSTRAINT ReviewIDFKReviewItems
    FOREIGN KEY (ReviewID)
    REFERENCES REVIEW (ReviewID)
);
CREATE INDEX item_id_review_items_idx ON REVIEWITEMS (ItemID);
CREATE INDEX review_id_review_items_idx ON REVIEWITEMS (ReviewID);


-- -----------------------------------------------------
-- Table stock
-- -----------------------------------------------------


CREATE TABLE STOCK (
  Price FLOAT NOT NULL,
  Quantity TINYINT NOT NULL,
  ItemID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  CONSTRAINT ItemIDFKItem
    FOREIGN KEY (ItemID)
    REFERENCES ITEM (ItemID)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);
CREATE INDEX item_id_stock_idx ON STOCK (ItemID);


-- -----------------------------------------------------
-- Table userorderitems
-- -----------------------------------------------------


CREATE TABLE USERORDERITEMS (
  UserOrderItemsID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  ItemCount TINYINT NOT NULL,
  Price FLOAT NOT NULL,
  OrderID INT NOT NULL,
  ItemID INT NOT NULL,
  CONSTRAINT ItemIDFKUserOrderItems
    FOREIGN KEY (ItemID)
    REFERENCES item (ItemID),
  CONSTRAINT OrderIDFKUserOrderItems
    FOREIGN KEY (OrderID)
    REFERENCES ORDERS (OrderID)
);
CREATE INDEX order_id_user_order_items_id_idx ON USERORDERITEMS (OrderID);
CREATE INDEX item_id_user_order_items_id_idx ON USERORDERITEMS (ItemID);
