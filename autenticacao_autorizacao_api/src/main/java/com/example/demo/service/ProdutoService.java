package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.model.Produto;
import com.example.demo.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	public ResponseEntity<Produto> cadastrarProduto(Produto produto){
		try {
			Produto novoProduto = this.produtoRepository.save(produto);
			return ResponseEntity.ok().body(novoProduto);
		}
		catch(Exception error) {
			return ResponseEntity.unprocessableEntity().body(produto);
		}
	}
	
	public ResponseEntity<List<Produto>> listarProdutos(){
		try {
			List<Produto> produtos = this.produtoRepository.findAll();
			return ResponseEntity.ok().body(produtos);
		}
		catch(Exception error) {
			return ResponseEntity.noContent().build();
		}
	}
	
}
