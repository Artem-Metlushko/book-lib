docker context use default
eval $(minikube -p minikube docker-env --shell=bash)
#zookeeper
kubectl delete deploy zookeeper
kubectl delete svc zookeeper
kubectl apply -f ./k8c/zookeeper.yml

#broker
kubectl delete deploy broker
kubectl delete svc broker
kubectl apply -f ./k8c/broker.yaml





