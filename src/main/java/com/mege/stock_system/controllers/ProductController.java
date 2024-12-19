package com.mege.stock_system.controllers;

import com.mege.stock_system.dtos.RequestProductDto;
import com.mege.stock_system.models.ProductModel;
import com.mege.stock_system.repositories.ProductRepository;
import com.mege.stock_system.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/list/all")
    public ResponseEntity<?> listAll(){
        List<ProductModel> all = productService.listAllProducts();
        return ResponseEntity.ok().body(all);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@RequestBody RequestProductDto requestProductDto){
        ProductModel product = new ProductModel();
        Optional<ProductModel> findedProduct = productRepository.findByName(requestProductDto.name());

        if(findedProduct.isPresent()) return ResponseEntity.badRequest().body("Product Already Exist on Database!");

        product.setBarCode(requestProductDto.barCode());
        product.setName(requestProductDto.name());
        product.setMark(requestProductDto.mark());
        product.setQuantity(requestProductDto.quantity());
        product.setType(requestProductDto.type());
        product.setEntryDate(LocalDateTime.now());
        product.setAdditionDate(LocalDateTime.now());

        productService.saveProduct(product);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/selling/{id}")
    public ResponseEntity<?> sellingProduct(@RequestBody int sellingQuantity, @RequestParam(name = "id") String id){
        ResponseEntity<?> sellingResponse = productService.sellingProduct(id, sellingQuantity);
        return sellingResponse;
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> deleteProduct(@RequestParam(name = "id")String id){
        ResponseEntity<?> response = productService.deleteProduct(id);
        return response;
    }

}