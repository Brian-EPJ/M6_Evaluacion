package com.example.M6_Evaluacion.Service;

import com.example.M6_Evaluacion.modelo.Producto;

import java.util.List;

public interface ProductoService {

    List<Producto> findAll();
    Producto findById(Long id);
    Producto save(Producto producto);
    Producto update(Long id, Producto producto);
    void delete(Long id);
}
