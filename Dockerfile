# Use a base image with Java 11
FROM adoptopenjdk:11-jre-hotspot
# Set the working directory
WORKDIR /app
# Copy the JAR file to the container
COPY target/prueba-tecnica-1.0.jar prueba-tecnica-1.0.jar
# Expose the port that your Spring Boot application listens on (default is 8080)
EXPOSE 8081
CMD ["java","-jar","prueba-tecnica-1.0.jar"]