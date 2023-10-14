package com.example.demo.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@Service
@SuppressWarnings("rawtypes")
public class ProductService {
	
	private Logger logger = Logger.getLogger(ProductService.class.getName());
	
	@Autowired
	ProductRepository productRepository;
	
	public ResponseEntity createProduct(Product product){
		try {
			logger.log(Level.INFO, "Criando um novo produto");
			Product newProduct = this.productRepository.save(product);
			return ResponseEntity.ok().body(newProduct);
		}
		catch(Exception error) {
			logger.log(Level.SEVERE, "Erro ao criar novo produto", error.getMessage());
			return ResponseEntity.unprocessableEntity().body(product);
		}
	}
	
	public ResponseEntity findAllProducts(){
		try {
			List<Product> products = this.productRepository.findAll();
			return ResponseEntity.ok().body(products);
		}
		catch(Exception error) {
			return ResponseEntity.noContent().build();
		}
	}
	
	public ResponseEntity findProductById(Long id){
		try {
			Product searchedProduct = productRepository.findById(id).get();
			if(searchedProduct != null) {
				return ResponseEntity.ok().body(searchedProduct);
			}
			throw new Error();
		}
		catch(Exception error) {
			return ResponseEntity.noContent().build();
		}
	}
	
	public ResponseEntity updateProduct() {
		
	}
	
	public ResponseEntity deleteProductById(Long id) {
		try {
			logger.log(Level.INFO, "Excluindo produto com ID: " + id);
			Product deletedProduct = this.productRepository.findById(id).get();
			productRepository.delete(deletedProduct);
			return ResponseEntity.ok().build();
		}
		catch(Exception error) {
			logger.log(Level.SEVERE, "Erro ao excluir produto", error.getMessage());
			return ResponseEntity.noContent().build();
		}
	}
	
}
