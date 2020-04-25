FROM openjdk:8-jdk-alpine
MAINTAINER zhangzhaofa <fa20091001@gmail.com>
VOLUME /tmp
ADD /target/oauth2-server-0.0.1.jar oauth.jar
RUN sh -c 'touch /oauth.jar'
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
RUN echo 'Asia/Shanghai' > /etc/timezone
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/oauth.jar","> /log/app.log"]