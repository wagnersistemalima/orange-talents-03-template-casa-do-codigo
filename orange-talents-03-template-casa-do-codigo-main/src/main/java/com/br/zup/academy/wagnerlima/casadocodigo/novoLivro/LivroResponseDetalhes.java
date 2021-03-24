package com.br.zup.academy.wagnerlima.casadocodigo.novoLivro;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonCreator;

public class LivroResponseDetalhes implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String titulo;
	private String resumo;
	private String sumario;
	private BigDecimal price;
	private int quantPagina;
	private String isbn;
	private Instant dataPublicacao;
	private String nomeCategiria;
	private String nomeAutor;
	
	@JsonCreator
	public LivroResponseDetalhes(Livro entity) {
		this.id = entity.getId();
		this.titulo = entity.getTitulo();
		this.resumo = entity.getResumo();
		this.sumario = entity.getSumario();
		this.price = entity.getPrice();
		this.quantPagina = entity.getQuantPagina();
		this.isbn = entity.getIsbn();
		this.dataPublicacao = entity.getDataPublicacao();
		this.nomeCategiria = entity.getCategoria().getNome();
		this.nomeAutor = entity.getAutor().getNome();
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

	public Instant getDataPublicacao() {
		return dataPublicacao;
	}

	public String getNomeCategiria() {
		return nomeCategiria;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}
	
	

}
