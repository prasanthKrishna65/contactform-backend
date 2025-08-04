FROM maven:3.9.4-eclipse-temurin-17

WORKDIR /app

COPY . .

RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

EXPOSE 8080

CMD ["java", "-jar", "target/contactform-backend.jar"]
