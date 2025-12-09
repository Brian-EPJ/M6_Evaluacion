package com.example.M6_Evaluacion;

import com.example.M6_Evaluacion.cliente.ProductoClientMock;
import com.example.M6_Evaluacion.modelo.Producto;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class M6EvaluacionApplication {

    public static void main(String[] args) {
        SpringApplication.run(M6EvaluacionApplication.class, args);
    }

    @Bean
    CommandLineRunner testClient(ProductoClientMock client) {
        return args -> {

            System.out.println("----- Ejecutando prueba de integración -----");

            // Crear producto desde el mock
            Producto creado = client.crearProductoMock();
            System.out.println("Producto creado mediante mock client:");
            System.out.println(creado);

            // Obtenerlo desde la API para validar
            Producto obtenido = client.obtenerProducto(creado.getId());
            System.out.println("Producto obtenido mediante mock client:");
            System.out.println(obtenido);

            System.out.println("----- Prueba de integración finalizada -----");
        };
    }
}
