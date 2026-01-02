package com.algaworks.algafood.di.modelo;

public class Cliente {

	private String nome;
	private String email;
	private String telefone;
	private boolean ativo = false;
	
	public Cliente(String nome, String email, String telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public boolean ativar() {
		return ativo;
	}

	public void ativar(boolean ativo) {
		this.ativo = ativo;
	}
	
	
	
}
