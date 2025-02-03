# Build stage
#FROM amazoncorretto:17 AS builder
#WORKDIR /build
#COPY . .
#RUN ./gradlew build -x test

# Run stage
FROM amazoncorretto:17-alpine

WORKDIR /app
COPY /build/libs/*.jar app.jar

EXPOSE 3000
ENTRYPOINT ["java", "-jar", "app.jar"]