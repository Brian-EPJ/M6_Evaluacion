package com.example.M6_Evaluacion.cliente;

import com.example.M6_Evaluacion.modelo.Producto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProductoClientMock {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String baseUrl = "http://localhost:8081/api/v1/productos";

    // Crear producto en la API
    public Producto crearProductoMock() {
        Producto nuevo = new Producto();
        nuevo.setNombre("Producto creado desde otra app");
        nuevo.setDescripcion("Prueba de integración con mock client");
        nuevo.setPrecio(new java.math.BigDecimal("15000"));
        nuevo.setStockDisponible(20);

        return restTemplate.postForObject(baseUrl, nuevo, Producto.class);
    }

    // Obtener producto desde la API
    public Producto obtenerProducto(Long id) {
        return restTemplate.getForObject(baseUrl + "/" + id, Producto.class);
    }
}