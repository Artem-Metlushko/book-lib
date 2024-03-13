FROM openjdk:17-oracle
WORKDIR /app
COPY build/libs/book-service-0.0.1-SNAPSHOT.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/book-service-0.0.1-SNAPSHOT.jar"]
EXPOSE 7000
