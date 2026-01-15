package com.algaworks.algafood.domain.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Restaurante;

@Repository
public interface RestauranteRepository extends CustomJpaRepository<Restaurante, Long>
						, RestauranteRepositoryQueries, JpaSpecificationExecutor<Restaurante> {
	
	@Query("select r from Restaurante r join fetch r.cozinha left join fetch r.formasPagamento")
	List<Restaurante> findAll();
	
	//Retorna uma faixa de taxa frete informado
	List<Restaurante> findByTaxaFreteBetween(BigDecimal taxaInicial, BigDecimal taxaFinal);

//	List<Restaurante> findByNomeContainingAndCozinhaId(String nome, Long cozinha);
//	@Query("from Restaurante where nome like %:nome% and cozinha.id = :id")
	List<Restaurante> consultarPorNome(String nome, @Param("id") Long cozinha);

	
	//recupera o primeiro  restaurante com o nome informado
	Optional<Restaurante> findFirstRestauranteByNomeContaining(String nome);
	
	//recupera os dois primeiros restaurantes da lista de acordo com o nome informado
	List<Restaurante> findTop2ByNomeContaining(String nome);
	
	//Recupera quantidade de restaurantes da Cozinha Informada
	int countByCozinhaId(Long cozinha);
		
}
