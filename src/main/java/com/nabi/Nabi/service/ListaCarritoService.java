package com.nabi.Nabi.service;

import com.nabi.Nabi.model.ListaCarrito;
import com.nabi.Nabi.model.ProductoCarrito;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nabi.Nabi.repository.ListaCarritoRepository;

@Service
public class ListaCarritoService implements IListaCarritoService {

    @Autowired
    ListaCarritoRepository listaCarritoR;   

    @Override
    public void crearListaCarrito(ListaCarrito listaCarrito) {
        listaCarritoR.save(listaCarrito);
    }

    @Override
    public ListaCarrito traerListaCarrito(String estado) {
        return listaCarritoR.findFirstByEstado(estado);
    }

    @Override
    public void modificarListaCarrito(ListaCarrito listaCarrito) {
        listaCarritoR.save(listaCarrito);
    }

}
