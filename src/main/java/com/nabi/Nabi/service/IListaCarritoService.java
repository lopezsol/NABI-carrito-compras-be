
package com.nabi.Nabi.service;

import com.nabi.Nabi.model.ListaCarrito;
import com.nabi.Nabi.model.ProductoCarrito;
import java.util.List;

public interface IListaCarritoService {
    public ListaCarrito traerListaCarrito(String estado);
    public void crearListaCarrito(ListaCarrito listaCarrito);
    public void modificarListaCarrito(ListaCarrito listaCarrito);
    
    
}
