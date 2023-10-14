package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.model.dto.ProductUpdateDTO;
import com.example.demo.service.ProductService;

@RestController
@SuppressWarnings("rawtypes")
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping
	public ResponseEntity createProduct(@RequestBody Product product){
		return productService.createProduct(product);
	}
	
	@GetMapping
	public ResponseEntity findAllProducts(){
		return productService.findAllProducts();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity findProductById(@PathVariable Long id) {
		return productService.findProductById(id);
	}
	
	public ResponseEntity updateProduct(@RequestBody ProductUpdateDTO product) {
		return productService.updateProduct(product);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity deleteProduct(@PathVariable Long id) {
		return productService.deleteProductById(id);
	}
	
}
