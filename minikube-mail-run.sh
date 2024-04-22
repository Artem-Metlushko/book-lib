docker context use default
eval $(minikube -p minikube docker-env --shell=bash)
#mail-service

  #app
./gradlew :mail:clean
./gradlew :mail:bootJar
docker rmi amtlh/mail:1.0.0 --force
docker image build ./mail -t amtlh/mail:1.0.0

kubectl delete deploy mail
kubectl delete svc maile

minikube image rm amtlh/mail:1.0.0 --force
minikube image ls
kubectl apply -f ./k8c/mail-service-deployment.yml



#docker push amtlh/book-service:1.0.0



