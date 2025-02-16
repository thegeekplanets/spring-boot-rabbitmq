
# Project Title

Spring Boot + RabbitMQ Implementation


## Authors

- [@thegeekplanets](https://www.github.com/thegeekplanets)


## Features

- This Repository has the implmentation of RabbitMQ topics with spring boot.
- Following exchanges are implemented - Direct, Topic, Fanout, etc.


## Future Scope
- Implement Header exchanges
- Dead Letter Queue

## Deployment


Run the RabbitMQ Docker Image
```
docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:4.0-management
```


## Run Locally

Clone the project

```bash
  git clone https://github.com/thegeekplanets/spring-boot-rabbitmq.git
```

Go to the project directory

```bash
  cd spring-boot-rabbitmq
```

Install dependencies

```bash
  mvn clean install
```

Start the server

```bash
  mvn spring-boot:run
```


## Test Locally

Note: Please use Postman Tool to execute the API calls.

Trigger the Direct Exchange

```
POST http://localhost:8080/mq/direct?message=hello
```

Trigger the Topic Exchange
```
POST http://localhost:8080/mq/topic

Body:
{
    "id": 1,
    "name": "thegeekplanets",
    "city": "Delhi"
}

```

Trigger the Fanout Exchange
```
POST http://localhost:8080/mq/fanout

Body:
{
    "id": 1,
    "name": "thegeekplanets",
    "city": "Delhi"
}

```
