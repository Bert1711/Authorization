FROM openjdk:8-jdk-alpine

# Установка рабочей директории внутри контейнера

# Копирование JAR-файла внутрь контейнера
COPY target/Authorization-0.0.1-SNAPSHOT.jar AuthorizationApp.jar

# Открытие порта 8080
EXPOSE 8080

# Задание команды для запуска приложения
CMD ["java", "-jar", "AuthorizationApp.jar"]
