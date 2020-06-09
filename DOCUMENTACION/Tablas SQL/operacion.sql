create database if not exists concesionario;

USE `concesionario`;

DROP TABLE IF EXISTS `operacion`;

CREATE TABLE `operacion` (
  `IDoperacion` int NOT NULL AUTO_INCREMENT,
  `Idvendedor` int NOT NULL,
  `IDvehiculo` int NOT NULL,
  `IDcliente` int NOT  NULL,
  `Date` varchar(12) DEFAULT NULL,
  `Numdias` int DEFAULT NULL,
  `Importe`  double DEFAULT NULL,
  `Financiacion` varchar(2) DEFAULT NULL,
  `Meses`  int DEFAULT NULL,
  `Formapago` varchar(30) DEFAULT NULL,
  `Tipooferta` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`IDoperacion`),
  FOREIGN KEY (`Idvendedor`) REFERENCES usuario(`idUsuario`),
  FOREIGN KEY (`IDvehiculo`) REFERENCES vehiculo(`idVehiculo`),
  FOREIGN KEY (`IDcliente`) REFERENCES usuario(`idUsuario`)


);


show tables;
