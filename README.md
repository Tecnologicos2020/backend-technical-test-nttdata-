# API de Gestión de Clientes y Tipos de Documento

Este proyecto es una API REST desarrollada con Spring Boot para la gestión de clientes y sus tipos de documento. Permite registrar, consultar y administrar clientes y los tipos de documentos asociados.

## Estructura del Proyecto

- **controller/**: Controladores REST (exponen los endpoints)
- **service/**: Lógica de negocio
- **repository/**: Acceso a datos (Spring Data JPA)
- **model/**: Entidades del dominio
- **dto/**: Objetos de transferencia de datos

## Endpoints Principales

### Clientes
- `GET /clientes` — Obtiene todos los clientes
- `GET /clientes/{id}` — Obtiene un cliente por su ID
- `POST /clientes` — Crea un nuevo cliente
- `PUT /clientes/{id}` — Actualiza un cliente existente
- `DELETE /clientes/{id}` — Elimina un cliente

### Tipos de Documento
- `GET /tipos-documento` — Obtiene todos los tipos de documento
- `GET /tipos-documento/{id}` — Obtiene un tipo de documento por ID
- `POST /tipos-documento` — Crea un nuevo tipo de documento
- `PUT /tipos-documento/{id}` — Actualiza un tipo de documento existente
- `DELETE /tipos-documento/{id}` — Elimina un tipo de documento

## Ejemplo de Entidad Cliente
```json
{
    "identificacion": "788888888",
    "primerNombre": "JUAN",
    "segundoNombre": "",
    "primerApellido": "PEREZ",
    "segundoApellido": "PEREZ",
    "telefono": "3106146310",
    "direccion": "CALLE 50 #89-20",
    "ciudadResidencia": "BOGOTA D.C",
    "tipoDocumento": 1
}
```

## Tecnologías Utilizadas
- Java 17+
- Spring Boot
- Spring Data JPA
- Maven

## Ejecución Local

1. Clona el repositorio
2. Para ejecutar en modo desarrollo:
   ```bash
   ./mvnw spring-boot:run
   ```
3. Para generar el archivo JAR ejecutable:
   ```bash
   ./mvnw clean package
   ```
   El JAR se generará en la carpeta `target/`.
4. Para ejecutar el JAR generado:
   ```bash
   java -jar target/<nombre-del-jar>.jar
   ```
5. Accede a la API en `http://localhost:8080`

## Notas
- Configura la conexión a base de datos en `src/main/resources/application.properties`.
- Puedes ampliar la API agregando nuevos endpoints o lógica en los servicios.

---

> Proyecto técnico de ejemplo para NTT DATA
