package com.algaworks.algafood.api.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import static com.algaworks.algafood.infrastructure.repository.spec.RestaurateSpecs.*;

@RestController
@RequestMapping("/teste")
public class TesteController {

	@Autowired
	private CozinhaRepository cozinhaRepository;

	@Autowired
	private RestauranteRepository restauranteRepository;

	@GetMapping("/cozinhas/por-nome") 
	public List<Cozinha> cozinhasPorNome(String nome){ //@RequestParam("nome") opcional para o bind 
		return cozinhaRepository.findTodasByNomeContaining(nome); 
	}

	@GetMapping("/cozinhas/unica-por-nome") 
	public Optional<Cozinha> cozinhaPorNome(String nome){ //@RequestParam("nome") opcional para o bind 
		return cozinhaRepository.findByNome(nome); 
	}

	/*
	 * @GetMapping("/restaurantes/por-taxa-frete") public List<Restaurante>
	 * restaurantesPorTaxaFrete(BigDecimal taxaFreteInicial, BigDecimal
	 * taxaFreteFinal){ return
	 * restauranteRepository.findByTaxaFreteBetween(taxaFreteInicial,
	 * taxaFreteFinal); }
	 */

	@GetMapping("/restaurantes/por-nome") public List<Restaurante>
	restaurantesPorNome(String nome, Long cozinhaId){ return
			restauranteRepository.consultarPorNome(nome, cozinhaId); }

	@GetMapping("/restaurantes/por-nome-e-frete")
	public List<Restaurante> restaurantesPorTaxaFrete(String nome, BigDecimal taxaFreteInicial, 
			BigDecimal taxaFreteFinal){
		return restauranteRepository.find(nome, taxaFreteInicial, 
				taxaFreteFinal);
	}

	@GetMapping("/restaurantes/com-frete-gratis")
	public List<Restaurante> restaurantesComFreteGratis(String nome, BigDecimal taxaFreteInicial, 
			BigDecimal taxaFreteFinal){
		return restauranteRepository.findComFreteGratis(nome);
	}
	
	@GetMapping("/restaurantes/primeiro")
	public Optional<Restaurante> restaurantePrimeiro(){
		return restauranteRepository.buscarPrimeiro();
	}

}
