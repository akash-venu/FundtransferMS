# Step 1: Use a base image with Java installed
FROM openjdk:17-jdk-slim

# Step 2: Set a working directory
WORKDIR /app

# Step 3: Copy the JAR file to the container
# Replace 'your-application.jar' with the name of your Spring Boot JAR file
COPY build/libs/fund-transfer.jar app.jar

# Step 4: Expose the port your application runs on
# Replace 8080 with your application's port
EXPOSE 8081

# Step 5: Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]