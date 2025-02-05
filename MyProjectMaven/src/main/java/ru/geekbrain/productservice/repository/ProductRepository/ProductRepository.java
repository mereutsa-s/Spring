package ru.geekbrain.productservice.repository.ProductRepository;

import ru.geekbrain.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}