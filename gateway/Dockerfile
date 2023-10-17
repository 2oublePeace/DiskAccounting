FROM gradle:jdk17 as builder

WORKDIR /app

COPY . .

RUN gradle :gateway:bootJar

FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=builder /app/gateway/build/libs/*.jar ./gateway.jar

CMD ["java", "-jar", "gateway.jar"]