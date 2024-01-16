FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY build/libs/*.jar ./report-service.jar

CMD ["java", "-jar", "report-service.jar"]
