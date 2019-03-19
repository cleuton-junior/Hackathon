package com.stefanini.projeto.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.stefanini.projeto.model.Mulher;


public interface MulherRepository extends CrudRepository<Mulher, Long>{

	@Query("select m from Mulher m where m.nome = :nome")
	Mulher buscarPorNome(@Param("nome") String nome);
	
}
