#book-service
docker context use default
eval $(minikube -p minikube docker-env --shell=bash)
  #postgers-book
kubectl delete deploy postgres-book
kubectl delete svc postgres-book
kubectl apply -f ./k8c/postgres-book-db-deployment.yml
  #mongo
kubectl delete deployment.apps/mongo-img
kubectl delete svc mongo-img-service
kubectl apply -f ./k8c/mongo-img-deployment.yml
  #app
./gradlew :book-service:clean
./gradlew :book-service:bootJar
docker rmi amtlh/book-service:1.0.0 --force
docker image build ./book-service -t amtlh/book-service:1.0.0

kubectl delete deploy book-service
kubectl delete svc book-service

minikube image rm amtlh/book-service:1.0.0
#minikube image load amtlh/book-service:1.0.0
minikube image ls
kubectl apply -f ./k8c/book-service-deployment.yml

kubectl port-forward service/book-service 7000:7000