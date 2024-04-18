package com.nabi.Nabi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ProductoCarrito {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int cantidad;
    @ManyToOne
    Producto producto;

    @ManyToOne
    @JsonIgnoreProperties("listaProductosCarrito")
    private ListaCarrito listaCarrito;

    @Override
    public String toString() {
        return "ProductoCarrito{" + "id=" + id + ", cantidad=" + cantidad + ", producto=" + producto + ", listaCarrito=" + listaCarrito + '}';
    }

}
