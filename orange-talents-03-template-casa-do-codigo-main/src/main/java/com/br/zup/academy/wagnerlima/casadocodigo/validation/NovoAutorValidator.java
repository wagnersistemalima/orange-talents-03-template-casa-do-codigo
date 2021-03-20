package com.br.zup.academy.wagnerlima.casadocodigo.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.br.zup.academy.wagnerlima.casadocodigo.exceptions.FieldMessage;
import com.br.zup.academy.wagnerlima.casadocodigo.novoAutor.Autor;
import com.br.zup.academy.wagnerlima.casadocodigo.novoAutor.AutorRepositoryProcuraEmail;
import com.br.zup.academy.wagnerlima.casadocodigo.novoAutor.NovoAutorRequest;

public class NovoAutorValidator implements ConstraintValidator<NovoAutorValid, NovoAutorRequest> {


	// injeção de dependencia para a camada de acesso a dados ClientRepository
	
		@Autowired
		private AutorRepositoryProcuraEmail repository;
		
		@Override
		public void initialize(NovoAutorValid ann) {
		}

		@Override
		public boolean isValid(NovoAutorRequest request, ConstraintValidatorContext context) {
			
			List<FieldMessage> list = new ArrayList<>();
			
			// Coloque aqui seus testes de validação, acrescentando objetos FieldMessage à lista
			
			Autor autor = repository.findByEmail(request.getEmail());
			
			
			if (autor != null) {
				list.add(new FieldMessage("email", "Este email já existe"));
			}
			
			
			
			for (FieldMessage e : list) {
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
						.addConstraintViolation();
			}
			return list.isEmpty();
		}
	}
