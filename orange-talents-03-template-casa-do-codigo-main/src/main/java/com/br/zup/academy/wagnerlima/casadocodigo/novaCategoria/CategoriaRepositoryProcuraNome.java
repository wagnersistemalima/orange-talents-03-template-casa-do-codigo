package com.br.zup.academy.wagnerlima.casadocodigo.novaCategoria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepositoryProcuraNome extends JpaRepository<Categoria, Long>{
	
	Categoria findByNome(String nome);
}
