package com.br.zup.academy.wagnerlima.casadocodigo.novoCliente;

import java.io.Serializable;

// objeto para trafegar dados de resposta da aplicação para o cliente


public class ClienteResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String email;
	
	
	public ClienteResponse(Cliente entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.email = entity.getEmail();
	}


	public Long getId() {
		return id;
	}


	public String getNome() {
		return nome;
	}


	public String getEmail() {
		return email;
	}
	
	

}
