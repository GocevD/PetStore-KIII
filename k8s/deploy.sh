#!/bin/bash

echo "Deploying PetStore application to Kubernetes..."

# Create namespace
echo "Creating namespace..."
kubectl apply -f namespace.yml

# Apply ConfigMaps and Secrets
echo "Applying ConfigMaps and Secrets..."
kubectl apply -f configmap.yml
kubectl apply -f secret.yml

# Deploy database
echo "Deploying PostgreSQL database..."
kubectl apply -f postgres-service.yml
kubectl apply -f postgres-statefulset.yml

# Wait for database to be ready
echo "Waiting for database to be ready..."
kubectl wait --for=condition=ready pod -l app=petstore-db -n petstore --timeout=300s

# Deploy applications
echo "Deploying backend application..."
kubectl apply -f backend-deployment.yml
kubectl apply -f backend-service.yml

echo "Deploying frontend application..."
kubectl apply -f frontend-deployment.yml
kubectl apply -f frontend-service.yml

# Deploy ingress
echo "Deploying ingress..."
kubectl apply -f ingress.yml

echo "Deployment complete"
