docker context use default
eval $(minikube -p minikube docker-env --shell=bash)
#user-service
#  postgers-user
kubectl delete deploy postgres-userdb
kubectl delete svc postgres-userdb
kubectl apply -f ./k8c/postgres-user-db-deployment.yml

  #app
./gradlew :user-service:clean
./gradlew :user-service:bootJar
kubectl delete deploy user-service
kubectl delete svc user-service
docker rmi amtlh/user-service:1.0.0
minikube image rm amtlh/user-service:1.0.0 --force

minikube image ls
kubectl apply -f ./k8c/user-service-deployment.yml




#docker push amtlh/book-service:1.0.0



