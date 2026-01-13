package com.algaworks.algafood.api.controller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import com.algaworks.algafood.domain.service.CadastroRestauranteService;

import tools.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Autowired
	private CadastroRestauranteService cadastroRestaurante;
	
	@GetMapping//(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Restaurante> listar() {
		return restauranteRepository.findAll();
	}
	
//	@ResponseStatus(HttpStatus.OK) // alterando codigo status response http. 
	@GetMapping("/{restauranteId}")
	public ResponseEntity<Restaurante> buscar(@PathVariable Long restauranteId) {	
		Optional<Restaurante> restaurante = restauranteRepository.findById(restauranteId);
		
		//ResponseEntity permite customizar a resposta HTTP com status e corpo(payload) do retorno da requisição.

		if(restaurante.isPresent()) {
//			return ResponseEntity.status(HttpStatus.OK).body(restaurante);
			return ResponseEntity.ok(restaurante.get());			
		}

		return ResponseEntity.notFound().build();			
//		HttpHeaders headers = new HttpHeaders();
//		headers.add(HttpHeaders.LOCATION, "http://localhost:8080/cozinhas"); // response status 302
//		return ResponseEntity.status(HttpStatus.FOUND).headers(headers).build();
	}
	
	@PostMapping
	public ResponseEntity<?> adicionar(@RequestBody Restaurante restaurante) {
		try {
			restaurante = cadastroRestaurante.salvar(restaurante);			
			return ResponseEntity.status(HttpStatus.CREATED).body(restaurante);
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage()); // Codigo response status HTTP 400.
		}
	}
	
	@PutMapping("/{restauranteId}")
	public ResponseEntity<?> atualizar(@PathVariable Long restauranteId, @RequestBody Restaurante restaurante) {
		try {
			Restaurante restauranteAtual = restauranteRepository.findById(restauranteId).orElse(null);
		
			if(restauranteAtual != null) {
//		   		cozinhaAtual.setNome(cozinha.getNome());
				BeanUtils.copyProperties(restaurante, restauranteAtual, "id", "formasPagamento", "endereco", "dataCadastro"); // copia os dados dos atributos de cozinha para cozinhaAtual
		
//				Restaurante restauranteSalvo = cadastroRestaurante.salvar(restauranteAtual.get());
				restauranteAtual = cadastroRestaurante.salvar(restauranteAtual);
				return ResponseEntity.ok(restauranteAtual);
			}
			return ResponseEntity.notFound().build();
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage()); // Codigo response status HTTP 400.
		}
		
	}
	
	@PatchMapping("/{restauranteId}")
	public ResponseEntity<?> atualizarParcial(@PathVariable Long restauranteId, 
			@RequestBody Map<String, Object> campos) {

			Optional<Restaurante> restauranteAtual = restauranteRepository.findById(restauranteId);
		
			if(restauranteAtual.isEmpty()) {	
				return ResponseEntity.notFound().build();
			}
			
			merge(campos, restauranteAtual.get());

			return atualizar(restauranteId, restauranteAtual.get());
	}

	@DeleteMapping("/{cozinhaId}")
	public ResponseEntity<Restaurante> remover(@PathVariable Long restauranteId) {
		try {
			cadastroRestaurante.excluir(restauranteId);
			return ResponseEntity.noContent().build();
		
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
			
		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build(); // Codigo response status HTTP 409.
		}
	}
	
	private void merge(Map<String, Object> dadosOrigem, Restaurante restauranteDestino) {
		ObjectMapper objectMapper = new ObjectMapper();
		Restaurante restautanteOrigem = objectMapper.convertValue(dadosOrigem, Restaurante.class);
		
		dadosOrigem.forEach((nomePropriedade, valorPropriedade) -> {
			Field field = ReflectionUtils.findField(Restaurante.class, nomePropriedade);
			field.setAccessible(true);
			
			Object novoValor = ReflectionUtils.getField(field, restautanteOrigem);
			
//			System.out.println(nomePropriedade + " = " + valorPropriedade);
			
			ReflectionUtils.setField(field, restauranteDestino, novoValor);
		});
	}
}
