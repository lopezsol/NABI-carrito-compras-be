package com.nabi.Nabi.service;

import com.nabi.Nabi.model.ProductoCarrito;
import java.util.List;

public interface IProductoCarritoService {

    public void crearProductoCarrito(ProductoCarrito producto);

    public ProductoCarrito traerProductoCarrito(Long id);

    public List<ProductoCarrito> traerProductosCarrito();

    public void modificarProductoCarrito(ProductoCarrito producto);

    public void eliminarProductoCarrito(Long id);

    public void disminuirProductoCarrito(Long id);
    public void aumentarProductoCarrito(Long id, int cantidad);

}
