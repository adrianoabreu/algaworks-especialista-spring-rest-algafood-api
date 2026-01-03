package com.algaworks.algafood.di.notificacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;

@Profile("prod")
@TipoDoNotificador(NivelUrgencia.NORMAL) // Anotação Customizada que se comporta como @Qualifier
//@Qualifier("normal") // Anotação usada para fazer desambiguação de beans.
//@Primary  // Anotação usada para fazer desambiguação de beans. Determina qual bean é prioritário
@Component // Esta anotação significa que a classe é um Bean
public class NotificadorEmail implements Notificador {
	
	@Autowired
	private NotificadorProperties properties;
	
	public NotificadorEmail() {
		System.out.println("NotificadorEmail REAL");
	}

	@Override
	public void notificar(Cliente cliente, String mensagem) {
		System.out.println("Host: " + properties.getHostServidor());
		System.out.println("Porta: " + properties.getPortaServidor());
		
		System.out.printf("Notificando %s através do email %s: %s\n", 
				cliente.getNome(), cliente.getEmail(), mensagem);
	}
	
}
