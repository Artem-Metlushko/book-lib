FROM openjdk:17-oracle
WORKDIR /app
ADD  build/libs/config-server-0.0.1-SNAPSHOT.jar /app/
EXPOSE 8888
CMD ["java", "-jar", "/app/config-server-0.0.1-SNAPSHOT.jar"]


#FROM openjdk:17-oracle
#WORKDIR /app
#COPY build/libs/config-server-0.0.1-SNAPSHOT.jar /app/
#CMD ["java", "-jar", "/app/config-server-0.0.1-SNAPSHOT.jar"]
