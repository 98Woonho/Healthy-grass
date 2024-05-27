CREATE DATABASE IF NOT EXISTS `shopping`;
USE `shopping`;



--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;

CREATE TABLE `shopping`.`user` (
  `id` varchar(50) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `password` varchar(150) DEFAULT NULL,
  `pwchkHint` varchar(80) DEFAULT NULL,
  `pwchkAns` varchar(100) DEFAULT NULL,
  `zipcode` varchar(80) DEFAULT NULL,
  `streetAdr` varchar(100) DEFAULT NULL,
  `detailAdr` varchar(100) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `role` varchar(20) DEFAULT NULL,
  `provider` varchar(80) DEFAULT NULL,
  `providerId` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `user` WRITE;

INSERT INTO `shopping`.`user` VALUES ('dsfasdf12','황보성현','$2a$10$p71WOPvNlnseiexXfBjIp.71ruw6uCOACfi85xwc7ElJZrLuR6Efa','memorable_place','123','04766','서울 성동구 서울숲길 17','123','01042162330','hbsh2330@naver.com','ROLE_USER',NULL,NULL),('fdjopasji12','황보성현','$2a$10$5OfUJfpOV9T0C/Iwe.rHFuiLNcutLqeG.id3mknHWRouNjsJFGrKW','memorable_place','123','43109','대구 군위군 군위읍 개봉길 23-72','123','010-4216-2330','hbsh2330@naver.com','ROLE_USER',NULL,NULL),('hbbsh1311','황보성현','$2a$10$JJ7yJq8OmrFG50VuJVOeF.XkD13kRN74j1H1xNpU/EkayQu866eo6','memorable_place','돈','43109','대구 군위군 군위읍 개봉길 23-72','','01042162330','hbsh2330@naver.com','ROLE_USER',NULL,NULL),('user1','John Doe','password1','First pet?','Fluffy','12345','123 Main St','Apt 101','010-1234-5671','user1@example.com','user','google','google_user1'),('user10','Jason Yellow','password10','Favorite sport?','Soccer','01234','012 Aspen St','Apt 1010','010-1234-5680','user10@example.com','user','facebook','facebook_user10'),('user11','Jacob Orange','password11','First car?','Honda','12345','123 Chestnut St','Apt 1111','010-1234-5681','user11@example.com','user','google','google_user11'),('user12','Joan Pink','password12','Best friend\'s name?','Alice','23456','234 Fir St','Apt 1212','010-1234-5682','user12@example.com','user','facebook','facebook_user12'),('user13','Jerome Gray','password13','Favorite vacation spot?','Paris','34567','345 Hemlock St','Apt 1313','010-1234-5683','user13@example.com','user','google','google_user13'),('user14','Jasmine Brown','password14','Favorite hobby?','Reading','45678','456 Juniper St','Apt 1414','010-1234-5684','user14@example.com','user','facebook','facebook_user14'),('user15','Javier Cyan','password15','Favorite band?','Beatles','56789','567 Poplar St','Apt 1515','010-1234-5685','user15@example.com','user','google','google_user15'),('user16','Jocelyn Indigo','password16','First job?','Barista','67890','678 Walnut St','Apt 1616','010-1234-5686','user16@example.com','user','facebook','facebook_user16'),('user17','Jordan Teal','password17','First concert?','U2','78901','789 Alder St','Apt 1717','010-1234-5687','user17@example.com','user','google','google_user17'),('user18','Julia Magenta','password18','High school mascot?','Tigers','89012','890 Hickory St','Apt 1818','010-1234-5688','user18@example.com','user','facebook','facebook_user18'),('user19','Justin Gold','password19','Favorite actor?','DiCaprio','90123','901 Sycamore St','Apt 1919','010-1234-5689','user19@example.com','user','google','google_user19'),('user2','Jane Smith','password2','Mother\'s maiden name?','Smith','23456','234 Oak St','Apt 202','010-1234-5672','user2@example.com','user','facebook','facebook_user2'),('user20','Jared Silver','password20','Favorite drink?','Coffee','01234','012 Redwood St','Apt 2020','010-1234-5690','user20@example.com','user','facebook','facebook_user20'),('user21','Joy Coral','password21','Dream job?','Chef','12345','123 Willow St','Apt 2121','010-1234-5691','user21@example.com','user','google','google_user21'),('user22','June Bronze','password22','Favorite car brand?','Toyota','23456','234 Birch St','Apt 2222','010-1234-5692','user22@example.com','user','facebook','facebook_user22'),('user23','Jules Ruby','password23','Favorite dessert?','Cake','34567','345 Maple St','Apt 2323','010-1234-5693','user23@example.com','user','google','google_user23'),('user24','Janet Emerald','password24','First phone?','Nokia','45678','456 Aspen St','Apt 2424','010-1234-5694','user24@example.com','user','facebook','facebook_user24'),('user25','Jackson Turquoise','password25','Favorite instrument?','Guitar','56789','567 Cedar St','Apt 2525','010-1234-5695','user25@example.com','user','google','google_user25'),('user26','Joanna Lavender','password26','Favorite flower?','Rose','67890','678 Elm St','Apt 2626','010-1234-5696','user26@example.com','user','facebook','facebook_user26'),('user27','Jaden Violet','password27','Favorite TV show?','Friends','78901','789 Pine St','Apt 2727','010-1234-5697','user27@example.com','user','google','google_user27'),('user28','Jada Mint','password28','Favorite season?','Winter','89012','890 Oak St','Apt 2828','010-1234-5698','user28@example.com','user','facebook','facebook_user28'),('user29','Jamie Amber','password29','Favorite holiday?','Christmas','90123','901 Fir St','Apt 2929','010-1234-5699','user29@example.com','user','google','google_user29'),('user3','Jim Brown','password3','Favorite color?','Blue','34567','345 Pine St','Apt 303','010-1234-5673','user3@example.com','user','google','google_user3'),('user30','Jeremy Sapphire','password30','Favorite animal?','Cat','01234','012 Hemlock St','Apt 3030','010-1234-5700','user30@example.com','user','facebook','facebook_user30'),('user4','Jack White','password4','First school?','Greenwood','45678','456 Birch St','Apt 404','010-1234-5674','user4@example.com','user','facebook','facebook_user4'),('user5','Jill Black','password5','Favorite food?','Pizza','56789','567 Cedar St','Apt 505','010-1234-5675','user5@example.com','user','google','google_user5'),('user6','Joe Green','password6','Birth city?','Seoul','67890','678 Elm St','Apt 606','010-1234-5676','user6@example.com','user','facebook','facebook_user6'),('user7','Jenny Blue','password7','Favorite animal?','Dog','78901','789 Maple St','Apt 707','010-1234-5677','user7@example.com','user','google','google_user7'),('user8','Jeff Red','password8','Favorite book?','1984','89012','890 Spruce St','Apt 808','010-1234-5678','user8@example.com','user','facebook','facebook_user8'),('user9','Julie Purple','password9','Favorite movie?','Inception','90123','901 Willow St','Apt 909','010-1234-5679','user9@example.com','user','google','google_user9');

UNLOCK TABLES;



DROP TABLE IF EXISTS `cart`;

CREATE TABLE `shopping`.`cart` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `Uid` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Cart_User_idx` (`Uid`),
  CONSTRAINT `FK_Cart_User` FOREIGN KEY (`Uid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `cart` WRITE;
UNLOCK TABLES;







DROP TABLE IF EXISTS `customerinquiryboard`;

CREATE TABLE `shopping`.`customerinquiryboard` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `Uid` varchar(50) NOT NULL,
  `title` varchar(100) DEFAULT NULL,
  `content` text,
  `imgPath` varchar(200) DEFAULT NULL,
  `imgName` varchar(100) DEFAULT NULL,
  `regDate` date DEFAULT NULL,
  `updateDate` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_CustomerInquiryBoard_User_idx` (`Uid`),
  CONSTRAINT `FK_CustomerInquiryBoard_User` FOREIGN KEY (`Uid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `customerinquiryboard` WRITE;
UNLOCK TABLES;








DROP TABLE IF EXISTS `customerinquirycomment`;

CREATE TABLE `shopping`.`customerinquirycomment` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `C_Board_id` bigint NOT NULL,
  `title` varchar(100) DEFAULT NULL,
  `comment` text,
  `imgPath` varchar(200) DEFAULT NULL,
  `imgName` varchar(100) DEFAULT NULL,
  `regDate` date DEFAULT NULL,
  `updateDate` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_CustomerInquiryComment_CustomerInquiryBoard_idx` (`C_Board_id`),
  CONSTRAINT `FK_CustomerInquiryComment_CustomerInquiryBoard` FOREIGN KEY (`C_Board_id`) REFERENCES `customerinquiryboard` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `customerinquirycomment` WRITE;
UNLOCK TABLES;







DROP TABLE IF EXISTS `order`;

CREATE TABLE `shopping`.`order` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `Uid` varchar(50) NOT NULL,
  `total_amount` int DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Order_User_Uid_idx` (`Uid`),
  CONSTRAINT `FK_Order_User_Uid` FOREIGN KEY (`Uid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `order` WRITE;

INSERT INTO `shopping`.`order` VALUES (1,'user1',1500,'pending'),(2,'user1',2500,'completed'),(3,'user1',3000,'shipped'),(4,'user1',2000,'completed'),(5,'user1',1800,'canceled'),(6,'user1',2200,'completed'),(7,'user1',2700,'pending'),(8,'user1',3500,'shipped'),(9,'user1',4000,'completed'),(10,'user1',2300,'canceled'),(11,'user2',2100,'pending'),(12,'user2',3200,'completed'),(13,'user2',1800,'shipped'),(14,'user2',2400,'completed'),(15,'user2',2900,'canceled'),(16,'user2',3300,'completed'),(17,'user2',2600,'pending'),(18,'user2',3700,'shipped'),(19,'user2',4100,'completed'),(20,'user2',1500,'canceled');

UNLOCK TABLES;










--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;

CREATE TABLE `shopping`.`payment` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `Oid` bigint DEFAULT NULL,
  `amount` int DEFAULT NULL,
  `payment_method` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `transaction_id` varchar(100) DEFAULT NULL,
  `regDate` date DEFAULT NULL,
  `updateDate` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Payment_Order_Oid_idx` (`Oid`),
  CONSTRAINT `FK_Payment_Order_Oid` FOREIGN KEY (`Oid`) REFERENCES `order` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;

UNLOCK TABLES;










--
-- Table structure for table `persistent_logins`
--

DROP TABLE IF EXISTS `persistent_logins`;

CREATE TABLE `shopping`.`persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


--
-- Dumping data for table `persistent_logins`
--

LOCK TABLES `persistent_logins` WRITE;

UNLOCK TABLES;









--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;

CREATE TABLE `shopping`.`product` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `price` int DEFAULT NULL,
  `amount` int DEFAULT NULL,
  `saleAmount` int DEFAULT NULL,
  `discount` int DEFAULT NULL,
  `majorCategory` varchar(50) DEFAULT NULL,
  `middleCategory` varchar(50) DEFAULT NULL,
  `content` text,
  `regDate` date DEFAULT NULL,
  `updateDate` date DEFAULT NULL,
  `mainImgPath` varchar(200) DEFAULT NULL,
  `mainImgName` varchar(100) DEFAULT NULL,
  `subImgPath` varchar(200) DEFAULT NULL,
  `subImgName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;

INSERT INTO `shopping`.`product` VALUES (2,'Product 1',10000,50,10,10,'Electronics','Mobile',NULL,'2024-05-01','2024-05-10','/images/products/p1.jpg','p1.jpg',NULL,NULL),(3,'Product 2',20000,30,5,15,'Electronics','Laptop',NULL,'2024-05-02','2024-05-11','/images/products/p2.jpg','p2.jpg',NULL,NULL),(4,'Product 3',15000,40,20,5,'Home Appliances','Refrigerator',NULL,'2024-05-03','2024-05-12','/images/products/p3.jpg','p3.jpg',NULL,NULL),(5,'Product 4',5000,60,25,8,'Electronics','Headphones',NULL,'2024-05-04','2024-05-13','/images/products/p4.jpg','p4.jpg',NULL,NULL),(6,'Product 5',3000,80,30,12,'Books','Fiction',NULL,'2024-05-05','2024-05-14','/images/products/p5.jpg','p5.jpg',NULL,NULL),(7,'Product 6',25000,20,15,20,'Fashion','Shoes',NULL,'2024-05-06','2024-05-15','/images/products/p6.jpg','p6.jpg',NULL,NULL),(8,'Product 7',12000,70,35,10,'Fashion','Clothes',NULL,'2024-05-07','2024-05-16','/images/products/p7.jpg','p7.jpg',NULL,NULL),(9,'Product 8',9000,90,40,5,'Books','Non-Fiction',NULL,'2024-05-08','2024-05-17','/images/products/p8.jpg','p8.jpg',NULL,NULL),(10,'Product 9',4500,100,45,15,'Home Appliances','Microwave',NULL,'2024-05-09','2024-05-18','/images/products/p9.jpg','p9.jpg',NULL,NULL),(11,'Product 10',7500,50,10,10,'Toys','Action Figures',NULL,'2024-05-10','2024-05-19','/images/products/p10.jpg','p10.jpg',NULL,NULL),(12,'Product 11',30000,25,8,20,'Electronics','Tablet',NULL,'2024-05-11','2024-05-20','/images/products/p11.jpg','p11.jpg',NULL,NULL),(13,'Product 12',1000,150,50,5,'Books','Children',NULL,'2024-05-12','2024-05-21','/images/products/p12.jpg','p12.jpg',NULL,NULL),(14,'Product 13',2000,120,55,8,'Toys','Educational',NULL,'2024-05-13','2024-05-22','/images/products/p13.jpg','p13.jpg',NULL,NULL),(15,'Product 14',18000,35,12,10,'Fashion','Accessories',NULL,'2024-05-14','2024-05-23','/images/products/p14.jpg','p14.jpg',NULL,NULL),(16,'Product 15',6000,75,20,12,'Electronics','Wearables',NULL,'2024-05-15','2024-05-24','/images/products/p15.jpg','p15.jpg',NULL,NULL),(17,'Product 16',8500,85,25,15,'Home Appliances','Vacuum',NULL,'2024-05-16','2024-05-25','/images/products/p16.jpg','p16.jpg',NULL,NULL),(18,'Product 17',12500,55,30,10,'Fashion','Bags',NULL,'2024-05-17','2024-05-26','/images/products/p17.jpg','p17.jpg',NULL,NULL),(19,'Product 18',9500,65,35,5,'Books','Science',NULL,'2024-05-18','2024-05-27','/images/products/p18.jpg','p18.jpg',NULL,NULL),(20,'Product 19',10500,45,40,8,'Toys','Puzzles',NULL,'2024-05-19','2024-05-28','/images/products/p19.jpg','p19.jpg',NULL,NULL),(21,'Product 20',7000,95,20,12,'Electronics','Camera',NULL,'2024-05-20','2024-05-29','/images/products/p20.jpg','p20.jpg',NULL,NULL),(22,'Product 21',35000,15,10,20,'Home Appliances','Washing Machine',NULL,'2024-05-21','2024-05-30','/images/products/p21.jpg','p21.jpg',NULL,NULL),(23,'Product 22',4000,105,25,5,'Books','Fantasy',NULL,'2024-05-22','2024-05-31','/images/products/p22.jpg','p22.jpg',NULL,NULL),(24,'Product 23',8000,110,30,15,'Fashion','Jackets',NULL,'2024-05-23','2024-06-01','/images/products/p23.jpg','p23.jpg',NULL,NULL),(25,'Product 24',5500,60,35,10,'Electronics','Speakers',NULL,'2024-05-24','2024-06-02','/images/products/p24.jpg','p24.jpg',NULL,NULL),(26,'Product 25',20000,25,40,12,'Home Appliances','Oven',NULL,'2024-05-25','2024-06-03','/images/products/p25.jpg','p25.jpg',NULL,NULL),(27,'Product 26',17500,20,45,8,'Fashion','Hats',NULL,'2024-05-26','2024-06-04','/images/products/p26.jpg','p26.jpg',NULL,NULL),(28,'Product 27',6500,90,50,10,'Toys','Board Games',NULL,'2024-05-27','2024-06-05','/images/products/p27.jpg','p27.jpg',NULL,NULL),(29,'Product 28',14000,45,55,15,'Books','Comics',NULL,'2024-05-28','2024-06-06','/images/products/p28.jpg','p28.jpg',NULL,NULL),(30,'Product 29',22000,30,60,5,'Electronics','Smartwatch',NULL,'2024-05-29','2024-06-07','/images/products/p29.jpg','p29.jpg',NULL,NULL),(31,'Product 30',500,200,65,20,'Books','Poetry',NULL,'2024-05-30','2024-06-08','/images/products/p30.jpg','p30.jpg',NULL,NULL);

UNLOCK TABLES;












DROP TABLE IF EXISTS `cartitems`;

CREATE TABLE `shopping`.`cartitems` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `Cart_Id` bigint NOT NULL,
  `Pid` bigint NOT NULL,
  `quantity` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Cart_CartItems_idx` (`Cart_Id`),
  KEY `FK_CartItems_Product_idx` (`Pid`),
  CONSTRAINT `FK_CartItems_Cart` FOREIGN KEY (`Cart_Id`) REFERENCES `cart` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_CartItems_Product` FOREIGN KEY (`Pid`) REFERENCES `product` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `cartitems` WRITE;
UNLOCK TABLES;






DROP TABLE IF EXISTS `orderitem`;

CREATE TABLE `shopping`.`orderitem` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `Oid` bigint NOT NULL,
  `Pid` bigint NOT NULL,
  `qunatity` int DEFAULT NULL,
  `price` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_OrderItem_Order_Oid_idx` (`Oid`),
  KEY `FK_OrderItem_Product_Pid_idx` (`Pid`),
  CONSTRAINT `FK_OrderItem_Order_Oid` FOREIGN KEY (`Oid`) REFERENCES `order` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_OrderItem_Product_Pid` FOREIGN KEY (`Pid`) REFERENCES `product` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `orderitem` WRITE;

INSERT INTO `shopping`.`orderitem` VALUES (31,1,2,1,1200),(32,2,3,3,1500),(33,2,4,1,3200),(34,3,5,2,900),(35,3,6,4,2000),(36,4,7,1,2400),(37,4,8,2,3000),(38,5,9,3,1100),(39,5,10,1,2900),(40,6,11,2,1700),(41,6,12,3,2500),(42,7,13,1,2600),(43,7,14,2,2800),(44,8,15,3,1900),(45,8,16,4,2700),(46,9,17,1,4100),(47,9,18,2,3500),(48,10,19,3,1300),(49,10,20,1,1500),(50,1,21,2,2100),(51,2,22,1,3200),(52,3,23,3,1800),(53,4,24,1,2400),(54,5,25,2,2900),(55,6,26,3,3300),(56,7,27,1,2600),(57,8,28,2,3700),(58,9,29,3,4100),(59,10,30,1,1500);

UNLOCK TABLES;








--
-- Table structure for table `productinquiryboard`
--

DROP TABLE IF EXISTS `productinquiryboard`;

CREATE TABLE `shopping`.`productinquiryboard` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `Pid` bigint NOT NULL,
  `Uid` varchar(50) NOT NULL,
  `title` varchar(100) DEFAULT NULL,
  `content` text,
  `regDate` date DEFAULT NULL,
  `updateDate` date DEFAULT NULL,
  `isLocked` varchar(10) DEFAULT NULL,
  `password` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ProductInquiryBoard_Proudct_idx` (`Pid`),
  KEY `FK_ProductInquiryBoard_User_idx` (`Uid`),
  CONSTRAINT `FK_ProductInquiryBoard_Proudct` FOREIGN KEY (`Pid`) REFERENCES `product` (`id`),
  CONSTRAINT `FK_ProductInquiryBoard_User` FOREIGN KEY (`Uid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


--
-- Dumping data for table `productinquiryboard`
--

LOCK TABLES `productinquiryboard` WRITE;

UNLOCK TABLES;













--
-- Table structure for table `productinquiryboardcomment`
--

DROP TABLE IF EXISTS `productinquiryboardcomment`;

CREATE TABLE `shopping`.`productinquiryboardcomment` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `P_Board_Id` bigint NOT NULL,
  `title` varchar(100) DEFAULT NULL,
  `content` text,
  `regDate` date DEFAULT NULL,
  `updateDate` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ProductInquiryBoardComment_ProductInquiryBoard_idx` (`P_Board_Id`),
  CONSTRAINT `FK_ProductInquiryBoardComment_ProductInquiryBoard` FOREIGN KEY (`P_Board_Id`) REFERENCES `productinquiryboard` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


--
-- Dumping data for table `productinquiryboardcomment`
--

LOCK TABLES `productinquiryboardcomment` WRITE;

UNLOCK TABLES;







--
-- Table structure for table `productreviewboard`
--

DROP TABLE IF EXISTS `productreviewboard`;

CREATE TABLE `shopping`.`productreviewboard` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `Pid` bigint NOT NULL,
  `Uid` varchar(50) NOT NULL,
  `title` varchar(100) DEFAULT NULL,
  `regDate` date DEFAULT NULL,
  `updateDate` date DEFAULT NULL,
  `content` text,
  `imgPath` varchar(200) DEFAULT NULL,
  `imgName` varchar(100) DEFAULT NULL,
  `rating` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ProductReviewBoard_Product_idx` (`Pid`),
  KEY `FK_ProductReviewBoard_User_idx` (`Uid`),
  CONSTRAINT `FK_ProductReviewBoard_Product` FOREIGN KEY (`Pid`) REFERENCES `product` (`id`),
  CONSTRAINT `FK_ProductReviewBoard_User` FOREIGN KEY (`Uid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=108 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


--
-- Dumping data for table `productreviewboard`
--

LOCK TABLES `productreviewboard` WRITE;

INSERT INTO `shopping`.`productreviewboard` VALUES (31,2,'user2','Not bad','2024-05-03','2024-05-04','It works well, but could be improved.','/images/reviews/','review2.jpg',3),(32,3,'user3','Excellent Quality','2024-05-05','2024-05-06','The quality of this product is top-notch.','/images/reviews/','review3.jpg',4),(33,4,'user4','Very Satisfied','2024-05-07','2024-05-08','I am very satisfied with this purchase.','/images/reviews/','review4.jpg',5),(34,5,'user5','Good Value','2024-05-09','2024-05-10','Good value for the price. Worth buying.','/images/reviews/','review5.jpg',4),(35,6,'user6','Highly Recommend','2024-05-11','2024-05-12','I highly recommend this product to everyone.','/images/reviews/','review6.jpg',5),(36,7,'user7','Just Okay','2024-05-13','2024-05-14','It is just okay, not what I expected.','/images/reviews/','review7.jpg',3),(37,8,'user8','Very Happy','2024-05-15','2024-05-16','I am very happy with this product.','/images/reviews/','review8.jpg',4),(38,9,'user9','Fantastic!','2024-05-17','2024-05-18','This product is fantastic. Love it!','/images/reviews/','review9.jpg',5),(39,10,'user10','Meets Expectations','2024-05-19','2024-05-20','It meets my expectations. Good product.','/images/reviews/','review10.jpg',4),(40,11,'user11','Works Well','2024-05-21','2024-05-22','The product works well as described.','/images/reviews/','review11.jpg',4),(41,12,'user12','Could Be Better','2024-05-23','2024-05-24','It could be better. Some issues found.','/images/reviews/','review12.jpg',3),(42,13,'user13','Superb Quality','2024-05-25','2024-05-26','The quality is superb. Very satisfied.','/images/reviews/','review13.jpg',5),(43,14,'user14','Not Satisfied','2024-05-27','2024-05-28','I am not satisfied with this product.','/images/reviews/','review14.jpg',2),(44,15,'user15','Good Product','2024-05-29','2024-05-30','This is a good product. Worth it.','/images/reviews/','review15.jpg',4),(45,16,'user16','Love It!','2024-05-31','2024-06-01','Absolutely love this product!','/images/reviews/','review16.jpg',5),(46,17,'user17','Average','2024-06-02','2024-06-03','It is average, nothing special.','/images/reviews/','review17.jpg',3),(47,18,'user18','Very Useful','2024-06-04','2024-06-05','Very useful and practical product.','/images/reviews/','review18.jpg',5),(48,19,'user19','Disappointed','2024-06-06','2024-06-07','I am disappointed with the quality.','/images/reviews/','review19.jpg',2),(49,20,'user20','Excellent','2024-06-08','2024-06-09','Excellent product. Will buy again.','/images/reviews/','review20.jpg',5),(50,21,'user21','Not Worth It','2024-06-10','2024-06-11','Not worth the money spent.','/images/reviews/','review21.jpg',2),(51,22,'user22','Very Good','2024-06-12','2024-06-13','Very good product. Happy with it.','/images/reviews/','review22.jpg',4),(52,23,'user23','Quality Product','2024-06-14','2024-06-15','The product is of high quality.','/images/reviews/','review23.jpg',5),(53,24,'user24','Regret Buying','2024-06-16','2024-06-17','I regret buying this product.','/images/reviews/','review24.jpg',1),(54,25,'user25','Good Purchase','2024-06-18','2024-06-19','This was a good purchase. Satisfied.','/images/reviews/','review25.jpg',4),(55,26,'user26','Very Happy','2024-06-20','2024-06-21','I am very happy with this product.','/images/reviews/','review26.jpg',5),(56,27,'user27','Could Be Improved','2024-06-22','2024-06-23','It could be improved in some areas.','/images/reviews/','review27.jpg',3),(57,28,'user28','Highly Satisfied','2024-06-24','2024-06-25','I am highly satisfied with this product.','/images/reviews/','review28.jpg',5),(58,29,'user29','Not Good','2024-06-26','2024-06-27','The product is not good. Disappointed.','/images/reviews/','review29.jpg',2),(59,30,'user30','Amazing Product','2024-06-28','2024-06-29','This product is amazing. Love it!','/images/reviews/','review30.jpg',5),(60,31,'user1','Great Product!','2024-05-01','2024-05-02','This product is amazing. Highly recommend!','/images/reviews/','review1.jpg',5),(61,2,'user2','Not bad','2024-05-03','2024-05-04','It works well, but could be improved.','/images/reviews/','review2.jpg',3),(62,3,'user3','Excellent Quality','2024-05-05','2024-05-06','The quality of this product is top-notch.','/images/reviews/','review3.jpg',4),(63,4,'user4','Very Satisfied','2024-05-07','2024-05-08','I am very satisfied with this purchase.','/images/reviews/','review4.jpg',5),(64,5,'user5','Good Value','2024-05-09','2024-05-10','Good value for the price. Worth buying.','/images/reviews/','review5.jpg',4),(65,6,'user6','Highly Recommend','2024-05-11','2024-05-12','I highly recommend this product to everyone.','/images/reviews/','review6.jpg',5),(66,7,'user7','Just Okay','2024-05-13','2024-05-14','It is just okay, not what I expected.','/images/reviews/','review7.jpg',3),(67,8,'user8','Very Happy','2024-05-15','2024-05-16','I am very happy with this product.','/images/reviews/','review8.jpg',4),(68,9,'user9','Fantastic!','2024-05-17','2024-05-18','This product is fantastic. Love it!','/images/reviews/','review9.jpg',5),(69,10,'user10','Meets Expectations','2024-05-19','2024-05-20','It meets my expectations. Good product.','/images/reviews/','review10.jpg',4),(70,11,'user11','Works Well','2024-05-21','2024-05-22','The product works well as described.','/images/reviews/','review11.jpg',4),(71,12,'user12','Could Be Better','2024-05-23','2024-05-24','It could be better. Some issues found.','/images/reviews/','review12.jpg',3),(72,13,'user13','Superb Quality','2024-05-25','2024-05-26','The quality is superb. Very satisfied.','/images/reviews/','review13.jpg',5),(73,14,'user14','Not Satisfied','2024-05-27','2024-05-28','I am not satisfied with this product.','/images/reviews/','review14.jpg',2),(74,15,'user15','Good Product','2024-05-29','2024-05-30','This is a good product. Worth it.','/images/reviews/','review15.jpg',4),(75,16,'user16','Love It!','2024-05-31','2024-06-01','Absolutely love this product!','/images/reviews/','review16.jpg',5),(76,17,'user17','Average','2024-06-02','2024-06-03','It is average, nothing special.','/images/reviews/','review17.jpg',3),(77,18,'user18','Very Useful','2024-06-04','2024-06-05','Very useful and practical product.','/images/reviews/','review18.jpg',5),(78,19,'user19','Disappointed','2024-06-06','2024-06-07','I am disappointed with the quality.','/images/reviews/','review19.jpg',2),(79,20,'user20','Excellent','2024-06-08','2024-06-09','Excellent product. Will buy again.','/images/reviews/','review20.jpg',5),(80,21,'user21','Not Worth It','2024-06-10','2024-06-11','Not worth the money spent.','/images/reviews/','review21.jpg',2),(81,22,'user22','Very Good','2024-06-12','2024-06-13','Very good product. Happy with it.','/images/reviews/','review22.jpg',4),(82,23,'user23','Quality Product','2024-06-14','2024-06-15','The product is of high quality.','/images/reviews/','review23.jpg',5),(83,2,'user2','Not bad','2024-05-03','2024-05-04','It works well, but could be improved.','/images/reviews/','review2.jpg',3),(84,3,'user3','Excellent Quality','2024-05-05','2024-05-06','The quality of this product is top-notch.','/images/reviews/','review3.jpg',4),(85,4,'user4','Very Satisfied','2024-05-07','2024-05-08','I am very satisfied with this purchase.','/images/reviews/','review4.jpg',5),(86,5,'user5','Good Value','2024-05-09','2024-05-10','Good value for the price. Worth buying.','/images/reviews/','review5.jpg',4),(87,6,'user6','Highly Recommend','2024-05-11','2024-05-12','I highly recommend this product to everyone.','/images/reviews/','review6.jpg',5),(88,7,'user7','Just Okay','2024-05-13','2024-05-14','It is just okay, not what I expected.','/images/reviews/','review7.jpg',3),(89,8,'user8','Very Happy','2024-05-15','2024-05-16','I am very happy with this product.','/images/reviews/','review8.jpg',4),(90,9,'user9','Fantastic!','2024-05-17','2024-05-18','This product is fantastic. Love it!','/images/reviews/','review9.jpg',5),(91,10,'user10','Meets Expectations','2024-05-19','2024-05-20','It meets my expectations. Good product.','/images/reviews/','review10.jpg',4),(92,11,'user11','Works Well','2024-05-21','2024-05-22','The product works well as described.','/images/reviews/','review11.jpg',4),(93,12,'user12','Could Be Better','2024-05-23','2024-05-24','It could be better. Some issues found.','/images/reviews/','review12.jpg',3),(94,13,'user13','Superb Quality','2024-05-25','2024-05-26','The quality is superb. Very satisfied.','/images/reviews/','review13.jpg',5),(95,14,'user14','Not Satisfied','2024-05-27','2024-05-28','I am not satisfied with this product.','/images/reviews/','review14.jpg',2),(96,15,'user15','Good Product','2024-05-29','2024-05-30','This is a good product. Worth it.','/images/reviews/','review15.jpg',4),(97,16,'user16','Love It!','2024-05-31','2024-06-01','Absolutely love this product!','/images/reviews/','review16.jpg',5),(98,17,'user17','Average','2024-06-02','2024-06-03','It is average, nothing special.','/images/reviews/','review17.jpg',3),(99,2,'user2','Not bad','2024-05-03','2024-05-04','It works well, but could be improved.','/images/reviews/','review2.jpg',3),(100,3,'user3','Excellent Quality','2024-05-05','2024-05-06','The quality of this product is top-notch.','/images/reviews/','review3.jpg',4),(101,4,'user4','Very Satisfied','2024-05-07','2024-05-08','I am very satisfied with this purchase.','/images/reviews/','review4.jpg',5),(102,5,'user5','Good Value','2024-05-09','2024-05-10','Good value for the price. Worth buying.','/images/reviews/','review5.jpg',4),(103,6,'user6','Highly Recommend','2024-05-11','2024-05-12','I highly recommend this product to everyone.','/images/reviews/','review6.jpg',5),(104,7,'user7','Just Okay','2024-05-13','2024-05-14','It is just okay, not what I expected.','/images/reviews/','review7.jpg',3),(105,8,'user8','Very Happy','2024-05-15','2024-05-16','I am very happy with this product.','/images/reviews/','review8.jpg',4),(106,9,'user9','Fantastic!','2024-05-17','2024-05-18','This product is fantastic. Love it!','/images/reviews/','review9.jpg',5),(107,10,'user10','Meets Expectations','2024-05-19','2024-05-20','It meets my expectations. Good product.','/images/reviews/','review10.jpg',4);

UNLOCK TABLES;










--
-- Table structure for table `shippingaddress`
--

DROP TABLE IF EXISTS `shippingaddress`;

CREATE TABLE `shopping`.`shippingaddress` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `Uid` varchar(50) NOT NULL,
  `recipient_name` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `zipcode` varchar(100) DEFAULT NULL,
  `streetAdr` varchar(100) DEFAULT NULL,
  `detailAdr` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ShippingAddress_User_idx` (`Uid`),
  CONSTRAINT `FK_ShippingAddress_User` FOREIGN KEY (`Uid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


--
-- Dumping data for table `shippingaddress`
--

LOCK TABLES `shippingaddress` WRITE;

UNLOCK TABLES;








--
-- Table structure for table `wishlist`
--

DROP TABLE IF EXISTS `wishlist`;

CREATE TABLE `shopping`.`wishlist` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `Pid` bigint NOT NULL,
  `Uid` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_WishList_Uid_idx` (`Uid`),
  KEY `FK_WishList_Pid_idx` (`Pid`),
  CONSTRAINT `FK_WishList_Pid` FOREIGN KEY (`Pid`) REFERENCES `product` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_WishList_Uid` FOREIGN KEY (`Uid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


--
-- Dumping data for table `wishlist`
--

LOCK TABLES `wishlist` WRITE;

UNLOCK TABLES;

--
-- Dumping events for database 'shopping'
--

--
-- Dumping routines for database 'shopping'
--


-- Dump completed on 2024-05-26 17:31:00
