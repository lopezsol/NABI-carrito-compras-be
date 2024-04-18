package com.nabi.Nabi.controller;

import com.nabi.Nabi.dto.ProductoDTO;
import com.nabi.Nabi.model.Producto;
import com.nabi.Nabi.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
@CrossOrigin
public class ProductoController {
    @Autowired
    private IProductoService productoService;

    @GetMapping("/ver/productos")
    @ResponseBody
    public List<Producto> traerProductos() {
        return productoService.traerProductos();
    }

    @PostMapping("/crear")
    public void crearProducto(@RequestBody Producto producto) {
        productoService.crearProducto(producto);
    }

    @GetMapping("/ver")
    @ResponseBody
    public List<ProductoDTO> traerProductosDTO() {
        System.out.println("productos dto");
        return productoService.traerProductosDTO();
    }

}
