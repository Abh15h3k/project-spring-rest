package com.kloudspot.controller;

import java.util.List;

import com.kloudspot.models.Product;
import com.kloudspot.service.ProductService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product-api")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    private static Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired private ProductService productService;

    @GetMapping("")
    public ResponseEntity<String> productHome() {
        LOGGER.info("In access test endpoint.");
        return ResponseEntity.ok("Welcome to product-api.");
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

    @DeleteMapping("/products/{id]")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") int id) {
        productService.deleteProduct(id);

        return ResponseEntity.ok("Ok");
    }
}