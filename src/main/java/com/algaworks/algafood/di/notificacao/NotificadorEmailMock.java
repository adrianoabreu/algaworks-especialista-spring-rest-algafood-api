package com.algaworks.algafood.di.notificacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;

@Profile("dev")
@TipoDoNotificador(NivelUrgencia.NORMAL) // Anotação Customizada que se comporta como @Qualifier
//@Qualifier("normal") // Anotação usada para fazer desambiguação de beans.
//@Primary  // Anotação usada para fazer desambiguação de beans. Determina qual bean é prioritário
@Component // Esta anotação significa que a classe é um Bean
public class NotificadorEmailMock implements Notificador {
	
	@Autowired
	private NotificadorProperties properties;
	
	public NotificadorEmailMock() {
		System.out.println("NotificadorEmail MOCK");
	}
	
	@Override
	public void notificar(Cliente cliente, String mensagem) {
		System.out.println("Host: " + properties.getHostServidor());
		System.out.println("Porta: " + properties.getPortaServidor());
		
		System.out.printf("MOCK: Notificação seria enviada para %s através do email %s: %s\n", 
				cliente.getNome(), cliente.getEmail(), mensagem);
	}
	
}
