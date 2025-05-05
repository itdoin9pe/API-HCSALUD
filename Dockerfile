FROM maven:3.8.6-eclipse-temurin-17 AS builder
WORKDIR /app

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

RUN addgroup --system javauser && \
    adduser --system --ingroup javauser javauser && \
    mkdir -p /app/uploads && \
    chown -R javauser:javauser /app

COPY --from=builder --chown=javauser:javauser /app/target/sysSalud-*.jar app.jar

# Configuración de perfiles
ENV SPRING_PROFILES_ACTIVE=prod

ENV SERVER_PORT=8081
ENV UPLOAD_DIR=/app/uploads

VOLUME ${UPLOAD_DIR}

EXPOSE ${SERVER_PORT}

USER javauser

ENTRYPOINT ["java", "-jar", "app.jar"]
