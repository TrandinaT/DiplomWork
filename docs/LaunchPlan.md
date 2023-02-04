Дипломный проект по профессии «Тестировщик»
Дипломный проект — автоматизация тестирования комплексного сервиса, взаимодействующего с СУБД и API Банка.

Процедура запуска автотестов
Склонировать репозиторий: git clone https://github.com/TrandinaT/java_aqa_diploma.git

Перейти в папку java_aqa_diploma

Запустить контейнер Docker командой в консоли:

docker-compose up

Запустить приложение командой в консоли
для MySQL:

java "-Dspring.datasource.url=jdbc:mysql://localhost:3306/app" "-Dspring.datasource.username=app" "-Dspring.datasource.password=pass" -jar artifacts/aqa-shop.jar

для PostgreSQL:

java "-Dspring.datasource.url=jdbc:postgresql://localhost:5432/app" "-Dspring.datasource.username=app" "-Dspring.datasource.password=pass" -jar artifacts/aqa-shop.jar

Запустить авто-тесты команой в консоли
для MySQL:

 ./gradlew test "-Ddb.url=jdbc:mysql://localhost:3306/app" "-Ddb.username=app" "-Ddb.password=pass"

для PostgreSQL:

./gradlew test "-Ddb.url=jdbc:postgresql://localhost:5432/app" "-Ddb.username=app" "-Ddb.password=pass"

Формирование Allure отчёта
./gradlew allureReport - формирование отчета

./gradlew allureServe -отображение отчета

После выполнения всех тестов остановить docker контейнер командой в консоли: docker-compose down
