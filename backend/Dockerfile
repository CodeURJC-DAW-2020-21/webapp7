FROM openjdk:11-jre
ADD target/*.jar app.jar
EXPOSE 8443
ENTRYPOINT ["java","-jar","app.jar"]