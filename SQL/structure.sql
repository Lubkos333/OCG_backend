CREATE TABLE `achievements` (
  `achievement_id` int NOT NULL AUTO_INCREMENT,
  `achievement_name` varchar(45) DEFAULT 'placeholder_value',
  `achievemen_desc` varchar(45) DEFAULT 'placeholder_value',
  `achievemen_thresold` int DEFAULT '-1',
  PRIMARY KEY (`achievement_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `cards` (
  `card_id` int NOT NULL AUTO_INCREMENT,
  `card_name` varchar(45) DEFAULT 'placeholder_value',
  `card_desc` varchar(45) DEFAULT 'placeholder_value',
  `card_value` int DEFAULT '-1',
  `card_attack` int DEFAULT '-1',
  `card_image` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`card_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `friends` (
  `friends_id` int NOT NULL AUTO_INCREMENT,
  `user_1_ref` int NOT NULL,
  `user_2_ref` int NOT NULL,
  `pending` tinyint(1) NOT NULL,
  PRIMARY KEY (`friends_id`),
  KEY `friends_user_1_ref_idx` (`user_1_ref`),
  KEY `friends_user_2_ref_idx` (`user_2_ref`),
  CONSTRAINT `friends_user_1_ref` FOREIGN KEY (`user_1_ref`) REFERENCES `users` (`user_id`),
  CONSTRAINT `friends_user_2_ref` FOREIGN KEY (`user_2_ref`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `sessions` (
  `session_id` int NOT NULL AUTO_INCREMENT,
  `session_name` varchar(100) NOT NULL,
  `user_1_id` int DEFAULT NULL,
  `user_2_id` int DEFAULT NULL,
  PRIMARY KEY (`session_id`),
  KEY `sessions_user_1_ref_idx` (`user_1_id`),
  KEY `sessions_user_2_ref_idx` (`user_2_id`),
  CONSTRAINT `sessions_user_1_ref` FOREIGN KEY (`user_1_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `sessions_user_2_ref` FOREIGN KEY (`user_2_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `user_achievements` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_ref` int NOT NULL,
  `achievement_ref` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_ref_idx` (`user_ref`),
  KEY `achievement_ref_idx` (`achievement_ref`),
  CONSTRAINT `achievements_achievement_ref` FOREIGN KEY (`achievement_ref`) REFERENCES `achievements` (`achievement_id`),
  CONSTRAINT `achievements_user_ref` FOREIGN KEY (`user_ref`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `user_cards` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_ref` int NOT NULL,
  `card_ref` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_ref_idx` (`user_ref`),
  KEY `cards_card_ref_idx` (`card_ref`),
  CONSTRAINT `cards_card_ref` FOREIGN KEY (`card_ref`) REFERENCES `cards` (`card_id`),
  CONSTRAINT `cards_user_ref` FOREIGN KEY (`user_ref`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `users` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL,
  `user_password` varchar(45) NOT NULL,
  `victory_count` int DEFAULT '0',
  `user_email` varchar(45) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;




