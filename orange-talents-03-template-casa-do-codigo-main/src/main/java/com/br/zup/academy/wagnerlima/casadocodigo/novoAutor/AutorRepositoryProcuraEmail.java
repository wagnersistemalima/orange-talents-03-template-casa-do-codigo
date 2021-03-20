package com.br.zup.academy.wagnerlima.casadocodigo.novoAutor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepositoryProcuraEmail extends JpaRepository<Autor, Long>{
	
	Autor findByEmail(String email);
}
