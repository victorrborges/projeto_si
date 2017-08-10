package com.ufcg.si1.model;

import exceptions.ObjetoInvalidoException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.ufcg.si1.util.FactoryPessoa;

@Entity
public class Queixa {
	
	@Id
	@GeneratedValue
	private long id;

	private String descricao;

	private Pessoa solicitante;

	private String comentario = ""; // usado na atualizacao da queixa

	public Queixa(){

	}
	
	public Queixa(String descricao,
            String nome, String email,
			  String rua, String uf, String cidade) {
	this.descricao = descricao;
	this.comentario = "";
	this.solicitante = FactoryPessoa.criaPessoa(nome, email, rua, uf, cidade);
}


	public Queixa(long id, String descricao, String comentario,
                  String nome, String email,
				  String rua, String uf, String cidade) {
		this.id = id;
		this.descricao = descricao;
		this.comentario = comentario;
		this.solicitante = new Pessoa(nome, email, rua, uf, cidade);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
	public void fechar(String coment) throws ObjetoInvalidoException {
		this.comentario = coment;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Pessoa getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Pessoa solicitante) {
		this.solicitante = solicitante;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Queixa other = (Queixa) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
