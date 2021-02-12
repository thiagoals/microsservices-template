#FROM openjdk:11
#VOLUME /tmp
#EXPOSE 8888
#ADD ./target/config-server-0.0.1.jar config-server.jar
#ENTRYPOINT ["java","-jar","/config-server.jar"]


#
# Build
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -Dmaven.test.skip=true

#
# Package
#
FROM openjdk:11-jre-slim

ARG PROJECT_VERSION="0.0.1"
ARG EXPOSED_PORT="8888"

EXPOSE $EXPOSED_PORT
COPY --from=build /home/app/target/config-server-$PROJECT_VERSION.jar /usr/local/lib/config-server.jar
ENTRYPOINT ["java","-jar","/usr/local/lib/config-server.jar"]