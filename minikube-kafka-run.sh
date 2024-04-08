alias k='kubectl'

#zookeeper
kubectl delete deploy zookeeper
kubectl delete svc zookeeper
#minikube image load confluentinc/cp-zookeeper:latest
minikube image ls
kubectl apply -f ./k8c/zookeeper.yml

#broker
kubectl delete deploy broker
kubectl delete svc broker
minikube image load confluentinc/cp-kafka:latest
minikube image ls
kubectl apply -f ./k8c/broker.yaml

#docker push auth/book-service:1.0.0



