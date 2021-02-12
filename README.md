# Java Microsservices Template
This project was created to store a minimun viable configuration to start developing microsservices with Spring-Boot and Spring-cloud (netflix), like Eureka, Gateway Zuul, Service Config, Feign Clients, Ribbon, and much more.

# Starting Config Server
Be aware that you need to store your environment variables of your github account into a github.env file in your main folder (the same as the docker-compose file). The docker-compose file will fill the args variables and environment variables with the github.env files.
Your file will need to have just 2 lines:
'''
GITHUB_USER=<YOUR_GITHUB_USER>
GITHUB_PASS=<YOUR_GITHUB_PASS>
'''
