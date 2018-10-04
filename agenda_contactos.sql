-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: agenda
-- ------------------------------------------------------
-- Server version	5.7.20-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `citas`
--

DROP TABLE IF EXISTS `citas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `citas` (
  `con_persona` varchar(30) NOT NULL COMMENT 'nombre del contacto',
  `con_lugar` varchar(15) NOT NULL COMMENT 'lugar de reunion',
  `con_hora` varchar(10) NOT NULL COMMENT 'hora de encuentro',
  `con_descripcion` varchar(150) NOT NULL COMMENT 'descrpcion de la cita',
  PRIMARY KEY (`con_persona`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='tabla con los nombres de conocidos';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `citas`
--

LOCK TABLES `citas` WRITE;
/*!40000 ALTER TABLE `citas` DISABLE KEYS */;
INSERT INTO `citas` VALUES ('Brayan David Chaparro','Cafe TOSTAO','10:00 am','Charla proyecto JAVA'),('Johan Rincon Amaya','U.Distrital','08:30 am','Refuerzo academico'),('Kevin Santiago Cuellar',' Cra 7 - 40','03:00 pm','Solucion trabajo extracurricular'),('Santiago Chauta','Cafe TOSTAO','10:00 am','Charla proyecto JAVA'),('Vivian Peña Hurtado','U.Nacional','12:00 pm','Almuerzo, discusion filosofica de la vida');
/*!40000 ALTER TABLE `citas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contactos`
--

DROP TABLE IF EXISTS `contactos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contactos` (
  `con_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'identificador del contacto',
  `con_nombre` varchar(30) NOT NULL COMMENT 'nombre del contacto',
  `con_apellido` varchar(30) NOT NULL COMMENT 'apellido del contacto',
  `con_telefono_domicilio` varchar(15) NOT NULL COMMENT 'telefono de la casa',
  `con_telefono_oficina` varchar(15) NOT NULL COMMENT 'telefono trabajo',
  `con_celular` varchar(20) NOT NULL COMMENT 'celular personal',
  `con_correo` varchar(150) NOT NULL COMMENT 'email personal',
  `con_direccion_residencia` varchar(150) NOT NULL COMMENT 'direccion de residencia',
  `con_direccion_trabajo` varchar(150) NOT NULL COMMENT 'direccion de trabajo',
  PRIMARY KEY (`con_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='tabla con los nombres de conocidos';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contactos`
--

LOCK TABLES `contactos` WRITE;
/*!40000 ALTER TABLE `contactos` DISABLE KEYS */;
INSERT INTO `contactos` VALUES (1,'Keivn Duvan','Bernal Ortiz','7782636','7782636','3132248033','kevinduvanbernalortiz@gmail.com','cll 71 b # 80 J 53','cll 71 b # 80 J 53'),(2,'Johan','Rincon Amaya','8932066','8932066','3007874469','Johanrinena@hotmail.com','cll 80 bis sur','cll 80 bis sur'),(3,'Nicolas','Gutierrez Morales','4974320','4974320','3106010259','ndgutierrezm@udistrtital.edu.co','cll 80 bis sur','cll 80 bis sur'),(4,'Jose','Diaz Aguilar','4610710','4610710','3043364257','nikolazbotwe@hotmail.com','cll 80 bis sur','cll 80 bis sur'),(5,'Cristian','Yara Pardo','5701252','5701252','3204231096','cmyarap@correo.udistrital.edu.co','cll 80 bis sur','cll 80 bis sur'),(6,'Juan Felipe','Herrera Poveda','8285065','8285065','3188419339','Jtherrerap@correo.udistrital.edu.co','cll 80 bis sur','cll 80 bis sur'),(7,'Fabian Enrique','Leon','4516130','4516130','3207649016','feleoni@correo.udistrital.edu.co','cll 80 bis sur','cll 80 bis sur'),(8,'Esteban','Triana','2516130','2516130','3193398040','jenoratot@correo.udistrital.edu.co','cll 80 bis sur','cll 80 bis sur'),(9,'Ivan Santigo','Chauta Gaviria','3528102','3528102','3506632164','santiagochauta@gmail.com','cll 80 bis sur','cll 80 bis sur'),(10,'Kevin Santiago','Garcia Cuellar','2287315','2287315','3103048275','kevingarcia.cuellar94@gmail.com','cll 80 bis sur','cll 80 bis sur'),(11,'Kevin Forero','Gualtero','4178898','4178898','3204178898','kevinandresforero@hotmail.com','cll 80 bis sur','cll 80 bis sur'),(12,'Alex','Rodriguez','7156701','7156701','3138040642','alexh.2401@hotmail.com','cll 80 bis sur','cll 80 bis sur'),(13,'Vivian','Peña Hurtado','7427353','7427353','3114612307','pavipehu1@gmail.com','cll 80 bis sur','cll 80 bis sur'),(14,'Alejandro','Gonzalez','7033212','7033212','3173881033','diegobermu1003@gmail.com','cll 80 bis sur','cll 80 bis sur'),(15,'Nicolas','Valderrama','4022153','4022153','3143155135','expectopatrum@gmail.com','cll 80 bis sur','cll 80 bis sur'),(16,'Camilo Andres','Caiman','4610589','4610589','3005931246','caimanco8@gmail.com','cll 80 bis sur','cll 80 bis sur'),(17,'Julian','Torres','4381237','4381237','3202882648','julianfelipeotxs@outlook.com','cll 80 bis sur','cll 80 bis sur'),(18,'Carlos','Correa','7367012','7367012','3205366790','cardorre14@gmail.com','cll 80 bis sur','cll 80 bis sur'),(19,'Jefferson','Bojaca','2981148','2981148','3204333497','manuel.bojaca@outllok.com','cll 80 bis sur','cll 80 bis sur');
/*!40000 ALTER TABLE `contactos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-04  7:48:04
