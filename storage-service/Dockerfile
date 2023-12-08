FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY  ./storage-service/build/libs/storage-service-0.0.1-SNAPSHOT.jar ./storage-service.jar

CMD ["java", "-jar", "storage-service.jar"]
