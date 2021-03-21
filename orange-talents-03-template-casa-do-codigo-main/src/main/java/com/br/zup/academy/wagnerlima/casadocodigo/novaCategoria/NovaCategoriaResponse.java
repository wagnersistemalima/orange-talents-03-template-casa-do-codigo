package com.br.zup.academy.wagnerlima.casadocodigo.novaCategoria;

import java.io.Serializable;

//Objeto para responder a requisição de cadastrar ua categoria

public class NovaCategoriaResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String nome;

	public NovaCategoriaResponse(Categoria entity) {
		this.nome = entity.getNome();
	}

	public String getNome() {
		return nome;
	}
	
	

}
