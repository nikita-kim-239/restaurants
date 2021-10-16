DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 100000;

CREATE TABLE users
(
    id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name             VARCHAR                 NOT NULL,
    email            VARCHAR                 NOT NULL,
    password         VARCHAR                 NOT NULL,
    registered       TIMESTAMP DEFAULT now() NOT NULL,
    enabled          BOOL DEFAULT TRUE       NOT NULL
);