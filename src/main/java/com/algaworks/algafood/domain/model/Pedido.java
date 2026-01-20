package com.algaworks.algafood.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.algaworks.algafood.domain.enums.StatusPedido;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Pedido {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private BigDecimal subtotal;
	
	@Column(name = "taxa_frete", nullable = false)
	private BigDecimal taxaFrete;

	@Column(nullable = false)
	private BigDecimal valorTotal;
	
	@CreationTimestamp
	private LocalDateTime dataCriacao;
	private LocalDateTime dataConfirmacao;
	private LocalDateTime dataEntrega;
	private LocalDateTime dataCancelamento;
	
	@JsonIgnore
	@Embedded
	private Endereco endereco; //A classe endereço é parte da classe Restaurante.
	
	@ManyToOne
    @JoinColumn(nullable = false)
    private FormaPagamento formaPagamento;
	
	@ManyToOne
    @JoinColumn(nullable = false)
    private Restaurante restaurante;
	
	@ManyToOne
    @JoinColumn(name = "usuario_cliente_id", nullable = false)
    private Usuario cliente;
	
	@OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itens = new ArrayList<>();
	
	private StatusPedido status;
	
}	
	
	
