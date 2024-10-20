package com.ecommerce.ecommerce.Product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/product")
public class ProductController {
    
    @Autowired
    ProductService productService;

    @GetMapping()
    ResponseEntity<List<Product>> listProducts(){
        List<Product> listproducts = productService.listProducts();
        return ResponseEntity.ok(listproducts);
    }

    @GetMapping("/{id}")
    ResponseEntity<Product> getProduct(@PathVariable Long id){
        Product product = productService.getProduct(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping()
    ResponseEntity<Product> addProduct(@RequestBody Product product){
        Product added = productService.addProduct(product);
        return ResponseEntity.ok(added);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted");
    }

    @PutMapping("/{id}")
    ResponseEntity<String> updateProduct(@PathVariable Long id, @RequestBody Product updated){
        productService.updateProduct(id, updated);
        return ResponseEntity.ok("Product Updated");
    }
}
