
#mail-service

  #app
./gradlew :mail:clean
./gradlew :mail:bootJar
docker rmi amtlh/mail:1.0.0 --force
docker image build ./mail -t amtlh/mail:1.0.0

kubectl delete deploy mail
kubectl delete svc maile

minikube image rm amtlh/mail:1.0.0 --force
minikube image load amtlh/mail:1.0.0
minikube image ls
kubectl apply -f ./k8c/mail-service-deployment.yml

#minikube image load postgres
#minikube image load mongo

kubectl get all
minikube dashboard

#docker push amtlh/book-service:1.0.0



