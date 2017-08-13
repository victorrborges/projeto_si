package com.ufcg.si1.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pessoa {
	
	@Id
	@GeneratedValue
	private Long id;

	private String nome;
	
	private String email;
	
	@Embedded
	private Endereco endereco;
	
	public Pessoa() {
		
	}

	public Pessoa(String nome, String email, String rua, String uf,
			String cidade) {
		this.setEndereco(new Endereco(rua, uf, cidade));
		this.nome = nome;
		this.email = email;
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
	
	public void setRua(String rua) {
		endereco.setRua(rua);
	}
	
	public void setCidade(String cidade) {
		endereco.setCidade(cidade);
	}
	
	public void setUf(String uf) {
		endereco.setUf(uf);
	}


	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
