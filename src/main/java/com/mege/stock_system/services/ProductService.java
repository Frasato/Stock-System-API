package com.mege.stock_system.services;

import com.mege.stock_system.models.ProductModel;
import com.mege.stock_system.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductModel> listAllProducts(){
        return productRepository.findAll();
    }

    public void saveProduct(ProductModel productModel){
        productRepository.save(productModel);
    }

    public ResponseEntity<?> sellingProduct(String id, int quantity){
        Optional<ProductModel> findedProduct = productRepository.findById(id);

        if(findedProduct.isPresent()){
            ProductModel product = findedProduct.get();
            product.setQuantity(product.getQuantity() - quantity);
            productRepository.save(product);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.status(404).body("Product not found!");
    }

    public ResponseEntity<?> deleteProduct(String id){
        Optional<ProductModel> findedProduct = productRepository.findById(id);

        if(findedProduct.isPresent()){
            ProductModel product = findedProduct.get();
            productRepository.delete(product);
            return ResponseEntity.status(200).build();
        }

        return ResponseEntity.status(404).body("Product not found!");
    }
}