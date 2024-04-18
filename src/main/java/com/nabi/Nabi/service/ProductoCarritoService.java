package com.nabi.Nabi.service;

import com.nabi.Nabi.model.ListaCarrito;
import com.nabi.Nabi.model.ProductoCarrito;
import com.nabi.Nabi.repository.ProductoCarritoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoCarritoService implements IProductoCarritoService {

    @Autowired
    ProductoCarritoRepository productoCarritoR;

    @Autowired
    private IListaCarritoService listaCarritoService;

    @Override
    public void crearProductoCarrito(ProductoCarrito producto) {
        ListaCarrito listaCarrito = listaCarritoService.traerListaCarrito("activa");
        producto.setListaCarrito(listaCarrito);
        productoCarritoR.save(producto);

    }

    @Override
    public ProductoCarrito traerProductoCarrito(Long id) {
        return productoCarritoR.findById(id).orElse(null);
    }

    @Override
    public List<ProductoCarrito> traerProductosCarrito() {
        return productoCarritoR.findAll();
    }

    @Override
    public void modificarProductoCarrito(ProductoCarrito producto) {
        ProductoCarrito productoCarrito = productoCarritoR.findById(producto.getId()).orElse(null);
        productoCarrito.setCantidad(producto.getCantidad());
        System.out.println("entre al modificar");
        System.out.println(producto.getCantidad());

        productoCarritoR.save(productoCarrito);
    }

    @Override
    public void eliminarProductoCarrito(Long id) {
        productoCarritoR.deleteById(id);
    }

    @Override
    public void disminuirProductoCarrito(Long id) {
        ProductoCarrito productoCarrito = productoCarritoR.findById(id).orElse(null);
        productoCarrito.setCantidad(productoCarrito.getCantidad() - 1);
        productoCarritoR.save(productoCarrito);
    }

    @Override
    public void aumentarProductoCarrito(Long id, int cantidad) {
        ProductoCarrito productoCarrito = productoCarritoR.findById(id).orElse(null);
        productoCarrito.setCantidad(productoCarrito.getCantidad() + cantidad);
        productoCarritoR.save(productoCarrito);

    }


}
