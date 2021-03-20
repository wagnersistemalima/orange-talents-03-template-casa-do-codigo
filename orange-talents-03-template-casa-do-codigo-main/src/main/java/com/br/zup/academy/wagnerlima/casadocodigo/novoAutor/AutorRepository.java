package com.br.zup.academy.wagnerlima.casadocodigo.novoAutor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long>{

	
	@SuppressWarnings("unchecked")
	Autor save(Autor entity);

}
