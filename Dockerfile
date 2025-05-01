FROM maven:3.8.6-eclipse-temurin-17 AS builder
WORKDIR /app

# Copiar solo los archivos necesarios para resolver dependencias primero
COPY pom.xml .
COPY src ./src

# Usar perfil reproducible y cachear dependencias
RUN --mount=type=cache,target=/root/.m2 \
    mvn -B dependency:go-offline && \
    mvn -B clean package -DskipTests \
        -Dmaven.test.skip=true \
        -Dmaven.compile.fork=true \
        -Dmaven.javadoc.skip=true \
        -Dcheckstyle.skip=true \
        -Dspotbugs.skip=true

FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

# Usar un usuario no-root por seguridad
RUN addgroup --system javauser && \
    adduser --system --ingroup javauser javauser && \
    mkdir -p /app/uploads && \
    chown -R javauser:javauser /app

# Copiar el JAR manteniendo permisos
COPY --from=builder --chown=javauser:javauser /app/target/sysSalud-*.jar app.jar

# Variables de entorno configurables
ENV SERVER_PORT=8081
ENV UPLOAD_DIR=/app/uploads

# Configurar volumen para uploads
VOLUME ${UPLOAD_DIR}

# Exponer puerto
EXPOSE ${SERVER_PORT}

# Ejecutar como usuario no-root
USER javauser

# Usar shell form para permitir variables de entorno
ENTRYPOINT ["java", "-jar", "app.jar"]