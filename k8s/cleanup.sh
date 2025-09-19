#!/bin/bash

echo "Cleaning up PetStore deployment..."

# Delete all resources in the petstore namespace
kubectl delete namespace petstore

echo "Cleanup completed!"
echo "Note: Persistent volumes may still exist and need to be manually deleted if required."