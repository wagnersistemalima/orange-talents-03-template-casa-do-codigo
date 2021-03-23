package com.br.zup.academy.wagnerlima.casadocodigo.novaCategoria;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Controlador Rest, responsavel por receber as requisiçoes do cliente e responder

@RestController
@RequestMapping(value = "/categorias")
public class CategoriasController {
	
	@PersistenceContext
	EntityManager manager;
	
	// 1º end point / inserir uma categoria / post
	
	@PostMapping
	@Transactional
	public ResponseEntity<NovaCategoriaResponse> insert(@Valid @RequestBody NovaCategoriaRequest request) {
		Categoria entity = request.toModel(manager);
		manager.persist(entity);
		return ResponseEntity.ok().body(new NovaCategoriaResponse(entity));
	}

}
