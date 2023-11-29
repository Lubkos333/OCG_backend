CREATE SEQUENCE achievements_id_seq;
CREATE SEQUENCE cards_id_seq;
CREATE SEQUENCE friends_id_seq;
CREATE SEQUENCE sessions_id_seq;
CREATE SEQUENCE user_cards_id_seq;
CREATE SEQUENCE user_achievements_id_seq;
CREATE SEQUENCE users_id_seq;

CREATE TABLE achievements (
          id BIGINT NOT NULL DEFAULT nextval('achievements_id_seq'::regclass) PRIMARY key,
          achievement_name varchar(45) DEFAULT 'placeholder_value',
          achievemen_desc varchar(45) DEFAULT 'placeholder_value',
          achievemen_thresold int DEFAULT '-1'
);

CREATE TABLE users (
          id BIGINT NOT NULL DEFAULT nextval('users_id_seq'::regclass) PRIMARY key,
          user_name varchar(50) NOT NULL,
          user_password varchar(45) NOT NULL,
          victory_count int DEFAULT '0',
          user_email varchar(45) NOT NULL
);

CREATE TABLE cards (
          id BIGINT NOT NULL DEFAULT nextval('cards_id_seq'::regclass) PRIMARY key,
          card_name varchar(45) DEFAULT 'placeholder_value',
          card_desc varchar(45) DEFAULT 'placeholder_value',
          card_value int DEFAULT '-1',
          card_attack int DEFAULT '-1',
          card_image varchar(200) DEFAULT NULL
);

CREATE TABLE friends (
          id BIGINT NOT NULL DEFAULT nextval('friends_id_seq'::regclass) PRIMARY key,
          user_1_ref int NOT NULL,
          user_2_ref int NOT NULL,
          pending int NOT NULL,
          CONSTRAINT friends_user_1_ref FOREIGN KEY (user_1_ref) REFERENCES users (id),
          CONSTRAINT friends_user_2_ref FOREIGN KEY (user_2_ref) REFERENCES users (id)
);

CREATE TABLE sessions (
          id BIGINT NOT NULL DEFAULT nextval('sessions_id_seq'::regclass) PRIMARY key,
          session_name varchar(100) NOT NULL,
          user_1_id int DEFAULT NULL,
          user_2_id int DEFAULT NULL,
          CONSTRAINT sessions_user_1_ref FOREIGN KEY (user_1_id) REFERENCES users (id),
          CONSTRAINT sessions_user_2_ref FOREIGN KEY (user_2_id) REFERENCES users (id)
);

CREATE TABLE user_achievements (
          id BIGINT NOT NULL DEFAULT nextval('user_achievements_id_seq'::regclass) PRIMARY key,
          user_ref int NOT NULL,
          achievement_ref int NOT NULL,
          CONSTRAINT achievements_achievement_ref FOREIGN KEY (achievement_ref) REFERENCES achievements (id),
          CONSTRAINT achievements_user_ref FOREIGN KEY (user_ref) REFERENCES users (id)
);

CREATE TABLE user_cards (
          id BIGINT NOT NULL DEFAULT nextval('user_cards_id_seq'::regclass) PRIMARY key,
          user_ref int NOT NULL,
          card_ref int NOT NULL,
          CONSTRAINT cards_card_ref FOREIGN KEY (card_ref) REFERENCES cards (id),
          CONSTRAINT cards_user_ref FOREIGN KEY (user_ref) REFERENCES users (id)
);