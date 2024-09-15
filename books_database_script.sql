CREATE DATABASE  IF NOT EXISTS `library-project`;
USE `library-project`;

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `author` varchar(45) DEFAULT NULL,
  `copies` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


INSERT INTO `book` VALUES 
				(1,'John Ronald Reuel Tolkien', 'Martin', 5);


