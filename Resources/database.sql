CREATE TABLE IF NOT EXISTS `player` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `authenticationTicket` varchar(255) DEFAULT NULL,
  `accountId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `authenticationTicket` (`authenticationTicket`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

INSERT INTO `player` (`id`, `username`, `authenticationTicket`, `accountId`) VALUES
	(1, 'Leon', NULL, 1);
