package com.br.zup.academy.wagnerlima.casadocodigo.novoCliente;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Controlador Rest

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {
	
	@PersistenceContext
	private EntityManager manager;
	
	// 1º end point / insert cliente / resposta 200 ok
	
	@Transactional
	@PostMapping
	public ResponseEntity<ClienteResponse> insert (@Valid @RequestBody ClienteRequest request) {
		
		Cliente entity = request.toModel(manager);
		manager.persist(entity);
		
		return ResponseEntity.ok().body(new ClienteResponse(entity));
		
	}

}
