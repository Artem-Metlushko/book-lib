docker context use default
eval $(minikube -p minikube docker-env --shell=bash)
#grafana
helm repo add prometheus-community https://prometheus-community.github.io/helm-charts
helm delete prometheus
helm install prometheus prometheus-community/prometheus
helm repo update
kubectl expose service prometheus-server --type=NodePort --target-port=9090 --name=prometheus-server-ext
minikube service prometheus-server-ext

