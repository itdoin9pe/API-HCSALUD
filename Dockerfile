# Etapa de construcción con Maven
FROM maven:3.8.6-eclipse-temurin-17 AS builder
WORKDIR /app

# Copiar los archivos de configuración de Maven y el código fuente
COPY pom.xml .
COPY src ./src

# Usar caché para las dependencias de Maven
RUN --mount=type=cache,target=/root/.m2 \
    mvn -B dependency:go-offline && \
    mvn -B clean package -DskipTests \
        -Dmaven.test.skip=true \
        -Dmaven.compile.fork=true \
        -Dmaven.javadoc.skip=true \
        -Dcheckstyle.skip=true \
        -Dspotbugs.skip=true

# Etapa de ejecución con JRE
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

# Crear un usuario específico para ejecutar la aplicación
RUN addgroup --system javauser && \
    adduser --system --ingroup javauser javauser && \
    mkdir -p /app/uploads && \
    chown -R javauser:javauser /app

# Copiar el JAR construido desde la etapa anterior
COPY --from=builder --chown=javauser:javauser /app/target/sysSalud-*.jar app.jar

# Definir las variables de entorno
ENV SPRING_PROFILES_ACTIVE=prod
ENV SERVER_PORT=8081
ENV UPLOAD_DIR=/app/uploads

# Exponer el puerto y el directorio de archivos subidos
VOLUME ${UPLOAD_DIR}
EXPOSE ${SERVER_PORT}

# Usar el usuario creado para ejecutar la aplicación
USER javauser

# Iniciar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
