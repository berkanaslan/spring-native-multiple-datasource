package com.berkanaslan.springnativemultipledatasource.repositories.product;

import com.berkanaslan.springnativemultipledatasource.models.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
