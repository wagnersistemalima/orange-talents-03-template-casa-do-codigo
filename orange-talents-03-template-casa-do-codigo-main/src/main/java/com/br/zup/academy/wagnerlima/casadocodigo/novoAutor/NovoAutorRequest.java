package com.br.zup.academy.wagnerlima.casadocodigo.novoAutor;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.br.zup.academy.wagnerlima.casadocodigo.validation.UniqueValue;
import com.fasterxml.jackson.annotation.JsonCreator;


// Objeto para trafegar dados entre cliente e aplicação

public class NovoAutorRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@NotBlank(message = "Campo obrigatório")
	private String nome;
	
	@NotBlank(message = "Campo obrigatório")
	@Email(message = "Favor entrar com um email válido")
	@UniqueValue(domainClass = Autor.class, fieldName = "email")
	private String email;
	
	@NotBlank(message = "Campo obrigatório")
	@Size(max = 400, message = "Maximo de 400 caracter")
	private String descricao;
	
	@JsonCreator
	public NovoAutorRequest(@NotBlank(message = "Campo obrigatório") String nome,
			@NotBlank(message = "Campo obrigatório") @Email(message = "Favor entrar com um email válido") String email,
			@NotBlank(message = "Campo obrigatório") @Size(max = 400, message = "Maximo de 400 caracter") String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
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
	
	// metodo para receber os dados da requisição e converter para entidade

	public Autor toModel(EntityManager manager) {
		
		return new Autor(nome, email, descricao);
	}
	
}
