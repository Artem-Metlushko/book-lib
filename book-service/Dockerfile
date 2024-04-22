##FROM openjdk:17-jdk-alpine3.14
#FROM alpine:3.19
##
#RUN apk add openjdk17

FROM openjdk:17-oracle
WORKDIR /app
COPY build/libs/book-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/book-service.jar"]
EXPOSE 7000
#FROM adoptopenjdk/openjdk11:alpine-jre
#ADD target/backend-service-0.0.1-SNAPSHOT.jar app.jar
#ENTRYPOINT ["java","-jar","app.jar"]