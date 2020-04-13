FROM openjdk:8-jdk-alpine
MAINTAINER Eran Cheung
VOLUME /tmp
ADD assignment.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
EXPOSE 9999