FROM openjdk:17-oracle
WORKDIR /app
COPY build/libs/auth-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/auth-service.jar"]
EXPOSE 6000
