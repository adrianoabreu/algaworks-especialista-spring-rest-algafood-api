package com.algaworks.algafood.domain.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Restaurante;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
	
	//Retorna uma faixa de taxa frete informado
	List<Restaurante> findByTaxaFreteBetween(BigDecimal taxaInicial, BigDecimal taxaFinal);

	
	List<Restaurante> findByNomeContainingAndCozinhaId(String nome, Long cozinha);
	
	//recupera o primeiro  restaurante com o nome informado
	Optional<Restaurante> findFirstRestauranteByNomeContaining(String nome);
	
	//recupera os dois primeiros restaurantes da lista de acordo com o nome informado
	List<Restaurante> findTop2ByNomeContaining(String nome);
	
	//Recupera quantidade de restaurantes da Cozinha Informada
	int countByCozinhaId(Long cozinha);
	
}
