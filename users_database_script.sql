USE `library-project`;

DROP TABLE IF EXISTS `authorities`;
DROP TABLE IF EXISTS `users`;

--
-- Table for users
--

CREATE TABLE `users` (
	`username` varchar(50) NOT NULL,
    `password` varchar(50) NOT NULL,
    `enabled` tinyint NOT NULL,
    PRIMARY KEY (`username`)
    )ENGINE=InnoDB DEFAULT CHARSET=latin1;
    
--
-- Insert some data for users
--

INSERT INTO `users` 
VALUES 
('john','{noop}test123',1),
('mary','{noop}test123',1);

--
-- Table for authorities
--

CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

  
--
-- Insert some data for authorities
--

INSERT INTO `authorities` VALUES
('john', 'ROLE_USER'),
('mary', 'ROLE_USER'),
('mary', 'ROLE_ADMIN');