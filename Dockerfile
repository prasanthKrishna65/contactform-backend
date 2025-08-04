FROM maven:3.9.4-eclipse-temurin-17

WORKDIR /app

COPY . .

RUN ./mvnw clean package -DskipTests

EXPOSE 8080

CMD ["java", "-jar", "target/contactform-backend-0.0.1-SNAPSHOT.jar"]