# План запуска Автотестов #

## Запуск автотестов ##
1.Склонировать репозиторий: git clone https://github.com/TrandinaT/DiplomWork

2.Перейти в папку DiplomWork.

3.Запустить контейнер Docker командой в консоли:

> docker-compose up

### Запустить приложение командой в консоли: ###

>java "-Dspring.datasource.url=jdbc:mysql://localhost:8080/app" "-Dspring.datasource.username=app" "-Dspring.datasource.password=pass" -jar artifacts/aqa-shop.jar

### Запустить авто-тесты команой в консоли: ###

> ./gradlew test "-Ddb.url=jdbc:mysql://localhost:8080/app" "-Ddb.username=app" "-Ddb.password=pass"

### Формирование Allure отчёта ###
> ./gradlew allureReport - формирование отчета

> ./gradlew allureServe -отображение отчета

### После выполнения всех тестов остановить docker контейнер командой в консоли: docker-compose down ###
