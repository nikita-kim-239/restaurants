DELETE FROM user_roles;
DELETE FROM users;
DELETE FROM dishes;
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

