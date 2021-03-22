package com.br.zup.academy.wagnerlima.casadocodigo.novaCategoria;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.br.zup.academy.wagnerlima.casadocodigo.validation.UniqueValue;
import com.fasterxml.jackson.annotation.JsonCreator;

// objeto simples para carregar dados do cliente para aplicação

public class NovaCategoriaRequest implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "Campo obrigatório")
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome")
	private String nome;
	
	
	@JsonCreator
	public NovaCategoriaRequest(@NotBlank(message = "Campo obrigatório") String nome) {
		this.nome = nome;
	}



	public String getNome() {
		return nome;
	}	

}
