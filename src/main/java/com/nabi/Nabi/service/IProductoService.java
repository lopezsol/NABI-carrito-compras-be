package com.nabi.Nabi.service;

import com.nabi.Nabi.model.Producto;
import com.nabi.Nabi.dto.ProductoDTO;
import java.util.List;

public interface IProductoService {

    public List<Producto> traerProductos();

    public void crearProducto(Producto producto);

    public List<ProductoDTO> traerProductosDTO();

}
