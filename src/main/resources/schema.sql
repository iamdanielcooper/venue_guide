DROP TABLE IF EXISTS users;

CREATE TABLE IF NOT EXISTS users (
id           VARCHAR(60)    PRIMARY KEY,
username     VARCHAR        NOT NULL,
email        VARCHAR        NOT NULL,
password     VARCHAR        NOT NULL
);