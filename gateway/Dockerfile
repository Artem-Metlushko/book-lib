FROM openjdk:17-oracle
WORKDIR /app
COPY build/libs/gateway.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/gateway.jar"]
EXPOSE 9191
