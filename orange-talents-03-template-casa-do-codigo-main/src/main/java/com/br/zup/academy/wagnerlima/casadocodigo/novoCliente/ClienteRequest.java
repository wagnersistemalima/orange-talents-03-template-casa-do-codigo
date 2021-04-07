package com.br.zup.academy.wagnerlima.casadocodigo.novoCliente;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import com.br.zup.academy.wagnerlima.casadocodigo.novoEstado.Estado;
import com.br.zup.academy.wagnerlima.casadocodigo.novoPais.Pais;
import com.br.zup.academy.wagnerlima.casadocodigo.validation.CpfOuCnpj;
import com.br.zup.academy.wagnerlima.casadocodigo.validation.ExistsId;
import com.br.zup.academy.wagnerlima.casadocodigo.validation.UniqueValue;
import com.fasterxml.jackson.annotation.JsonCreator;

// Objeto para trafegar dados entre a requisição e a aplicação


public class ClienteRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	
	// atributos basicos
	
	@NotBlank
	@Email
	@UniqueValue(domainClass = Cliente.class, fieldName = "email")
	private String email;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String sobreNome;
	
	
	@UniqueValue(domainClass = Cliente.class, fieldName = "documento")
	@NotBlank
	@CpfOuCnpj(domainClass = Cliente.class, fieldName = "documento")
	private String documento;                            // cpf ou cnpj
	
	@NotBlank
	private String endereco;
	
	@NotBlank
	private String complemento;
	
	@NotBlank
	private String cidade;
	
	@NotNull
	@ExistsId(domainClass = Pais.class, fieldName = "id")
	private Long idPais;
	
	@NotNull
	@ExistsId(domainClass = Estado.class, fieldName = "id")
	private Long idEstado;
	
	@NotBlank
	private String telefone;
	
	@NotBlank
	private String cep;
	
	// construtor com argumentos
	
	@Deprecated
	public ClienteRequest() {
		
	}

	@JsonCreator
	public ClienteRequest(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobreNome,
			@CPF @CNPJ @NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotBlank Long idPais, @NotBlank Long idEstado, @NotBlank String telefone,
			@NotBlank String cep) {
		this.email = email.toLowerCase();
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.idPais = idPais;
		this.idEstado = idEstado;
		this.telefone = telefone;
		this.cep = cep;
	}

	public String getEmail() {
		return email.toLowerCase();
	}


	public String getNome() {
		return nome;
	}
	
	public String getSobreNome() {
		return sobreNome;
	}


	public String getDocumento() {
		return documento;
	}


	public String getEndereco() {
		return endereco;
	}


	public String getComplemento() {
		return complemento;
	}
	

	public String getCidade() {
		return cidade;
	}

	public Long getIdPais() {
		return idPais;
	}


	public Long getIdEstado() {
		return idEstado;
	}


	public String getTelefone() {
		return telefone;
	}


	public String getCep() {
		return cep;
	}
	
	// metodo com a logica de validação convertendo a request para entidade

	public Cliente toModel(EntityManager manager) {
		
		@NotNull Pais pais = manager.find(Pais.class, idPais);
		@NotNull Estado estado = manager.find(Estado.class, idEstado);
		
		return new Cliente(email, nome, sobreNome, documento, endereco, complemento, cidade, telefone, cep, pais, estado);
	}
	
}
