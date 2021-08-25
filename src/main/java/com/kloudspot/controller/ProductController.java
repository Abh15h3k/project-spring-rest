package com.kloudspot.controller;

import java.util.List;

import com.kloudspot.models.Product;
import com.kloudspot.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product-api")
public class ProductController {

    @Autowired private ProductService productService;

    @GetMapping("")
    public ResponseEntity<String> productHome() {
        return ResponseEntity.ok("Welcome to product-apit.");
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAll();

        return ResponseEntity.ok(products);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") int id) {
        Product product = productService.getById(id);

        return ResponseEntity.ok(product);
    }

    @GetMapping("/products/name/{name}")
    public ResponseEntity<List<Product>> getProductByName(@PathVariable("name") String name) {
        List<Product> products = productService.getByName(name);

        return ResponseEntity.ok(products);
    }

    @GetMapping("/products/price-less-than/{price}")
    public ResponseEntity<List<Product>> getProductByPriceLessThan(
            @PathVariable("price") double price) {
        List<Product> products = productService.getByPriceLessThan(price);

        return ResponseEntity.ok(products);
    }

    @GetMapping("/products/price-greater-than/{price}")
    public ResponseEntity<List<Product>> getProductByPriceGreaterThan(
            @PathVariable("price") double price) {
        List<Product> products = productService.getByPriceGreaterThan(price);

        return ResponseEntity.ok(products);
    }

    @GetMapping("/products/age-less-than/{age}")
    public ResponseEntity<List<Product>> getProductByAgeLessThan(@PathVariable("age") int age) {
        List<Product> products = productService.getByAgeLessThan(age);

        return ResponseEntity.ok(products);
    }

    @GetMapping("/products/category/{category}")
    public ResponseEntity<List<Product>> getProductByCategory(@PathVariable("category") String category) {
        List<Product> products = productService.getByCategory(category);

        return ResponseEntity.ok(products);
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createNewProduct(@RequestBody Product product) {
        Product createdProduct = productService.addProduct(product);

        return ResponseEntity.ok(createdProduct);
    }

    @PutMapping("/products")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(product);

        return ResponseEntity.ok(updatedProduct);
    }
}