./gradlew clean build
docker rmi amtlh/book-service:1.0.0 --force
docker image build . -t amtlh/book-service:1.0.0
#docker push amtlh/book-service:1.0.0
minikube image load amtlh/book-service:1.0.0
#minikube image load postgres
#minikube image load mongo



