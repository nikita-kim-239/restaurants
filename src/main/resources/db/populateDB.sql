DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('Ivan', 'ivan@yandex.ru', 'password'),
       ('Petr', 'petr@gmail.com', 'admin');