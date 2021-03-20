package com.br.zup.academy.wagnerlima.casadocodigo.novoAutor;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.br.zup.academy.wagnerlima.casadocodigo.validation.NovoAutorValid;

// Objeto para trafegar dados entre cliente e aplicação

@NovoAutorValid
public class NovoAutorRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "Campo obrigatório")
	private String nome;
	
	@NotBlank(message = "Campo obrigatório")
	@Email(message = "Favor entrar com um email válido")
	private String email;
	
	@NotBlank(message = "Campo obrigatório")
	@Size(max = 400, message = "Maximo de 400 caracter")
	private String descricao;

	public NovoAutorRequest(@NotBlank String nome, @NotBlank @Email String email,
			@NotBlank @Size(max = 400) String descricao) {
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

}
