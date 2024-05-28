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




CREATE TABLE `shopping`.`productMajorCategory` (
	name VARCHAR(255) NOT NULL PRIMARY KEY
);

INSERT INTO `shopping`.`productMajorCategory`
VALUES ('테스트1'),('테스트2'),('테스트3'),('테스트4'),('테스트5');





CREATE TABLE `shopping`.`productMiddleCategory` (
	name VARCHAR(255) NOT NULL PRIMARY KEY,
    productMajorCategory_name VARCHAR(255) NOT NULL,
    FOREIGN KEY (productMajorCategory_name) REFERENCES productMajorCategory(name)
);

INSERT INTO `shopping`.`productMiddleCategory`
VALUES ('테스트1-1','테스트1'),('테스트1-2','테스트1'),('테스트1-3','테스트1'),('테스트1-4','테스트1'),('테스트1-5','테스트1'),('테스트2-1','테스트2'),('테스트2-2','테스트2'),('테스트2-3','테스트2'),('테스트2-4','테스트2'),('테스트2-5','테스트2'),('테스트3-1','테스트3'),('테스트3-2','테스트3'),('테스트3-3','테스트3'),('테스트3-4','테스트3'),('테스트3-5','테스트3'),('테스트4-1','테스트4'),('테스트4-2','테스트4'),('테스트4-3','테스트4'),('테스트4-4','테스트4'),('테스트4-5','테스트4'),('테스트5-1','테스트5'),('테스트5-2','테스트5'),('테스트5-3','테스트5'),('테스트5-4','테스트5'),('테스트5-5','테스트5');
