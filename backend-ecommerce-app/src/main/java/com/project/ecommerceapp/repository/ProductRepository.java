package com.project.ecommerceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.ecommerceapp.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}