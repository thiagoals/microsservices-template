#FROM openjdk:11
#VOLUME /tmp
#EXPOSE 8888
#ADD ./target/hr-eureka-server-0.0.1-SNAPSHOT.jar hr-eureka-server.jar
#ENTRYPOINT ["java","-jar","/hr-eureka-server.jar"]

ARG PROJECT_VERSION="0.0.1"
ARG EXPOSED_PORT="8761"
ARG SKIP_TEST=true


#
# Build
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -Dmaven.test.skip=${SKIP_TEST}

#
# Package
#
FROM openjdk:11-jre-slim
EXPOSE ${EXPOSED_PORT}
COPY --from=build /home/app/target/authorization-${PROJECT_VERSION}.jar /usr/local/lib/authorization.jar
ENTRYPOINT ["java","-jar","/usr/local/lib/authorization.jar"]