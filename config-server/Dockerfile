FROM openjdk:11-jre-slim

WORKDIR /workspace/app

COPY target/*.jar ./myapp.jar

ENTRYPOINT [ "java", "-jar", "./myapp.jar" ]