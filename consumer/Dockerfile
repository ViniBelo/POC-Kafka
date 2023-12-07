FROM openjdk:21-jdk-slim
LABEL author="ViniBelo"

LABEL version="1.0"

EXPOSE 8081

COPY ./target/*.jar consumer.jar

ENTRYPOINT [ "java" , "-Xms128m",  "-Xmx400m", "-jar", "-DLog4jContextSelector=org.apache.logging.log4j.core.async.AsyncLoggerContextSelector", "consumer.jar"]