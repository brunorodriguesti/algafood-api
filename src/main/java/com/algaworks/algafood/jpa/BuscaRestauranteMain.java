package com.algaworks.algafood.jpa;


import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

public class BuscaRestauranteMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext =  new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);
		Restaurante restaurante = restauranteRepository.findById(1L).get();
		System.out.printf("%d - %s - %s - %s\n", restaurante.getId(), restaurante.getNome(), restaurante.getTaxaFrete()
				, restaurante.getCozinha() != null ? restaurante.getCozinha().getNome() : "");

	}

}
