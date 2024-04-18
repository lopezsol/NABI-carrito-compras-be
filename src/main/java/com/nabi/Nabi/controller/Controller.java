package com.nabi.Nabi.controller;

import com.nabi.Nabi.model.Informacion;
import com.nabi.Nabi.model.ListaCarrito;
import com.nabi.Nabi.model.Producto;
import com.nabi.Nabi.model.ProductoCarrito;
import com.nabi.Nabi.dto.ProductoDTO;
import com.nabi.Nabi.service.IProductoService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.nabi.Nabi.service.IListaCarritoService;
import com.nabi.Nabi.service.IProductoCarritoService;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin
public class Controller {

    @Autowired
    IProductoService productoS;
    @Autowired
    IListaCarritoService listaCarritoS;
    @Autowired
    IProductoCarritoService productoCarritoS;

    List<Producto> productos = new ArrayList<Producto>();
    List<ProductoCarrito> listaProductosC = new ArrayList<ProductoCarrito>();

    Informacion info1 = new Informacion("esta es la info", "este es el modo de uso");
    Informacion info2 = new Informacion("esta es la info2", "este es el modo de uso2");
    Informacion info3 = new Informacion("esta es la info3", "este es el modo de uso3");

    @GetMapping("/ver/productos")
    @ResponseBody
    public List<Producto> traerProductos() {
        return productoS.traerProductos();
    }

    @PostMapping("/crear/producto")
    public void crearProducto(@RequestBody Producto producto) {
        productoS.crearProducto(producto);
    }

    @GetMapping("/ver/productos-dto")
    @ResponseBody
    public List<ProductoDTO> traerProductosDTO() {
        System.out.println("productos dto");
        return productoS.traerProductosDTO();
    }

    //productos carrito
    @PostMapping("/crear/producto-carrito")
    public void crearProductoCarrito(@RequestBody ProductoCarrito producto) {
        productoCarritoS.crearProductoCarrito(producto);
    }

    @GetMapping("/ver/productos-carrito")
    @ResponseBody
    public List<ProductoCarrito> traerProductosCarrito() {
        return productoCarritoS.traerProductosCarrito();
    }

    //lista carrito
    @PostMapping("/crear/lista-carrito")
    public void crearListaCarrito(@RequestBody ListaCarrito listaCarrito) {
        listaCarrito.setEstado("activa");
        listaCarritoS.crearListaCarrito(listaCarrito);

    }

    @GetMapping("/lista-carrito")
    @ResponseBody
    public ListaCarrito traerListaCarrito() {
        System.out.println(listaCarritoS.traerListaCarrito("activa"));
        if (listaCarritoS.traerListaCarrito("activa") == null) {
            ListaCarrito nuevaLista = new ListaCarrito();
            crearListaCarrito(nuevaLista);
        }
        return listaCarritoS.traerListaCarrito("activa");
    }

    @PutMapping("/modificar/lista-carrito")
    public void modificarListaCarrito(@RequestBody ListaCarrito listaCarrito) {
        System.out.println("----");
        System.out.println("la lista es: " + listaCarrito.toString());
        for (ProductoCarrito producto : listaCarrito.getListaProductosCarrito()) {
            System.out.println(producto.toString());
            producto.setListaCarrito(listaCarrito);
            crearProductoCarrito(producto);
            System.out.println("----");
            System.out.println("entre a crear el productoCarrito");
            System.out.println(producto.toString());
        }
        System.out.println("----");
        System.out.println("entre a modificar la lista");
        System.out.println(listaCarrito.getListaProductosCarrito().toString());
        listaCarritoS.modificarListaCarrito(listaCarrito);

    }

    @PostMapping("/agregar/producto-carrito/lista-carrito")
    public void agregarProductoListaCarrito(@RequestBody ListaCarrito listaCarrito,
            @RequestBody ProductoCarrito productoC) {
        System.out.println("entre a crear el productoCarrito");
        crearProductoCarrito(productoC);
        System.out.println(productoC.toString());

    }

}
