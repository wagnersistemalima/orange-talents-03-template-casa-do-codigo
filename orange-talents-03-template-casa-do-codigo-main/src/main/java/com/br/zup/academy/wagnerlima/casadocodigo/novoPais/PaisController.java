package com.br.zup.academy.wagnerlima.casadocodigo.novoPais;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

// controlador Rest

@RestController
@RequestMapping(value = "/pais")
public class PaisController {
	
	// injeção de dependencia para repository
	
	@Autowired
	private PaisRepository repository;
	
	// 1º end point / insert / post / resposta 201 create
	
	
	@Transactional
	@PostMapping
	public ResponseEntity<PaisResponse> insert(@Valid @RequestBody PaisRequest request) {
		Pais entity = new Pais(request.getNome());
		entity = repository.save(entity);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entity.getId()).toUri();
		return ResponseEntity.created(uri).body(new PaisResponse(entity));
	}

}
