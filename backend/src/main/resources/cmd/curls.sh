# Testing GET, POST, PUT, DELETE requests with curl
# Usage: sh curls.sh

# GET request
echo "[Test] Route: GET /api/v1/books"
curl -X GET http://localhost:8080/api/v1/books

# POST request
echo "[TEST] Route: POST /api/v1/books"
curl -X POST http://localhost:8080/api/v1/books -H "Content-Type: application/json" -d '{

}'

# PUT request
echo "[TEST] Route: PUT /api/v1/books"
curl -X PUT http://localhost:8080/api/v1/books -H "Content-Type: application/json" -d '{

}'

# DELETE request
echo "[TEST] Route: DELETE /api/v1/books/{id}"
curl -X DELETE http://localhost:8080/api/v1/books/1