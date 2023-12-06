FROM gradle:jdk17 as builder

WORKDIR /app

COPY . .

RUN gradle :storage-service:bootJar

FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY --from=builder /app/storage-service/build/libs/*.jar ./storage-service.jar

CMD ["java", "-jar", "storage-service.jar"]
