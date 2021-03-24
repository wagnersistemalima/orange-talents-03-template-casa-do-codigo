package com.br.zup.academy.wagnerlima.casadocodigo.novoEstado;

import java.io.Serializable;

// objeto para trafegar dados de resposta para o cliente

public class EstadoResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	// atributos basicos
	
	private Long id;
	private String nome;
	
	// construtor personalizado
	
	public EstadoResponse(Estado entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
	}
	
	// getters

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	

}
