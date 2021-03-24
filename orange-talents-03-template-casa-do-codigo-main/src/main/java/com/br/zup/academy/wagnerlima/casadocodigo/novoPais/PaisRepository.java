package com.br.zup.academy.wagnerlima.casadocodigo.novoPais;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long>{
	

}
