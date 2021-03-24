package com.br.zup.academy.wagnerlima.casadocodigo.novoPais;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.br.zup.academy.wagnerlima.casadocodigo.validation.UniqueValue;
import com.fasterxml.jackson.annotation.JsonCreator;

// objeto para trafegar dados da requisição para a aplicação

public class PaisRequest implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	// atributos basicos
	
	@NotBlank
	@UniqueValue(domainClass = Pais.class, fieldName = "nome")
	private String nome;
	
	@JsonCreator
	public PaisRequest(@NotBlank String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	
	
	

}
