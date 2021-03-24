package com.br.zup.academy.wagnerlima.casadocodigo.novoEstado;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.br.zup.academy.wagnerlima.casadocodigo.novoPais.Pais;
import com.br.zup.academy.wagnerlima.casadocodigo.validation.ExistsId;
import com.br.zup.academy.wagnerlima.casadocodigo.validation.UniqueValue;
import com.fasterxml.jackson.annotation.JsonCreator;

// objeto para trafegar dados entre cliente e aplicação

public class EstadoRequest implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	// atributos basicos
	
	@NotBlank
	@UniqueValue(domainClass = Estado.class, fieldName = "nome")
	private String nome;
	
	@ExistsId(domainClass = Pais.class, fieldName = "id")
	@NotNull
	private Long idPais;
	
	
	@JsonCreator
	public EstadoRequest(@NotBlank String nome, Long idPais) {
		this.nome = nome;
		this.idPais = idPais;
	}

	public String getNome() {
		return nome;
	}

	public Long getId() {
		return idPais;
	}
	
	// metodo para verificar se existe o pais em qual o cliente quer cadastrar o estado

	public Estado toModel(EntityManager manager) {
		@NotNull(message = "Você está tentando cadastrar um estado que já existe a este pais") Pais pais = manager.find(Pais.class, idPais);
		
		return new Estado(nome, pais);
	}

}
