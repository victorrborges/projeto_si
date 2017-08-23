package com.ufcg.si1.model.queixa;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
	@JsonSubTypes.Type(value = QueixaAnimal.class, name = "queixa_animal")
})

@Entity
public class Queixa {

	@Id
	@GeneratedValue
	private Long id;

	private String descricao;

	private Long solicitanteId;

	private String comentario = "";
	
	@Enumerated(EnumType.STRING)
	private SituacaoQueixa situacaoQueixa;
	
	@Embedded
	private QueixaState queixaState;

	public Queixa() {

	}
	
	public Queixa(String descricao, Long solicitanteId) {
		this.descricao = descricao;
		this.comentario = "";
		this.solicitanteId = solicitanteId;
		this.situacaoQueixa = SituacaoQueixa.ABERTA;
		this.queixaState = new Aberta();
	}

	public Queixa(String descricao, String comentario, Long solicitanteId) {
		this.descricao = descricao;
		this.comentario = comentario;
		this.solicitanteId = solicitanteId;
		this.situacaoQueixa = SituacaoQueixa.FECHADA;
		this.queixaState = new Fechada();
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
	
	public Long getSolicitanteId() {
		return this.solicitanteId;
	}
	
	public void setSolicitanteId(Long solicitanteId) {
		this.solicitanteId = solicitanteId;
	}

	public SituacaoQueixa getSituacao() {
		return this.situacaoQueixa;
	}

	public void setSituacao(SituacaoQueixa situacao) {
		this.situacaoQueixa = situacao;
	}

//	public void abrir() throws ObjetoInvalidoException {
//		//this.queixaState.abrir();
//		if (this.situacaoQueixa != SituacaoQueixa.EM_ANDAMENTO)
//			this.situacaoQueixa = SituacaoQueixa.ABERTA;
//	}

//	public void fechar(String coment) throws ObjetoInvalidoException {
//		//this.queixaState.fechar();
//		if (this.situacaoQueixa == SituacaoQueixa.EM_ANDAMENTO || this.situacaoQueixa == SituacaoQueixa.ABERTA) {
//				 			this.situacaoQueixa = SituacaoQueixa.FECHADA;
//				 			this.comentario = coment;
//		}
//	}

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