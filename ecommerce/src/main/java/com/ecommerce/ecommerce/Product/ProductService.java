package com.ecommerce.ecommerce.Product;

import java.util.List;
import com.ecommerce.ecommerce.Product.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.Product.ProductRepository;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> listProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(Long id){
        return productRepository.findById(id).orElse(null);
    }
    
    public Product addProduct(Product product){
        try {
            return productRepository.save(product);
        } catch (Exception e) {
            return null;
        }
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    public void updateProduct(Long id, Product updated){
        Product existingProduct = productRepository.findById(id).orElse(null);
        if (existingProduct != null) {
            existingProduct.setName(updated.getName());
            existingProduct.setDescription(updated.getDescription());
            existingProduct.setPrice(updated.getPrice());
            productRepository.save(existingProduct);
        }
    }
}
