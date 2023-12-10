INSERT INTO achievements (achievement_name,achievement_desc,achievement_threshold) VALUES ('First Blood','Your mommy will be proud', 1);
INSERT INTO achievements (achievement_name,achievement_desc,achievement_threshold) VALUES ('Second Blood','Your mommy will be very proud', 2);

INSERT INTO cards (card_name, card_desc, card_value, card_attack,card_image) VALUES ('Test_card', 'This card does stuff',1,1,'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/card_placeholder.jpg');
INSERT INTO cards (card_name, card_desc, card_value, card_attack) VALUES ('Another_test_card', 'This card does stuff too',2,2);

INSERT INTO users (user_name, user_password, user_email) VALUES ('Franta Lala', '1234','franta@seznam.cz');
INSERT INTO users (user_name, user_password, user_email) VALUES ('John Doe', '1111','doe@gmail.com');
INSERT INTO users (user_name, user_password, user_email) VALUES ('PussyKiller3000', '0000','auticko@seznam.cz');

INSERT INTO friend_request (user_1_ref, user_2_ref, pending) VALUES ('1', '2','0');
INSERT INTO friend_request (user_1_ref, user_2_ref, pending) VALUES ('2', '3','1');

INSERT INTO user_achievements (user_ref, achievement_ref) VALUES('1','1');
INSERT INTO user_achievements (user_ref, achievement_ref) VALUES('1','2');

INSERT INTO user_cards (user_ref, card_ref) VALUES('1','1');
INSERT INTO user_cards (user_ref, card_ref) VALUES('1','2');
INSERT INTO user_cards (user_ref, card_ref) VALUES('2','1');
INSERT INTO user_cards (user_ref, card_ref) VALUES('2','2');
INSERT INTO user_cards (user_ref, card_ref) VALUES('3','1');
INSERT INTO user_cards (user_ref, card_ref) VALUES('3','2');

INSERT INTO room (name)
VALUES ('/endpoint-one'),
       ('/endpoint-two'),
       ('/endpoint-three'),
       ('/endpoint-four'),
       ('/endpoint-five');


