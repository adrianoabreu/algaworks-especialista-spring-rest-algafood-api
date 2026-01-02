package com.algaworks.algafood.di.notificacao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;

@TipoDoNotificador(NivelUrgencia.NORMAL) // Anotação Customizada que se comporta como @Qualifier
//@Qualifier("normal") // Anotação usada para fazer desambiguação de beans.
//@Primary  // Anotação usada para fazer desambiguação de beans. Determina qual bean é prioritário
@Component // Esta anotação significa que a classe é um Bean
public class NotificadorEmail implements Notificador {
		
	@Override
	public void notificar(Cliente cliente, String mensagem) {
		
		System.out.printf("Notificando %s através do email %s usando SMTP %s: %s\n", 
				cliente.getNome(), cliente.getEmail(), mensagem);
	}
	
}
