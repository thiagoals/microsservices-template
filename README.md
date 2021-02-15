# Java Microsservices Template
This project was created to store a minimun viable configuration to start developing microsservices with Spring-Boot and Spring-cloud (netflix), like Eureka, Gateway Zuul, Service Config, Feign Clients, Ribbon, and much more.

# Setting up the environment

## Starting containers
This project has a docker-compose file where you can just type docker-compose up -d --build to build all the microsservices in order. If you want to start them in any IDE, like Spring Tool Suite, Eclipse or Intellij, you need to start first the Config Server, then Service Discovery, Authentication/Authorization, and then any of the others containers.
Be aware that the gateway need to be on in order to access the endpoints of other containers/microsservices.

## Starting Config Server
Be aware that you need to store your environment variables of your github account into a '.env' file in your main folder (the same as the docker-compose file). The docker-compose file will fill the args variables and environment variables with the .env files.
Your file will need to have these attributes:
```
ENVIRONMENT=<test/dev/prod>
GITHUB_USER=<YOUR_GITHUB_USER>
GITHUB_PASS=<YOUR_GITHUB_PASS>
```
