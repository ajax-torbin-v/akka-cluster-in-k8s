#!/bin/bash

eval "$(minikube docker-env)"

./gradlew clean :backend-node:shadowJar # :frontend-node:shadowJar

docker build -t backend-node:v1.1.8 ./backend-node
# docker build -t frontend-node:v1.1.7 ./frontend-node

kubectl apply -f k8s/akka-cluster-rbac.yaml
kubectl apply -f k8s/akka-cluster-service.yaml
kubectl apply -f k8s/backend-deployment.yaml
# kubectl apply -f k8s/frontend-deployment.yaml

kubectl wait --for=condition=ready pod --all --timeout=300s

kubectl port-forward svc/akka-cluster 8558:8558

