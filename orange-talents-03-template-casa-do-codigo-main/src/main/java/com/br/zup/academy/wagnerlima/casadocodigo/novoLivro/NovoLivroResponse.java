package com.br.zup.academy.wagnerlima.casadocodigo.novoLivro;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonCreator;

// Objeto para carregar dados da aplicação para o cliente

public class NovoLivroResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String titulo;
	private String resumo;
	private String sumario;
	private BigDecimal price;
	private int quantPagina;
	private String isbn;
	private LocalDate dataPublicacao;
	private Long idCategoria;
	private Long idAutor;
	
	@JsonCreator
	public NovoLivroResponse(Livro entity) {
		this.titulo = entity.getTitulo();
		this.resumo = entity.getResumo();
		this.sumario = entity.getSumario();
		this.price = entity.getPrice();
		this.quantPagina = entity.getQuantPagina();
		this.isbn = entity.getIsbn();
		this.dataPublicacao = entity.getDataPublicacao();
		this.idCategoria = entity.getCategoria().getId();
		this.idAutor = entity.getAutor().getId();
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


	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}


	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}


	public Long getIdCategoria() {
		return idCategoria;
	}


	public Long getIdAutor() {
		return idAutor;
	}
	
	

}
