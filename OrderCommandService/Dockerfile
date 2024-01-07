FROM openjdk:17-alpine
WORKDIR /OrderCommandService
COPY target/*jar app.jar
EXPOSE 10000
ENTRYPOINT ["java" , "-jar", "app.jar"]

