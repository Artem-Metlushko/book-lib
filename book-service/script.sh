./gradlew clean build
docker build . -t amtlh/book-service:1.0.0
docker push amtlh/book-service:1.0.0

