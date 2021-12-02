Это система голосования за рестораны, которая определяет, где будет происходить ланч. Приложение без фронтенда.

Взаимодействие происходит с помощью curl.

Команды:

    1)Получить все рестораны вместе с меню и голосами(доступно всем):
    curl localhost:8080/restaurants 

    2)Получить все блюда(доступно всем)
    curl localhost:8080/dishes

    3)Получить всех пользователей(доступно только админу)
    curl localhost:8080/admin/users --user {email}:{password}

    4)Добавить новый ресторан(доступно только админу)
    curl -H "Content-Type: application/json"  --request POST  --data "{\"name\":\"{name}\"}"  localhost:8080/admin/restaurants --user {email}:{password}

    5)Добавить новое блюдо(доступно только админу)
    curl -H "Content-Type: application/json"  --request POST  --data "{\"name\":\"{name}\"}"  localhost:8080/admin/dishes --user {email}:{password}
    
    6)Зарегистрироваться(доступно всем)
    curl -H "Content-Type: application/json"  --request POST  --data "{\"name\":\"{name}\",\"email\":\"{email}\",\"password\":\"{password}\"}"  localhost:8080/register