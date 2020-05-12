
//Creates table transaction

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction` (
  `id` bigint NOT NULL,
  `bookid` varchar(255) DEFAULT NULL,
  `counter_partyid` varchar(255) DEFAULT NULL,
  `createddt` varchar(255) DEFAULT NULL,
  `expired` bit(1) NOT NULL,
  `maturitydt` varchar(255) DEFAULT NULL,
  `prev_tradeid` varchar(255) DEFAULT NULL,
  `tradeid` varchar(255) DEFAULT NULL,
  `versionid` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


//creates an event to check and update store's Expired flag on every day 1pm

CREATE EVENT updateExpiredFlag
  ON SCHEDULE
    EVERY 1 DAY
    STARTS (TIMESTAMP(CURRENT_DATE) + INTERVAL 1 DAY + INTERVAL 1 HOUR)
  DO
    
	 UPDATE transaction
	 SET expired=1
	 WHERE maturitydt<CURRENT_DATE	
     
     
	


