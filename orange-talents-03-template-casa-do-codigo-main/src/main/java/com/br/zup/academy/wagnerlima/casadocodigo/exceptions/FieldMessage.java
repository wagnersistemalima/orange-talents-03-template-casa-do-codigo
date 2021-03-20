package com.br.zup.academy.wagnerlima.casadocodigo.exceptions;

import java.io.Serializable;

public class FieldMessage implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String fieldName;            
	private String message;
	
	
	@Deprecated
	public FieldMessage() {
		
	}


	public FieldMessage(String fieldName, String message) {
		this.fieldName = fieldName;
		this.message = message;
	}


	public String getFieldName() {
		return fieldName;
	}


	public String getMessage() {
		return message;
	}
	
	

}
