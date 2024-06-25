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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (4,'admin'),(3,'kakao_3491192927');
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart_items`
--

DROP TABLE IF EXISTS `cart_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart_items` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `Cart_Id` bigint NOT NULL,
  `Pid` bigint NOT NULL,
  `quantity` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Cart_CartItems_idx` (`Cart_Id`),
  KEY `FK_CartItems_Product_idx` (`Pid`),
  CONSTRAINT `FK_CartItems_Cart` FOREIGN KEY (`Cart_Id`) REFERENCES `cart` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_CartItems_Product` FOREIGN KEY (`Pid`) REFERENCES `product` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart_items`
--

LOCK TABLES `cart_items` WRITE;
/*!40000 ALTER TABLE `cart_items` DISABLE KEYS */;
INSERT INTO `cart_items` VALUES (10,3,229,2);
/*!40000 ALTER TABLE `cart_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_inquiry_board`
--

DROP TABLE IF EXISTS `customer_inquiry_board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_inquiry_board` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `Uid` varchar(50) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `content` text,
  `imgPath` varchar(200) DEFAULT NULL,
  `imgName` varchar(100) DEFAULT NULL,
  `regDate` date DEFAULT NULL,
  `updateDate` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_CustomerInquiryBoard_User_idx` (`Uid`),
  CONSTRAINT `FK_CustomerInquiryBoard_User` FOREIGN KEY (`Uid`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_inquiry_board`
--

LOCK TABLES `customer_inquiry_board` WRITE;
/*!40000 ALTER TABLE `customer_inquiry_board` DISABLE KEYS */;
INSERT INTO `customer_inquiry_board` VALUES (1,'user1','Title 1','Content 1','/images/img1.jpg','img1.jpg','2023-01-01','2023-01-02'),(2,'user2','Title 2','Content 2','/images/img2.jpg','img2.jpg','2023-01-02','2023-01-03'),(3,'user3','Title 3','Content 3','/images/img3.jpg','img3.jpg','2023-01-03','2023-01-04'),(4,'user4','Title 4','Content 4','/images/img4.jpg','img4.jpg','2023-01-04','2023-01-05'),(5,'user5','Title 5','Content 5','/images/img5.jpg','img5.jpg','2023-01-05','2023-01-06'),(6,'user6','Title 6','Content 6','/images/img6.jpg','img6.jpg','2023-01-06','2023-01-07'),(7,'user7','Title 7','Content 7','/images/img7.jpg','img7.jpg','2023-01-07','2023-01-08'),(8,'user8','Title 8','Content 8','/images/img8.jpg','img8.jpg','2023-01-08','2023-01-09'),(9,'user9','Title 9','Content 9','/images/img9.jpg','img9.jpg','2023-01-09','2023-01-10'),(10,'user10','Title 10','Content 10','/images/img10.jpg','img10.jpg','2023-01-10','2023-01-11'),(11,'user11','Title 11','Content 11','/images/img11.jpg','img11.jpg','2023-01-11','2023-01-12'),(12,'user12','Title 12','Content 12','/images/img12.jpg','img12.jpg','2023-01-12','2023-01-13'),(13,'user13','Title 13','Content 13','/images/img13.jpg','img13.jpg','2023-01-13','2023-01-14'),(14,'user14','Title 14','Content 14','/images/img14.jpg','img14.jpg','2023-01-14','2023-01-15'),(15,'user15','Title 15','Content 15','/images/img15.jpg','img15.jpg','2023-01-15','2023-01-16'),(16,'user16','Title 16','Content 16','/images/img16.jpg','img16.jpg','2023-01-16','2023-01-17'),(17,'user17','Title 17','Content 17','/images/img17.jpg','img17.jpg','2023-01-17','2023-01-18'),(18,'user18','Title 18','Content 18','/images/img18.jpg','img18.jpg','2023-01-18','2023-01-19'),(19,'user19','Title 19','Content 19','/images/img19.jpg','img19.jpg','2023-01-19','2023-01-20'),(20,'user20','Title 20','Content 20','/images/img20.jpg','img20.jpg','2023-01-20','2023-01-21'),(21,NULL,'Inquiry about product availability','Is this product available in stock?','/images/inquiries/1','inquiry1.jpg','2024-06-01','2024-06-02'),(22,NULL,'Shipping details','When will my order be shipped?','/images/inquiries/2','inquiry2.jpg','2024-06-03','2024-06-04'),(23,NULL,'Payment issue','I am having trouble with the payment process.','/images/inquiries/3','inquiry3.jpg','2024-06-05','2024-06-06'),(24,NULL,'Order cancellation','Can I cancel my order?','/images/inquiries/4','inquiry4.jpg','2024-06-07','2024-06-08'),(25,NULL,'Return policy','What is your return policy?','/images/inquiries/5','inquiry5.jpg','2024-06-09','2024-06-10'),(26,NULL,'Product warranty','Is there a warranty on this product?','/images/inquiries/6','inquiry6.jpg','2024-06-11','2024-06-12'),(27,NULL,'Discount availability','Are there any discounts available?','/images/inquiries/7','inquiry7.jpg','2024-06-13','2024-06-14'),(28,NULL,'Product compatibility','Is this product compatible with model X?','/images/inquiries/8','inquiry8.jpg','2024-06-15','2024-06-16'),(29,NULL,'Damaged product received','I received a damaged product.','/images/inquiries/9','inquiry9.jpg','2024-06-17','2024-06-18'),(30,NULL,'Order status','What is the status of my order?','/images/inquiries/10','inquiry10.jpg','2024-06-19','2024-06-20'),(31,NULL,'Billing issue','There is a problem with my billing.','/images/inquiries/11','inquiry11.jpg','2024-06-21','2024-06-22'),(32,NULL,'Account issue','I cannot log into my account.','/images/inquiries/12','inquiry12.jpg','2024-06-23','2024-06-24'),(33,NULL,'Shipping delay','Why is my shipment delayed?','/images/inquiries/13','inquiry13.jpg','2024-06-25','2024-06-26'),(34,NULL,'Product exchange','Can I exchange this product?','/images/inquiries/14','inquiry14.jpg','2024-06-27','2024-06-28'),(35,NULL,'Refund status','When will I receive my refund?','/images/inquiries/15','inquiry15.jpg','2024-06-29','2024-06-30'),(36,NULL,'Technical support','I need technical support for this product.','/images/inquiries/16','inquiry16.jpg','2024-07-01','2024-07-02'),(37,NULL,'Product recommendation','Can you recommend a product for my needs?','/images/inquiries/17','inquiry17.jpg','2024-07-03','2024-07-04'),(38,NULL,'Feature request','I would like to request a feature.','/images/inquiries/18','inquiry18.jpg','2024-07-05','2024-07-06'),(39,NULL,'Incorrect order received','I received the wrong order.','/images/inquiries/19','inquiry19.jpg','2024-07-07','2024-07-08'),(40,NULL,'Loyalty points','How can I redeem my loyalty points?','/images/inquiries/20','inquiry20.jpg','2024-07-09','2024-07-10'),(41,NULL,'Gift card usage','How do I use my gift card?','/images/inquiries/21','inquiry21.jpg','2024-07-11','2024-07-12'),(42,NULL,'Bulk order','Do you offer discounts for bulk orders?','/images/inquiries/22','inquiry22.jpg','2024-07-13','2024-07-14'),(43,NULL,'Product authenticity','Is this product authentic?','/images/inquiries/23','inquiry23.jpg','2024-07-15','2024-07-16'),(44,NULL,'Store location','Where is your nearest store?','/images/inquiries/24','inquiry24.jpg','2024-07-17','2024-07-18'),(45,NULL,'Order modification','Can I modify my order?','/images/inquiries/25','inquiry25.jpg','2024-07-19','2024-07-20'),(46,NULL,'Out of stock notification','Can you notify me when this product is back in stock?','/images/inquiries/26','inquiry26.jpg','2024-07-21','2024-07-22'),(47,NULL,'Subscription issue','I have an issue with my subscription.','/images/inquiries/27','inquiry27.jpg','2024-07-23','2024-07-24'),(48,NULL,'Order confirmation','Did you receive my order?','/images/inquiries/28','inquiry28.jpg','2024-07-25','2024-07-26'),(49,NULL,'Missing items','Some items are missing from my order.','/images/inquiries/29','inquiry29.jpg','2024-07-27','2024-07-28'),(50,NULL,'Feedback','I would like to leave feedback.','/images/inquiries/30','inquiry30.jpg','2024-07-29','2024-07-30');
/*!40000 ALTER TABLE `customer_inquiry_board` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_inquiry_comment`
--

DROP TABLE IF EXISTS `customer_inquiry_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_inquiry_comment` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `C_Board_id` bigint DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `comment` text,
  `imgPath` varchar(200) DEFAULT NULL,
  `imgName` varchar(100) DEFAULT NULL,
  `regDate` date DEFAULT NULL,
  `updateDate` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_CustomerInquiryComment_CustomerInquiryBoard_idx` (`C_Board_id`),
  CONSTRAINT `FK_CustomerInquiryComment_CustomerInquiryBoard` FOREIGN KEY (`C_Board_id`) REFERENCES `customer_inquiry_board` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_inquiry_comment`
--

LOCK TABLES `customer_inquiry_comment` WRITE;
/*!40000 ALTER TABLE `customer_inquiry_comment` DISABLE KEYS */;
INSERT INTO `customer_inquiry_comment` VALUES (1,1,'Comment Title 1','Comment 1','/images/comment_img1.jpg','comment_img1.jpg','2023-01-01','2023-01-02'),(2,2,'Comment Title 2','Comment 2','/images/comment_img2.jpg','comment_img2.jpg','2023-01-02','2023-01-03'),(3,3,'Comment Title 3','Comment 3','/images/comment_img3.jpg','comment_img3.jpg','2023-01-03','2023-01-04'),(4,4,'Comment Title 4','Comment 4','/images/comment_img4.jpg','comment_img4.jpg','2023-01-04','2023-01-05'),(5,5,'Comment Title 5','Comment 5','/images/comment_img5.jpg','comment_img5.jpg','2023-01-05','2023-01-06'),(6,6,'Comment Title 6','Comment 6','/images/comment_img6.jpg','comment_img6.jpg','2023-01-06','2023-01-07'),(7,7,'Comment Title 7','Comment 7','/images/comment_img7.jpg','comment_img7.jpg','2023-01-07','2023-01-08'),(8,8,'Comment Title 8','Comment 8','/images/comment_img8.jpg','comment_img8.jpg','2023-01-08','2023-01-09'),(9,9,'Comment Title 9','Comment 9','/images/comment_img9.jpg','comment_img9.jpg','2023-01-09','2023-01-10'),(10,10,'Comment Title 10','Comment 10','/images/comment_img10.jpg','comment_img10.jpg','2023-01-10','2023-01-11'),(11,11,'Comment Title 11','Comment 11','/images/comment_img11.jpg','comment_img11.jpg','2023-01-11','2023-01-12'),(12,12,'Comment Title 12','Comment 12','/images/comment_img12.jpg','comment_img12.jpg','2023-01-12','2023-01-13'),(13,21,'Response to your inquiry','Thank you for reaching out. We are looking into your issue.','/images/comments/1','comment1.jpg','2024-06-01','2024-06-02'),(14,22,'Shipping details update','Your order has been shipped and is on its way.','/images/comments/2','comment2.jpg','2024-06-03','2024-06-04'),(15,23,'Payment issue resolved','Your payment issue has been resolved. Thank you for your patience.','/images/comments/3','comment3.jpg','2024-06-05','2024-06-06'),(16,24,'Order cancellation confirmation','Your order has been successfully cancelled.','/images/comments/4','comment4.jpg','2024-06-07','2024-06-08'),(17,25,'Return policy information','You can return the product within 30 days.','/images/comments/5','comment5.jpg','2024-06-09','2024-06-10'),(18,26,'Warranty details','The product comes with a 1-year warranty.','/images/comments/6','comment6.jpg','2024-06-11','2024-06-12'),(19,27,'Discount details','Currently, we have a 10% discount on all products.','/images/comments/7','comment7.jpg','2024-06-13','2024-06-14'),(20,28,'Product compatibility confirmation','Yes, the product is compatible with model X.','/images/comments/8','comment8.jpg','2024-06-15','2024-06-16'),(21,29,'Damage report received','We have received your report and will send a replacement.','/images/comments/9','comment9.jpg','2024-06-17','2024-06-18'),(22,30,'Order status update','Your order is currently being processed.','/images/comments/10','comment10.jpg','2024-06-19','2024-06-20'),(23,31,'Billing issue update','The billing issue has been resolved. Please check your email for details.','/images/comments/11','comment11.jpg','2024-06-21','2024-06-22'),(24,32,'Account issue resolved','You can now log into your account. Thank you for your patience.','/images/comments/12','comment12.jpg','2024-06-23','2024-06-24'),(25,33,'Shipping delay explanation','The shipment is delayed due to unforeseen circumstances.','/images/comments/13','comment13.jpg','2024-06-25','2024-06-26'),(26,34,'Product exchange details','You can exchange the product by visiting our nearest store.','/images/comments/14','comment14.jpg','2024-06-27','2024-06-28'),(27,35,'Refund status update','Your refund will be processed within 5 business days.','/images/comments/15','comment15.jpg','2024-06-29','2024-06-30'),(28,36,'Technical support provided','Our technical team has contacted you for support.','/images/comments/16','comment16.jpg','2024-07-01','2024-07-02'),(38,46,'Out of stock notification setup','We will notify you when the product is back in stock.','/images/comments/26','comment26.jpg','2024-07-21','2024-07-22'),(40,48,'Order confirmation received','Yes, we have received your order and it is being processed.','/images/comments/28','comment28.jpg','2024-07-25','2024-07-26'),(42,50,'Feedback received','Thank you for your feedback. We value your input.','/images/comments/30','comment30.jpg','2024-07-29','2024-07-30'),(43,21,'Response to inquiry 21','Thank you for your inquiry. We are currently checking the product availability.','/images/comments/21','comment21.jpg','2024-06-01','2024-06-02'),(44,22,'Response to inquiry 22','Your order has been shipped and should arrive within 5 business days.','/images/comments/22','comment22.jpg','2024-06-03','2024-06-04'),(45,23,'Response to inquiry 23','Please try again with a different payment method. Contact support if the issue persists.','/images/comments/23','comment23.jpg','2024-06-05','2024-06-06'),(46,24,'Response to inquiry 24','Your order cancellation request has been processed successfully.','/images/comments/24','comment24.jpg','2024-06-07','2024-06-08'),(47,25,'Response to inquiry 25','Our return policy allows returns within 30 days of purchase.','/images/comments/25','comment25.jpg','2024-06-09','2024-06-10'),(48,26,'Response to inquiry 26','This product comes with a 1-year warranty.','/images/comments/26','comment26.jpg','2024-06-11','2024-06-12'),(49,27,'Response to inquiry 27','Currently, we are offering a 10% discount on all products.','/images/comments/27','comment27.jpg','2024-06-13','2024-06-14'),(50,28,'Response to inquiry 28','Yes, this product is compatible with model X.','/images/comments/28','comment28.jpg','2024-06-15','2024-06-16'),(51,29,'Response to inquiry 29','We apologize for the inconvenience. A replacement product will be sent to you.','/images/comments/29','comment29.jpg','2024-06-17','2024-06-18'),(52,30,'Response to inquiry 30','Your order is currently being processed and will be shipped soon.','/images/comments/30','comment30.jpg','2024-06-19','2024-06-20');
/*!40000 ALTER TABLE `customer_inquiry_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `major_category`
--

DROP TABLE IF EXISTS `major_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `major_category` (
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `major_category`
--

LOCK TABLES `major_category` WRITE;
/*!40000 ALTER TABLE `major_category` DISABLE KEYS */;
INSERT INTO `major_category` VALUES ('가공식품'),('건강식품'),('과일/채소'),('쌀/잡곡'),('축산물');
/*!40000 ALTER TABLE `major_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `middle_category`
--

DROP TABLE IF EXISTS `middle_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `middle_category` (
  `name` varchar(255) NOT NULL,
  `major_category_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`name`),
  KEY `idx_middle_category_major_category_name` (`major_category_name`),
  CONSTRAINT `FK_major_category_name_middle_category_major_category_name` FOREIGN KEY (`major_category_name`) REFERENCES `major_category` (`name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `middle_category`
--

LOCK TABLES `middle_category` WRITE;
/*!40000 ALTER TABLE `middle_category` DISABLE KEYS */;
INSERT INTO `middle_category` VALUES ('가공육','가공식품'),('두유/미숫가루','가공식품'),('만두/탕/간편조리','가공식품'),('빵/떡/과자','가공식품'),('약과/한과/유과','가공식품'),('꿀/조청','건강식품'),('수삼/인삼/백하수오','건강식품'),('엑기스/분말/즙류','건강식품'),('과일류','과일/채소'),('기타 채소 과일류','과일/채소'),('도라지','과일/채소'),('밤/견과류','과일/채소'),('버섯류','과일/채소'),('채소류','과일/채소'),('일반쌀','쌀/잡곡'),('현미/찹쌀/잡곡','쌀/잡곡'),('달걀','축산물'),('닭고기/오리','축산물'),('돼지고기','축산물'),('한우','축산물');
/*!40000 ALTER TABLE `middle_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `Uid` varchar(50) DEFAULT NULL,
  `total_amount` int DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Order_User_Uid_idx` (`Uid`),
  CONSTRAINT `FK_Order_User_Uid` FOREIGN KEY (`Uid`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (57,NULL,100,'paid'),(58,NULL,200,'paid'),(59,NULL,300,'paid'),(60,NULL,400,'paid'),(61,NULL,500,'paid'),(62,NULL,600,'paid'),(63,NULL,700,'paid'),(64,NULL,800,'paid'),(65,NULL,900,'paid'),(66,NULL,1000,'paid'),(67,NULL,1100,'paid'),(68,NULL,1200,'paid'),(69,NULL,1300,'paid'),(70,NULL,1400,'paid'),(71,NULL,1500,'paid'),(72,NULL,1600,'paid'),(73,NULL,1700,'paid'),(74,NULL,1800,'paid'),(75,NULL,1900,'paid'),(76,NULL,2000,'paid'),(77,NULL,100,'주문완료'),(78,NULL,100,'주문완료'),(79,'admin',100,'주문완료');
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_item`
--

DROP TABLE IF EXISTS `order_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_item` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `Oid` bigint NOT NULL,
  `Pid` bigint DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `price` int DEFAULT NULL,
  `review_status` varchar(45) DEFAULT 'N',
  PRIMARY KEY (`id`),
  KEY `FK_OrderItem_Order_Oid_idx` (`Oid`),
  KEY `FK_OrderItem_Product_Pid_idx` (`Pid`),
  CONSTRAINT `FK_OrderItem_Order_Oid` FOREIGN KEY (`Oid`) REFERENCES `order` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_OrderItem_Product_Pid` FOREIGN KEY (`Pid`) REFERENCES `product` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=227 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_item`
--

LOCK TABLES `order_item` WRITE;
/*!40000 ALTER TABLE `order_item` DISABLE KEYS */;
INSERT INTO `order_item` VALUES (160,57,193,1,100,'N'),(161,57,230,2,200,'N'),(162,57,121,3,300,'N'),(163,58,91,1,200,'N'),(164,58,63,2,400,'N'),(165,58,223,3,600,'N'),(166,59,48,1,300,'N'),(167,59,172,2,600,'N'),(168,59,51,3,900,'N'),(169,60,131,1,400,'N'),(170,60,47,2,800,'N'),(171,60,234,3,1200,'N'),(172,61,154,1,500,'N'),(173,61,36,2,1000,'N'),(174,61,108,3,1500,'N'),(175,62,189,1,600,'N'),(176,62,169,2,1200,'N'),(177,62,37,3,1800,'N'),(178,63,66,1,700,'N'),(179,63,188,2,1400,'N'),(180,63,79,3,2100,'N'),(181,64,221,1,800,'N'),(182,64,202,2,1600,'N'),(183,64,106,3,2400,'N'),(184,65,105,1,900,'N'),(185,65,173,2,1800,'N'),(186,65,98,3,2700,'N'),(187,66,150,1,1000,'N'),(188,66,215,2,2000,'N'),(189,66,169,3,3000,'N'),(190,67,169,1,1100,'N'),(191,67,95,2,2200,'N'),(192,67,149,3,3300,'N'),(193,68,216,1,1200,'N'),(194,68,181,2,2400,'N'),(195,68,223,3,3600,'N'),(196,69,120,1,1300,'N'),(197,69,112,2,2600,'N'),(198,69,166,3,3900,'N'),(199,70,40,1,1400,'N'),(200,70,92,2,2800,'N'),(201,70,101,3,4200,'N'),(202,71,194,1,1500,'N'),(203,71,214,2,3000,'N'),(204,71,35,3,4500,'N'),(205,72,135,1,1600,'N'),(206,72,117,2,3200,'N'),(207,72,147,3,4800,'N'),(208,73,141,1,1700,'N'),(209,73,235,2,3400,'N'),(210,73,86,3,5100,'N'),(211,74,114,1,1800,'N'),(212,74,70,2,3600,'N'),(213,74,186,3,5400,'N'),(214,75,57,1,1900,'N'),(215,75,118,2,3800,'N'),(216,75,178,3,5700,'N'),(217,76,79,1,2000,'N'),(218,76,43,2,4000,'N'),(219,76,155,3,6000,'N'),(220,77,229,3,50400,'N'),(221,78,239,1,16800,'N'),(222,78,229,1,16800,'N'),(223,78,219,1,18200,'N'),(224,79,189,1,52500,'N'),(225,79,219,1,18200,'N'),(226,79,169,1,45500,'N');
/*!40000 ALTER TABLE `order_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `buyer_addr` varchar(255) DEFAULT NULL,
  `buyer_email` varchar(255) DEFAULT NULL,
  `buyer_name` varchar(255) DEFAULT NULL,
  `buyer_postcode` varchar(10) DEFAULT NULL,
  `buyer_tel` varchar(20) DEFAULT NULL,
  `card_name` varchar(255) DEFAULT NULL,
  `imp_uid` varchar(255) DEFAULT NULL,
  `merchant_uid` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `paid_amount` int DEFAULT NULL,
  `paid_at` int DEFAULT NULL,
  `pg_type` varchar(50) DEFAULT NULL,
  `pay_method` varchar(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `regDate` date DEFAULT NULL,
  `updateDate` date DEFAULT NULL,
  `userid` varchar(100) DEFAULT NULL,
  `Oid` bigint DEFAULT NULL,
  `delivery_status` varchar(45) DEFAULT NULL,
  `refund_request_status` varchar(45) DEFAULT NULL,
  `delivery_message` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userid` (`userid`),
  KEY `payment_order_oId_idx` (`Oid`),
  CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `payment_order_oId` FOREIGN KEY (`Oid`) REFERENCES `order` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (2,'123 Main St','buyer1@example.com','Buyer One','12345','123-456-7890','Visa','imp_123','merchant_123','Order 57',100,1718849865,'PG1','card','paid','2024-06-20','2024-06-20','Anonymous',57,'배송준비','C',NULL),(3,'123 Main St','buyer2@example.com','Buyer Two','12345','123-456-7890','Visa','imp_124','merchant_124','Order 58',200,1718849865,'PG1','card','paid','2024-06-20','2024-06-20','Anonymous',58,'배송준비','N',NULL),(4,'123 Main St','buyer3@example.com','Buyer Three','12345','123-456-7890','Visa','imp_125','merchant_125','Order 59',300,1718849865,'PG1','card','paid','2024-06-20','2024-06-20','Anonymous',59,'배송준비','N',NULL),(5,'123 Main St','buyer4@example.com','Buyer Four','12345','123-456-7890','Visa','imp_126','merchant_126','Order 60',400,1718849865,'PG1','card','paid','2024-06-20','2024-06-20','Anonymous',60,'배송준비','N',NULL),(6,'123 Main St','buyer5@example.com','Buyer Five','12345','123-456-7890','Visa','imp_127','merchant_127','Order 61',500,1718849865,'PG1','card','paid','2024-06-20','2024-06-20','Anonymous',61,'배송준비','N',NULL),(7,'123 Main St','buyer6@example.com','Buyer Six','12345','123-456-7890','Visa','imp_128','merchant_128','Order 62',600,1718849865,'PG1','card','paid','2024-06-20','2024-06-20','Anonymous',62,'배송준비','N',NULL),(8,'123 Main St','buyer7@example.com','Buyer Seven','12345','123-456-7890','Visa','imp_129','merchant_129','Order 63',700,1718849865,'PG1','card','paid','2024-06-20','2024-06-20','Anonymous',63,'배송준비','N',NULL),(9,'123 Main St','buyer8@example.com','Buyer Eight','12345','123-456-7890','Visa','imp_130','merchant_130','Order 64',800,1718849865,'PG1','card','paid','2024-06-20','2024-06-25','Anonymous',64,'배송완료','N',NULL),(10,'123 Main St','buyer9@example.com','Buyer Nine','12345','123-456-7890','Visa','imp_131','merchant_131','Order 65',900,1718849865,'PG1','card','paid','2024-06-20','2024-06-20','Anonymous',65,'배송준비','N',NULL),(11,'123 Main St','buyer10@example.com','Buyer Ten','12345','123-456-7890','Visa','imp_132','merchant_132','Order 66',1000,1718849865,'PG1','card','paid','2024-06-20','2024-06-25','Anonymous',66,'배송중','N',NULL),(12,'123 Main St','buyer11@example.com','Buyer Eleven','12345','123-456-7890','Visa','imp_133','merchant_133','Order 67',1100,1718849865,'PG1','card','paid','2024-06-20','2024-06-20','Anonymous',67,'배송완료','N',NULL),(13,'123 Main St','buyer12@example.com','Buyer Twelve','12345','123-456-7890','Visa','imp_134','merchant_134','Order 68',1200,1718849865,'PG1','card','paid','2024-06-20','2024-06-25','Anonymous',68,'배송중','N',NULL),(14,'123 Main St','buyer13@example.com','Buyer Thirteen','12345','123-456-7890','Visa','imp_135','merchant_135','Order 69',1300,1718849865,'PG1','card','paid','2024-06-20','2024-06-25','Anonymous',69,'배송중','N',NULL),(15,'123 Main St','buyer14@example.com','Buyer Fourteen','12345','123-456-7890','Visa','imp_136','merchant_136','Order 70',1400,1718849865,'PG1','card','paid','2024-06-20','2024-06-25','Anonymous',70,'배송완료','N',NULL),(16,'123 Main St','buyer15@example.com','Buyer Fifteen','12345','123-456-7890','Visa','imp_137','merchant_137','Order 71',1500,1718849865,'PG1','card','paid','2024-06-20','2024-06-25','Anonymous',71,'배송중','N',NULL),(17,'123 Main St','buyer16@example.com','Buyer Sixteen','12345','123-456-7890','Visa','imp_138','merchant_138','Order 72',1600,1718849865,'PG1','card','paid','2024-06-20','2024-06-25','Anonymous',72,'배송중','N',NULL),(18,'123 Main St','buyer17@example.com','Buyer Seventeen','12345','123-456-7890','Visa','imp_139','merchant_139','Order 73',1700,1718849865,'PG1','card','paid','2024-06-20','2024-06-25','Anonymous',73,'배송중','R',NULL),(19,'123 Main St','buyer18@example.com','Buyer Eighteen','12345','123-456-7890','Visa','imp_140','merchant_140','Order 74',1800,1718849865,'PG1','card','paid','2024-06-20','2024-06-25','Anonymous',74,'배송중','R',NULL),(20,'123 Main St','buyer19@example.com','Buyer Nineteen','12345','123-456-7890','Visa','imp_141','merchant_141','Order 75',1900,1718849865,'PG1','card','paid','2024-06-20','2024-06-25','Anonymous',75,'배송중','B',NULL),(21,'123 Main St','buyer20@example.com','Buyer Twenty','12345','123-456-7890','Visa','imp_142','merchant_142','Order 76',2000,1718849865,'PG1','card','paid','2024-06-20','2024-06-25','Anonymous',76,'배송중','C',NULL),(24,'서울 강동구 아리수로 46d','','박민석','05237','010-5282-4082',NULL,'imp_162274964576','merchant_1719277274634','한과 상품 8',100,1719277323,'payment','point','paid','2024-06-25','2024-06-25','Anonymous',77,'배송완료','N','asdsadsadsadsad'),(25,'대구 군위군 군위읍 개봉길 23-72길거리 바닥','','박민석','43109','010-5282-4082',NULL,'imp_788376527843','merchant_1719277376300','미숫가루 상품 8',100,1719277407,'payment','point','paid','2024-06-25','2024-06-25','Anonymous',78,'배송완료','N',NULL),(26,'대구 군위군 군위읍 개봉길 23-72상세 주소 테스트3','pakms980319@gmail.com','박민석','43109','010-5282-4082',NULL,'imp_253332266380','merchant_1719302333313','분말 상품 8',100,1719302368,'payment','point','paid','2024-06-25','2024-06-25','admin',79,'배송준비','C','부재시 경비(관리)실에 맡겨주세요.');
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
  `discountedPrice` int DEFAULT NULL,
  `discount` int DEFAULT NULL,
  `amount` int DEFAULT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=251 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (32,'일반쌀 상품 1',10000,9000,10,100,'쌀/잡곡','일반쌀','일반쌀 상품 1 설명','2024-05-29','2024-05-29','/images/main1.jpg','main1.jpg','/images/sub1.jpg','sub1.jpg'),(33,'일반쌀 상품 2',20000,17000,15,200,'쌀/잡곡','일반쌀','일반쌀 상품 2 설명','2024-05-29','2024-05-29','/images/main2.jpg','main2.jpg','/images/sub2.jpg','sub2.jpg'),(34,'일반쌀 상품 3',15000,13200,12,150,'쌀/잡곡','일반쌀','일반쌀 상품 3 설명','2024-05-29','2024-05-29','/images/main3.jpg','main3.jpg','/images/sub3.jpg','sub3.jpg'),(35,'일반쌀 상품 4',18000,14400,20,180,'쌀/잡곡','일반쌀','일반쌀 상품 4 설명','2024-05-29','2024-05-29','/images/main4.jpg','main4.jpg','/images/sub4.jpg','sub4.jpg'),(36,'일반쌀 상품 5',13000,11960,8,130,'쌀/잡곡','일반쌀','일반쌀 상품 5 설명','2024-05-29','2024-05-29','/images/main5.jpg','main5.jpg','/images/sub5.jpg','sub5.jpg'),(37,'일반쌀 상품 6',22000,16500,25,220,'쌀/잡곡','일반쌀','일반쌀 상품 6 설명','2024-05-29','2024-05-29','/images/main6.jpg','main6.jpg','/images/sub6.jpg','sub6.jpg'),(38,'일반쌀 상품 7',17000,16150,5,170,'쌀/잡곡','일반쌀','일반쌀 상품 7 설명','2024-05-29','2024-05-29','/images/main7.jpg','main7.jpg','/images/sub7.jpg','sub7.jpg'),(39,'일반쌀 상품 8',25000,17500,30,250,'쌀/잡곡','일반쌀','일반쌀 상품 8 설명','2024-05-29','2024-05-29','/images/main8.jpg','main8.jpg','/images/sub8.jpg','sub8.jpg'),(40,'일반쌀 상품 9',19000,15580,18,190,'쌀/잡곡','일반쌀','일반쌀 상품 9 설명','2024-05-29','2024-05-29','/images/main9.jpg','main9.jpg','/images/sub9.jpg','sub9.jpg'),(41,'일반쌀 상품 10',14000,12600,10,140,'쌀/잡곡','일반쌀','일반쌀 상품 10 설명','2024-05-29','2024-05-29','/images/main10.jpg','main10.jpg','/images/sub10.jpg','sub10.jpg'),(42,'현미/찹쌀/잡곡 상품 1',15000,13500,10,150,'쌀/잡곡','현미/찹쌀/잡곡','현미/찹쌀/잡곡 상품 1 설명','2024-05-29','2024-05-29','/images/main1.jpg','main1.jpg','/images/sub1.jpg','sub1.jpg'),(43,'현미/찹쌀/잡곡 상품 2',16000,13600,15,160,'쌀/잡곡','현미/찹쌀/잡곡','현미/찹쌀/잡곡 상품 2 설명','2024-05-29','2024-05-29','/images/main2.jpg','main2.jpg','/images/sub2.jpg','sub2.jpg'),(44,'현미/찹쌀/잡곡 상품 3',14000,12320,12,140,'쌀/잡곡','현미/찹쌀/잡곡','현미/찹쌀/잡곡 상품 3 설명','2024-05-29','2024-05-29','/images/main3.jpg','main3.jpg','/images/sub3.jpg','sub3.jpg'),(45,'현미/찹쌀/잡곡 상품 4',13000,10400,20,130,'쌀/잡곡','현미/찹쌀/잡곡','현미/찹쌀/잡곡 상품 4 설명','2024-05-29','2024-05-29','/images/main4.jpg','main4.jpg','/images/sub4.jpg','sub4.jpg'),(46,'현미/찹쌀/잡곡 상품 5',17000,15640,8,170,'쌀/잡곡','현미/찹쌀/잡곡','현미/찹쌀/잡곡 상품 5 설명','2024-05-29','2024-05-29','/images/main5.jpg','main5.jpg','/images/sub5.jpg','sub5.jpg'),(47,'현미/찹쌀/잡곡 상품 6',18000,13500,25,180,'쌀/잡곡','현미/찹쌀/잡곡','현미/찹쌀/잡곡 상품 6 설명','2024-05-29','2024-05-29','/images/main6.jpg','main6.jpg','/images/sub6.jpg','sub6.jpg'),(48,'현미/찹쌀/잡곡 상품 7',20000,19000,5,200,'쌀/잡곡','현미/찹쌀/잡곡','현미/찹쌀/잡곡 상품 7 설명','2024-05-29','2024-05-29','/images/main7.jpg','main7.jpg','/images/sub7.jpg','sub7.jpg'),(49,'현미/찹쌀/잡곡 상품 8',19000,13300,30,190,'쌀/잡곡','현미/찹쌀/잡곡','현미/찹쌀/잡곡 상품 8 설명','2024-05-29','2024-05-29','/images/main8.jpg','main8.jpg','/images/sub8.jpg','sub8.jpg'),(50,'현미/찹쌀/잡곡 상품 9',22000,18040,18,220,'쌀/잡곡','현미/찹쌀/잡곡','현미/찹쌀/잡곡 상품 9 설명','2024-05-29','2024-05-29','/images/main9.jpg','main9.jpg','/images/sub9.jpg','sub9.jpg'),(51,'현미/찹쌀/잡곡 상품 10',21000,18900,10,210,'쌀/잡곡','현미/찹쌀/잡곡','현미/찹쌀/잡곡 상품 10 설명','2024-05-29','2024-05-29','/images/main10.jpg','main10.jpg','/images/sub10.jpg','sub10.jpg'),(52,'과일류 상품 1',12000,10800,10,120,'과일/채소','과일류','과일류 상품 1 설명','2024-05-29','2024-05-29','/images/main1.jpg','main1.jpg','/images/sub1.jpg','sub1.jpg'),(53,'과일류 상품 2',15000,12750,15,150,'과일/채소','과일류','과일류 상품 2 설명','2024-05-29','2024-05-29','/images/main2.jpg','main2.jpg','/images/sub2.jpg','sub2.jpg'),(54,'과일류 상품 3',14000,12320,12,140,'과일/채소','과일류','과일류 상품 3 설명','2024-05-29','2024-05-29','/images/main3.jpg','main3.jpg','/images/sub3.jpg','sub3.jpg'),(55,'과일류 상품 4',13000,10400,20,130,'과일/채소','과일류','과일류 상품 4 설명','2024-05-29','2024-05-29','/images/main4.jpg','main4.jpg','/images/sub4.jpg','sub4.jpg'),(56,'과일류 상품 5',17000,15640,8,170,'과일/채소','과일류','과일류 상품 5 설명','2024-05-29','2024-05-29','/images/main5.jpg','main5.jpg','/images/sub5.jpg','sub5.jpg'),(57,'과일류 상품 6',18000,13500,25,180,'과일/채소','과일류','과일류 상품 6 설명','2024-05-29','2024-05-29','/images/main6.jpg','main6.jpg','/images/sub6.jpg','sub6.jpg'),(58,'과일류 상품 7',20000,19000,5,200,'과일/채소','과일류','과일류 상품 7 설명','2024-05-29','2024-05-29','/images/main7.jpg','main7.jpg','/images/sub7.jpg','sub7.jpg'),(59,'과일류 상품 8',19000,13300,30,190,'과일/채소','과일류','과일류 상품 8 설명','2024-05-29','2024-05-29','/images/main8.jpg','main8.jpg','/images/sub8.jpg','sub8.jpg'),(60,'과일류 상품 9',16000,13120,18,160,'과일/채소','과일류','과일류 상품 9 설명','2024-05-29','2024-05-29','/images/main9.jpg','main9.jpg','/images/sub9.jpg','sub9.jpg'),(61,'과일류 상품 10',21000,18900,10,210,'과일/채소','과일류','과일류 상품 10 설명','2024-05-29','2024-05-29','/images/main10.jpg','main10.jpg','/images/sub10.jpg','sub10.jpg'),(62,'채소류 상품 1',10000,9000,10,100,'과일/채소','채소류','채소류 상품 1 설명','2024-05-29','2024-05-29','/images/main1.jpg','main1.jpg','/images/sub1.jpg','sub1.jpg'),(63,'채소류 상품 2',12000,10200,15,120,'과일/채소','채소류','채소류 상품 2 설명','2024-05-29','2024-05-29','/images/main2.jpg','main2.jpg','/images/sub2.jpg','sub2.jpg'),(64,'채소류 상품 3',9000,8550,5,90,'과일/채소','채소류','채소류 상품 3 설명','2024-05-29','2024-05-29','/images/main3.jpg','main3.jpg','/images/sub3.jpg','sub3.jpg'),(65,'채소류 상품 4',11000,8800,20,110,'과일/채소','채소류','채소류 상품 4 설명','2024-05-29','2024-05-29','/images/main4.jpg','main4.jpg','/images/sub4.jpg','sub4.jpg'),(66,'채소류 상품 5',8000,7360,8,80,'과일/채소','채소류','채소류 상품 5 설명','2024-05-29','2024-05-29','/images/main5.jpg','main5.jpg','/images/sub5.jpg','sub5.jpg'),(67,'채소류 상품 6',9500,8360,12,95,'과일/채소','채소류','채소류 상품 6 설명','2024-05-29','2024-05-29','/images/main6.jpg','main6.jpg','/images/sub6.jpg','sub6.jpg'),(68,'채소류 상품 7',13000,10660,18,130,'과일/채소','채소류','채소류 상품 7 설명','2024-05-29','2024-05-29','/images/main7.jpg','main7.jpg','/images/sub7.jpg','sub7.jpg'),(69,'채소류 상품 8',14000,10500,25,140,'과일/채소','채소류','채소류 상품 8 설명','2024-05-29','2024-05-29','/images/main8.jpg','main8.jpg','/images/sub8.jpg','sub8.jpg'),(70,'채소류 상품 9',11500,10350,10,115,'과일/채소','채소류','채소류 상품 9 설명','2024-05-29','2024-05-29','/images/main9.jpg','main9.jpg','/images/sub9.jpg','sub9.jpg'),(71,'채소류 상품 10',12500,9750,22,125,'과일/채소','채소류','채소류 상품 10 설명','2024-05-29','2024-05-29','/images/main10.jpg','main10.jpg','/images/sub10.jpg','sub10.jpg'),(72,'버섯류 상품 1',12000,10800,10,100,'과일/채소','버섯류','버섯류 상품 1 설명','2024-05-29','2024-05-29','/images/main1.jpg','main1.jpg','/images/sub1.jpg','sub1.jpg'),(73,'버섯류 상품 2',15000,12750,15,150,'과일/채소','버섯류','버섯류 상품 2 설명','2024-05-29','2024-05-29','/images/main2.jpg','main2.jpg','/images/sub2.jpg','sub2.jpg'),(74,'버섯류 상품 3',14000,12320,12,140,'과일/채소','버섯류','버섯류 상품 3 설명','2024-05-29','2024-05-29','/images/main3.jpg','main3.jpg','/images/sub3.jpg','sub3.jpg'),(75,'버섯류 상품 4',13000,10400,20,130,'과일/채소','버섯류','버섯류 상품 4 설명','2024-05-29','2024-05-29','/images/main4.jpg','main4.jpg','/images/sub4.jpg','sub4.jpg'),(76,'버섯류 상품 5',17000,15640,8,170,'과일/채소','버섯류','버섯류 상품 5 설명','2024-05-29','2024-05-29','/images/main5.jpg','main5.jpg','/images/sub5.jpg','sub5.jpg'),(77,'버섯류 상품 6',18000,13500,25,180,'과일/채소','버섯류','버섯류 상품 6 설명','2024-05-29','2024-05-29','/images/main6.jpg','main6.jpg','/images/sub6.jpg','sub6.jpg'),(78,'버섯류 상품 7',20000,19000,5,200,'과일/채소','버섯류','버섯류 상품 7 설명','2024-05-29','2024-05-29','/images/main7.jpg','main7.jpg','/images/sub7.jpg','sub7.jpg'),(79,'버섯류 상품 8',19000,13300,30,190,'과일/채소','버섯류','버섯류 상품 8 설명','2024-05-29','2024-05-29','/images/main8.jpg','main8.jpg','/images/sub8.jpg','sub8.jpg'),(80,'버섯류 상품 9',16000,13120,18,160,'과일/채소','버섯류','버섯류 상품 9 설명','2024-05-29','2024-05-29','/images/main9.jpg','main9.jpg','/images/sub9.jpg','sub9.jpg'),(81,'버섯류 상품 10',21000,18900,10,210,'과일/채소','버섯류','버섯류 상품 10 설명','2024-05-29','2024-05-29','/images/main10.jpg','main10.jpg','/images/sub10.jpg','sub10.jpg'),(82,'밤/견과류 상품 1',12000,10800,10,100,'과일/채소','밤/견과류','밤/견과류 상품 1 설명','2024-05-29','2024-05-29','/images/main1.jpg','main1.jpg','/images/sub1.jpg','sub1.jpg'),(83,'밤/견과류 상품 2',15000,12750,15,150,'과일/채소','밤/견과류','밤/견과류 상품 2 설명','2024-05-29','2024-05-29','/images/main2.jpg','main2.jpg','/images/sub2.jpg','sub2.jpg'),(84,'밤/견과류 상품 3',14000,12320,12,140,'과일/채소','밤/견과류','밤/견과류 상품 3 설명','2024-05-29','2024-05-29','/images/main3.jpg','main3.jpg','/images/sub3.jpg','sub3.jpg'),(85,'밤/견과류 상품 4',13000,10400,20,130,'과일/채소','밤/견과류','밤/견과류 상품 4 설명','2024-05-29','2024-05-29','/images/main4.jpg','main4.jpg','/images/sub4.jpg','sub4.jpg'),(86,'밤/견과류 상품 5',17000,15640,8,170,'과일/채소','밤/견과류','밤/견과류 상품 5 설명','2024-05-29','2024-05-29','/images/main5.jpg','main5.jpg','/images/sub5.jpg','sub5.jpg'),(87,'밤/견과류 상품 6',18000,13500,25,180,'과일/채소','밤/견과류','밤/견과류 상품 6 설명','2024-05-29','2024-05-29','/images/main6.jpg','main6.jpg','/images/sub6.jpg','sub6.jpg'),(88,'밤/견과류 상품 7',20000,19000,5,200,'과일/채소','밤/견과류','밤/견과류 상품 7 설명','2024-05-29','2024-05-29','/images/main7.jpg','main7.jpg','/images/sub7.jpg','sub7.jpg'),(89,'밤/견과류 상품 8',19000,13300,30,190,'과일/채소','밤/견과류','밤/견과류 상품 8 설명','2024-05-29','2024-05-29','/images/main8.jpg','main8.jpg','/images/sub8.jpg','sub8.jpg'),(90,'밤/견과류 상품 9',16000,13120,18,160,'과일/채소','밤/견과류','밤/견과류 상품 9 설명','2024-05-29','2024-05-29','/images/main9.jpg','main9.jpg','/images/sub9.jpg','sub9.jpg'),(91,'밤/견과류 상품 10',21000,18900,10,210,'과일/채소','밤/견과류','밤/견과류 상품 10 설명','2024-05-29','2024-05-29','/images/main10.jpg','main10.jpg','/images/sub10.jpg','sub10.jpg'),(92,'기타 채소 과일류 상품 1',12000,10800,10,100,'과일/채소','기타 채소 과일류','기타 채소 과일류 상품 1 설명','2024-05-29','2024-05-29','/images/main1.jpg','main1.jpg','/images/sub1.jpg','sub1.jpg'),(93,'기타 채소 과일류 상품 2',15000,12750,15,150,'과일/채소','기타 채소 과일류','기타 채소 과일류 상품 2 설명','2024-05-29','2024-05-29','/images/main2.jpg','main2.jpg','/images/sub2.jpg','sub2.jpg'),(94,'기타 채소 과일류 상품 3',14000,12320,12,140,'과일/채소','기타 채소 과일류','기타 채소 과일류 상품 3 설명','2024-05-29','2024-05-29','/images/main3.jpg','main3.jpg','/images/sub3.jpg','sub3.jpg'),(95,'기타 채소 과일류 상품 4',13000,10400,20,130,'과일/채소','기타 채소 과일류','기타 채소 과일류 상품 4 설명','2024-05-29','2024-05-29','/images/main4.jpg','main4.jpg','/images/sub4.jpg','sub4.jpg'),(96,'기타 채소 과일류 상품 5',17000,15640,8,170,'과일/채소','기타 채소 과일류','기타 채소 과일류 상품 5 설명','2024-05-29','2024-05-29','/images/main5.jpg','main5.jpg','/images/sub5.jpg','sub5.jpg'),(97,'기타 채소 과일류 상품 6',18000,13500,25,180,'과일/채소','기타 채소 과일류','기타 채소 과일류 상품 6 설명','2024-05-29','2024-05-29','/images/main6.jpg','main6.jpg','/images/sub6.jpg','sub6.jpg'),(98,'기타 채소 과일류 상품 7',20000,19000,5,200,'과일/채소','기타 채소 과일류','기타 채소 과일류 상품 7 설명','2024-05-29','2024-05-29','/images/main7.jpg','main7.jpg','/images/sub7.jpg','sub7.jpg'),(99,'기타 채소 과일류 상품 8',19000,13300,30,190,'과일/채소','기타 채소 과일류','기타 채소 과일류 상품 8 설명','2024-05-29','2024-05-29','/images/main8.jpg','main8.jpg','/images/sub8.jpg','sub8.jpg'),(100,'기타 채소 과일류 상품 9',16000,13120,18,160,'과일/채소','기타 채소 과일류','기타 채소 과일류 상품 9 설명','2024-05-29','2024-05-29','/images/main9.jpg','main9.jpg','/images/sub9.jpg','sub9.jpg'),(101,'기타 채소 과일류 상품 10',21000,18900,10,210,'과일/채소','기타 채소 과일류','기타 채소 과일류 상품 10 설명','2024-05-29','2024-05-29','/images/main10.jpg','main10.jpg','/images/sub10.jpg','sub10.jpg'),(102,'한우 상품 1',50000,45000,10,50,'축산물','한우','한우 상품 1 설명','2024-05-29','2024-05-29','/images/main1.jpg','main1.jpg','/images/sub1.jpg','sub1.jpg'),(103,'한우 상품 2',55000,46750,15,55,'축산물','한우','한우 상품 2 설명','2024-05-29','2024-05-29','/images/main2.jpg','main2.jpg','/images/sub2.jpg','sub2.jpg'),(104,'한우 상품 3',60000,52800,12,60,'축산물','한우','한우 상품 3 설명','2024-05-29','2024-05-29','/images/main3.jpg','main3.jpg','/images/sub3.jpg','sub3.jpg'),(105,'한우 상품 4',65000,52000,20,65,'축산물','한우','한우 상품 4 설명','2024-05-29','2024-05-29','/images/main4.jpg','main4.jpg','/images/sub4.jpg','sub4.jpg'),(106,'한우 상품 5',70000,64400,8,70,'축산물','한우','한우 상품 5 설명','2024-05-29','2024-05-29','/images/main5.jpg','main5.jpg','/images/sub5.jpg','sub5.jpg'),(107,'한우 상품 6',75000,56250,25,75,'축산물','한우','한우 상품 6 설명','2024-05-29','2024-05-29','/images/main6.jpg','main6.jpg','/images/sub6.jpg','sub6.jpg'),(108,'한우 상품 7',80000,76000,5,80,'축산물','한우','한우 상품 7 설명','2024-05-29','2024-05-29','/images/main7.jpg','main7.jpg','/images/sub7.jpg','sub7.jpg'),(109,'한우 상품 8',85000,59500,30,85,'축산물','한우','한우 상품 8 설명','2024-05-29','2024-05-29','/images/main8.jpg','main8.jpg','/images/sub8.jpg','sub8.jpg'),(110,'한우 상품 9',90000,73800,18,90,'축산물','한우','한우 상품 9 설명','2024-05-29','2024-05-29','/images/main9.jpg','main9.jpg','/images/sub9.jpg','sub9.jpg'),(111,'한우 상품 10',95000,85500,10,95,'축산물','한우','한우 상품 10 설명','2024-05-29','2024-05-29','/images/main10.jpg','main10.jpg','/images/sub10.jpg','sub10.jpg'),(112,'돼지고기 상품 1',20000,18000,10,200,'축산물','돼지고기','돼지고기 상품 1 설명','2024-05-29','2024-05-29','/images/main1.jpg','main1.jpg','/images/sub1.jpg','sub1.jpg'),(113,'돼지고기 상품 2',25000,21250,15,250,'축산물','돼지고기','돼지고기 상품 2 설명','2024-05-29','2024-05-29','/images/main2.jpg','main2.jpg','/images/sub2.jpg','sub2.jpg'),(114,'돼지고기 상품 3',30000,26400,12,300,'축산물','돼지고기','돼지고기 상품 3 설명','2024-05-29','2024-05-29','/images/main3.jpg','main3.jpg','/images/sub3.jpg','sub3.jpg'),(115,'돼지고기 상품 4',35000,28000,20,350,'축산물','돼지고기','돼지고기 상품 4 설명','2024-05-29','2024-05-29','/images/main4.jpg','main4.jpg','/images/sub4.jpg','sub4.jpg'),(116,'돼지고기 상품 5',22000,20240,8,220,'축산물','돼지고기','돼지고기 상품 5 설명','2024-05-29','2024-05-29','/images/main5.jpg','main5.jpg','/images/sub5.jpg','sub5.jpg'),(117,'돼지고기 상품 6',28000,21000,25,280,'축산물','돼지고기','돼지고기 상품 6 설명','2024-05-29','2024-05-29','/images/main6.jpg','main6.jpg','/images/sub6.jpg','sub6.jpg'),(118,'돼지고기 상품 7',24000,22800,5,240,'축산물','돼지고기','돼지고기 상품 7 설명','2024-05-29','2024-05-29','/images/main7.jpg','main7.jpg','/images/sub7.jpg','sub7.jpg'),(119,'돼지고기 상품 8',27000,18900,30,270,'축산물','돼지고기','돼지고기 상품 8 설명','2024-05-29','2024-05-29','/images/main8.jpg','main8.jpg','/images/sub8.jpg','sub8.jpg'),(120,'돼지고기 상품 9',26000,21320,18,260,'축산물','돼지고기','돼지고기 상품 9 설명','2024-05-29','2024-05-29','/images/main9.jpg','main9.jpg','/images/sub9.jpg','sub9.jpg'),(121,'돼지고기 상품 10',23000,20700,10,230,'축산물','돼지고기','돼지고기 상품 10 설명','2024-05-29','2024-05-29','/images/main10.jpg','main10.jpg','/images/sub10.jpg','sub10.jpg'),(122,'닭고기 상품 1',15000,13500,10,100,'축산물','닭고기/오리','닭고기 상품 1 설명','2024-05-29','2024-05-29','/images/main1.jpg','main1.jpg','/images/sub1.jpg','sub1.jpg'),(123,'오리고기 상품 2',18000,15300,15,150,'축산물','닭고기/오리','오리고기 상품 2 설명','2024-05-29','2024-05-29','/images/main2.jpg','main2.jpg','/images/sub2.jpg','sub2.jpg'),(124,'닭고기 상품 3',16000,14080,12,140,'축산물','닭고기/오리','닭고기 상품 3 설명','2024-05-29','2024-05-29','/images/main3.jpg','main3.jpg','/images/sub3.jpg','sub3.jpg'),(125,'오리고기 상품 4',17000,13600,20,130,'축산물','닭고기/오리','오리고기 상품 4 설명','2024-05-29','2024-05-29','/images/main4.jpg','main4.jpg','/images/sub4.jpg','sub4.jpg'),(126,'닭고기 상품 5',14000,12880,8,170,'축산물','닭고기/오리','닭고기 상품 5 설명','2024-05-29','2024-05-29','/images/main5.jpg','main5.jpg','/images/sub5.jpg','sub5.jpg'),(127,'오리고기 상품 6',19000,14250,25,180,'축산물','닭고기/오리','오리고기 상품 6 설명','2024-05-29','2024-05-29','/images/main6.jpg','main6.jpg','/images/sub6.jpg','sub6.jpg'),(128,'닭고기 상품 7',15500,14720,5,200,'축산물','닭고기/오리','닭고기 상품 7 설명','2024-05-29','2024-05-29','/images/main7.jpg','main7.jpg','/images/sub7.jpg','sub7.jpg'),(129,'오리고기 상품 8',16500,11550,30,190,'축산물','닭고기/오리','오리고기 상품 8 설명','2024-05-29','2024-05-29','/images/main8.jpg','main8.jpg','/images/sub8.jpg','sub8.jpg'),(130,'닭고기 상품 9',17500,14350,18,160,'축산물','닭고기/오리','닭고기 상품 9 설명','2024-05-29','2024-05-29','/images/main9.jpg','main9.jpg','/images/sub9.jpg','sub9.jpg'),(131,'오리고기 상품 10',18500,16650,10,210,'축산물','닭고기/오리','오리고기 상품 10 설명','2024-05-29','2024-05-29','/images/main10.jpg','main10.jpg','/images/sub10.jpg','sub10.jpg'),(132,'가공육 상품 1',15000,13500,10,100,'축산물','가공육','가공육 상품 1 설명','2024-05-29','2024-05-29','/images/main1.jpg','main1.jpg','/images/sub1.jpg','sub1.jpg'),(133,'가공육 상품 2',16000,13600,15,150,'축산물','가공육','가공육 상품 2 설명','2024-05-29','2024-05-29','/images/main2.jpg','main2.jpg','/images/sub2.jpg','sub2.jpg'),(134,'가공육 상품 3',17000,14960,12,140,'축산물','가공육','가공육 상품 3 설명','2024-05-29','2024-05-29','/images/main3.jpg','main3.jpg','/images/sub3.jpg','sub3.jpg'),(135,'가공육 상품 4',18000,14400,20,130,'축산물','가공육','가공육 상품 4 설명','2024-05-29','2024-05-29','/images/main4.jpg','main4.jpg','/images/sub4.jpg','sub4.jpg'),(136,'가공육 상품 5',19000,17480,8,170,'축산물','가공육','가공육 상품 5 설명','2024-05-29','2024-05-29','/images/main5.jpg','main5.jpg','/images/sub5.jpg','sub5.jpg'),(137,'가공육 상품 6',20000,15000,25,180,'축산물','가공육','가공육 상품 6 설명','2024-05-29','2024-05-29','/images/main6.jpg','main6.jpg','/images/sub6.jpg','sub6.jpg'),(138,'가공육 상품 7',21000,19950,5,200,'축산물','가공육','가공육 상품 7 설명','2024-05-29','2024-05-29','/images/main7.jpg','main7.jpg','/images/sub7.jpg','sub7.jpg'),(139,'가공육 상품 8',22000,15400,30,190,'축산물','가공육','가공육 상품 8 설명','2024-05-29','2024-05-29','/images/main8.jpg','main8.jpg','/images/sub8.jpg','sub8.jpg'),(140,'가공육 상품 9',23000,18860,18,160,'축산물','가공육','가공육 상품 9 설명','2024-05-29','2024-05-29','/images/main9.jpg','main9.jpg','/images/sub9.jpg','sub9.jpg'),(141,'가공육 상품 10',24000,21600,10,210,'축산물','가공육','가공육 상품 10 설명','2024-05-29','2024-05-29','/images/main10.jpg','main10.jpg','/images/sub10.jpg','sub10.jpg'),(142,'달걀 상품 1',5000,4500,10,100,'축산물','달걀','달걀 상품 1 설명','2024-05-29','2024-05-29','/images/main1.jpg','main1.jpg','/images/sub1.jpg','sub1.jpg'),(143,'달걀 상품 2',5500,4670,15,120,'축산물','달걀','달걀 상품 2 설명','2024-05-29','2024-05-29','/images/main2.jpg','main2.jpg','/images/sub2.jpg','sub2.jpg'),(144,'달걀 상품 3',6000,5280,12,140,'축산물','달걀','달걀 상품 3 설명','2024-05-29','2024-05-29','/images/main3.jpg','main3.jpg','/images/sub3.jpg','sub3.jpg'),(145,'달걀 상품 4',6500,5200,20,130,'축산물','달걀','달걀 상품 4 설명','2024-05-29','2024-05-29','/images/main4.jpg','main4.jpg','/images/sub4.jpg','sub4.jpg'),(146,'달걀 상품 5',7000,6440,8,150,'축산물','달걀','달걀 상품 5 설명','2024-05-29','2024-05-29','/images/main5.jpg','main5.jpg','/images/sub5.jpg','sub5.jpg'),(147,'달걀 상품 6',7500,5620,25,160,'축산물','달걀','달걀 상품 6 설명','2024-05-29','2024-05-29','/images/main6.jpg','main6.jpg','/images/sub6.jpg','sub6.jpg'),(148,'달걀 상품 7',8000,7600,5,180,'축산물','달걀','달걀 상품 7 설명','2024-05-29','2024-05-29','/images/main7.jpg','main7.jpg','/images/sub7.jpg','sub7.jpg'),(149,'달걀 상품 8',8500,5950,30,170,'축산물','달걀','달걀 상품 8 설명','2024-05-29','2024-05-29','/images/main8.jpg','main8.jpg','/images/sub8.jpg','sub8.jpg'),(150,'달걀 상품 9',9000,7380,18,190,'축산물','달걀','달걀 상품 9 설명','2024-05-29','2024-05-29','/images/main9.jpg','main9.jpg','/images/sub9.jpg','sub9.jpg'),(151,'달걀 상품 10',9500,8550,10,200,'축산물','달걀','달걀 상품 10 설명','2024-05-29','2024-05-29','/images/main10.jpg','main10.jpg','/images/sub10.jpg','sub10.jpg'),(152,'수삼 상품 1',30000,27000,10,50,'건강식품','수삼/인삼/백하수오','수삼 상품 1 설명','2024-05-29','2024-05-29','/images/main1.jpg','main1.jpg','/images/sub1.jpg','sub1.jpg'),(153,'인삼 상품 2',35000,29750,15,60,'건강식품','수삼/인삼/백하수오','인삼 상품 2 설명','2024-05-29','2024-05-29','/images/main2.jpg','main2.jpg','/images/sub2.jpg','sub2.jpg'),(154,'백하수오 상품 3',40000,35200,12,70,'건강식품','수삼/인삼/백하수오','백하수오 상품 3 설명','2024-05-29','2024-05-29','/images/main3.jpg','main3.jpg','/images/sub3.jpg','sub3.jpg'),(155,'수삼 상품 4',45000,36000,20,80,'건강식품','수삼/인삼/백하수오','수삼 상품 4 설명','2024-05-29','2024-05-29','/images/main4.jpg','main4.jpg','/images/sub4.jpg','sub4.jpg'),(156,'인삼 상품 5',50000,46000,8,90,'건강식품','수삼/인삼/백하수오','인삼 상품 5 설명','2024-05-29','2024-05-29','/images/main5.jpg','main5.jpg','/images/sub5.jpg','sub5.jpg'),(157,'백하수오 상품 6',55000,41250,25,100,'건강식품','수삼/인삼/백하수오','백하수오 상품 6 설명','2024-05-29','2024-05-29','/images/main6.jpg','main6.jpg','/images/sub6.jpg','sub6.jpg'),(158,'수삼 상품 7',60000,57000,5,110,'건강식품','수삼/인삼/백하수오','수삼 상품 7 설명','2024-05-29','2024-05-29','/images/main7.jpg','main7.jpg','/images/sub7.jpg','sub7.jpg'),(159,'인삼 상품 8',65000,45500,30,120,'건강식품','수삼/인삼/백하수오','인삼 상품 8 설명','2024-05-29','2024-05-29','/images/main8.jpg','main8.jpg','/images/sub8.jpg','sub8.jpg'),(160,'백하수오 상품 9',70000,57400,18,130,'건강식품','수삼/인삼/백하수오','백하수오 상품 9 설명','2024-05-29','2024-05-29','/images/main9.jpg','main9.jpg','/images/sub9.jpg','sub9.jpg'),(161,'수삼 상품 10',75000,67500,10,140,'건강식품','수삼/인삼/백하수오','수삼 상품 10 설명','2024-05-29','2024-05-29','/images/main10.jpg','main10.jpg','/images/sub10.jpg','sub10.jpg'),(162,'도라지 상품 1',30000,27000,10,50,'건강식품','도라지','도라지 상품 1 설명','2024-05-29','2024-05-29','/images/main1.jpg','main1.jpg','/images/sub1.jpg','sub1.jpg'),(163,'도라지 상품 2',35000,29750,15,60,'건강식품','도라지','도라지 상품 2 설명','2024-05-29','2024-05-29','/images/main2.jpg','main2.jpg','/images/sub2.jpg','sub2.jpg'),(164,'도라지 상품 3',40000,35200,12,70,'건강식품','도라지','도라지 상품 3 설명','2024-05-29','2024-05-29','/images/main3.jpg','main3.jpg','/images/sub3.jpg','sub3.jpg'),(165,'도라지 상품 4',45000,36000,20,80,'건강식품','도라지','도라지 상품 4 설명','2024-05-29','2024-05-29','/images/main4.jpg','main4.jpg','/images/sub4.jpg','sub4.jpg'),(166,'도라지 상품 5',50000,46000,8,90,'건강식품','도라지','도라지 상품 5 설명','2024-05-29','2024-05-29','/images/main5.jpg','main5.jpg','/images/sub5.jpg','sub5.jpg'),(167,'도라지 상품 6',55000,41250,25,100,'건강식품','도라지','도라지 상품 6 설명','2024-05-29','2024-05-29','/images/main6.jpg','main6.jpg','/images/sub6.jpg','sub6.jpg'),(168,'도라지 상품 7',60000,57000,5,110,'건강식품','도라지','도라지 상품 7 설명','2024-05-29','2024-05-29','/images/main7.jpg','main7.jpg','/images/sub7.jpg','sub7.jpg'),(169,'도라지 상품 8',65000,45500,30,119,'건강식품','도라지','도라지 상품 8 설명','2024-05-29','2024-05-29','/images/main8.jpg','main8.jpg','/images/sub8.jpg','sub8.jpg'),(170,'도라지 상품 9',70000,57400,18,130,'건강식품','도라지','도라지 상품 9 설명','2024-05-29','2024-05-29','/images/main9.jpg','main9.jpg','/images/sub9.jpg','sub9.jpg'),(171,'도라지 상품 10',75000,67500,10,140,'건강식품','도라지','도라지 상품 10 설명','2024-05-29','2024-05-29','/images/main10.jpg','main10.jpg','/images/sub10.jpg','sub10.jpg'),(172,'홍삼 상품 1',50000,45000,10,100,'건강식품','홍삼/절편','홍삼 상품 1 설명','2024-05-29','2024-05-29','/images/main1.jpg','main1.jpg','/images/sub1.jpg','sub1.jpg'),(173,'홍삼 상품 2',55000,46750,15,120,'건강식품','홍삼/절편','홍삼 상품 2 설명','2024-05-29','2024-05-29','/images/main2.jpg','main2.jpg','/images/sub2.jpg','sub2.jpg'),(174,'홍삼 상품 3',60000,52800,12,140,'건강식품','홍삼/절편','홍삼 상품 3 설명','2024-05-29','2024-05-29','/images/main3.jpg','main3.jpg','/images/sub3.jpg','sub3.jpg'),(175,'홍삼 상품 4',65000,52000,20,130,'건강식품','홍삼/절편','홍삼 상품 4 설명','2024-05-29','2024-05-29','/images/main4.jpg','main4.jpg','/images/sub4.jpg','sub4.jpg'),(176,'홍삼 상품 5',70000,64400,8,150,'건강식품','홍삼/절편','홍삼 상품 5 설명','2024-05-29','2024-05-29','/images/main5.jpg','main5.jpg','/images/sub5.jpg','sub5.jpg'),(177,'홍삼 상품 6',75000,56250,25,160,'건강식품','홍삼/절편','홍삼 상품 6 설명','2024-05-29','2024-05-29','/images/main6.jpg','main6.jpg','/images/sub6.jpg','sub6.jpg'),(178,'홍삼 상품 7',80000,76000,5,180,'건강식품','홍삼/절편','홍삼 상품 7 설명','2024-05-29','2024-05-29','/images/main7.jpg','main7.jpg','/images/sub7.jpg','sub7.jpg'),(179,'홍삼 상품 8',85000,59500,30,170,'건강식품','홍삼/절편','홍삼 상품 8 설명','2024-05-29','2024-05-29','/images/main8.jpg','main8.jpg','/images/sub8.jpg','sub8.jpg'),(180,'홍삼 상품 9',90000,73800,18,190,'건강식품','홍삼/절편','홍삼 상품 9 설명','2024-05-29','2024-05-29','/images/main9.jpg','main9.jpg','/images/sub9.jpg','sub9.jpg'),(181,'홍삼 상품 10',95000,85500,10,200,'건강식품','홍삼/절편','홍삼 상품 10 설명','2024-05-29','2024-05-29','/images/main10.jpg','main10.jpg','/images/sub10.jpg','sub10.jpg'),(182,'엑기스 상품 1',40000,36000,10,50,'건강식품','엑기스/분말/즙류','엑기스 상품 1 설명','2024-05-29','2024-05-29','/images/main1.jpg','main1.jpg','/images/sub1.jpg','sub1.jpg'),(183,'분말 상품 2',45000,38250,15,60,'건강식품','엑기스/분말/즙류','분말 상품 2 설명','2024-05-29','2024-05-29','/images/main2.jpg','main2.jpg','/images/sub2.jpg','sub2.jpg'),(184,'즙류 상품 3',50000,44000,12,70,'건강식품','엑기스/분말/즙류','즙류 상품 3 설명','2024-05-29','2024-05-29','/images/main3.jpg','main3.jpg','/images/sub3.jpg','sub3.jpg'),(185,'엑기스 상품 4',55000,44000,20,80,'건강식품','엑기스/분말/즙류','엑기스 상품 4 설명','2024-05-29','2024-05-29','/images/main4.jpg','main4.jpg','/images/sub4.jpg','sub4.jpg'),(186,'분말 상품 5',60000,55200,8,90,'건강식품','엑기스/분말/즙류','분말 상품 5 설명','2024-05-29','2024-05-29','/images/main5.jpg','main5.jpg','/images/sub5.jpg','sub5.jpg'),(187,'즙류 상품 6',65000,48750,25,100,'건강식품','엑기스/분말/즙류','즙류 상품 6 설명','2024-05-29','2024-05-29','/images/main6.jpg','main6.jpg','/images/sub6.jpg','sub6.jpg'),(188,'엑기스 상품 7',70000,66500,5,110,'건강식품','엑기스/분말/즙류','엑기스 상품 7 설명','2024-05-29','2024-05-29','/images/main7.jpg','main7.jpg','/images/sub7.jpg','sub7.jpg'),(189,'분말 상품 8',75000,52500,30,119,'건강식품','엑기스/분말/즙류','분말 상품 8 설명','2024-05-29','2024-05-29','/images/main8.jpg','main8.jpg','/images/sub8.jpg','sub8.jpg'),(190,'즙류 상품 9',80000,65600,18,130,'건강식품','엑기스/분말/즙류','즙류 상품 9 설명','2024-05-29','2024-05-29','/images/main9.jpg','main9.jpg','/images/sub9.jpg','sub9.jpg'),(191,'엑기스 상품 10',85000,76500,10,140,'건강식품','엑기스/분말/즙류','엑기스 상품 10 설명','2024-05-29','2024-05-29','/images/main10.jpg','main10.jpg','/images/sub10.jpg','sub10.jpg'),(192,'꿀 상품 1',25000,22500,10,100,'건강식품','꿀/조청','꿀 상품 1 설명','2024-05-29','2024-05-29','/images/main1.jpg','main1.jpg','/images/sub1.jpg','sub1.jpg'),(193,'조청 상품 2',30000,25500,15,120,'건강식품','꿀/조청','조청 상품 2 설명','2024-05-29','2024-05-29','/images/main2.jpg','main2.jpg','/images/sub2.jpg','sub2.jpg'),(194,'꿀 상품 3',35000,30800,12,140,'건강식품','꿀/조청','꿀 상품 3 설명','2024-05-29','2024-05-29','/images/main3.jpg','main3.jpg','/images/sub3.jpg','sub3.jpg'),(195,'조청 상품 4',40000,32000,20,130,'건강식품','꿀/조청','조청 상품 4 설명','2024-05-29','2024-05-29','/images/main4.jpg','main4.jpg','/images/sub4.jpg','sub4.jpg'),(196,'꿀 상품 5',45000,41400,8,150,'건강식품','꿀/조청','꿀 상품 5 설명','2024-05-29','2024-05-29','/images/main5.jpg','main5.jpg','/images/sub5.jpg','sub5.jpg'),(197,'조청 상품 6',50000,37500,25,160,'건강식품','꿀/조청','조청 상품 6 설명','2024-05-29','2024-05-29','/images/main6.jpg','main6.jpg','/images/sub6.jpg','sub6.jpg'),(198,'꿀 상품 7',55000,52250,5,180,'건강식품','꿀/조청','꿀 상품 7 설명','2024-05-29','2024-05-29','/images/main7.jpg','main7.jpg','/images/sub7.jpg','sub7.jpg'),(199,'조청 상품 8',60000,42000,30,170,'건강식품','꿀/조청','조청 상품 8 설명','2024-05-29','2024-05-29','/images/main8.jpg','main8.jpg','/images/sub8.jpg','sub8.jpg'),(200,'꿀 상품 9',65000,53300,18,190,'건강식품','꿀/조청','꿀 상품 9 설명','2024-05-29','2024-05-29','/images/main9.jpg','main9.jpg','/images/sub9.jpg','sub9.jpg'),(201,'조청 상품 10',70000,63000,10,200,'건강식품','꿀/조청','조청 상품 10 설명','2024-05-29','2024-05-29','/images/main10.jpg','main10.jpg','/images/sub10.jpg','sub10.jpg'),(202,'빵 상품 1',15000,13500,10,100,'가공식품','빵/떡/과자','빵 상품 1 설명','2024-05-29','2024-05-29','/images/main1.jpg','main1.jpg','/images/sub1.jpg','sub1.jpg'),(203,'떡 상품 2',20000,17000,15,120,'가공식품','빵/떡/과자','떡 상품 2 설명','2024-05-29','2024-05-29','/images/main2.jpg','main2.jpg','/images/sub2.jpg','sub2.jpg'),(204,'과자 상품 3',25000,22000,12,140,'가공식품','빵/떡/과자','과자 상품 3 설명','2024-05-29','2024-05-29','/images/main3.jpg','main3.jpg','/images/sub3.jpg','sub3.jpg'),(205,'빵 상품 4',30000,24000,20,130,'가공식품','빵/떡/과자','빵 상품 4 설명','2024-05-29','2024-05-29','/images/main4.jpg','main4.jpg','/images/sub4.jpg','sub4.jpg'),(206,'떡 상품 5',35000,32200,8,150,'가공식품','빵/떡/과자','떡 상품 5 설명','2024-05-29','2024-05-29','/images/main5.jpg','main5.jpg','/images/sub5.jpg','sub5.jpg'),(207,'과자 상품 6',40000,30000,25,160,'가공식품','빵/떡/과자','과자 상품 6 설명','2024-05-29','2024-05-29','/images/main6.jpg','main6.jpg','/images/sub6.jpg','sub6.jpg'),(208,'빵 상품 7',45000,42750,5,180,'가공식품','빵/떡/과자','빵 상품 7 설명','2024-05-29','2024-05-29','/images/main7.jpg','main7.jpg','/images/sub7.jpg','sub7.jpg'),(209,'떡 상품 8',50000,35000,30,170,'가공식품','빵/떡/과자','떡 상품 8 설명','2024-05-29','2024-05-29','/images/main8.jpg','main8.jpg','/images/sub8.jpg','sub8.jpg'),(210,'과자 상품 9',55000,45100,18,190,'가공식품','빵/떡/과자','과자 상품 9 설명','2024-05-29','2024-05-29','/images/main9.jpg','main9.jpg','/images/sub9.jpg','sub9.jpg'),(211,'빵 상품 10',60000,54000,10,200,'가공식품','빵/떡/과자','빵 상품 10 설명','2024-05-29','2024-05-29','/images/main10.jpg','main10.jpg','/images/sub10.jpg','sub10.jpg'),(212,'만두 상품 1',12000,10800,10,100,'가공식품','만두/탕/간편조리','만두 상품 1 설명','2024-05-29','2024-05-29','/images/main1.jpg','main1.jpg','/images/sub1.jpg','sub1.jpg'),(213,'탕 상품 2',14000,11900,15,120,'가공식품','만두/탕/간편조리','탕 상품 2 설명','2024-05-29','2024-05-29','/images/main2.jpg','main2.jpg','/images/sub2.jpg','sub2.jpg'),(214,'간편조리 상품 3',16000,14080,12,140,'가공식품','만두/탕/간편조리','간편조리 상품 3 설명','2024-05-29','2024-05-29','/images/main3.jpg','main3.jpg','/images/sub3.jpg','sub3.jpg'),(215,'만두 상품 4',18000,14400,20,130,'가공식품','만두/탕/간편조리','만두 상품 4 설명','2024-05-29','2024-05-29','/images/main4.jpg','main4.jpg','/images/sub4.jpg','sub4.jpg'),(216,'탕 상품 5',20000,18400,8,150,'가공식품','만두/탕/간편조리','탕 상품 5 설명','2024-05-29','2024-05-29','/images/main5.jpg','main5.jpg','/images/sub5.jpg','sub5.jpg'),(217,'간편조리 상품 6',22000,16500,25,160,'가공식품','만두/탕/간편조리','간편조리 상품 6 설명','2024-05-29','2024-05-29','/images/main6.jpg','main6.jpg','/images/sub6.jpg','sub6.jpg'),(218,'만두 상품 7',24000,22800,5,180,'가공식품','만두/탕/간편조리','만두 상품 7 설명','2024-05-29','2024-05-29','/images/main7.jpg','main7.jpg','/images/sub7.jpg','sub7.jpg'),(219,'탕 상품 8',26000,18200,30,168,'가공식품','만두/탕/간편조리','탕 상품 8 설명','2024-05-29','2024-05-29','/images/main8.jpg','main8.jpg','/images/sub8.jpg','sub8.jpg'),(220,'간편조리 상품 9',28000,22960,18,190,'가공식품','만두/탕/간편조리','간편조리 상품 9 설명','2024-05-29','2024-05-29','/images/main9.jpg','main9.jpg','/images/sub9.jpg','sub9.jpg'),(221,'만두 상품 10',30000,27000,10,200,'가공식품','만두/탕/간편조리','만두 상품 10 설명','2024-05-29','2024-05-29','/images/main10.jpg','main10.jpg','/images/sub10.jpg','sub10.jpg'),(222,'약과 상품 1',10000,9000,10,100,'가공식품','약과/한과/유과','약과 상품 1 설명','2024-05-29','2024-05-29','/images/main1.jpg','main1.jpg','/images/sub1.jpg','sub1.jpg'),(223,'한과 상품 2',12000,10200,15,120,'가공식품','약과/한과/유과','한과 상품 2 설명','2024-05-29','2024-05-29','/images/main2.jpg','main2.jpg','/images/sub2.jpg','sub2.jpg'),(224,'유과 상품 3',14000,12320,12,140,'가공식품','약과/한과/유과','유과 상품 3 설명','2024-05-29','2024-05-29','/images/main3.jpg','main3.jpg','/images/sub3.jpg','sub3.jpg'),(225,'약과 상품 4',16000,12800,20,130,'가공식품','약과/한과/유과','약과 상품 4 설명','2024-05-29','2024-05-29','/images/main4.jpg','main4.jpg','/images/sub4.jpg','sub4.jpg'),(226,'한과 상품 5',18000,16560,8,150,'가공식품','약과/한과/유과','한과 상품 5 설명','2024-05-29','2024-05-29','/images/main5.jpg','main5.jpg','/images/sub5.jpg','sub5.jpg'),(227,'유과 상품 6',20000,15000,25,160,'가공식품','약과/한과/유과','유과 상품 6 설명','2024-05-29','2024-05-29','/images/main6.jpg','main6.jpg','/images/sub6.jpg','sub6.jpg'),(228,'약과 상품 7',22000,20900,5,180,'가공식품','약과/한과/유과','약과 상품 7 설명','2024-05-29','2024-05-29','/images/main7.jpg','main7.jpg','/images/sub7.jpg','sub7.jpg'),(229,'한과 상품 8',24000,16800,30,166,'가공식품','약과/한과/유과','한과 상품 8 설명','2024-05-29','2024-05-29','/images/main8.jpg','main8.jpg','/images/sub8.jpg','sub8.jpg'),(230,'유과 상품 9',26000,21320,18,190,'가공식품','약과/한과/유과','유과 상품 9 설명','2024-05-29','2024-05-29','/images/main9.jpg','main9.jpg','/images/sub9.jpg','sub9.jpg'),(231,'약과 상품 10',28000,25200,10,200,'가공식품','약과/한과/유과','약과 상품 10 설명','2024-05-29','2024-05-29','/images/main10.jpg','main10.jpg','/images/sub10.jpg','sub10.jpg'),(232,'두유 상품 1',10000,9000,10,100,'가공식품','두유/미숫가루','두유 상품 1 설명','2024-05-29','2024-05-29','/images/main1.jpg','main1.jpg','/images/sub1.jpg','sub1.jpg'),(233,'미숫가루 상품 2',12000,10200,15,120,'가공식품','두유/미숫가루','미숫가루 상품 2 설명','2024-05-29','2024-05-29','/images/main2.jpg','main2.jpg','/images/sub2.jpg','sub2.jpg'),(234,'두유 상품 3',14000,12320,12,140,'가공식품','두유/미숫가루','두유 상품 3 설명','2024-05-29','2024-05-29','/images/main3.jpg','main3.jpg','/images/sub3.jpg','sub3.jpg'),(235,'미숫가루 상품 4',16000,12800,20,130,'가공식품','두유/미숫가루','미숫가루 상품 4 설명','2024-05-29','2024-05-29','/images/main4.jpg','main4.jpg','/images/sub4.jpg','sub4.jpg'),(236,'두유 상품 5',18000,16560,8,150,'가공식품','두유/미숫가루','두유 상품 5 설명','2024-05-29','2024-05-29','/images/main5.jpg','main5.jpg','/images/sub5.jpg','sub5.jpg'),(237,'미숫가루 상품 6',20000,15000,25,160,'가공식품','두유/미숫가루','미숫가루 상품 6 설명','2024-05-29','2024-05-29','/images/main6.jpg','main6.jpg','/images/sub6.jpg','sub6.jpg'),(238,'두유 상품 7',22000,20900,5,180,'가공식품','두유/미숫가루','두유 상품 7 설명','2024-05-29','2024-05-29','/images/main7.jpg','main7.jpg','/images/sub7.jpg','sub7.jpg'),(239,'미숫가루 상품 8',24000,16800,30,169,'가공식품','두유/미숫가루','미숫가루 상품 8 설명','2024-05-29','2024-05-29','/images/main8.jpg','main8.jpg','/images/sub8.jpg','sub8.jpg'),(240,'두유 상품 9',26000,21320,18,190,'가공식품','두유/미숫가루','두유 상품 9 설명','2024-05-29','2024-05-29','/images/main9.jpg','main9.jpg','/images/sub9.jpg','sub9.jpg'),(241,'미숫가루 상품 10',28000,25200,10,200,'가공식품','두유/미숫가루','미숫가루 상품 10 설명','2024-05-29','2024-05-29','/images/main10.jpg','main10.jpg','/images/sub10.jpg','sub10.jpg'),(244,'ㅇㅇㅇ',111111,110000,1,1,'쌀/잡곡','일반쌀','11111','2024-06-20','2024-06-20','\\uploads\\product\\ㅇㅇㅇ\\','main_IT_바탕화면.jpg','\\uploads\\product\\ㅇㅇㅇ\\','sub_IT_바탕화면 - 복사본.jpg'),(245,'상품등록 테스트1',1000,900,10,100,'쌀/잡곡','일반쌀','테스트','2024-06-20','2024-06-20','\\uploads\\product\\상품등록 테스트1\\','main_IT_대구 강사석.jpg','\\uploads\\product\\상품등록 테스트1\\','sub_IT_대구.jpg'),(246,'테스트2',1000,900,10,10,'쌀/잡곡','일반쌀','ㅇ','2024-06-20','2024-06-20','\\uploads\\product\\테스트2\\','main_main_IT_대구 강사석.jpg','\\uploads\\product\\테스트2\\','sub_sub_IT_대구.jpg'),(247,'ㅇㅇㅇ',100,100,0,10,'쌀/잡곡','일반쌀','ㅇ','2024-06-20','2024-06-20','\\uploads\\product\\ㅇㅇㅇ\\','main_main_IT_대구 강사석.jpg','\\uploads\\product\\ㅇㅇㅇ\\','sub_sub_IT_대구.jpg'),(248,'ㅇㅇㅇ',1000,900,10,100,'쌀/잡곡','일반쌀','ㅇㅇㅇ','2024-06-20','2024-06-20','\\uploads\\product\\ㅇㅇㅇ\\','main_main_main_IT_대구 강사석.jpg','\\uploads\\product\\ㅇㅇㅇ\\','sub_sub_sub_IT_대구.jpg'),(249,'ㅇㅇㅇ',1000,900,10,10,'쌀/잡곡','일반쌀','ㅇㅇㅇ','2024-06-20','2024-06-20','\\uploads\\product\\ㅇㅇㅇ\\','main_sub_sub_sub_IT_대구.jpg','\\uploads\\product\\ㅇㅇㅇ\\','sub_main_main_main_IT_대구 강사석.jpg'),(250,'상품테스트(2)',10000,9000,10,10,'과일/채소','과일류','ㅅㄷㄴㅅ','2024-06-24','2024-06-24','\\uploads\\product\\2024-06-24\\','73f14cb6f7e74302b67d0994c894bef4.jpg','\\uploads\\product\\2024-06-24\\','551233d80b0a418aa11441bbcd121328.jpg');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_inquiry_board`
--

DROP TABLE IF EXISTS `product_inquiry_board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_inquiry_board` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `Pid` bigint DEFAULT NULL,
  `Uid` varchar(50) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `content` text,
  `regDate` date DEFAULT NULL,
  `updateDate` date DEFAULT NULL,
  `isLocked` varchar(10) DEFAULT NULL,
  `password` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ProductInquiryBoard_Proudct_idx` (`Pid`),
  KEY `FK_ProductInquiryBoard_User_idx` (`Uid`),
  CONSTRAINT `FK_ProductInquiryBoard_Proudct` FOREIGN KEY (`Pid`) REFERENCES `product` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_ProductInquiryBoard_User` FOREIGN KEY (`Uid`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_inquiry_board`
--

LOCK TABLES `product_inquiry_board` WRITE;
/*!40000 ALTER TABLE `product_inquiry_board` DISABLE KEYS */;
INSERT INTO `product_inquiry_board` VALUES (1,32,'user1','문의 제목 1','문의 내용 1','2024-05-01','2024-05-02','N','password1'),(2,33,'user2','문의 제목 2','문의 내용 2','2024-05-03','2024-05-04','Y','password2'),(3,34,'user3','문의 제목 3','문의 내용 3','2024-05-05','2024-05-06','N','password3'),(4,35,'user4','문의 제목 4','문의 내용 4','2024-05-07','2024-05-08','Y','password4'),(5,36,'user5','문의 제목 5','문의 내용 5','2024-05-09','2024-05-10','N','password5'),(6,37,'user6','문의 제목 6','문의 내용 6','2024-05-11','2024-05-12','Y','password6'),(7,38,'user7','문의 제목 7','문의 내용 7','2024-05-13','2024-05-14','N','password7'),(8,39,'user8','문의 제목 8','문의 내용 8','2024-05-15','2024-05-16','Y','password8'),(9,40,'user9','문의 제목 9','문의 내용 9','2024-05-17','2024-05-18','Y','password9'),(10,41,'user10','문의 제목 10','문의 내용 10','2024-05-19','2024-05-20','Y','password10'),(11,42,'user11','문의 제목 11','문의 내용 11','2024-05-21','2024-05-22','N','password11'),(12,43,'user12','문의 제목 12','문의 내용 12','2024-05-23','2024-05-24','Y','password12'),(13,44,'user13','문의 제목 13','문의 내용 13','2024-05-25','2024-05-26','N','password13'),(14,45,'user14','문의 제목 14','문의 내용 14','2024-05-27','2024-05-28','Y','password14'),(15,46,'user15','문의 제목 15','문의 내용 15','2024-05-29','2024-05-30','N','password15'),(16,47,'user16','문의 제목 16','문의 내용 16','2024-05-31','2024-06-01','Y','password16'),(17,48,'user17','문의 제목 17','문의 내용 17','2024-06-02','2024-06-03','N','password17'),(18,49,'user18','문의 제목 18','문의 내용 18','2024-06-04','2024-06-05','Y','password18'),(19,50,'user19','문의 제목 19','문의 내용 19','2024-06-06','2024-06-07','N','password19'),(20,51,'user20','문의 제목 20','문의 내용 20','2024-06-08','2024-06-09','Y','password20'),(21,32,NULL,'Inquiry about product 32','Can you provide more details about product 32?','2024-06-01','2024-06-02','N','password123'),(22,33,NULL,'Inquiry about product 33','Is product 33 available in blue color?','2024-06-03','2024-06-04','N','password123'),(23,34,NULL,'Inquiry about product 34','What is the warranty period for product 34?','2024-06-05','2024-06-06','Y','password123'),(24,35,NULL,'Inquiry about product 35','Are there any discounts available for product 35?','2024-06-07','2024-06-08','N','password123'),(25,36,NULL,'Inquiry about product 36','Can product 36 be shipped internationally?','2024-06-09','2024-06-10','Y','password123'),(26,37,NULL,'Inquiry about product 37','What is the return policy for product 37?','2024-06-11','2024-06-12','N','password123'),(27,38,NULL,'Inquiry about product 38','Is product 38 compatible with model X?','2024-06-13','2024-06-14','N','password123'),(28,39,NULL,'Inquiry about product 39','Can I get a bulk discount on product 39?','2024-06-15','2024-06-16','N','password123'),(29,40,NULL,'Inquiry about product 40','Does product 40 come with free shipping?','2024-06-17','2024-06-18','N','password123'),(30,41,NULL,'Inquiry about product 41','Is product 41 available in stores?','2024-06-19','2024-06-20','Y','password123'),(31,42,NULL,'Inquiry about product 42','Can product 42 be customized?','2024-06-21','2024-06-22','N','password123'),(32,43,NULL,'Inquiry about product 43','What is the expected delivery time for product 43?','2024-06-23','2024-06-24','N','password123'),(33,44,NULL,'Inquiry about product 44','Is product 44 available in large size?','2024-06-25','2024-06-26','N','password123'),(34,45,NULL,'Inquiry about product 45','Are there any additional accessories for product 45?','2024-06-27','2024-06-28','N','password123'),(35,46,NULL,'Inquiry about product 46','What materials are used in product 46?','2024-06-29','2024-06-30','N','password123'),(36,47,NULL,'Inquiry about product 47','Is product 47 eco-friendly?','2024-07-01','2024-07-02','Y','password123'),(37,48,NULL,'Inquiry about product 48','Can I get a sample of product 48?','2024-07-03','2024-07-04','N','password123'),(38,49,NULL,'Inquiry about product 49','What are the dimensions of product 49?','2024-07-05','2024-07-06','N','password123'),(39,50,NULL,'Inquiry about product 50','Is product 50 suitable for outdoor use?','2024-07-07','2024-07-08','N','password123'),(40,51,NULL,'Inquiry about product 51','Does product 51 come in other colors?','2024-07-09','2024-07-10','N','password123'),(41,52,NULL,'Inquiry about product 52','What is the battery life of product 52?','2024-07-11','2024-07-12','Y','password123'),(42,53,NULL,'Inquiry about product 53','Is product 53 available for preorder?','2024-07-13','2024-07-14','N','password123'),(43,54,NULL,'Inquiry about product 54','Can product 54 be used with product Y?','2024-07-15','2024-07-16','N','password123'),(44,55,NULL,'Inquiry about product 55','What is the weight of product 55?','2024-07-17','2024-07-18','N','password123'),(45,56,NULL,'Inquiry about product 56','Is product 56 waterproof?','2024-07-19','2024-07-20','N','password123'),(46,57,NULL,'Inquiry about product 57','Does product 57 come with a user manual?','2024-07-21','2024-07-22','N','password123'),(47,58,NULL,'Inquiry about product 58','Is there a discount on product 58 for first-time buyers?','2024-07-23','2024-07-24','N','password123'),(48,59,NULL,'Inquiry about product 59','Can product 59 be gift-wrapped?','2024-07-25','2024-07-26','N','password123'),(49,60,NULL,'Inquiry about product 60','What is the energy consumption of product 60?','2024-07-27','2024-07-28','N','password123');
/*!40000 ALTER TABLE `product_inquiry_board` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_inquiry_board_comment`
--

DROP TABLE IF EXISTS `product_inquiry_board_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_inquiry_board_comment` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `P_Board_Id` bigint DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `content` text,
  `regDate` date DEFAULT NULL,
  `updateDate` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ProductInquiryBoardComment_ProductInquiryBoard_idx` (`P_Board_Id`),
  CONSTRAINT `FK_ProductInquiryBoardComment_ProductInquiryBoard` FOREIGN KEY (`P_Board_Id`) REFERENCES `product_inquiry_board` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_inquiry_board_comment`
--

LOCK TABLES `product_inquiry_board_comment` WRITE;
/*!40000 ALTER TABLE `product_inquiry_board_comment` DISABLE KEYS */;
INSERT INTO `product_inquiry_board_comment` VALUES (41,1,'댓글 제목 1','댓글 내용 1','2024-05-02','2024-05-02'),(42,2,'댓글 제목 2','댓글 내용 2','2024-05-04','2024-05-04'),(43,3,'댓글 제목 3','댓글 내용 3','2024-05-06','2024-05-06'),(44,4,'댓글 제목 4','댓글 내용 4','2024-05-08','2024-05-08'),(45,5,'댓글 제목 5','댓글 내용 5','2024-05-10','2024-05-10'),(46,6,'댓글 제목 6','댓글 내용 6','2024-05-12','2024-05-12'),(47,7,'댓글 제목 7','댓글 내용 7','2024-05-14','2024-05-14'),(48,8,'댓글 제목 8','댓글 내용 8','2024-05-16','2024-05-16'),(49,9,'댓글 제목 9','댓글 내용 9','2024-05-18','2024-05-18'),(50,10,'댓글 제목 10','댓글 내용 10','2024-05-20','2024-05-20'),(51,1,'댓글 제목 1','댓글 내용 1','2024-05-02','2024-05-02'),(52,2,'댓글 제목 2','댓글 내용 2','2024-05-04','2024-05-04'),(53,3,'댓글 제목 3','댓글 내용 3','2024-05-06','2024-05-06'),(83,21,'Response to inquiry 21','Thank you for your inquiry about product 21. We are currently checking the availability.','2024-06-01','2024-06-02'),(84,22,'Response to inquiry 22','Your question about product 22 has been received. We will get back to you shortly.','2024-06-03','2024-06-04'),(85,23,'Response to inquiry 23','We have noted your query about product 23. Our team will respond soon.','2024-06-05','2024-06-06'),(86,24,'Response to inquiry 24','Thank you for your interest in product 24. We are checking the details and will update you soon.','2024-06-07','2024-06-08'),(87,25,'Response to inquiry 25','Your inquiry about product 25 is being processed. Please expect a response within 24 hours.','2024-06-09','2024-06-10'),(88,26,'Response to inquiry 26','We have received your question about product 26 and will respond as soon as possible.','2024-06-11','2024-06-12'),(89,27,'Response to inquiry 27','Thank you for reaching out about product 27. We are looking into your query.','2024-06-13','2024-06-14'),(90,28,'Response to inquiry 28','We appreciate your inquiry about product 28. Our support team will contact you shortly.','2024-06-15','2024-06-16'),(91,29,'Response to inquiry 29','Your question regarding product 29 has been forwarded to the relevant department.','2024-06-17','2024-06-18'),(92,30,'Response to inquiry 30','Thank you for your patience. We are working on your inquiry about product 30.','2024-06-19','2024-06-20');
/*!40000 ALTER TABLE `product_inquiry_board_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_review_board`
--

DROP TABLE IF EXISTS `product_review_board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_review_board` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `Pid` bigint DEFAULT NULL,
  `Oid` bigint DEFAULT NULL,
  `Uid` varchar(50) DEFAULT NULL,
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
  KEY `FK_ProductReviewBoard_Oid_idx` (`Oid`),
  CONSTRAINT `FK_ProductReviewBoard_Oid` FOREIGN KEY (`Oid`) REFERENCES `order` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_ProductReviewBoard_Product` FOREIGN KEY (`Pid`) REFERENCES `product` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_ProductReviewBoard_User` FOREIGN KEY (`Uid`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=217 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_review_board`
--

LOCK TABLES `product_review_board` WRITE;
/*!40000 ALTER TABLE `product_review_board` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_review_board` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipping_address`
--

DROP TABLE IF EXISTS `shipping_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shipping_address` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `Uid` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `zipcode` varchar(100) DEFAULT NULL,
  `streetAdr` varchar(100) DEFAULT NULL,
  `detailAdr` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ShippingAddress_User_idx` (`Uid`),
  CONSTRAINT `FK_ShippingAddress_User` FOREIGN KEY (`Uid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipping_address`
--

LOCK TABLES `shipping_address` WRITE;
/*!40000 ALTER TABLE `shipping_address` DISABLE KEYS */;
/*!40000 ALTER TABLE `shipping_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `signature`
--

DROP TABLE IF EXISTS `signature`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `signature` (
  `signature` varbinary(3072) NOT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`signature`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `signature`
--

LOCK TABLES `signature` WRITE;
/*!40000 ALTER TABLE `signature` DISABLE KEYS */;
INSERT INTO `signature` VALUES (_binary '��`ڃKkh��`7:0v�=�}�2W�\\H�3�6','2024-06-20');
/*!40000 ALTER TABLE `signature` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('admin','박민석','$2a$10$SBxUDT9a56YFHWGvWR8.QOE2n1abIL1h7RmW.eA0Mmyk8vGb3sCde','43109','대구 군위군 군위읍 개봉길 23-72','상세 주소 테스트3','010-5282-4082','pakms980319@gmail.com','ROLE_ADMIN',NULL,NULL),('hbsh2330','황보성현','$2a$10$EzVZu3A/vBcV8LKwXCs.aeUVvf41qhJUSEew2/ZOVEdpDLtnmleFu','43109','대구 군위군 군위읍 개봉길 23-72','나동','010-4216-2330','hbsh2330@naver.com','ROLE_USER',NULL,NULL),('kakao_3491192927',NULL,'$2a$10$zrQCnqGH2OZNcO0jNdJGR.7sJtZPdfJTqtdT6dfPYB0HiH.fnDmdS',NULL,NULL,NULL,NULL,NULL,'ROLE_USER','kakao','3491192927'),('pakms980319','박민석','$2a$10$SBxUDT9a56YFHWGvWR8.QOE2n1abIL1h7RmW.eA0Mmyk8vGb3sCde','43109','대구 군위군 군위읍 개봉길 23-72','상세 주소 테스트3','010-5282-4082','pakms980319@gmail.com','ROLE_USER',NULL,NULL),('user1','Alice','password1','12345','123 Main St','Apt 1','010-1234-5678','alice@example.com','user','local','provider1'),('user10','Judy','password10','01234','707 Spruce St','Apt 10','010-0123-4567','judy@example.com','admin','google','provider10'),('user11','Karl','password11','11223','808 Willow St','Apt 11','010-1123-5678','karl@example.com','user','facebook','provider11'),('user12','Laura','password12','22334','909 Redwood St','Apt 12','010-2234-6789','laura@example.com','user','facebook','provider12'),('user13','Mallory','password13','33445','1010 Palm St','Apt 13','010-3345-7890','mallory@example.com','user','local','provider13'),('user14','Nathan','password14','44556','1111 Fir St','Apt 14','010-4456-8901','nathan@example.com','user','local','provider14'),('user15','Olivia','password15','55667','1212 Poplar St','Apt 15','010-5567-9012','olivia@example.com','admin','google','provider15'),('user16','Peggy','password16','66778','1313 Beech St','Apt 16','010-6678-0123','peggy@example.com','user','google','provider16'),('user17','Quentin','password17','77889','1414 Cedar St','Apt 17','010-7789-1234','quentin@example.com','user','facebook','provider17'),('user18','Rupert','password18','88990','1515 Holly St','Apt 18','010-8890-2345','rupert@example.com','user','facebook','provider18'),('user19','Sybil','password19','99001','1616 Alder St','Apt 19','010-9901-3456','sybil@example.com','user','local','provider19'),('user2','Bob','password2','23456','456 Oak St','Apt 2','010-2345-6789','bob@example.com','admin','local','provider2'),('user20','Trent','password20','10112','1717 Juniper St','Apt 20','010-1011-4567','trent@example.com','admin','local','provider20'),('user3','Charlie','password3','34567','789 Pine St','Apt 3','010-3456-7890','charlie@example.com','user','google','provider3'),('user4','David','password4','45678','101 Maple St','Apt 4','010-4567-8901','david@example.com','user','google','provider4'),('user5','Eve','password5','56789','202 Birch St','Apt 5','010-5678-9012','eve@example.com','admin','facebook','provider5'),('user6','Frank','password6','67890','303 Cedar St','Apt 6','010-6789-0123','frank@example.com','user','facebook','provider6'),('user7','Grace','password7','78901','404 Walnut St','Apt 7','010-7890-1234','grace@example.com','user','local','provider7'),('user8','Heidi','password8','89012','505 Ash St','Apt 8','010-8901-2345','heidi@example.com','user','local','provider8'),('user9','Ivan','password9','90123','606 Elm St','Apt 9','010-9012-3456','ivan@example.com','user','google','provider9');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wish`
--

DROP TABLE IF EXISTS `wish`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wish` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `Pid` bigint NOT NULL,
  `Uid` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Wish_Uid_idx` (`Uid`),
  KEY `FK_Wish_Pid_idx` (`Pid`),
  CONSTRAINT `FK_Wish_Pid` FOREIGN KEY (`Pid`) REFERENCES `product` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Wish_Uid` FOREIGN KEY (`Uid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wish`
--

LOCK TABLES `wish` WRITE;
/*!40000 ALTER TABLE `wish` DISABLE KEYS */;
/*!40000 ALTER TABLE `wish` ENABLE KEYS */;
UNLOCK TABLES;

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

-- Dump completed on 2024-06-25 17:23:19
