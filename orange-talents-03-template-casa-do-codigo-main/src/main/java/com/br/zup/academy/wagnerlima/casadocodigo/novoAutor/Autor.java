package com.br.zup.academy.wagnerlima.casadocodigo.novoAutor;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

// Entidade

@Entity
@Table(name = "tb_autor")
public class Autor implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String nome;
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	@Size(max = 400)
	private String descricao;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant dataRegistro;
	
	@Deprecated
	public Autor() {
	}

	public Autor(@NotBlank String nome, @NotBlank @Email String email,
			@NotBlank @Size(max = 400) String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}


	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public Instant getDataRegistro() {
		return dataRegistro;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autor other = (Autor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	// metodo  auxiliar para sempre que for salvar um autor, ele armazenar na dataRegistro o instante atual

	@PrePersist
	public void prePersist() {
		dataRegistro = Instant.now();
	}

}
