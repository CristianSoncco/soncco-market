package com.crislearning.soncco_market.web.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crislearning.soncco_market.domain.Product;
import com.crislearning.soncco_market.domain.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;

@RestController 
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    @Operation(summary = "Obtiene todas las compras", description = "Recuperar todas las compras en el sistema") 
    public ResponseEntity<List<Product>> getAll(){
        return new ResponseEntity<>(productService.getAll(),HttpStatus.OK);
    };

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") int productId){
        return productService.getProduct(productId)
        .map(product->new ResponseEntity<>(product, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    };

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable("categoryId") int categoryId){
        return productService.getByCategory(categoryId)
        .map(category->new ResponseEntity<>(category, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    };
    
    @PostMapping("/save")
    public ResponseEntity<Product> save(@RequestBody Product product){
        return new ResponseEntity<>(productService.save(product),HttpStatus.CREATED);
        
    };

    @SuppressWarnings("rawtypes")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id")int productId){
        if (productService.delete(productId)) {
            return new ResponseEntity(HttpStatus.OK);
            
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    };
}
