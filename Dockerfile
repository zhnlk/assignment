FROM openjdk:8-jdk-alpine
LABEL maintainer="Eran Cheung"
VOLUME /tmp
ADD ./target/assignment.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
EXPOSE 9999