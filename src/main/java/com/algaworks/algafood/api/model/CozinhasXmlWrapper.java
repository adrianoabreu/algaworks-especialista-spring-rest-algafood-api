package com.algaworks.algafood.api.model;

import java.util.List;

import com.algaworks.algafood.domain.model.Cozinha;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Data;
import lombok.NonNull;

// A Função desta classe é empacotar uma lista de cozinhas
@JacksonXmlRootElement(localName = "cozinhas") // altera o nome da tag root CozinhasXmlWrapper para cozinhas no retorno do xml. Poderia também ter usado @JsonRootElement que possui o mesmo efeito. 
@Data
public class CozinhasXmlWrapper {
	
	@JsonProperty("cozinha")
	@JacksonXmlElementWrapper(useWrapping = false) // elimina duplicidade de tags durante o empacotamento das cozinhas.
	@NonNull
	private List<Cozinha> cozinhas;

}
