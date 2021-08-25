package com.kloudspot.repository;

import java.util.List;

import com.kloudspot.models.Product;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, Integer> {
    List<Product> findByName(String name);
    List<Product> findByPriceLessThan(double price);
    List<Product> findByPriceGreaterThan(double price);
    List<Product> findByAgeInMonthsLessThan(int age);
    List<Product> findByCategory(String category);
}
