./gradlew :book-service:clean
./gradlew :book-service:bootJar

./gradlew :user-service:clean
./gradlew :user-service:bootJar

docker image rmi book-lib-book-service
docker image rmi book-lib-user-service

docker compose up