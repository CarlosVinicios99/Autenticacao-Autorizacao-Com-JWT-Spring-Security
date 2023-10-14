package com.example.demo.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.model.dto.ProductUpdateDTO;
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
			logger.log(Level.INFO, "Buscando todos os produtos");
			List<Product> products = this.productRepository.findAll();
			return ResponseEntity.ok().body(products);
		}
		catch(Exception error) {
			logger.log(Level.SEVERE, "Erro ao buscar todos os produtos");
			return ResponseEntity.badRequest().build();
		}
	}
	
	public ResponseEntity findProductById(Long id){
		try {
			logger.log(Level.INFO, "Buscando produto com ID: " + id);
			Product searchedProduct = this.productRepository.findById(id).get();
			if(searchedProduct != null) {
				return ResponseEntity.ok().body(searchedProduct);
			}
			throw new Error();
		}
		catch(Exception error) {
			logger.log(Level.SEVERE, "Erro ao buscar produto", error.getMessage());
			return ResponseEntity.noContent().build();
		}
	}
	
	public ResponseEntity updateProduct(ProductUpdateDTO product) {
		try {
			logger.log(Level.INFO, "Atualizando produto com ID: " + product.id());
			Product searchedProduct = this.productRepository.findById(product.id()).get();
			if(searchedProduct != null) {
				if(product.name() != null) {
					searchedProduct.setName(product.name());
				}
				if(product.price() != null) {
					searchedProduct.setPrice(product.price());
				}
			}
			throw new Error();
		}
		catch(Exception error) {
			logger.log(Level.SEVERE, "Erro ao atualizar produto", error.getMessage());
			return ResponseEntity.noContent().build();
		}
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
