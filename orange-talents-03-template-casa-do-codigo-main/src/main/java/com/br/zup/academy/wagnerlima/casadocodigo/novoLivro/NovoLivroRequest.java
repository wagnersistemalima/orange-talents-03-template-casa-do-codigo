package com.br.zup.academy.wagnerlima.casadocodigo.novoLivro;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.util.Assert;

import com.br.zup.academy.wagnerlima.casadocodigo.novaCategoria.Categoria;
import com.br.zup.academy.wagnerlima.casadocodigo.novoAutor.Autor;
import com.br.zup.academy.wagnerlima.casadocodigo.validation.ExistsId;
import com.br.zup.academy.wagnerlima.casadocodigo.validation.UniqueValue;
import com.fasterxml.jackson.annotation.JsonCreator;

//objeto simples para carregar dados do cliente para aplicação

public class NovoLivroRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	
	// atributos basicos
	
	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "titulo") 
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
	
	@UniqueValue(domainClass = Livro.class, fieldName = "isbn")
	@NotBlank
	private String isbn;
	
	@Future
	@NotNull
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant dataPublicacao;
	
	// associaçoes
	
	@ExistsId(domainClass = Categoria.class, fieldName = "id")
	@NotNull
	private Long idCategoria;
	
	@ExistsId(domainClass = Autor.class, fieldName = "id")
	@NotNull
	private Long idAutor;
	
	@JsonCreator
	public NovoLivroRequest(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, @NotBlank String sumario,
			@NotNull @Min(20) BigDecimal price, @Min(100) @NotNull int quantPagina, @NotBlank String isbn,
			@NotNull @Future Instant dataPublicacao, @NotNull Long idCategoria, @NotNull Long idAutor) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.price = price;
		this.quantPagina = quantPagina;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.idCategoria = idCategoria;
		this.idAutor = idAutor;
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

	public Instant getDataPublicacao() {
		return dataPublicacao;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public Long getIdAutor() {
		return idAutor;
	}
	
	// metodo com a logica de validação 1º endPoint

	public Livro toModel(EntityManager manager) {
		
		Categoria categoria = manager.find(Categoria.class, idCategoria);
		Autor autor = manager.find(Autor.class, idAutor);
		
		Assert.state(categoria != null, "você está tentando cadastrar uma livro para um categoria que não existe!" + idCategoria);
		Assert.state(autor != null, "Você está tentando cadastrar um livro para um autor que não existe" + idAutor);

		return new Livro(titulo, resumo, sumario, price, quantPagina, isbn, dataPublicacao, categoria, autor);
	}

	

	
}
