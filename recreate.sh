#minikube delete --all
docker context use default
eval $(minikube -p minikube docker-env --shell=bash)
minikube start
./minikube-script-run.sh
./minikube-consul-run.sh
./minikube-book-run.sh
./minikube-user-run.sh
./minikube-gateway-run.sh
./minikube-auth-run.sh
./minikube-kafka-run.sh
./minikube-mail-run.sh
#./minikube-prometheus-run.sh
#./minikube-grafana-run.sh