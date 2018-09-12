-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bdbussean
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.33-MariaDB

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
-- Table structure for table `articulos`
--

DROP TABLE IF EXISTS `articulos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `articulos` (
  `idArticulo` int(11) NOT NULL AUTO_INCREMENT,
  `nombreArticulo` varchar(40) NOT NULL,
  `descripcion` tinytext,
  `foto` text,
  `idTipoArticulo` int(11) NOT NULL,
  `idEstadoArticulo` int(11) NOT NULL,
  PRIMARY KEY (`idArticulo`),
  KEY `articuloTipoArticulo_idx` (`idTipoArticulo`),
  KEY `articuloEstado_idx` (`idEstadoArticulo`),
  CONSTRAINT `articuloEstado` FOREIGN KEY (`idEstadoArticulo`) REFERENCES `estadosarticulos` (`idEstadoArticulo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `articuloTipoArticulo` FOREIGN KEY (`idTipoArticulo`) REFERENCES `tiposarticulo` (`idTipoArticulo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articulos`
--

LOCK TABLES `articulos` WRITE;
/*!40000 ALTER TABLE `articulos` DISABLE KEYS */;
/*!40000 ALTER TABLE `articulos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ciudades`
--

DROP TABLE IF EXISTS `ciudades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ciudades` (
  `idCiudad` int(11) NOT NULL AUTO_INCREMENT,
  `nombreCiudad` varchar(40) NOT NULL,
  PRIMARY KEY (`idCiudad`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciudades`
--

LOCK TABLES `ciudades` WRITE;
/*!40000 ALTER TABLE `ciudades` DISABLE KEYS */;
INSERT INTO `ciudades` VALUES (1,'Bogota'),(2,'Medellin'),(3,'Cali'),(4,'Barranquilla'),(5,'Cartagena de Indias'),(6,'Bucaramanga'),(7,'Pereira'),(8,'Manizales'),(9,'Cucuta'),(10,'Santa Marta'),(11,'Ibague'),(12,'Villavicencio'),(13,'Monteria'),(14,'Armenia'),(15,'Tunja'),(16,'Quibdo'),(17,'Facatativa'),(18,'Soacha'),(19,'Honda'),(20,'Mitu'),(21,'Girardot');
/*!40000 ALTER TABLE `ciudades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientes` (
  `idClienteUsuario` int(11) NOT NULL,
  `nombreLavanderia` varchar(30) NOT NULL,
  `numeroLegal` bigint(20) NOT NULL,
  `direccion` varchar(30) NOT NULL,
  `idEstadoCliente` int(11) NOT NULL,
  `idCiudad` int(11) NOT NULL,
  PRIMARY KEY (`idClienteUsuario`),
  UNIQUE KEY `sigla_UNIQUE` (`numeroLegal`),
  KEY `clienteEstado_idx` (`idEstadoCliente`),
  KEY `clienteCiudad_idx` (`idCiudad`),
  CONSTRAINT `clienteCiudad` FOREIGN KEY (`idCiudad`) REFERENCES `ciudades` (`idCiudad`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `clienteEstado` FOREIGN KEY (`idEstadoCliente`) REFERENCES `estadoscliente` (`idEstadoCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `clienteUsuario` FOREIGN KEY (`idClienteUsuario`) REFERENCES `usuarios` (`idUsuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detallesorden`
--

DROP TABLE IF EXISTS `detallesorden`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detallesorden` (
  `idDetalleOrden` int(11) NOT NULL AUTO_INCREMENT,
  `idArticulo` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `idOrden` int(11) NOT NULL,
  PRIMARY KEY (`idDetalleOrden`),
  KEY `detOrdArticulo_idx` (`idArticulo`),
  KEY `detOrdOrden_idx` (`idOrden`),
  CONSTRAINT `detOrdArticulo` FOREIGN KEY (`idArticulo`) REFERENCES `articulos` (`idArticulo`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `detOrdOrden` FOREIGN KEY (`idOrden`) REFERENCES `ordenes` (`idOrden`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detallesorden`
--

LOCK TABLES `detallesorden` WRITE;
/*!40000 ALTER TABLE `detallesorden` DISABLE KEYS */;
/*!40000 ALTER TABLE `detallesorden` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estadosarticulos`
--

DROP TABLE IF EXISTS `estadosarticulos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estadosarticulos` (
  `idEstadoArticulo` int(11) NOT NULL AUTO_INCREMENT,
  `nombreEstadoArticulo` varchar(20) NOT NULL,
  PRIMARY KEY (`idEstadoArticulo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estadosarticulos`
--

LOCK TABLES `estadosarticulos` WRITE;
/*!40000 ALTER TABLE `estadosarticulos` DISABLE KEYS */;
/*!40000 ALTER TABLE `estadosarticulos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estadoscliente`
--

DROP TABLE IF EXISTS `estadoscliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estadoscliente` (
  `idEstadoCliente` int(11) NOT NULL AUTO_INCREMENT,
  `nombreEstadoCliente` varchar(20) NOT NULL,
  PRIMARY KEY (`idEstadoCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estadoscliente`
--

LOCK TABLES `estadoscliente` WRITE;
/*!40000 ALTER TABLE `estadoscliente` DISABLE KEYS */;
INSERT INTO `estadoscliente` VALUES (1,'Inactivo'),(2,'Activo');
/*!40000 ALTER TABLE `estadoscliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estadosorden`
--

DROP TABLE IF EXISTS `estadosorden`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estadosorden` (
  `idEstadoOrden` int(11) NOT NULL AUTO_INCREMENT,
  `nombreEstadoOrden` varchar(20) NOT NULL,
  PRIMARY KEY (`idEstadoOrden`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estadosorden`
--

LOCK TABLES `estadosorden` WRITE;
/*!40000 ALTER TABLE `estadosorden` DISABLE KEYS */;
/*!40000 ALTER TABLE `estadosorden` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `formaspagos`
--

DROP TABLE IF EXISTS `formaspagos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `formaspagos` (
  `idFormaPago` int(11) NOT NULL AUTO_INCREMENT,
  `formaPago` varchar(20) NOT NULL,
  PRIMARY KEY (`idFormaPago`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `formaspagos`
--

LOCK TABLES `formaspagos` WRITE;
/*!40000 ALTER TABLE `formaspagos` DISABLE KEYS */;
/*!40000 ALTER TABLE `formaspagos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordenes`
--

DROP TABLE IF EXISTS `ordenes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ordenes` (
  `idOrden` int(11) NOT NULL AUTO_INCREMENT,
  `fechaOrden` date NOT NULL,
  `fechaEntrega` date NOT NULL,
  `observacion` text,
  `idFormaPago` int(11) NOT NULL,
  `idEstadoOrden` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  PRIMARY KEY (`idOrden`),
  KEY `ordenEstado_idx` (`idEstadoOrden`),
  KEY `ordenCliente_idx` (`idCliente`),
  KEY `ordenForPago_idx` (`idFormaPago`),
  CONSTRAINT `ordenCliente` FOREIGN KEY (`idCliente`) REFERENCES `clientes` (`idClienteUsuario`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ordenEstado` FOREIGN KEY (`idEstadoOrden`) REFERENCES `estadosorden` (`idEstadoOrden`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ordenForPago` FOREIGN KEY (`idFormaPago`) REFERENCES `formaspagos` (`idFormaPago`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordenes`
--

LOCK TABLES `ordenes` WRITE;
/*!40000 ALTER TABLE `ordenes` DISABLE KEYS */;
/*!40000 ALTER TABLE `ordenes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permisos`
--

DROP TABLE IF EXISTS `permisos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permisos` (
  `idPermiso` int(11) NOT NULL AUTO_INCREMENT,
  `nombrePermiso` varchar(30) NOT NULL,
  `tipoMenu` enum('S','I') NOT NULL,
  `permisoPadre` int(11) DEFAULT NULL,
  `estado` bit(1) NOT NULL,
  `url` tinytext,
  `icon` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idPermiso`),
  KEY `permisoPerPadre_idx` (`permisoPadre`),
  CONSTRAINT `permisoPerPadre` FOREIGN KEY (`permisoPadre`) REFERENCES `permisos` (`idPermiso`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permisos`
--

LOCK TABLES `permisos` WRITE;
/*!40000 ALTER TABLE `permisos` DISABLE KEYS */;
INSERT INTO `permisos` VALUES (1,'Inicio','S',NULL,'','/faces/protegido/administrador/inicio.xhtml','fa fa-home'),(2,'Inicio','S',NULL,'','/faces/protegido/cliente/inicio.xhtml','fa fa-home');
/*!40000 ALTER TABLE `permisos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permisosroles`
--

DROP TABLE IF EXISTS `permisosroles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permisosroles` (
  `idPermiso` int(11) NOT NULL,
  `idRol` int(11) NOT NULL,
  PRIMARY KEY (`idPermiso`,`idRol`),
  KEY `permisoRolRol_idx` (`idRol`),
  CONSTRAINT `permisoRolPermiso` FOREIGN KEY (`idPermiso`) REFERENCES `permisos` (`idPermiso`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `permisoRolRol` FOREIGN KEY (`idRol`) REFERENCES `roles` (`idRol`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permisosroles`
--

LOCK TABLES `permisosroles` WRITE;
/*!40000 ALTER TABLE `permisosroles` DISABLE KEYS */;
INSERT INTO `permisosroles` VALUES (1,1),(2,2);
/*!40000 ALTER TABLE `permisosroles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pqrs`
--

DROP TABLE IF EXISTS `pqrs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pqrs` (
  `idPqr` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` text NOT NULL,
  `fecha` date NOT NULL,
  `idCliente` int(11) NOT NULL,
  PRIMARY KEY (`idPqr`),
  KEY `pqrCliente_idx` (`idCliente`),
  CONSTRAINT `pqrCliente` FOREIGN KEY (`idCliente`) REFERENCES `clientes` (`idClienteUsuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pqrs`
--

LOCK TABLES `pqrs` WRITE;
/*!40000 ALTER TABLE `pqrs` DISABLE KEYS */;
/*!40000 ALTER TABLE `pqrs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedores`
--

DROP TABLE IF EXISTS `proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proveedores` (
  `idProveedor` int(11) NOT NULL,
  `nombreProveedor` varchar(30) NOT NULL,
  `numeroLegal` bigint(20) NOT NULL,
  `direccion` varchar(10) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `idCiudad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedores`
--

LOCK TABLES `proveedores` WRITE;
/*!40000 ALTER TABLE `proveedores` DISABLE KEYS */;
/*!40000 ALTER TABLE `proveedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `respuestas`
--

DROP TABLE IF EXISTS `respuestas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `respuestas` (
  `idRespuestaPqr` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` text NOT NULL,
  `fecha` date NOT NULL,
  PRIMARY KEY (`idRespuestaPqr`),
  CONSTRAINT `respuestaPqr` FOREIGN KEY (`idRespuestaPqr`) REFERENCES `pqrs` (`idPqr`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `respuestasPqr` FOREIGN KEY (`idRespuestaPqr`) REFERENCES `pqrs` (`idPqr`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `respuestas`
--

LOCK TABLES `respuestas` WRITE;
/*!40000 ALTER TABLE `respuestas` DISABLE KEYS */;
/*!40000 ALTER TABLE `respuestas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `idRol` int(11) NOT NULL AUTO_INCREMENT,
  `nombreRol` varchar(30) NOT NULL,
  `rolNombre` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`idRol`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'Administrador',NULL),(2,'Cliente',NULL),(3,'Proveedor',NULL);
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `telefonos`
--

DROP TABLE IF EXISTS `telefonos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `telefonos` (
  `idTelefono` int(11) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  PRIMARY KEY (`idTelefono`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telefonos`
--

LOCK TABLES `telefonos` WRITE;
/*!40000 ALTER TABLE `telefonos` DISABLE KEYS */;
/*!40000 ALTER TABLE `telefonos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tiposarticulo`
--

DROP TABLE IF EXISTS `tiposarticulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tiposarticulo` (
  `idTipoArticulo` int(11) NOT NULL AUTO_INCREMENT,
  `tipoArticulo` varchar(20) NOT NULL,
  PRIMARY KEY (`idTipoArticulo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tiposarticulo`
--

LOCK TABLES `tiposarticulo` WRITE;
/*!40000 ALTER TABLE `tiposarticulo` DISABLE KEYS */;
/*!40000 ALTER TABLE `tiposarticulo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `cedula` bigint(20) NOT NULL,
  `primerNombre` varchar(45) NOT NULL,
  `segundonombre` varchar(45) DEFAULT NULL,
  `primerApellido` varchar(45) NOT NULL,
  `segundoApellido` varchar(45) DEFAULT NULL,
  `clave` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `fidelizacion` varchar(45) NOT NULL,
  `idRol` int(11) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE KEY `cedula_UNIQUE` (`cedula`),
  KEY `rolUsuario` (`idRol`),
  CONSTRAINT `rolUsuario` FOREIGN KEY (`idRol`) REFERENCES `roles` (`idRol`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (100,27062018,'Alexander',NULL,'Gutierrez',NULL,'12345','alex@correo.com','7177187','*',1),(101,26062018,'Juan',NULL,'Suarez',NULL,'12345','suarez@gmail.com','7177187','*',2),(102,25062018,'Carlos',NULL,'Gomez',NULL,'12345','juancarlos@correo.com','7177187','*',3);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-09-12 17:36:24
