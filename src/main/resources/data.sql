-- -----------------------------------------------------
-- populate users table
-- -----------------------------------------------------
insert into users ( username, gender, address, county, phone, email, status) values ('Peter', 'MALE', 'Willow park, Athlone', 'Westmeath', '08330213523', 'peter@ait.ie', '1');
insert into users ( username, gender, address, county, phone, email, status) values ('Mark', 'MALE', 'Greenfield Road', 'Dublin', '08330217436', 'mark@ait.ie', '1');
insert into users ( username, gender, address, county, phone, email, status) values ('Anne', 'FEMALE', 'Pembroke Rd', 'Dublin', '08330214286', 'anne@ait.ie', '1');
insert into users ( username, gender, address, county, phone, email, status) values ('Elizabeth', 'FEMALE', 'Parnell Square', 'Dublin', '08330214287', 'elizabeth@ait.ie', '1');
insert into users ( username, gender, address, county, phone, email, status) values ('Sophia', 'FEMALE', 'Herbert Park', 'Dublin', '08330214288', 'olivia@ait.ie', '1');
insert into users ( username, gender, address, county, phone, email, status) values ('Isabella', 'FEMALE', 'Kildare Street', 'Dublin', '08330214289', 'isabella@ait.ie', '1');
insert into users ( username, gender, address, county, phone, email, status) values ('Emma', 'FEMALE', 'Quay Street', 'Galway', '08330214281', 'emma@ait.ie', '1');
insert into users ( username, gender, address, county, phone, email, status) values ('Ava', 'FEMALE', 'Oliver Plunkett Street', 'Cork', '08330214282', 'ava@ait.ie', '1');
insert into users ( username, gender, address, county, phone, email, status) values ('Megan', 'FEMALE', 'Athlunkard Street.', 'Limerick', '08395377483', 'megan@ait.ie', '1');
insert into users ( username, gender, address, county, phone, email, status) values ('Frank', 'MALE', 'Grafton Street', 'Dublin', '08315737485', 'frank@ait.ie', '2');
insert into users ( username, gender, address, county, phone, email, status) values ('Justin', 'MALE', 'Earl Street,', 'Westmeath', '08384577413', 'justin@ait.ie', '1');
insert into users ( username, gender, address, county, phone, email, status) values ('Jaohar', 'MALE', 'Willow Park', 'Westmeath', '08330246711', 'jaohar@ait.ie', '1');
insert into users ( username, gender, address, county, phone, email, status) values ('Suzy', 'FEMALE', 'Willow Park', 'Westmeath', '0833003763', 'suzy@ait.ie', '2');
insert into users ( username, gender, address, county, phone, email, status) values ('Ubby', 'FEMALE', 'Meadowbrook', 'Westmeath', '0833357497', 'ubby@ait.ie', '1');
insert into users ( username, gender, address, county, phone, email, status) values ('Uche', 'MALE', 'Glen Abhainn', 'Westmeath', '0833027597', 'uche@ait.ie', '1');
insert into users ( username, gender, address, county, phone, email, status) values ('Efe', 'MALE', 'Meadowbrook', 'Westmeath', '0833029997', 'efe@ait.ie', '1');


-- ---------------------------------------------------------------------------------------------------------------------------------------------------
-- ---------------------------------------------------------------------------------------------------------------------------------------------------
-- ---------------------------------------------------------------------------------------------------------------------------------------------------
-- ---------------------------------------------------------------------------------------------------------------------------------------------------


