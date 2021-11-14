DROP TABLE IF EXISTS votes;
DROP TABLE IF EXISTS menus;
DROP TABLE IF EXISTS  user_roles;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS dishes;
DROP TABLE IF EXISTS restaurants;
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

CREATE TABLE user_roles
(
    user_id INTEGER NOT NULL,
    role    VARCHAR,
    CONSTRAINT user_roles_idx UNIQUE (user_id, role),
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE dishes
(

    id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name             VARCHAR                 NOT NULL

);

CREATE TABLE restaurants
(

    id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name             VARCHAR                 NOT NULL

);

CREATE TABLE votes(
    id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    user_id          INTEGER  REFERENCES users (id) ON DELETE CASCADE NOT NULL,
    restaurant_id    INTEGER  REFERENCES restaurants (id) ON DELETE CASCADE NOT NULL

);

CREATE TABLE menus(
    id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    restaurant_id    INTEGER  REFERENCES restaurants (id) ON DELETE CASCADE NOT NULL,
    dish_id          INTEGER  REFERENCES dishes (id) ON DELETE CASCADE NOT NULL,
    price            INTEGER NOT NULL
);

