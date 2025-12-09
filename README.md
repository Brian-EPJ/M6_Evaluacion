# 📦 API REST de Gestión de Productos – Módulo 6 Evaluación

Esta aplicación es una **API REST desarrollada con Spring Boot 3**, que permite gestionar productos, realizar validaciones, manejar excepciones globales y ejecutar una prueba de integración utilizando un cliente mock.

---

## 🧾 **Descripción del Servicio**

Este servicio permite administrar productos con las operaciones básicas:

* Crear productos
* Listar productos
* Obtener producto por ID
* Actualizar producto
* Eliminar producto

Incluye:

* Validaciones con Jakarta Validation
* Manejo global de errores mediante `@ControllerAdvice`
* Integración simulada (mock) usando RestTemplate

---

## 🎯 **Casos de Uso**

1. **Tienda online:** Registrar productos, actualizar precios y administrar inventario.
2. **Sistema de bodega:** Ver y modificar stock disponible.
3. **Aplicación de reportes:** Consultar productos almacenados.
4. **Servicios externos:** Consumir esta API desde otra aplicación para sincronizar datos.

---

## 🛠 **Tecnologías Utilizadas**

* Java 17
* Spring Boot 3.5.7
* Spring Web
* Spring Data JPA
* MariaDB
* Spring Validation
* RestTemplate (integración mock)
* Spring Security (configurada para permitir todo)

---

## 📁 **Estructura del Proyecto**

```
src/
├── controller/
├── service/
├── repository/
├── modelo/
├── exception/
├── cliente/     <- integración mock
```

---

## 🚀 **Cómo Compilar, Ejecutar y Probar**

### 🔧 1. **Compilar el proyecto**

```bash
mvn clean install
```

### ▶️ 2. **Ejecutar el proyecto**

```bash
mvn spring-boot:run
```

El servidor se inicia en:

```
http://localhost:8081
```

### 🧪 3. **Probar con Postman o cURL**

* Evidencia con capturas de pantalla en carpeta Evidencia PostMan

### 🧷 4. **Prueba de integración automática**

Se ejecuta en consola al iniciar la aplicación:

* Crea un producto vía mock
* Lo consulta vía GET
* Imprime resultados

**Salida esperada (ejemplo):**

```
----- Ejecutando prueba de integración -----
Producto creado mediante mock client:
Producto(id=1, nombre="Producto Mock", ...)
Producto obtenido mediante mock client:
Producto(id=1, nombre="Producto Mock", ...)
----- Prueba de integración finalizada -----
```

---

## 🔧 **Endpoints de la API**

### 📌 Obtener todos los productos

**GET** `/api/v1/productos`

### 📌 Obtener producto por ID

**GET** `/api/v1/productos/{id}`

### 📌 Crear producto

**POST** `/api/v1/productos`

Ejemplo de JSON:

```json
{
  "nombre": "Galletas Sunick",
  "descripcion": "bien buenas pero altas en calorias",
  "precio": 30.5,
  "stockDisponible": 3000
}
```

### 📌 Actualizar producto

**PUT** `/api/v1/productos/{id}`

### 📌 Eliminar producto

**DELETE** `/api/v1/productos/{id}`

---

## 📌 **Ejemplos de prueba (cURL)**

### Crear producto

```bash
curl -X POST http://localhost:8081/api/v1/productos \
-H "Content-Type: application/json" \
-d '{"nombre":"Cereal","descripcion":"Integral","precio":1500,"stockDisponible":50}'
```

### Obtener todos

```bash
curl http://localhost:8081/api/v1/productos
```

### Actualizar producto

```bash
curl -X PUT http://localhost:8081/api/v1/productos/1 \
-H "Content-Type: application/json" \
-d '{"nombre":"Cereal Light","descripcion":"Menos azúcar","precio":1800,"stockDisponible":40}'
```

### Eliminar

```bash
curl -X DELETE http://localhost:8081/api/v1/productos/1
```

---

## 🛡 **Validaciones Implementadas**

En el modelo `Producto`:

```java
@NotBlank(message = "El nombre es obligatorio")
@Min(value = 100, message = "El precio mínimo es 100")
```

---

## ⚠️ **Manejo Global de Errores**

Implementado con:

```java
@ControllerAdvice
public class GlobalExceptionHandler { ... }
```

**Respuesta de error JSON:**

```json
{
  "mensaje": "Producto no encontrado",
  "status": 404,
  "timestamp": "2025-11-13T20:15:22"
}
```

---

## 📘 **Swagger / OpenAPI — Nota Importante**

Intenté implementar documentación automática con **Springdoc OpenAPI**, pero:

⚠️ La aplicación no lograba iniciar debido al error:

```
NoSuchMethodError: ControllerAdviceBean.<init>
```

Esto indica una incompatibilidad entre **Spring Boot 3.5.7** y la versión disponible de **Springdoc**, por lo que Swagger UI (`/swagger-ui.html`) y `/v3/api-docs` no pudieron habilitarse.

Dejo esta nota como evidencia de que **se intentó integrar**, pero no fue posible completarlo dentro del plazo.

---

## 🗃 **Base de Datos**

Se utiliza **MariaDB** con la configuración incluida en `application.properties`.

---

## ✔️ Estado Actual

* ✓ CRUD 100% funcional
* ✓ Validaciones
* ✓ Manejo global de errores
* ✓ Prueba de integración mock
* ✓ Documentación técnica
* ✖ Swagger (intentado, pero falló por incompatibilidad)

---

## 👨‍💻 Desarrollado por

**Brian Pradenas Jaramillo** – Evaluación Módulo 6



