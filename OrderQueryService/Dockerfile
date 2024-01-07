FROM openjdk:17-alpine
WORKDIR /OrderQueryService
COPY target/*jar app.jar
EXPOSE 10002
ENTRYPOINT ["java" , "-jar", "app.jar"]