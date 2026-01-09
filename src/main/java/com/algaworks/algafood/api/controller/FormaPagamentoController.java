package com.algaworks.algafood.api.controller;

import java.util.List;
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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;
import com.algaworks.algafood.domain.service.CadastroFormaPagamentoService;

@RestController
@RequestMapping("/pagamentos")
public class FormaPagamentoController {
	
	@Autowired 
	private FormaPagamentoRepository formaPagamentoRepository;
	
	@Autowired
	private CadastroFormaPagamentoService cadastroFormaPagamento;
	
	@GetMapping//(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<FormaPagamento> listar() {
		return formaPagamentoRepository.findAll();
	}
	
//	@ResponseStatus(HttpStatus.OK) // alterando codigo status response http. 
	@GetMapping("/{formaPagamentoId}")
	public ResponseEntity<FormaPagamento> buscar(@PathVariable Long formaPagamentoId) {	
		Optional<FormaPagamento> formaPagamento = formaPagamentoRepository.findById(formaPagamentoId);
		
		//ResponseEntity permite customizar a resposta HTTP com status e corpo(payload) do retorno da requisição.

		if(formaPagamento.isPresent()) {
//			return ResponseEntity.status(HttpStatus.OK).body(cozinha);
			return ResponseEntity.ok(formaPagamento.get());			
		}

		return ResponseEntity.notFound().build();			
//		HttpHeaders headers = new HttpHeaders();
//		headers.add(HttpHeaders.LOCATION, "http://localhost:8080/cozinhas"); // response status 302
//		return ResponseEntity.status(HttpStatus.FOUND).headers(headers).build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public FormaPagamento adicionar(@RequestBody FormaPagamento formaPagamento) {
		return cadastroFormaPagamento.salvar(formaPagamento);
	}
	
	@PutMapping("/{formaPagamentoId}")
	public ResponseEntity<FormaPagamento> atualizar(@PathVariable Long formaPagamentoId, @RequestBody FormaPagamento formaPagamento) {
		Optional<FormaPagamento> formaPagamentoAtual = formaPagamentoRepository.findById(formaPagamentoId);
		
		if(formaPagamentoAtual != null) {
//		   cozinhaAtual.setNome(cozinha.getNome());
		   BeanUtils.copyProperties(formaPagamento, formaPagamentoAtual.get(), "id"); // copia os dados dos atributos de cozinha para cozinhaAtual
		
		   FormaPagamento formaPagamentoSalva = cadastroFormaPagamento.salvar(formaPagamentoAtual.get());
		   return ResponseEntity.ok(formaPagamentoSalva);
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{formaPagamentoId}")
	public ResponseEntity<FormaPagamento> remover(@PathVariable Long formaPagamentoId) {
		try {
			cadastroFormaPagamento.excluir(formaPagamentoId);
			return ResponseEntity.noContent().build();
		
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
			
		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build(); // Codigo response status HTTP 409.
		}
	}
}
