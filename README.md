# Тестовое задание

Спроектировать(продумать формат и ограничения входящих/исходящих параметров) и реализовать REST API, вычисляющее частоту встречи символов по заданной строке. Результат должен быть отсортирован по убыванию количества вхождений символа в заданную строку.

Пример входной строки: “aaaaabcccc”  
Пример выходного результата: “a”: 5, “c”: 4, “b”: 1

Требования к решению:
1. Java 8+
2. Spring boot 2+
3. Решение должно быть покрыто тестами
4. У решения должна быть документация по запуску и формату входящих/исходящих параметров
5. Код решения необходимо разместить в публичном Github репозитории.

## Решение

Разработан REST API сервер, предоставляющий GET-запрос по адресу /symbolsCount. Этот запрос принимает строку символов в качестве входных данных в URL и возвращает отображение символов с их частотой, упорядоченное по убыванию частоты.

## Инструкция по запуску

Настроить свой свободный порт в конфигурационном файле:  
[application.properties](./src/main/resources/application.properties)
в поле:
```yaml
server.port=8080
```

Сборка проекта с помощью Maven:

```bash
mvn clean install
```

Запустите приложение с помощью команды:

```bash
java -jar target/T1TestTask-0.0.1-SNAPSHOT.jar
```

### Проверка работоспособности:

Проверить работоспособность сервера можно с помощью команды (порт укажите тот, который указывали в конфигурационном файле):

```bash
curl -X GET "http://localhost:8080/symbolsCount?input=aaaaabcccc" -H "accept: */*"
```

## Документация

Чтобы посмотреть документацию REST API сервера, нужно после запуска перейти по URL: /swagger-ui/index.html#/
