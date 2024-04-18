package com.nabi.Nabi.repository;

import com.nabi.Nabi.model.Producto;
import com.nabi.Nabi.dto.ProductoDTO;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    /*@Query("SELECT pc.id, pc.nombre, pc.marca, pc.descripcion, pc.precio, pc.img, pc.informacion, pc.modoUso FROM Producto pc")
    List<Object[]> findProductoDTO();*/
    @Query("SELECT new com.nabi.Nabi.dto.ProductoDTO(p.id, p.nombre, p.marca, p.descripcion, p.precio, p.img, p.informacion, p.modoUso) FROM Producto p")
    List<ProductoDTO> findProductoDTO();

    //List<ProductoDTO> findAllBy();
}
