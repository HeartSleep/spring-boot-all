FROM openjdk:11.0.6-jdk

MAINTAINER gehuadong gehuadong@shuidihuzhu.com

ADD target/spring-boot-docker-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8761

ENTRYPOINT ["java","-jar","/app.jar"]