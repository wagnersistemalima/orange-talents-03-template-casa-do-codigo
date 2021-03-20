package com.br.zup.academy.wagnerlima.casadocodigo.exceptions;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Instant timestamp;
	private Integer status;
	private String error;
	private String message;
	private String path;
	
	
	private List<FieldMessage> errors = new ArrayList<>();
	

	public ValidationError(Instant timestamp, Integer status, String error, String message, String path) {
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}
	
	

	public Instant getTimestamp() {
		return timestamp;
	}



	public Integer getStatus() {
		return status;
	}



	public String getError() {
		return error;
	}



	public String getMessage() {
		return message;
	}



	public String getPath() {
		return path;
	}



	public List<FieldMessage> getErrors() {
		return errors;
	}
	
	// metodo para adicionar erros na lista de erros
	
	public void addErro(String fieldName, String message) {
		errors.add(new FieldMessage(fieldName, message));
	}

}
