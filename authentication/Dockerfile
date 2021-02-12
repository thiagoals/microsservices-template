#FROM openjdk:11
#VOLUME /tmp
#ADD ./target/hr-oauth-0.0.1-SNAPSHOT.jar hr-oauth.jar
#ENTRYPOINT ["java","-jar","/hr-oauth.jar"]

#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /home/app/target/authentication-0.0.1.jar /usr/local/lib/authentication.jar
ENTRYPOINT ["java","-jar","/usr/local/lib/authentication.jar"]