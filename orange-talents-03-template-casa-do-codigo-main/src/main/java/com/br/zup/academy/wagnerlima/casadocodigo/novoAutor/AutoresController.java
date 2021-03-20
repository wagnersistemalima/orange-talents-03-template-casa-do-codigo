package com.br.zup.academy.wagnerlima.casadocodigo.novoAutor;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Controlador Rest, responsavel por receber as requisiçoes do cliente e responder

@RestController
@RequestMapping(value = "/autores")
public class AutoresController {
	
	
	@Autowired
	AutorRepository repository;
	
	
	// 1º end point / inserir um autor / insert / post
	
	@PostMapping
	@Transactional
	public ResponseEntity<NovoAutorResponse> insert(@Valid @RequestBody NovoAutorRequest request) {
		Autor entity = new Autor(request.getNome(), request.getEmail(), request.getDescricao());
		entity = repository.save(entity);
		return ResponseEntity.ok().body(new NovoAutorResponse(entity));
	}

}