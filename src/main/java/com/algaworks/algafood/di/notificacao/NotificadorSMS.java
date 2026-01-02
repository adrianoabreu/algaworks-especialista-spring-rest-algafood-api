package com.algaworks.algafood.di.notificacao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;

@TipoDoNotificador(NivelUrgencia.URGENTE) // Anotação Customizada que se comporta como @Qualifier
//@Qualifier("urgente") // Anotação usada para fazer desambiguação de beans.
//@Primary  // Anotação usada para fazer desambiguação de beans. Determina qual bean é prioritário
@Component // Esta anotação significa que a classe é um Bean
public class NotificadorSMS implements Notificador {
		
	@Override
	public void notificar(Cliente cliente, String mensagem) {
		
		System.out.printf("Notificando %s por SMS através do telefone %s: %s\n", 
				cliente.getNome(), cliente.getTelefone(), mensagem);
	}
	
}
