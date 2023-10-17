FROM gradle:jdk17 as builder

WORKDIR /app

COPY . .

RUN gradle :main-service:bootJar

FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=builder /app/main-service/build/libs/*.jar ./main-service.jar

CMD ["java", "-jar", "main-service.jar"]