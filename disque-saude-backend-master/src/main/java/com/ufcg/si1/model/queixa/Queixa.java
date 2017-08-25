package com.ufcg.si1.model.queixa;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.ufcg.si1.model.Endereco;
import com.ufcg.si1.model.Pessoa;

//@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
//@JsonSubTypes({
//	@JsonSubTypes.Type(value = QueixaAnimal.class, name = "queixa_animal")
//})

@Entity
public class Queixa {

	@Id
	@GeneratedValue
	private Long id;

	private String descricao;
	
	@Embedded
	private Pessoa solicitante;
	
	@Embedded
	private Endereco endereco;

	private String comentario;
	
	@Enumerated(EnumType.STRING)
	private SituacaoQueixa situacaoQueixa;
	
	public Queixa() {
		situacaoQueixa = SituacaoQueixa.ABERTA;
	}
	
	public Queixa(String descricao, Pessoa solicitante) {
		this.descricao = descricao;
		this.comentario = "";
		this.solicitante = solicitante;
	}

	public Queixa(String descricao, String comentario, Pessoa solicitante) {
		this.descricao = descricao;
		this.comentario = comentario;
		this.solicitante = solicitante;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	public Pessoa getSolicitante() {
		return this.solicitante;
	}
	
	public void setSituacao(SituacaoQueixa situacao) {
		this.situacaoQueixa = situacao;
	}	
	
	public SituacaoQueixa getSituacao() {
		return this.situacaoQueixa;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public Endereco getEndereco() {
		return this.endereco;
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