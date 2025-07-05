# Cargar variables desde el archivo .env
include .env.local
export

# Escaneo con SonarQube
sonar:
	mvn clean verify sonar:sonar \
		-Dsonar.projectKey=$(SONAR_PROJECT_KEY) \
		-Dsonar.projectName='$(SONAR_PROJECT_NAME)' \
		-Dsonar.host.url=$(SONAR_HOST) \
		-Dsonar.token=$(SONAR_TOKEN)

# Compilar y empaquetar el proyecto
build:
	mvn clean package -DskipTests

# Levantar contenedores Docker
up:
	docker-compose up -d

# Detener contenedores Docker
down:
	docker-compose down

# Ejecutar tests
test:
	mvn test

# Limpiar artefactos generados
clean:
	mvn clean

# Verificar formato del código (si usas formatter o checkstyle)
verify:
	mvn verify
