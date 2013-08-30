jobs-manager
============

#PUT job example

curl --header "Content-type: application/json" --request PUT --data '{"id": 123, "userId": "johndoe", "nthFibonacci": 12}' http://localhost:9000/job