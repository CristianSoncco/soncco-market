package com.crislearning.soncco_market.persistence.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.crislearning.soncco_market.persistence.entity.Producto;

public interface ProductoCrudRepository extends CrudRepository<Producto,Integer>{
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidad);
    
}

