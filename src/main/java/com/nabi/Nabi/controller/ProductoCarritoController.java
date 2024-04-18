package com.nabi.Nabi.controller;

import com.nabi.Nabi.model.ProductoCarrito;
import com.nabi.Nabi.service.IProductoCarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos-carrito")
@CrossOrigin
public class ProductoCarritoController {
    @Autowired
    private IProductoCarritoService productoCarritoService;

    @PostMapping("/crear")
    public void crearProductoCarrito(@RequestBody ProductoCarrito producto) {
        productoCarritoService.crearProductoCarrito(producto);
    }

    @GetMapping("/ver")
    @ResponseBody
    public List<ProductoCarrito> traerProductosCarrito() {
        return productoCarritoService.traerProductosCarrito();
    }

    @PutMapping("/agregar")
    public void agregarProductoListaCarrito(@RequestBody ProductoCarrito productoC) {
        System.out.println("entre a crear el productoCarrito");
        productoCarritoService.crearProductoCarrito(productoC);
        System.out.println(productoC.toString());

    }

    @PutMapping("/modificar")
    public void modificarProductoListaCarrito(@RequestBody ProductoCarrito productoC) {
        System.out.println("entre a modificar el productoCarrito");
        productoCarritoService.modificarProductoCarrito(productoC);
        System.out.println(productoC.toString());
    }

    @PutMapping("/modificar/aumentar/{id}/{cantidad}")
    public void aumentarProductoListaCarrito(@PathVariable Long id, @PathVariable int cantidad) {
        System.out.println("entre a aumentar productoCarrito");
        productoCarritoService.aumentarProductoCarrito(id, cantidad);
    }
    @PutMapping("/modificar/disminuir")
    public void disminuirProductoListaCarrito(@RequestBody Long id) {
        System.out.println("entre a disminuir productoCarrito");
        productoCarritoService.disminuirProductoCarrito(id);
    }
    @DeleteMapping("/eliminar")
    public void eliminarProductoListaCarrito(@RequestBody Long id) {
        System.out.println("entre a eliminar el productoCarrito");
        productoCarritoService.eliminarProductoCarrito(id);
    }
}
