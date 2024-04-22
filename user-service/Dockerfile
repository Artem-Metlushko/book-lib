FROM openjdk:17-oracle
WORKDIR /app
COPY build/libs/user-service.jar /app
CMD ["java","-Xmx200m", "-jar", "/app/user-service.jar"]
EXPOSE 1000
