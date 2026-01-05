package com.algaworks.algafood.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

public class ConsultaRestauranteMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
						.web(WebApplicationType.NONE)
						.run(args);
		
		RestauranteRepository restauranteRepositoty = applicationContext.getBean(RestauranteRepository.class);
		
		Restaurante restaurante = restauranteRepositoty.porId(1L);
		
		System.out.println(restaurante.getNome());
	}
}
