FROM openjdk:17-jdk-slim

WORKDIR /app

# копируем jar (после сборки)
COPY target/*.jar app.jar

# Railway / Render передают порт через переменную
ENV PORT=8080

EXPOSE 8080

CMD ["sh", "-c", "java -jar app.jar --server.port=${PORT}"]