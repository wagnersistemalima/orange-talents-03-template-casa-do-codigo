package com.br.zup.academy.wagnerlima.casadocodigo.novoEstado;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.br.zup.academy.wagnerlima.casadocodigo.novoPais.Pais;

// entidade

@Entity
@Table(name = "tb_estado")
public class Estado implements Serializable{

	private static final long serialVersionUID = 1L;
	
	// atributos basicos
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(unique = true)
	private String nome;
	
	// associação
	
	@ManyToOne
	private Pais pais;
	
	@Deprecated
	public Estado() {
		
	}
	
	// construtor

	public Estado(@NotBlank String nome, Pais pais) {
		this.nome = nome;
		this.pais = pais;
	}
	
	// getters

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Pais getPais() {
		return pais;
	}
	
	// hashCode & equals

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
		Estado other = (Estado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
