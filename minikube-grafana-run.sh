docker context use default
eval $(minikube -p minikube docker-env --shell=bash)
#grafana
helm repo add grafana https://grafana.github.io/helm-charts
helm repo update
helm delete grafana
helm install grafana grafana/grafana
kubectl expose service grafana --type=NodePort --target-port=3000 --name=grafana-ext
kubectl get secret --namespace default grafana -o jsonpath="{.data.admin-password}" | base64 --decode ; echo
minikube service grafana-ext