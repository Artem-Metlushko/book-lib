#FROM openjdk:17-oracle
FROM alpine:3.19

RUN apk add openjdk17

WORKDIR /app
COPY build/libs/book-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/book-service.jar"]
EXPOSE 7000
