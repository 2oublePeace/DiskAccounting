FROM openjdk:17-jdk-slim

COPY build/libs/LookingBooking-0.0.1-SNAPSHOT.jar /LookingBooking.jar

EXPOSE 8080

CMD ["java", "-jar", "/LookingBooking.jar"]