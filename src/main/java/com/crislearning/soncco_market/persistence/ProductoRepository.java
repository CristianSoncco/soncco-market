package com.crislearning.soncco_market.persistence;

import java.util.List;
import java.util.Optional;

import com.crislearning.soncco_market.persistence.crud.ProductoCrudRepository;
import com.crislearning.soncco_market.persistence.entity.Producto;

public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;
    
    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }
    
    public List<Producto> getByCategoria(int idCategoria){
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidad) {
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad);
    }
}
