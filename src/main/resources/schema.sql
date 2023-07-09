DROP TABLE IF EXISTS venues;

CREATE TABLE IF NOT EXISTS venues (
id       VARCHAR(60)  PRIMARY KEY,
name     VARCHAR      NOT NULL,
capacity INTEGER      NOT NULL,
accessibility INTEGER
);