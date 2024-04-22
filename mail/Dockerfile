FROM openjdk:17-oracle
WORKDIR /app
COPY build/libs/mail.jar /app
CMD ["java","-Xmx200m", "-jar", "/app/mail.jar"]
EXPOSE 5000