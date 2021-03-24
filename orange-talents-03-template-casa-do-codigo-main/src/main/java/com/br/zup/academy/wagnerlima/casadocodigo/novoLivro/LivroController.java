package com.br.zup.academy.wagnerlima.casadocodigo.novoLivro;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.br.zup.academy.wagnerlima.casadocodigo.exceptions.ResourceNotFoundException;

@RestController
@RequestMapping(value = "/livros")
public class LivroController {

	// injeção de dependencia para o repository

	@Autowired
	private LivroRepository repository;

	@PersistenceContext
	private EntityManager manager;

	// 1º endPoint / inserir livro / insert post / resposta 201 create

	@Transactional
	@PostMapping
	public ResponseEntity<NovoLivroResponse> insert(@Valid @RequestBody NovoLivroRequest request) {
		Livro entity = request.toModel(manager);
		manager.persist(entity);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(entity.getId()).toUri();
		return ResponseEntity.created(uri).body(new NovoLivroResponse(entity));
	}

	// 2º end point / buscar todos livros  / resposta 200 ok

	@Transactional(readOnly = true)
	@GetMapping
	public ResponseEntity<List<NovoLivroResponse>> findAll() {
		List<Livro> list = repository.findAll();
		return ResponseEntity.ok().body(list.stream().map(x -> new NovoLivroResponse(x)).collect(Collectors.toList()));
	}

	// 3º end point / buscar um livro por id  /  resposta 200 ok

	@Transactional(readOnly = true)
	@GetMapping(value = "/{id}")
	public ResponseEntity<LivroResponseDetalhes> findById(@PathVariable Long id) {
		Livro entity = Optional.ofNullable(manager.find(Livro.class, id))
				.orElseThrow(() -> new ResourceNotFoundException("Id do livro não existe no cadastro"));
		return ResponseEntity.ok().body(new LivroResponseDetalhes(entity));
	}

}
