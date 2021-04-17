FROM openjdk:11-jre
ADD target/*.jar webapp7.jar
EXPOSE 8443
ENTRYPOINT ["java","-jar","webapp7.jar"]