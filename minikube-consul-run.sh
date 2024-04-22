alias k='kubectl'
docker context use default
eval $(minikube -p minikube docker-env --shell=bash)
#auth-service
#consul
kubectl delete deployment consul-server
kubectl delete svc consul-service
kubectl apply -f ./k8c/consul-server.yaml



