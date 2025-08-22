-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: imobiliaria
-- ------------------------------------------------------
-- Server version	9.1.0

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `cpf` varchar(15) DEFAULT NULL,
  `telefone` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Carlos Pereira','11122233344','11977777777','carlos@email.com'),(2,'Ana Lima','55566677788','11966666666','ana@email.com'),(3,'Roberto Alves','99988877766','11955555555','roberto@email.com'),(4,'Fernanda Costa','33344455566','11944444444','fernanda@email.com'),(5,'Marcos Oliveira','77788899900','11933333333','marcos@email.com'),(6,'João','12345678900','119999999','joao@email.com'),(7,'João','12345678900','119999999','joao@email.com'),(8,'rbertha','2323232323','9895622','eyrmfkge@gmail');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contrato`
--

DROP TABLE IF EXISTS `contrato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contrato` (
  `id` int NOT NULL AUTO_INCREMENT,
  `imovel_id` int DEFAULT NULL,
  `cliente_id` int DEFAULT NULL,
  `valor` double DEFAULT NULL,
  `data_inicio` date DEFAULT NULL,
  `data_fim` date DEFAULT NULL,
  `ativo` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `imovel_id` (`imovel_id`),
  KEY `cliente_id` (`cliente_id`),
  CONSTRAINT `contrato_ibfk_1` FOREIGN KEY (`imovel_id`) REFERENCES `imovel` (`id`),
  CONSTRAINT `contrato_ibfk_2` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contrato`
--

LOCK TABLES `contrato` WRITE;
/*!40000 ALTER TABLE `contrato` DISABLE KEYS */;
INSERT INTO `contrato` VALUES (1,1,1,1200,'2025-07-01','2026-06-30',1),(2,2,2,2000,'2025-06-15','2026-06-14',1),(3,3,3,900,'2025-05-01','2025-10-30',1),(4,4,4,2500,'2025-04-01','2025-09-30',1),(5,5,5,1300,'2025-03-15','2025-09-14',1),(6,1,2,1200,'2024-07-01','2025-06-30',0),(7,2,3,2000,'2024-06-15','2025-06-14',0),(8,1,1,1200,'2025-08-01','2026-08-01',1),(9,1,1,1200,'2025-08-01','2026-08-01',1);
/*!40000 ALTER TABLE `contrato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `imovel`
--

DROP TABLE IF EXISTS `imovel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `imovel` (
  `id` int NOT NULL AUTO_INCREMENT,
  `endereco` varchar(255) DEFAULT NULL,
  `tipo` varchar(50) DEFAULT NULL,
  `quartos` int DEFAULT NULL,
  `valor_aluguel` double DEFAULT NULL,
  `disponivel` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `imovel`
--

LOCK TABLES `imovel` WRITE;
/*!40000 ALTER TABLE `imovel` DISABLE KEYS */;
INSERT INTO `imovel` VALUES (1,'Rua C, 789','Apartamento',1,900,1),(2,'Av. Central, 101','Casa',4,2500,1),(3,'Rua das Flores, 202','Apartamento',3,1800,1),(4,'Rua Nova, 303','Casa',2,1500,1),(5,'Av. Brasil, 404','Apartamento',2,1300,1),(6,'Rua C, 789','Apartamento',1,900,1),(7,'Rua C, 789','Apartamento',1,900,1),(8,'rua casa','ap',2,1000,1),(9,'rua maria','apartamento',4,1700,1),(10,'rua ana, 54','casa',5,7000,1),(11,'rua P, 69','apartamento',5,7000,1),(12,'rua M, 85','casa',5,8000,1),(13,'Heriberto Petry, 483','dmksmdksmdksmd',3,7777,1);
/*!40000 ALTER TABLE `imovel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'imobiliaria'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-08-22  1:54:06
