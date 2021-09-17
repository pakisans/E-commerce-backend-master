-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: db
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (1,_binary '\0'),(2,_binary '\0'),(3,_binary '\0'),(4,_binary '\0'),(5,_binary '\0'),(6,_binary '\0'),(7,_binary '\0'),(8,_binary '\0'),(9,_binary '\0');
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `cart_cart_items`
--

LOCK TABLES `cart_cart_items` WRITE;
/*!40000 ALTER TABLE `cart_cart_items` DISABLE KEYS */;
INSERT INTO `cart_cart_items` VALUES (1,1),(1,2),(2,3),(2,4),(3,5),(4,6),(5,7),(5,8),(6,9),(6,10),(7,11),(8,12),(8,13),(9,14),(9,15);
/*!40000 ALTER TABLE `cart_cart_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `cart_item`
--

LOCK TABLES `cart_item` WRITE;
/*!40000 ALTER TABLE `cart_item` DISABLE KEYS */;
INSERT INTO `cart_item` VALUES (1,_binary '\0',1,1),(2,_binary '\0',1,2),(3,_binary '\0',1,1),(4,_binary '\0',1,2),(5,_binary '\0',4,1),(6,_binary '\0',1,1),(7,_binary '\0',4,2),(8,_binary '\0',1,1),(9,_binary '\0',1,1),(10,_binary '\0',2,2),(11,_binary '\0',1,1),(12,_binary '\0',1,1),(13,_binary '\0',1,2),(14,_binary '\0',1,1),(15,_binary '\0',1,2);
/*!40000 ALTER TABLE `cart_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,_binary '\0','Phones'),(2,_binary '\0','Laptops'),(3,_binary '','PC'),(4,_binary '','Phone'),(5,_binary '\0','PCs'),(6,_binary '\0','Watches');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `category_products`
--

LOCK TABLES `category_products` WRITE;
/*!40000 ALTER TABLE `category_products` DISABLE KEYS */;
/*!40000 ALTER TABLE `category_products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,_binary '\0','Color silver,memory 128gb','https://img.gigatron.rs/img/products/large/image5d931f4e066de.png','Iphone 11Pro 128GB',500,1),(2,_binary '\0','Color space silver,memory 128gb','https://img.gigatron.rs/img/products/large/image5e90580999142.png','Huawei Mate 30 Pro',400,1),(3,_binary '\0','Intel core i7 10700k 8C 3.6Ghz,16GB DDR4 Ram','https://cdn.originpc.com/opc/case/opc-blob-469e9d64-8b05-4161-9525-07f2259749c3.png','Origin neuron',2000,5),(4,_binary '\0','G5 15,6\"/Intel Core i5 10300H /8 GB DDR4/256 GB SSD/Windows 10 Home','https://static.tehnomanija.rs/UserFiles/products/2020/009/large/153759.webp','HP Laptop',600,2),(5,_binary '\0','Color black','https://www.kindpng.com/picc/m/104-1041789_samsung-galaxy-watch-active2-hd-png-download.png','Samsung Gear S3',600,6),(6,_binary '\0','Cpu i9-9990k,Ram 32GB DDR4,MBO MSI Z590-A PRO','https://cdn.originpc.com/opc/case/opc-blob-a0f067f0-4f6f-4420-a5b1-95c5add5cfdd.png','Milenium',3000,5),(7,_binary '\0','Color black,memory 128GB','https://www.upc.ch/content/www-upc-ch/inventory/mobile-inventory/samsung/galaxy-s20plus/jcr:content/items/_128gb/images/front/image.img.0.350.png/1610026086840.png','Samsung Galaxy S20+',700,1);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `product_order`
--

LOCK TABLES `product_order` WRITE;
/*!40000 ALTER TABLE `product_order` DISABLE KEYS */;
INSERT INTO `product_order` VALUES (1,'',_binary '\0',900,1,1),(2,'Jugovic 11',_binary '\0',900,2,1),(3,'Test 11',_binary '\0',2000,3,1),(4,'Test address',_binary '\0',500,4,1),(5,'address 11',_binary '\0',2100,5,1),(6,'asddsa',_binary '\0',1300,6,2),(7,'test 11',_binary '\0',500,7,2),(8,'test 11',_binary '\0',900,8,2),(9,'test 11',_binary '\0',900,9,2);
/*!40000 ALTER TABLE `product_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,_binary '\0','admin@gmail.com','Admin','Admin','$2a$12$4B9bdpxGXtyoCmJmAqi1keksK1eItnT3HRt7GnFVWt/mxa2heTWFq','ADMIN'),(2,_binary '','test@gmail.com','test@gmail.com','Test','$2a$10$5s6R1C6tlq4laZUKAOtytOHaQXwvc/3jhWxBawQKajG83yB/fOhum','USER'),(3,_binary '\0','user@gmail.com','user@gmail.com','test','$2a$10$sqnU6kbwXNWJhhDvaHlTYOv3zF/3AECX/JoxYNxheGiAy41wbyjk2','USER');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-17 19:25:49
