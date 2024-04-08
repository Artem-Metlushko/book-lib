
#user-service
  #postgers-user
#kubectl delete deploy postgres-userdb
#kubectl delete svc postgres-userdb
#kubectl apply -f ./k8c/postgres-user-db-deployment.yml

  #app
./gradlew :user-service:clean
./gradlew :user-service:bootJar
docker rmi amtlh/user-service:1.0.0 --force
docker image build ./user-service -t amtlh/user-service:1.0.0

kubectl delete deploy user-service
kubectl delete svc user-service

minikube image rm amtlh/user-service:1.0.0 --force
minikube image load amtlh/user-service:1.0.0
minikube image ls
kubectl apply -f ./k8c/user-service-deployment.yml

#minikube image load postgres
#minikube image load mongo

kubectl get all
minikube dashboard

#docker push amtlh/book-service:1.0.0



