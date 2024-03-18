package com.algaworks.algafood.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Restaurante;

@Repository
public interface RestauranteRepository 
	   extends JpaRepository<Restaurante, Long>, RestauranteRepositoryQueries
	   , JpaSpecificationExecutor<Restaurante>{
	
	List<Restaurante> findByTaxaFreteBetween(BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal);
	
//	@Query("from Restaurante r where r.nome like %:nome% and r.cozinha.id = :id")
	List<Restaurante> consultarPorNome(String nome, @Param("id") Long id);
	//List<Restaurante> findByNomeContainingAndCozinhaId(String nome, Long id);

}
