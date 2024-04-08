alias k='kubectl'

#auth-service
./gradlew :auth-service:clean
./gradlew :auth-service:bootJar
docker rmi amtlh/auth-service:1.0.0 --force
docker image build ./auth-service -t amtlh/auth-service:1.0.0

kubectl delete deploy auth-service
kubectl delete svc auth-service

minikube image rm amtlh/auth-service:1.0.0 --force
minikube image load amtlh/auth-service:1.0.0
minikube image ls
kubectl apply -f ./k8c/auth-service-deployment.yml

#docker push auth/book-service:1.0.0



