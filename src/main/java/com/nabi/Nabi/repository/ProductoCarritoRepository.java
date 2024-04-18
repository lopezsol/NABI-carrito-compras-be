package com.nabi.Nabi.repository;

import com.nabi.Nabi.model.ProductoCarrito;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoCarritoRepository extends JpaRepository<ProductoCarrito, Long> {

}
