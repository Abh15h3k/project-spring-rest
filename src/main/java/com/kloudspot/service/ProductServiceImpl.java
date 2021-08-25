package com.kloudspot.service;

import java.util.List;

import com.kloudspot.exception.ProductNotFoundException;
import com.kloudspot.models.Product;
import com.kloudspot.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired private ProductRepository productRepository;

	@Override
	public List<Product> getAll() {
        return productRepository.findAll();
	}

	@Override
	public Product getById(int id) throws ProductNotFoundException {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product with id " + id + " not Found"));
	}

	@Override
	public List<Product> getByName(String name) throws ProductNotFoundException {
        List<Product> products = productRepository.findByName(name);

        if (products.isEmpty()) {
            throw new ProductNotFoundException("Product with name " + name + " not found");
        }

        return products;
	}

	@Override
	public List<Product> getByPriceLessThan(double price) throws ProductNotFoundException {
        List<Product> products = productRepository.findByPriceLessThan(price);

        if (products.isEmpty()) {
            throw new ProductNotFoundException("Product with price less than " + price + " not found");
        }

        return products;
	}

	@Override
	public List<Product> getByPriceGreaterThan(double price) throws ProductNotFoundException {
        List<Product> products = productRepository.findByPriceGreaterThan(price);

        if (products.isEmpty()) {
            throw new ProductNotFoundException("Product with price greater than " + price + " not found");
        }

        return products;
	}

	@Override
	public List<Product> getByAgeLessThan(int age) throws ProductNotFoundException {
        List<Product> products = productRepository.findByAgeInMonthsLessThan(age);

        if (products.isEmpty()) {
            throw new ProductNotFoundException("Product with age less than " + age + " not found");
        }

        return products;
	}

	@Override
	public Product addProduct(Product product) {
        Product addedProduct = productRepository.insert(product);
        return addedProduct;
	}

	@Override
	public Product updateProduct(Product product) throws ProductNotFoundException {
        productRepository.findById(product.getId()).orElseThrow(() -> new ProductNotFoundException("Product with id " + product.getId() + " not found."));

        Product updatedProduct = productRepository.save(product);
        return updatedProduct;
	}

	@Override
	public void deleteProduct(int id) throws ProductNotFoundException {
        productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product with id " + id + " not found."));
        productRepository.deleteById(id);
	}

	@Override
	public List<Product> getByCategory(String category) throws ProductNotFoundException {
        List<Product> products = productRepository.findByCategory(category);

        if (products.isEmpty()) {
            throw new ProductNotFoundException("Product with category " + category + " not found");
        }

        return products;
	}
}
