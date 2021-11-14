DELETE FROM menus;
DELETE FROM votes;
DELETE FROM user_roles;
DELETE FROM users;
DELETE FROM dishes;
DELETE FROM restaurants;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('Ivan', 'ivan@yandex.ru', 'password'),
       ('Petr', 'petr@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id)
VALUES ('USER', 100000),
       ('ADMIN', 100001);

INSERT INTO dishes (name)
VALUES ('bread'),
       ('tea'),
       ('juice'),
       ('meat'),
       ('salad'),
       ('water');


INSERT INTO restaurants (name)
VALUES ('Russian'),
       ('French'),
       ('Italian'),
       ('Chinese');

INSERT INTO votes (user_id, restaurant_id)
VALUES (100000,100008),
       (100001,100009);


INSERT INTO menus (restaurant_id,dish_id,price)
VALUES (100008,100005,100),
       (100008,100006,200),
       (100009,100004,50),
       (100010,100003,90),
       (100011,100007,300);




