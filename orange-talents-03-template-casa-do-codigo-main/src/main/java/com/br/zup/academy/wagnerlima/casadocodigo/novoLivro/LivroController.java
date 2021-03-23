package com.br.zup.academy.wagnerlima.casadocodigo.novoLivro;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/livros")
public class LivroController {
	
	// injeção de dependencia para o repository autor
	
	@PersistenceContext
	EntityManager manager;
	
	
	// 1º endPoint / inserir livro / insert post
	
	@Transactional
	@PostMapping
	public ResponseEntity<NovoLivroResponse> insert(@Valid @RequestBody NovoLivroRequest request) {
		Livro entity = request.toModel(manager);
		manager.persist(entity);
		return ResponseEntity.ok().body(new NovoLivroResponse(entity));
	}
	
}