-- -----------------------------------------------------
-- populate items table
-- -----------------------------------------------------
insert into items (item_name, item_price, item_description, item_quantity) values ('Bottle Water', '2.50', 'Clean and clear drinking water (50cl).', 34);
insert into items (item_name, item_price, item_description, item_quantity) values ('Coca Cola', '3.50', 'Popular Soft Drink', 23);
insert into items (item_name, item_price, item_description, item_quantity) values ('Heineken', '4.50', 'Beer for champions.', 3);
insert into items (item_name, item_price, item_description, item_quantity) values ('Samsung Galaxy S10 Plus', '985.50', 'Cutting edge smart phone with 128GB memory', 12);
insert into items (item_name, item_price, item_description, item_quantity) values ('Tetley Tea', '2.70', 'Healthy fruit and herbal team. Pack ot 50 bags.', 35);
insert into items (item_name, item_price, item_description, item_quantity) values ('Samsung S10', '885.70', '4G Smart Phone with 64GB memory', 22);
insert into items (item_name, item_price, item_description, item_quantity) values ('Iphone 11 pro', '923.40', 'Amazing apple smart phone', 15);
insert into items (item_name, item_price, item_description, item_quantity) values ('Lenovo ThinkPad', '845.50', 'Intel core-i5 Gaming Laptop', 42);
insert into items (item_name, item_price, item_description, item_quantity) values ('Dior Sauvage Eau de Toilette', '56.43', 'A radically fresh fragrance.', 44);
insert into items (item_name, item_price, item_description, item_quantity) values ('Sony PlayStation 4', '249.00', '500GB gaming console with 4 free cds.', 50);
insert into items (item_name, item_price, item_description, item_quantity) values ('Acer Nitro 5 AN515-43', '637.20', '15.6 Inch Gaming Laptop - (AMD Ryzen 5 3550H Mobile Processor, 8GB RAM, 1TB HDD, AMD Radeon RX 560X, Full HD Display, Windows 10, Black)', 11);
insert into items (item_name, item_price, item_description, item_quantity) values ('Nike Air Max 97', '270.00', 'Beautifully designed sneaker with ultra-responsive cushioning and an enhanced rubber sole', 7);
insert into items (item_name, item_price, item_description, item_quantity) values ('If It Bleeds', '13.60', 'Popular book from Stephen King', 8);
insert into items (item_name, item_price, item_description, item_quantity) values ('Logitech Z200 PC Speakers', '26.66', '10 Watts Peak Power, 2 x 3.5mm Inputs, Headphone Jack, Adjustable Bass', 4);
insert into items (item_name, item_price, item_description, item_quantity) values ('Uncle Bens Rice', '10.99', 'Long Grain 250g, 6 and Wholegrain 250g', 38);
insert into items (item_name, item_price, item_description, item_quantity) values ('Fissler vitaquick Pressure Cooker', '121.95', 'Cooking-Pot (4.5 litre capacity) with Steamer and 2 Cooking Levels', 24);



-- -----------------------------------------------------
-- populate review table
-- -----------------------------------------------------
insert into reviews(review_text, review_date, user_id, item_id) values('I really enjoyed it, great beer.','2020-04-24 12:33:22',3,3);
insert into reviews(review_text, review_date, user_id, item_id) values('It is bitter bu definitely not as much as it is exaggerated. Has a refreshing feel.','2020-04-15 10:22:32',6,3);
insert into reviews(review_text, review_date, user_id, item_id) values('Cooked it and it came out perfect. per-boiling it is also a nice option.','2020-03-30 14:30:29',12,15);
insert into reviews(review_text, review_date, user_id, item_id) values('Very fine grains which do not stick together when cooked. .','2020-02-02 18:54:22',1,15);
insert into reviews(review_text, review_date, user_id, item_id) values('Best rice I have eaten in a very long time.','2020-02-13 14:20:22',3,15);
insert into reviews(review_text, review_date, user_id, item_id) values('This phone is perfect. Has a great camera, very fast processor, sleek design, brightly rich display and most of all, it is water-proof','2020-04-21 15:15:22',2,12);
insert into reviews(review_text, review_date, user_id, item_id) values('It is amazing fast unlike my previous phone. No lagging whatsoever despite installing many games.','2020-04-07 07:59:24',9,12);
insert into reviews(review_text, review_date, user_id, item_id) values('Synchronizes perfectly with my Samsung watch and the ear buds are just perfect','2020-04-07 11:34:12',16,12);
insert into reviews(review_text, review_date, user_id, item_id) values('Sound quality is excellent as well as very powerful camera','2020-04-14 12:19:05',7,12);
insert into reviews(review_text, review_date, user_id, item_id) values('The fragrance lasts a whole day','2020-04-24 13:10:22',8,9);
insert into reviews(review_text, review_date, user_id, item_id) values('Great perfume. Does not stain my clothes and fragrance is mild and gentle.','2020-04-19 14:17:02',11,9);
insert into reviews(review_text, review_date, user_id, item_id) values('Very lovely tea..','2020-04-19 15:17:02',11,5);
insert into reviews(review_text, review_date, user_id, item_id) values('Tastes great without sugar and gives a relaxing feel.','2020-04-12 11:14:52',1,5);
insert into reviews(review_text, review_date, user_id, item_id) values('This was a very good deal. Fast computer and powerful processor..','2020-03-12 11:13:53',2,8);
insert into reviews(review_text, review_date, user_id, item_id) values('I consider this a good buy. It is very fast and has a good display resolution quality.','2020-02-22 10:14:34',4,8);
insert into reviews(review_text, review_date, user_id, item_id) values('It is very rugged and durable. Fallen from my hands a few times but no damage to it.','2020-03-27 17:16:25',13,8);
insert into reviews(review_text, review_date, user_id, item_id) values('You get more returns than your investment the moment you start devouring page after page of this book.','2020-04-21 08:49:25',15,13);
insert into reviews(review_text, review_date, user_id, item_id) values('The best part of this book is how it really sets the stage for the mentality a person should have if they want to get rich.','2019-09-14 18:34:45',6,13);
insert into reviews(review_text, review_date, user_id, item_id) values('This book is so well written that you gonna fall in love with the story and theory. This book will help you understand and structure your life on right principles.','2020-01-11 08:28:26',12,13);