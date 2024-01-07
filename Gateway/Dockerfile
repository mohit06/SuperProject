FROM openjdk:17-alpine
WORKDIR /Gateway
COPY target/*jar app.jar
EXPOSE 8151
ENTRYPOINT ["java" , "-jar", "app.jar"]