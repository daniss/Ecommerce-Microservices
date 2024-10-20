package com.ecommerce.ecommerce.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ecommerce.ecommerce.Product.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
