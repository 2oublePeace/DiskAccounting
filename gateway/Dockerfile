FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY build/libs/*.jar ./gateway.jar

CMD ["java", "-jar", "gateway.jar"]