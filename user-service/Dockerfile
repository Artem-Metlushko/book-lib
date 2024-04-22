FROM openjdk:17-oracle
WORKDIR /app
COPY build/libs/user-service-0.0.1-SNAPSHOT.jar /app
CMD ["java","-Xmx200m", "-jar", "/app/user-service-0.0.1-SNAPSHOT.jar"]
EXPOSE 1000
