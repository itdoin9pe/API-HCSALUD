FROM maven:3.8.6-eclipse-temurin-17 AS builder
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn package -DskipTests && cp target/sysSalud-*.jar app.jar

FROM gcr.io/distroless/java17-debian11
WORKDIR /app
COPY --from=builder /app/app.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/app/app.jar"]