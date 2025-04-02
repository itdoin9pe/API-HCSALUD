# Etapa de construcción
FROM eclipse-temurin:17-jdk-jammy as builder

WORKDIR /app
COPY . .
RUN apt-get update && \
    apt-get install -y maven && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/* && \
    mvn clean package -DskipTests

# Etapa de producción
FROM eclipse-temurin:17-jre-jammy

WORKDIR /app
COPY --from=builder /app/target/sysSalud-*.jar app.jar
RUN mkdir -p /app/uploads

# Puerto expuesto
EXPOSE 8081

# Comando de arranque (sin .env)
ENTRYPOINT ["java", "-jar", "app.jar"]