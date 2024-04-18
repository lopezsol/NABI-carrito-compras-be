package com.nabi.Nabi.controller;

import com.nabi.Nabi.model.ListaCarrito;
import com.nabi.Nabi.model.ProductoCarrito;
import com.nabi.Nabi.service.IListaCarritoService;
import com.nabi.Nabi.service.IProductoCarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lista-carrito")
@CrossOrigin
public class ListaCarritoController {
    @Autowired
    private IListaCarritoService listaCarritoService;

    @Autowired
    private IProductoCarritoService productoCarritoService;

    @PostMapping("/crear/lista-carrito")
    public void crearListaCarrito(@RequestBody ListaCarrito listaCarrito) {
        listaCarrito.setEstado("activa");
        listaCarritoService.crearListaCarrito(listaCarrito);

    }

    @GetMapping("/ver")
    @ResponseBody
    public ListaCarrito traerListaCarrito() {
        System.out.println(listaCarritoService.traerListaCarrito("activa"));
        if (listaCarritoService.traerListaCarrito("activa") == null) {
            ListaCarrito nuevaLista = new ListaCarrito();
            crearListaCarrito(nuevaLista);
        }
        return listaCarritoService.traerListaCarrito("activa");
    }

    @PutMapping("/modificar")
    public void modificarListaCarrito(@RequestBody ListaCarrito listaCarrito) {
        System.out.println("----");
        System.out.println("la lista es: " + listaCarrito.getId());
        System.out.println("estado: " + listaCarrito.getEstado());
        System.out.println("productos: " + listaCarrito.getListaProductosCarrito());

        System.out.println(listaCarrito.getListaProductosCarrito().toString());
        for (ProductoCarrito producto : listaCarrito.getListaProductosCarrito()) {
            System.out.println(producto.toString());
            producto.setListaCarrito(listaCarrito);
            productoCarritoService.crearProductoCarrito(producto);
            System.out.println("----");
            System.out.println("entre a crear el productoCarrito");
            System.out.println(producto.toString());
        }
        System.out.println("----");
        System.out.println("entre a modificar la lista");
        System.out.println(listaCarrito.getListaProductosCarrito().toString());
        listaCarritoService.modificarListaCarrito(listaCarrito);

    }


}
