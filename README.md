# SysSalud API

## Descripción
SysSalud es una API REST desarrollada en **Spring Boot** utilizando **arquitectura hexagonal** y principios de **Domain-Driven Design (DDD)**. La API gestiona información relacionada con pacientes, médicos, citas y catálogos en un sistema de salud.

## Tecnologías utilizadas
- **Java 17+**
- **Spring Boot 3.x**
- **Spring Security & JWT**
- **Hibernate & JPA**
- **Arquitectura Hexagonal**
- **Docker**
- **Swagger OpenAPI**
- **Maven**

## Estructura del Proyecto
```bash
.mvn/
src/
├── main/
│   ├── java/com/saludSystem/
│   │   ├── application/ # DTOs y casos de uso
│   │   ├── domain/       # Modelo de dominio y excepciones
│   │   ├── infrastructure/
│   │   │   ├── adapters/ # Controladores y persistencia
│   │   │   ├── config/   # Configuraciones generales
│   │   │   ├── security/ # Seguridad y autenticación JWT
│   │   ├── services/     # Servicios de negocio
│   │   ├── SysSaludApplication.java
│   ├── resources/
│   │   ├── application.yml # Configuración de la API
├── test/java/com/saludSystem/
├── Dockerfile
├── pom.xml
```

## Instalación y Configuración
### Prerrequisitos
- Tener **Java 17+** y **Maven** instalado
- Base de datos **MySQL** en ejecución

### Configuración de la Base de Datos
Edita el archivo `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/sys_salud
spring.datasource.username=root
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
```

### Construcción y Ejecución
```sh
# Clonar el repositorio
git clone https://github.com/tu_usuario/sys-salud-api.git
cd sys-salud-api

# Construir el proyecto con Maven
mvn clean install

# Ejecutar la API
mvn spring-boot:run
```

## Autenticación y Seguridad
La API usa **JWT** para la autenticación de usuarios.
- **Login:** `/auth/login`
- **Registro:** `/auth/register`

### Ejemplo de Login
```sh
curl -X POST "http://localhost:8080/auth/login" \
     -H "Content-Type: application/json" \
     -d '{"username": "admin", "password": "admin"}'
```

## Endpoints Principales
La API está dividida en diferentes módulos:

### 📂 **Catálogo** (`/catalogo`)
| Método | Endpoint              | Descripción                  |
|--------|----------------------|------------------------------|
| `GET`  | `/alergias`          | Obtener lista de alergias    |
| `POST` | `/alergias`          | Crear nueva alergia          |
| `PUT`  | `/alergias/{id}`     | Actualizar una alergia       |
| `GET`  | `/clientes`          | Obtener lista de clientes    |
| `POST` | `/clientes`          | Crear un nuevo cliente       |

### 📂 **Paciente** (`/pacientes`)
| Método | Endpoint               | Descripción               |
|--------|------------------------|---------------------------|
| `GET`  | `/pacientes`           | Listar todos los pacientes |
| `POST` | `/pacientes`           | Registrar un paciente     |
| `PUT`  | `/pacientes/{id}`      | Actualizar datos paciente |

## Documentación con Swagger
Swagger UI está disponible en:
```
http://localhost:8080/swagger-ui/index.html
```

## Despliegue con Docker
Para ejecutar la API con Docker:
```sh
docker build -t syssalud-api .
docker run -p 8080:8080 syssalud-api
```

## Contribución
Si deseas contribuir:
1. Haz un fork del proyecto
2. Crea una nueva rama (`git checkout -b feature/nueva_funcionalidad`)
3. Realiza tus cambios y commitea (`git commit -m 'Añadir nueva funcionalidad'`)
4. Sube tu rama (`git push origin feature/nueva_funcionalidad`)
5. Abre un Pull Request

## Licencia
Este proyecto está bajo la **Licencia MIT**.

