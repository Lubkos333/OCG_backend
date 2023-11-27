INSERT INTO cardgame.achievements (`achievement_name`,`achievemen_desc`,`achievemen_thresold`) VALUES ("First Blood","Your mommy will be proud", 1);
INSERT INTO cardgame.achievements (`achievement_name`,`achievemen_desc`,`achievemen_thresold`) VALUES ("Second Blood","Your mommy will be very proud", 2);

INSERT INTO cardgame.cards (`card_name`, `card_desc`, `card_value`, `card_attack`,`card_image`) VALUES ("Test_card", "This card does stuff",1,1,"C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/card_placeholder.jpg");
INSERT INTO cardgame.cards (`card_name`, `card_desc`, `card_value`, `card_attack`) VALUES ("Another_test_card", "This card does stuff too",2,2);

INSERT INTO cardgame.users (`user_name`, `user_password`) VALUES ("Franta Lala", "1234");
INSERT INTO cardgame.users (`user_name`, `user_password`) VALUES ("John Doe", "1111");
INSERT INTO cardgame.users (`user_name`, `user_password`) VALUES ("PussyKiller3000", "0000");

INSERT INTO cardgame.friends (`user_1_ref`, `user_2_ref`,`pending`) VALUES ("1", "2","0");
INSERT INTO cardgame.friends (`user_1_ref`, `user_2_ref`,`pending`) VALUES ("2", "3","1");

INSERT INTO cardgame.user_achievements (`user_ref`,`achievement_ref`) VALUES("1","1");
INSERT INTO cardgame.user_achievements (`user_ref`,`achievement_ref`) VALUES("1","2");

INSERT INTO cardgame.user_cards (`user_ref`,`card_ref`) VALUES("1","1");
INSERT INTO cardgame.user_cards (`user_ref`,`card_ref`) VALUES("1","2");
INSERT INTO cardgame.user_cards (`user_ref`,`card_ref`) VALUES("2","1");
INSERT INTO cardgame.user_cards (`user_ref`,`card_ref`) VALUES("2","2");
INSERT INTO cardgame.user_cards (`user_ref`,`card_ref`) VALUES("3","1");
INSERT INTO cardgame.user_cards (`user_ref`,`card_ref`) VALUES("3","2");



