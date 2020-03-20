FROM openjdk:8-jdk-alpine
MAINTAINER zhangzhaofa <fa20091001@gmail.com>
VOLUME /tmp
ADD /target/oauth2-server-0.0.1.jar oauth.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/oauth.jar","> /log/app.log"]