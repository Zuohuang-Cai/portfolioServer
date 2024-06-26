FROM openjdk:21-jdk
ADD target/demo-0.0.1-SNAPSHOT.jar spring-boot-portfolioserver.jar

LABEL maintainer="zuohuangcai"

ENTRYPOINT ["java", "-jar", "/spring-boot-portfolioserver.jar"]

EXPOSE 8080