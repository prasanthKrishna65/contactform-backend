FROM maven:3.9.4-eclipse-temurin-17

WORKDIR /app

COPY . .

# Make mvnw executable
RUN chmod +x mvnw

# Build the project
RUN ./mvnw clean package -DskipTests

EXPOSE 8080

# Run the JAR
CMD ["java", "-jar", "target/contactform-backend.jar"]
