FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY web_crawler.sqlite web_crawler.sqlite
COPY ${JAR_FILE} web-crawler.jar
ENTRYPOINT ["java","-jar","/web-crawler.jar"]
