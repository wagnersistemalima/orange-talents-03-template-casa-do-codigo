package com.br.zup.academy.wagnerlima.casadocodigo.novaCategoria;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Controlador Rest, responsavel por receber as requisiçoes do cliente e responder

@RestController
@RequestMapping(value = "/categorias")
public class CategoriasController {
	
	// injeção de dependencia para o repository
	
	@Autowired
	CategoriaRepository repository;
	
	// 1º end point / inserir uma categoria / post
	
	@PostMapping
	@Transactional
	public ResponseEntity<NovaCategoriaResponse> insert(@Valid @RequestBody NovaCategoriaRequest request) {
		Categoria entity = new Categoria(request.getNome());
		entity = repository.save(entity);
		return ResponseEntity.ok().body(new NovaCategoriaResponse(entity));
	}

}
