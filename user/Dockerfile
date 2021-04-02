#FROM openjdk:11
#VOLUME /tmp
#ADD ./target/hr-user-0.0.1-SNAPSHOT.jar hr-user.jar
#ENTRYPOINT ["java","-jar","/hr-user.jar"]



#
# Build
#
FROM maven:3.6.0-jdk-11-slim AS build
ARG AUTH_NAME
ARG AUTH_EMAIL
ARG AUTH_PASS
COPY src /home/app/src
COPY pom.xml /home/app
#Copying .docker.properties to match the mvnw clean package with docker configs
COPY src/main/resources/application.docker.properties /home/app/src/main/resources/application.properties
COPY src/main/resources/bootstrap.docker.properties /home/app/src/main/resources/bootstrap.properties
#Editing .docker.sql to match the user got by .env for authorization/authentication microsservice
RUN rm /home/app/src/main/resources/data.sql
RUN touch /home/app/src/main/resources/data.sql
RUN echo "INSERT INTO tb_role (role_name) VALUES ('ROLE_OPERATOR');" >> /home/app/src/main/resources/data.sql
RUN echo "INSERT INTO tb_role (role_name) VALUES ('ROLE_ADMIN');" >> /home/app/src/main/resources/data.sql
RUN echo "INSERT INTO tb_user (name, email, password) VALUES ('$AUTH_NAME', '$AUTH_EMAIL', '$AUTH_PASS');" >> /home/app/src/main/resources/data.sql
RUN echo "INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);" >> /home/app/src/main/resources/data.sql
RUN echo "INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 2);" >> /home/app/src/main/resources/data.sql
#Then copying from one to another file
#ADD /home/app/src/main/resources/data.docker.sql /home/app/src/main/resources/data.sql
#Finally, running mvnw clean package
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