docker context use default
eval $(minikube -p minikube docker-env --shell=bash)

kubectl delete configmap configmap
kubectl apply -f ./k8c/configmap.yml

kubectl delete secret postgres-credentials
kubectl apply -f ./k8c/postgres-credentials.yml

minikube image ls
#minikube image load consul:1.11.11
#minikube image load postgres
#minikube image load mongo
#minikube image load confluentinc/cp-zookeeper:latest
#minikube image load confluentinc/cp-kafka:latest
#minikube image ls
#docker push amtlh/book-service:1.0.0



