package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public ResponseEntity<Product> createProduct(Product product){
		try {
			Product newProduct = this.productRepository.save(product);
			return ResponseEntity.ok().body(newProduct);
		}
		catch(Exception error) {
			return ResponseEntity.unprocessableEntity().body(product);
		}
	}
	
	public ResponseEntity<List<Product>> findAllProducts(){
		try {
			List<Product> products = this.productRepository.findAll();
			return ResponseEntity.ok().body(products);
		}
		catch(Exception error) {
			return ResponseEntity.noContent().build();
		}
	}
	
}
