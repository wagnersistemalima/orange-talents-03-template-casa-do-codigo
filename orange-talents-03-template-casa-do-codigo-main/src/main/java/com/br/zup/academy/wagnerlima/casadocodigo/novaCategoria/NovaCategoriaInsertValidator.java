package com.br.zup.academy.wagnerlima.casadocodigo.novaCategoria;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.br.zup.academy.wagnerlima.casadocodigo.exceptions.FieldMessage;

public class NovaCategoriaInsertValidator implements ConstraintValidator<NovaCategoriaInsertValid, NovaCategoriaRequest>{
	
	
	// injeção de dependencia para o repository
	
	@Autowired
	CategoriaRepositoryProcuraNome repository;
	
	
	@Override
	public void initialize(NovaCategoriaInsertValid ann) {
	}

	@Override
	public boolean isValid(NovaCategoriaRequest request, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		
		// Coloque aqui seus testes de validação, acrescentando objetos FieldMessage à lista
		
		Categoria categoria = repository.findByNome(request.getNome());
		
		
		if (categoria != null) {
			list.add(new FieldMessage("nome", "Esta nome já existe em uma categoria"));
		}
		
		
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
