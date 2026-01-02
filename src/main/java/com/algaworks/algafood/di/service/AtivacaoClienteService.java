package com.algaworks.algafood.di.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;
import com.algaworks.algafood.di.notificacao.NivelUrgencia;
import com.algaworks.algafood.di.notificacao.Notificador;
import com.algaworks.algafood.di.notificacao.TipoDoNotificador;

@Component // Esta anotação significa que a classe é um Bean
public class AtivacaoClienteService {

	@TipoDoNotificador(NivelUrgencia.NORMAL)
//	@Qualifier("normal")
//	@Qualifier("urgente")
	@Autowired // ponto de injeção de dependência via atributo. É a forma de injeção de dependência mais utilizada, mas não é a mais ideal, pois dificulta testes da classe ou configuração programatica da classe(instanciar a classe, porém não tem acesso devido estar definido como private)
//	@Autowired(required = false) // injeção de dependência opcional.
	private Notificador notificador;
	
//	@Autowired // ponto de injeção de dependência via atributo. É a forma de injeção de dependência mais utilizada, mas não é a mais ideal, pois dificulta testes da classe ou configuração programatica da classe(instanciar a classe, porém não tem acesso devido estar definido como private)
//	private List<Notificador> notificadores;
	
//  Usar injeção de dependência via construtor é o ideal, por que deixa claro ao instanciar uma classe, qual as dependências obrigatórias da classe. Mas não é sempre essa injeção que é utilizada, pois depende de cada caso.
//	@Autowired // ponto de injeção de dependência via construtor
//	public AtivacaoClienteService(Notificador notificador) {
//		this.notificador = notificador;
//	}
	
//	public AtivacaoClienteService(String qualquer) {
//		
//	}

	public void ativar(Cliente cliente) {
		cliente.ativar();
		
//		for(Notificador notificador : notificadores) {
			notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
//		}

	}

//	@Autowired //ponto de injeção de dependência via metodo set
//	public void setNotificador(Notificador notificador) {
//		this.notificador = notificador;
//	}
	
	
}
