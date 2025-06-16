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
- `GET /api/client` — Obtiene todos los clientes
- `GET /api/client/{id}` — Obtiene un cliente por su ID
- `GET /api/client/{identification}/{tipoDocumento}` — Busca un cliente por identificación y tipo de documento
- `POST /api/client` — Crea un nuevo cliente

### Tipos de Documento
- `GET /api/tipo-documento` — Obtiene todos los tipos de documento
- `GET /api/tipo-documento/{id}` — Obtiene un tipo de documento por ID

## Ejemplo de Entidad Cliente
```json
{
    "identificacion":"23445322",
    "primerNombre":"NTTDATA",
    "segundoNombre":"NTTDATA",
    "primerApellido":"NTTDATA",
    "segundoApellido":"NTTDATA",
    "telefono":"6017930303",
    "direccion":"CALLE 50 #89-20",
    "ciudadResidencia":"BOGOTA D.C",
    "tipoDocumento":1
}
```

## Tecnologías Utilizadas
- Java 17+
- Spring Boot
- Spring Data JPA
- MySQL
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
5. Accede a la API en https://api---nttdata-technical-test-jefdcgvyja-ew.a.run.app

## Notas
- Configura la conexión a base de datos en `src/main/resources/application.properties`.
- Puedes ampliar la API agregando nuevos endpoints o lógica en los servicios.

---

> Proyecto técnico de ejemplo para NTT DATA
