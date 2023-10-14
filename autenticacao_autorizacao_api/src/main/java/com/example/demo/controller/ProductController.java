package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.model.dto.ProductUpdateDTO;
import com.example.demo.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@SuppressWarnings("rawtypes")
@RequestMapping("/products")
@CrossOrigin
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Operation(
			summary = "Cria um novo produto",
			tags = {"Product"}
	)
	@PostMapping
	public ResponseEntity createProduct(@RequestBody Product product){
		return productService.createProduct(product);
	}
	
	@Operation(
			summary = "Busca por todos os produtos",
			tags = {"Product"}
	)
	@GetMapping
	public ResponseEntity findAllProducts(){
		return productService.findAllProducts();
	}
	
	@Operation(
			summary = "Busca um produto por ID",
			tags = {"Product"}
	)
	@GetMapping("/{id}")
	public ResponseEntity findProductById(@PathVariable Long id) {
		return productService.findProductById(id);
	}
	
	@Operation(
			summary = "Atualiza um produto",
			tags = {"Product"}
	)
	@PutMapping
	public ResponseEntity updateProduct(@RequestBody ProductUpdateDTO product) {
		return productService.updateProduct(product);
	}
	
	@Operation(
			summary = "Excluí um produto",
			tags = {"Product"}
	)
	@DeleteMapping("/{id}")
	public ResponseEntity deleteProduct(@PathVariable Long id) {
		return productService.deleteProductById(id);
	}
	
}
