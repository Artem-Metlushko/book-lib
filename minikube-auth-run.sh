docker context use default
eval $(minikube -p minikube docker-env --shell=bash)
#auth-service

./gradlew :auth-service:clean
./gradlew :auth-service:bootJar
kubectl delete deploy auth-service
kubectl delete svc auth-service
docker rmi amtlh/auth-service:1.0.0
minikube image rm amtlh/auth-service:1.0.0 --force

docker image build ./auth-service -t amtlh/auth-service:1.0.0
minikube image ls
kubectl apply -f ./k8c/auth-service-deployment.yml

#docker push auth/book-service:1.0.0



