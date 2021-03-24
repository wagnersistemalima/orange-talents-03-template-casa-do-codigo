package com.br.zup.academy.wagnerlima.casadocodigo.novoPais;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;

// objeto para trafegar dados de resposta customizado para o cliente

public class PaisResponse implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	// atributo basico
	
	private Long id;
	private String nome;
	
	// construtor personalizado
	
	@JsonCreator
	public PaisResponse(Pais entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	

}
