# CompanyMicroservices

Pet-project приложения с сихронным взаимодействием микросервисов компаний и клиентов, облачным сервером хранящим конфигурацию микросервисов и расположенным в репозитории.

[Ссылка на сервер](https://github.com/TaarMaan/Configuration)

## Необходимые технологии для запуска

- Intellij Idea
- Docker
- Postman
- PostgreSQL

## Установка и запуск приложения

- git clone https://github.com/TaarMaan/CompanyMicrosrvices или локальная устновка проекта

- Создаем свой репозиторий облачного сервера:
  -  > git clone https://github.com/TaarMaan/Configuration или локальная устновка проекта
  -  > меняем в ссылку на облачный сервер /CompanyMicrosrvices/SpringServer/src/main/resources/application.properies

- Черновой запуск для первичной настройки окружения в keycloak:
  - > cd ссылка на модуль SpringClient
  - > docker-compose up
  - > http://127.0.0.1:8484/auth/
  - > создаем свой realm -> создаем свой клиент (Access Type = "confidential", Authorization Enable "ON", Valid redirect URLS = http://localhost:8080/*) -> создаем роли наших пользователей (admin, user) -> во вкладке "Users"-"Admin"/"User"-"Role Mappings" добавляем админу роль admin/юзер - user и во вкладке "Credentials" выставляем пароли нашим ролям -> возвращаемся в "Clients" находим наше приложение "Edit"-"Credentials" копируем "client secret" себе в конфигурацию. Ссылку на гайд будет ниже.

- Добавляем наши базульки в database вкладке нашей идейке (ультимейт версия)

- В Postman открываем нашу коллекцию эндпоинтов /CompanyMicrosrvices/SpringClient/microservices.postman_collection.json и в переменных находим "micro-2" меняем наш Bearer token , который находится в нашем окружении keycloak там же где мы брали client secret - ниже в поле Registraion token

#  Ссылки на ресурсы

- [Настройка Keycloak](https://habr.com/ru/articles/661541/)
- [Пример Spring+keycloak](https://examples.javacodegeeks.com/keycloak-in-a-spring-boot-application/)
- [Spring Cloud](https://betacode.net/11723/understanding-spring-cloud-config-server-with-example)
