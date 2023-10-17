# Этап сборки
FROM gradle:jdk17 as builder

WORKDIR /app

COPY . .

RUN gradle :report-service:bootJar

FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=builder /app/report-service/build/libs/*.jar ./report-service.jar

CMD ["java", "-jar", "report-service.jar"]
