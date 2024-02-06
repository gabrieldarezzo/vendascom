package io.github.gabrieldarezzo.domain.repository;

import io.github.gabrieldarezzo.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByDescriptionStartsWith(String nome);


}
