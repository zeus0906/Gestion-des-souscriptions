FROM openjdk:17-jdk-slim
RUN apt-get update && apt-get install -y maven
MAINTAINER franky (frankynyambi20@gmail.com)
WORKDIR /app
COPY /target/GesBoo-0.0.1-SNAPSHOT.jar GesBoo.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "GesBoo.jar"]
