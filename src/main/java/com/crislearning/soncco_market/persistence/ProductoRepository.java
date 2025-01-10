package com.crislearning.soncco_market.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crislearning.soncco_market.domain.Product;
import com.crislearning.soncco_market.domain.repository.ProductRepository;
import com.crislearning.soncco_market.persistence.crud.ProductoCrudRepository;
import com.crislearning.soncco_market.persistence.entity.Producto;
import com.crislearning.soncco_market.persistence.mapper.ProductMapper;

@Repository
public class ProductoRepository implements ProductRepository{
    @Autowired
    private ProductoCrudRepository productoCrudRepository;
    @Autowired
    private ProductMapper mapperProduct;
    
    public List<Product> getAll(){
        List<Producto> productos= (List<Producto>) productoCrudRepository.findAll();
        return mapperProduct.toProducts(productos);
    }

    public List<Producto> getComprasRealizadasDeUnaCategoriaPorCliente(Integer idCategoria, String idCliente) {
        return productoCrudRepository.findByIdCategoriaAndComprasProductosCompraIdCliente(idCategoria, idCliente);
    }



    @Override
    public void delete(int productId){
        productoCrudRepository.deleteById(productId);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapperProduct.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarceProducts(int quantity) {
        Optional<List<Producto>> productosEscasos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity,"P");
         return productosEscasos.map(prods -> mapperProduct.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
         return productoCrudRepository.findById(productId).map(prod ->mapperProduct.toProduct(prod)) ;
    }

    @Override
    public Product save(Product product) {
        return mapperProduct.toProduct(productoCrudRepository.save(mapperProduct.toProducto(product)));
    }

}
