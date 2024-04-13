docker context use default
eval $(minikube -p minikube docker-env --shell=bash)
#auth-service
./gradlew :gateway:clean
./gradlew :gateway:bootJar
docker rmi amtlh/gateway:1.0.0 --force
docker image build ./gateway -t amtlh/gateway:1.0.0

kubectl delete deploy gateway
kubectl delete svc gateway

minikube image rm amtlh/gateway:1.0.0 --force
kubectl apply -f ./k8c/gateway-service-deployment.yml

#docker push auth/book-service:1.0.0



