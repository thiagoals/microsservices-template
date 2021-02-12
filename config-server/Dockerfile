FROM openjdk:11
VOLUME /tmp
EXPOSE 8888
ADD ./target/config-server-0.0.1.jar config-server.jar
ENTRYPOINT ["java","-jar","/config-server.jar"]