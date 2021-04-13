# Select base image
FROM openjdk:8

# Copy target jar app and static for images
COPY /webapp7.jar /webapp7.jar
# COPY ../backend/animalshelter/src/main/resources/static /src/main/resources/static

# Port to expose
EXPOSE 8443

# Command for running the app
CMD ["java", "-jar", "webapp7.jar"]