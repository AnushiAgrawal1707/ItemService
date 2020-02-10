# mykart-user-service

#Pre-requisites:
1. Docker desktop must be installed on your machine.
2. item service must be running.
3. You must be in the directory where the docker-compose.yml file is present to run it.

## Steps to Setup

### 1. Clone the application
Either clone the complete application or just download the docker-compose.yml file.
```bash
https://github.com/AnushiAgrawal1707/mykart_user_service.git
```

### 2. Create a custom network
```bash
Execute: docker network create mykart-web-application-network || true
```

### 3. Move to the directory where docker-compose.yml file is present.

``` bash
Execute: docker-compose up
```

The app will start running at http://localhost:5050

# Explore Rest APIs

The app defines following CRUD APIs.

For User:

```bash

POST /v1/users/register                -   to register user 

PUT /v1/users/update/{user_id}         -   to update user with given identifier

DELETE /v1/users/delete/{user_id}      -   to delete user with given identifier
```
For Authentication:
```bash
POST /v1/users/login                   -   to authenticate user and generate token
```
For Cart:

```bash

POST /v1/users/{userId}/carts                -   to add items to cart 

GET /v1/users/{userId}/carts/{item_id}       -   to get specific item from cart

PUT /v1/users/{userId}/carts{item_id}         -   to update quantity of item with given identifier

DELETE /v1/users/{userId}/carts/{itemId}      -   to delete item from cart with given identifier

```
For Order:

```bash

POST /v1/users/{userId}/orders                -   to add items to cart 

GET /v1/users/{userId}/orders/{orderId}       -   to get specific item from cart

GET /v1/users/{userId}/orders                 -   to get all orders of the user with given identifier

DELETE /v1/users/{userId}/carts/{itemId}      -   to delete item from cart with given identifier

```
