-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: bd_divasbank
-- ------------------------------------------------------
-- Server version	8.0.31

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
  `id` bigint NOT NULL,
  `agencia` int DEFAULT NULL,
  `ativo` bit(1) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `data_nascimento` varchar(12) NOT NULL,
  `email` varchar(100) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `renda_mensal` double NOT NULL,
  `telefone` varchar(255) NOT NULL,
  `conta_id` bigint DEFAULT NULL,
  `endereco_id_endereco` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_r1u8010d60num5vc8fp0q1j2a` (`cpf`),
  UNIQUE KEY `UK_cmxo70m08n43599l3h0h07cc6` (`email`),
  KEY `FKecelonnki00i82at8krt5ptjs` (`conta_id`),
  KEY `FKh0xbiq7232e2rjfe30rv36ucr` (`endereco_id_endereco`),
  CONSTRAINT `FKecelonnki00i82at8krt5ptjs` FOREIGN KEY (`conta_id`) REFERENCES `conta` (`id`),
  CONSTRAINT `FKh0xbiq7232e2rjfe30rv36ucr` FOREIGN KEY (`endereco_id_endereco`) REFERENCES `endereco` (`id_endereco`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (3,1,_binary '','003.002.002-00','23111986','paula@email','Paula Belmiro',2500,'5191072552',1,2),(6,1,_binary '\0','001.003.002-00','01011990','bruna@email','Bruna Hirano',2500,'71999992222',4,5),(9,1,_binary '','001.002.001-00','01011990','luiza@email','Luiza Trocino',2500,'11999992222',7,8),(12,1,_binary '','001.002.032-00','01011990','kalli@email','Kalliandra Lima',2500,'81999992222',10,11),(15,1,_binary '','001.026.036-00','01011990','rosana@email','Rosana Oliveira',2500,'71999992222',13,14),(18,1,_binary '','012.126.036-00','01011990','yasmin@email','Yasmin Porto',2500,'47999992222',16,17),(21,1,_binary '','022.426.036-00','01011990','cami@email','Camila Avila',2500,'11999992222',19,20),(24,1,_binary '','002.126.001-00','01011990','carina@email','Carina Aguiar',2500,'51999992222',22,23),(27,1,_binary '','001.100.201-00','01011990','aline@email','Aline Borges',2500,'11998882222',25,26),(33,1,_binary '','002.100.201-00','01011990','simon@email','Simon Banguela',2500,'11999882222',31,32),(43,1,_binary '','033.100.201-00','01011990','gal@email','Gal Costa',2500,'11999882222',41,42);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conta`
--

DROP TABLE IF EXISTS `conta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `conta` (
  `id` bigint NOT NULL,
  `ativo` bit(1) DEFAULT NULL,
  `digito` int NOT NULL,
  `numero` bigint NOT NULL,
  `saldo` double NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_i0yefx3uy4mtik3ldcc9cu0a9` (`numero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conta`
--

LOCK TABLES `conta` WRITE;
/*!40000 ALTER TABLE `conta` DISABLE KEYS */;
INSERT INTO `conta` VALUES (1,_binary '',5,4066,250),(4,_binary '\0',6,9829,550),(7,_binary '',8,2166,650),(10,_binary '',1,772,980),(13,_binary '',7,6102,786),(16,_binary '',6,1426,1299),(19,_binary '',6,3314,2390),(22,_binary '',0,7324,1560),(25,_binary '',5,5860,3540),(28,_binary '',8,9902,3540),(31,_binary '',8,7831,0),(35,_binary '',8,6402,0),(38,_binary '',5,7705,0),(41,_binary '',2,6614,0);
/*!40000 ALTER TABLE `conta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `endereco`
--

DROP TABLE IF EXISTS `endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `endereco` (
  `id_endereco` bigint NOT NULL,
  `bairro` varchar(255) NOT NULL,
  `cep` varchar(9) NOT NULL,
  `cidade` varchar(255) NOT NULL,
  `estado` varchar(2) NOT NULL,
  `numero` varchar(10) NOT NULL,
  `pais` varchar(255) NOT NULL,
  `rua` varchar(255) NOT NULL,
  PRIMARY KEY (`id_endereco`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endereco`
--

LOCK TABLES `endereco` WRITE;
/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
INSERT INTO `endereco` VALUES (2,'Jardim dos Lagos','92714-680','Guaíba','RS','441','Brasil','Cenair Maica'),(5,'Centro','01430-001','São Paulo','SP','100','Brasil','Av Brasil'),(8,'Centro','01430-001','São Paulo','SP','1000/22','Brasil','Av Brasil'),(11,'Centro','01430-001','São Paulo','SP','680','Brasil','Av Brasil'),(14,'Centro','01430-001','São Paulo','SP','400A','Brasil','Av Brasil'),(17,'Centro','01430-001','São Paulo','SP','1256','Brasil','Av Brasil'),(20,'Centro','01430-001','São Paulo','SP','2000/10','Brasil','Av Brasil'),(23,'Centro','90430-001','Porto Alegre','RS','126B','Brasil','Av Brasil'),(26,'Centro','01430-001','São Paulo','SP','3267','Brasil','Av Brasil'),(29,'Centro','01430-001','São Paulo','SP','3267','Brasil','Av Brasil'),(32,'Centro','01430-001','São Paulo','SP','2267','Brasil','Av Brasil'),(36,'Centro','01430-001','São Paulo','SP','2267','Brasil','Av Brasil'),(39,'Centro','01430-001','São Paulo','SP','2267','Brasil','Av Brasil'),(42,'Centro','01430-001','São Paulo','SP','2267','Brasil','Av Brasil');
/*!40000 ALTER TABLE `endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (44);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transacao`
--

DROP TABLE IF EXISTS `transacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transacao` (
  `id` bigint NOT NULL,
  `data` datetime DEFAULT NULL,
  `numero_conta_destino` bigint NOT NULL,
  `numero_conta_origem` bigint NOT NULL,
  `tipo_transacao` varchar(60) NOT NULL,
  `valor` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transacao`
--

LOCK TABLES `transacao` WRITE;
/*!40000 ALTER TABLE `transacao` DISABLE KEYS */;
INSERT INTO `transacao` VALUES (34,'2022-11-22 20:45:45',4066,2166,'transferencia',100);
/*!40000 ALTER TABLE `transacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'bd_divasbank'
--

--
-- Dumping routines for database 'bd_divasbank'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-22 22:40:08
