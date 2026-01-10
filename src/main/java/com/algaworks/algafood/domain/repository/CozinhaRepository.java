package com.algaworks.algafood.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Cozinha;

@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long>{ 
	
//	List<Cozinha> findTodasByNome(String nome);
	List<Cozinha> findTodasByNomeContaining(String nome);
	
	//retorna uma cozinha pelo nome informado.
	Optional<Cozinha> findByNome(String nome);
	
	//retorna true caso exista o nome informado, false caso não exista
	boolean existsByNome(String nome);
	
	

}
