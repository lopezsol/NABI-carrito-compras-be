/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nabi.Nabi.repository;

import com.nabi.Nabi.model.ListaCarrito;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Sol
 */
public interface ListaCarritoRepository  extends JpaRepository<ListaCarrito, Long> {
    ListaCarrito findFirstByEstado(String estado); 
    
}
