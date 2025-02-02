package com.br.zup.academy.wagnerlima.casadocodigo.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = {ExistsIdValidator.class})
@Target({ FIELD})
@Retention(RUNTIME)
public @interface ExistsId {

	String message() default "Validation error, este dado é unicos e já existe cadastro no banco";
	Class<?>[] groups() default { };
	Class<? extends Payload>[] payload() default { };
	String fieldName();
	Class<?> domainClass();
}