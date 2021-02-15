#FROM openjdk:11
#VOLUME /tmp
#EXPOSE 8765
#ADD ./target/hr-api-gateway-zuul-0.0.1-SNAPSHOT.jar hr-api-gateway-zuul.jar
#ENTRYPOINT ["java","-jar","/hr-api-gateway-zuul.jar"]



#
# Build
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
ARG SKIP_TEST=true
RUN mvn -f /home/app/pom.xml clean package -Dmaven.test.skip=$SKIP_TEST

#
# Package
#
FROM openjdk:11-jre-slim
ARG PROJECT_VERSION="0.0.1"
EXPOSE 8765
COPY --from=build /home/app/target/gateway-$PROJECT_VERSION.jar /usr/local/lib/gateway.jar
ENTRYPOINT ["java","-jar","/usr/local/lib/gateway.jar"]