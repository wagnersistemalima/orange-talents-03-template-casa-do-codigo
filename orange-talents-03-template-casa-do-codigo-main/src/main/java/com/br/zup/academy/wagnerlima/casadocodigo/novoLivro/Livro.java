package com.br.zup.academy.wagnerlima.casadocodigo.novoLivro;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.br.zup.academy.wagnerlima.casadocodigo.novaCategoria.Categoria;
import com.br.zup.academy.wagnerlima.casadocodigo.novoAutor.Autor;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

// Entidade


@Entity
@Table(name = "tb_livro")
public class Livro implements Serializable{
	
	private static final long serialVersionUID = 1L;

	// atributos basicos
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(unique = true)
	private String titulo;
	
	@NotBlank
	@Size(max = 500)
	private String resumo;
	
	@NotBlank
	private String sumario;
	
	@NotNull
	@Min(20)
	private BigDecimal price;
	
	
	@Min(100)
	@NotNull
	private int quantPagina;
	
	@NotBlank
	@Column(unique = true)
	private String isbn;
	
	@Future
	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate dataPublicacao;
	
	// associaçoes
	
	@NotNull
	@ManyToOne
	private Categoria categoria;
	
	@NotNull
	@ManyToOne
	private Autor autor;;
	
	@Deprecated
	public Livro() {
		
	}
	
	
	@JsonCreator
	public Livro(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, @NotBlank String sumario,
			@NotNull @Min(20) BigDecimal price, @Min(100) @NotNull int quantPagina, @NotBlank String isbn,
			@Future @NotNull LocalDate dataPublicacao, @NotNull @Valid Categoria categoria, @NotNull @Valid Autor autor) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.price = price;
		this.quantPagina = quantPagina;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.categoria = categoria;
		this.autor = autor;
	}



	public Long getId() {
		return id;
	}

	

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public int getQuantPagina() {
		return quantPagina;
	}

	public String getIsbn() {
		return isbn;
	}


	public Categoria getCategoria() {
		return categoria;
	}

	public Autor getAutor() {
		return autor;
	}
	

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
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
		Livro other = (Livro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


}
