CREATE SEQUENCE user_id_seq;

CREATE TABLE users(
            id BIGINT NOT NULL DEFAULT nextval('user_id_seq'::regclass) PRIMARY key,
            name VARCHAR(30)
);