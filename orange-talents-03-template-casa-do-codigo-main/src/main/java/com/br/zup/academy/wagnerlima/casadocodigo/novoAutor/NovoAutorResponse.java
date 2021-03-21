package com.br.zup.academy.wagnerlima.casadocodigo.novoAutor;

import java.io.Serializable;

// Objeto para responder a requisição de cadastrar um autor

public class NovoAutorResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String nome;
	
	private String email;
	
	private String descricao;
	

	public NovoAutorResponse(Autor entity) {
		this.nome = entity.getNome();
		this.email = entity.getEmail();
		this.descricao = entity.getDescricao();
	}


	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

}
