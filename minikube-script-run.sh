alias k='kubectl'
kubectl delete configmap configmap
kubectl apply -f ./k8c/configmap.yml

kubectl delete secret postgres-credentials
kubectl apply -f ./k8c/postgres-credentials.yml

minikube image ls
minikube image load consul:1.11.11
minikube image ls

#consul
kubectl delete deployment consul-server
kubectl delete svc consul-service
kubectl apply -f ./k8c/consul-server.yaml

#book-service
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

minikube image rm amtlh/book-service:1.0.0 --force
minikube image load amtlh/book-service:1.0.0
minikube image ls
kubectl apply -f ./k8c/book-service-deployment.yml



#user-service
  #postgers-user
kubectl delete deploy postgres-userdb
kubectl delete svc postgres-userdb
kubectl apply -f ./k8c/postgres-user-db-deployment.yml

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



