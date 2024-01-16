FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY build/libs/*.jar ./storage-service.jar

CMD ["java", "-jar", "storage-service.jar"]