CREATE DATABASE  IF NOT EXISTS `shopping` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `shopping`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: shopping
-- ------------------------------------------------------
-- Server version	8.0.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `Uid` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Cart_User_idx` (`Uid`),
  CONSTRAINT `FK_Cart_User` FOREIGN KEY (`Uid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cartitems`
--

DROP TABLE IF EXISTS `cartitems`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cartitems` (
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cartitems`
--

LOCK TABLES `cartitems` WRITE;
/*!40000 ALTER TABLE `cartitems` DISABLE KEYS */;
/*!40000 ALTER TABLE `cartitems` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customerinquiryboard`
--

DROP TABLE IF EXISTS `customerinquiryboard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customerinquiryboard` (
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customerinquiryboard`
--

LOCK TABLES `customerinquiryboard` WRITE;
/*!40000 ALTER TABLE `customerinquiryboard` DISABLE KEYS */;
/*!40000 ALTER TABLE `customerinquiryboard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customerinquirycomment`
--

DROP TABLE IF EXISTS `customerinquirycomment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customerinquirycomment` (
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customerinquirycomment`
--

LOCK TABLES `customerinquirycomment` WRITE;
/*!40000 ALTER TABLE `customerinquirycomment` DISABLE KEYS */;
/*!40000 ALTER TABLE `customerinquirycomment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `Uid` varchar(50) NOT NULL,
  `total_amount` int DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Order_User_Uid_idx` (`Uid`),
  CONSTRAINT `FK_Order_User_Uid` FOREIGN KEY (`Uid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderitem`
--

DROP TABLE IF EXISTS `orderitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderitem` (
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderitem`
--

LOCK TABLES `orderitem` WRITE;
/*!40000 ALTER TABLE `orderitem` DISABLE KEYS */;
/*!40000 ALTER TABLE `orderitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment` (
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persistent_logins`
--

DROP TABLE IF EXISTS `persistent_logins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persistent_logins`
--

LOCK TABLES `persistent_logins` WRITE;
/*!40000 ALTER TABLE `persistent_logins` DISABLE KEYS */;
/*!40000 ALTER TABLE `persistent_logins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `price` int DEFAULT NULL,
  `amount` int DEFAULT NULL,
  `saleAmount` int DEFAULT NULL,
  `discount` int DEFAULT NULL,
  `majorCategory` varchar(50) DEFAULT NULL,
  `middleCategory` varchar(50) DEFAULT NULL,
  `regDate` date DEFAULT NULL,
  `updateDate` date DEFAULT NULL,
  `mainImgPath` varchar(200) DEFAULT NULL,
  `mainImgName` varchar(100) DEFAULT NULL,
  `subImgPath` varchar(200) DEFAULT NULL,
  `subImgName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Sample Product',2000,10,5,10,'Electronics','Mobile','2024-05-22','2024-05-22','/images/sample.png','sample.png',NULL,NULL),(2,'Product 1',1000,50,10,0,'Electronics','Mobile','2024-05-22','2024-05-22','/images/product1.png','product1.png',NULL,NULL),(3,'Product 2',2000,30,5,5,'Electronics','Laptop','2024-05-23','2024-05-23','/images/product2.png','product2.png',NULL,NULL),(4,'Product 3',1500,40,8,10,'Clothing','T-Shirts','2024-05-24','2024-05-24','/images/product3.png','product3.png',NULL,NULL),(5,'Product 4',3000,20,3,15,'Electronics','Smartwatch','2024-05-25','2024-05-25','/images/product4.png','product4.png',NULL,NULL),(6,'Product 5',2500,35,6,8,'Clothing','Jeans','2024-05-26','2024-05-26','/images/product5.png','product5.png',NULL,NULL),(7,'Product 6',1800,45,7,12,'Electronics','Headphones','2024-05-27','2024-05-27','/images/product6.png','product6.png',NULL,NULL),(8,'Product 7',2200,25,4,6,'Clothing','Jackets','2024-05-28','2024-05-28','/images/product7.png','product7.png',NULL,NULL),(9,'Product 8',2800,15,2,18,'Electronics','Tablet','2024-05-29','2024-05-29','/images/product8.png','product8.png',NULL,NULL),(10,'Product 9',1900,55,9,9,'Clothing','Sweaters','2024-05-30','2024-05-30','/images/product9.png','product9.png',NULL,NULL),(11,'Product 10',3200,10,1,20,'Electronics','Camera','2024-05-31','2024-05-31','/images/product10.png','product10.png',NULL,NULL),(12,'Product 11',1100,60,12,5,'Electronics','Mobile','2024-06-01','2024-06-01','/images/product11.png','product11.png',NULL,NULL),(13,'Product 12',2100,70,14,8,'Electronics','Laptop','2024-06-02','2024-06-02','/images/product12.png','product12.png',NULL,NULL),(14,'Product 13',1600,80,16,10,'Clothing','T-Shirts','2024-06-03','2024-06-03','/images/product13.png','product13.png',NULL,NULL),(15,'Product 14',3100,90,18,15,'Electronics','Smartwatch','2024-06-04','2024-06-04','/images/product14.png','product14.png',NULL,NULL),(16,'Product 15',2600,100,20,12,'Clothing','Jeans','2024-06-05','2024-06-05','/images/product15.png','product15.png',NULL,NULL),(17,'Product 16',1900,110,22,18,'Electronics','Headphones','2024-06-06','2024-06-06','/images/product16.png','product16.png',NULL,NULL),(18,'Product 17',2300,120,24,14,'Clothing','Jackets','2024-06-07','2024-06-07','/images/product17.png','product17.png',NULL,NULL),(19,'Product 18',2900,130,26,20,'Electronics','Tablet','2024-06-08','2024-06-08','/images/product18.png','product18.png',NULL,NULL),(20,'Product 19',2000,140,28,15,'Clothing','Sweaters','2024-06-09','2024-06-09','/images/product19.png','product19.png',NULL,NULL),(21,'Product 20',3300,150,30,10,'Electronics','Camera','2024-06-10','2024-06-10','/images/product20.png','product20.png',NULL,NULL),(22,'Product 21',1200,160,32,8,'Electronics','Mobile','2024-06-11','2024-06-11','/images/product21.png','product21.png',NULL,NULL),(23,'Product 22',2200,170,34,10,'Electronics','Laptop','2024-06-12','2024-06-12','/images/product22.png','product22.png',NULL,NULL),(24,'Product 23',1700,180,36,12,'Clothing','T-Shirts','2024-06-13','2024-06-13','/images/product23.png','product23.png',NULL,NULL),(25,'Product 24',3200,190,38,18,'Electronics','Smartwatch','2024-06-14','2024-06-14','/images/product24.png','product24.png',NULL,NULL),(26,'Product 25',2700,200,40,16,'Clothing','Jeans','2024-06-15','2024-06-15','/images/product25.png','product25.png',NULL,NULL),(27,'Product 26',2000,210,42,20,'Electronics','Headphones','2024-06-16','2024-06-16','/images/product26.png','product26.png',NULL,NULL),(28,'Product 27',2400,220,44,14,'Clothing','Jackets','2024-06-17','2024-06-17','/images/product27.png','product27.png',NULL,NULL),(29,'Product 28',3000,230,46,22,'Electronics','Tablet','2024-06-18','2024-06-18','/images/product28.png','product28.png',NULL,NULL),(30,'Product 29',2100,240,48,12,'Clothing','Sweaters','2024-06-19','2024-06-19','/images/product29.png','product29.png',NULL,NULL),(31,'Product 30',3400,250,50,25,'Electronics','Camera','2024-06-20','2024-06-20','/images/product30.png','product30.png',NULL,NULL);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productinquiryboard`
--

DROP TABLE IF EXISTS `productinquiryboard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productinquiryboard` (
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productinquiryboard`
--

LOCK TABLES `productinquiryboard` WRITE;
/*!40000 ALTER TABLE `productinquiryboard` DISABLE KEYS */;
/*!40000 ALTER TABLE `productinquiryboard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productinquiryboardcomment`
--

DROP TABLE IF EXISTS `productinquiryboardcomment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productinquiryboardcomment` (
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productinquiryboardcomment`
--

LOCK TABLES `productinquiryboardcomment` WRITE;
/*!40000 ALTER TABLE `productinquiryboardcomment` DISABLE KEYS */;
/*!40000 ALTER TABLE `productinquiryboardcomment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productreviewboard`
--

DROP TABLE IF EXISTS `productreviewboard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productreviewboard` (
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productreviewboard`
--

LOCK TABLES `productreviewboard` WRITE;
/*!40000 ALTER TABLE `productreviewboard` DISABLE KEYS */;
/*!40000 ALTER TABLE `productreviewboard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shippingaddress`
--

DROP TABLE IF EXISTS `shippingaddress`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shippingaddress` (
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shippingaddress`
--

LOCK TABLES `shippingaddress` WRITE;
/*!40000 ALTER TABLE `shippingaddress` DISABLE KEYS */;
/*!40000 ALTER TABLE `shippingaddress` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` varchar(50) NOT NULL,
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wishlist`
--

DROP TABLE IF EXISTS `wishlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wishlist` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `Pid` bigint NOT NULL,
  `Uid` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_WishList_Uid_idx` (`Uid`),
  KEY `FK_WishList_Pid_idx` (`Pid`),
  CONSTRAINT `FK_WishList_Pid` FOREIGN KEY (`Pid`) REFERENCES `product` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_WishList_Uid` FOREIGN KEY (`Uid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wishlist`
--

LOCK TABLES `wishlist` WRITE;
/*!40000 ALTER TABLE `wishlist` DISABLE KEYS */;
/*!40000 ALTER TABLE `wishlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'shopping'
--

--
-- Dumping routines for database 'shopping'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-22 17:53:48
