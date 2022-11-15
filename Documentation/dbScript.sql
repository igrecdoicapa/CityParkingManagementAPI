create database cityparkingmanagementapi;

use cityparkingmanagementapi;

CREATE TABLE `city` (
  `int_id` int NOT NULL AUTO_INCREMENT,
  `id` varchar(10) DEFAULT NULL,
  `name` varchar(256) DEFAULT NULL,
  `code` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`int_id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `parking_facility` (
  `int_id` int NOT NULL AUTO_INCREMENT,
  `id` varchar(10) DEFAULT NULL,
  `name` varchar(256) DEFAULT NULL,
  `id_city` int DEFAULT NULL,
  `capacity` int DEFAULT NULL,
  `available_capacity` int DEFAULT NULL,
  `parking_type` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`int_id`),
  UNIQUE KEY `id` (`id`),
  KEY `id_city` (`id_city`),
  CONSTRAINT `parking_facility_ibfk_1` FOREIGN KEY (`id_city`) REFERENCES `city` (`int_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `vehicle` (
  `int_id` int NOT NULL AUTO_INCREMENT,
  `id` varchar(10) DEFAULT NULL,
  `id_city` int DEFAULT NULL,
  `is_parked` int DEFAULT NULL,
  `id_parking_facility` int DEFAULT NULL,
  `vehicle_type` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`int_id`),
  UNIQUE KEY `id` (`id`),
  KEY `id_city` (`id_city`),
  KEY `id_parking_facility` (`id_parking_facility`),
  CONSTRAINT `vehicle_ibfk_1` FOREIGN KEY (`id_city`) REFERENCES `city` (`int_id`),
  CONSTRAINT `vehicle_ibfk_2` FOREIGN KEY (`id_parking_facility`) REFERENCES `parking_facility` (`int_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

