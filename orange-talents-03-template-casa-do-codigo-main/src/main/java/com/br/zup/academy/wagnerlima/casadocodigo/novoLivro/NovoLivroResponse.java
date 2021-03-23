package com.br.zup.academy.wagnerlima.casadocodigo.novoLivro;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;

// Objeto para carregar dados da aplicação para o cliente

public class NovoLivroResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private long id;
	private String titulo;
	
	@JsonCreator
	public NovoLivroResponse(Livro entity) {
		this.id = entity.getId();
		this.titulo = entity.getTitulo();
	}


	public long getId() {
		return id;
	}


	public String getTitulo() {
		return titulo;
	}

}
