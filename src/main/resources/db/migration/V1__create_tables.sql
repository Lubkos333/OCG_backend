CREATE SEQUENCE achievements_id_seq;
CREATE SEQUENCE cards_id_seq;
CREATE SEQUENCE friend_request_id_seq;
CREATE SEQUENCE sessions_id_seq;
CREATE SEQUENCE user_cards_id_seq;
CREATE SEQUENCE user_achievements_id_seq;
CREATE SEQUENCE users_id_seq;

CREATE TABLE achievements (
          id BIGINT NOT NULL DEFAULT nextval('achievements_id_seq'::regclass) PRIMARY key,
          achievement_name varchar(45) DEFAULT 'placeholder_value',
          achievement_desc varchar(45) DEFAULT 'placeholder_value',
          achievement_threshold int DEFAULT '-1'
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

CREATE TABLE friend_request (
          id BIGINT NOT NULL DEFAULT nextval('friend_request_id_seq'::regclass) PRIMARY key,
          user_1_ref BIGINT NOT NULL,
          user_2_ref BIGINT NOT NULL,
          pending int NOT NULL,
          CONSTRAINT friends_user_1_ref FOREIGN KEY (user_1_ref) REFERENCES users (id),
          CONSTRAINT friends_user_2_ref FOREIGN KEY (user_2_ref) REFERENCES users (id)
);

CREATE TABLE sessions (
          id BIGINT NOT NULL DEFAULT nextval('sessions_id_seq'::regclass) PRIMARY key,
          session_name varchar(100) NOT NULL,
          user_1_id BIGINT DEFAULT NULL,
          user_2_id BIGINT DEFAULT NULL,
          CONSTRAINT sessions_user_1_ref FOREIGN KEY (user_1_id) REFERENCES users (id),
          CONSTRAINT sessions_user_2_ref FOREIGN KEY (user_2_id) REFERENCES users (id)
);

CREATE TABLE user_achievements (
          id BIGINT NOT NULL DEFAULT nextval('user_achievements_id_seq'::regclass) PRIMARY key,
          user_ref BIGINT NOT NULL,
          achievement_ref BIGINT NOT NULL,
          CONSTRAINT achievements_achievement_ref FOREIGN KEY (achievement_ref) REFERENCES achievements (id),
          CONSTRAINT achievements_user_ref FOREIGN KEY (user_ref) REFERENCES users (id)
);

CREATE TABLE user_cards (
          id BIGINT NOT NULL DEFAULT nextval('user_cards_id_seq'::regclass) PRIMARY key,
          user_ref BIGINT NOT NULL,
          card_ref BIGINT NOT NULL,
          CONSTRAINT cards_card_ref FOREIGN KEY (card_ref) REFERENCES cards (id),
          CONSTRAINT cards_user_ref FOREIGN KEY (user_ref) REFERENCES users (id)
);