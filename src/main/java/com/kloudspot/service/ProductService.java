package com.kloudspot.service;

import java.util.List;

import com.kloudspot.models.Product;
import com.kloudspot.exception.ProductNotFoundException;

public interface ProductService {

    // C
    Product addProduct(Product product);

    // R
    Product getById(int id) throws ProductNotFoundException;

    List<Product> getAll();

    List<Product> getByName(String name) throws ProductNotFoundException;

    List<Product> getByPriceLessThan(double price) throws ProductNotFoundException;

    List<Product> getByPriceGreaterThan(double price) throws ProductNotFoundException;

    List<Product> getByAgeLessThan(int age) throws ProductNotFoundException;

    List<Product> getByCategory(String category) throws ProductNotFoundException;

    // U
    Product updateProduct(Product product) throws ProductNotFoundException;

    // D
    void deleteProduct(int id) throws ProductNotFoundException;
}
