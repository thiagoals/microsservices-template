#FROM openjdk:11
#VOLUME /tmp
#ADD ./target/hr-user-0.0.1-SNAPSHOT.jar hr-user.jar
#ENTRYPOINT ["java","-jar","/hr-user.jar"]



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
ARG SKIP_TEST=true
ARG PROJECT_PROFILE
COPY --from=build /home/app/target/user-$PROJECT_VERSION.jar /usr/local/lib/user.jar
ENTRYPOINT ["java","-jar","/usr/local/lib/user.jar"]