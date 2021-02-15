#FROM openjdk:11
#VOLUME /tmp
#EXPOSE 8888
#ADD ./target/hr-eureka-server-0.0.1-SNAPSHOT.jar hr-eureka-server.jar
#ENTRYPOINT ["java","-jar","/hr-eureka-server.jar"]

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
ARG EXPOSED_PORT="8761"
ARG SKIP_TEST=true
EXPOSE $EXPOSED_PORT
COPY --from=build /home/app/target/service-discovery-0.0.1.jar /usr/local/lib/service-discovery.jar
ENTRYPOINT ["java","-jar","/usr/local/lib/service-discovery.jar"]