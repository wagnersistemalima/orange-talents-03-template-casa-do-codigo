package com.br.zup.academy.wagnerlima.casadocodigo.novoEstado;

import java.net.URI;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

// Controlador Rest


@RestController
@RequestMapping(value = "/estados")
public class EstadoController {
	
	@PersistenceContext
	EntityManager manager;
	
	// 1º end point / insert / resposta 201 create
	
	@Transactional
	@PostMapping
	public ResponseEntity<EstadoResponse> insert(@Valid @RequestBody EstadoRequest request) {
		Estado entity = request.toModel(manager);
		manager.persist(entity);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entity.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new EstadoResponse(entity));
	}

}
