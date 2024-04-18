package com.nabi.Nabi.service;

import com.nabi.Nabi.model.Producto;
import com.nabi.Nabi.dto.ProductoDTO;
import com.nabi.Nabi.repository.ProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    ProductoRepository productoR;

    @Override
    public List<Producto> traerProductos() {
        return productoR.findAll();
    }

    @Override
    public void crearProducto(Producto producto) {
        productoR.save(producto);
    }

    @Override
    public List<ProductoDTO> traerProductosDTO() {
        return productoR.findProductoDTO();
    }

}
