package com.ufcg.si1.model.queixa;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.ufcg.si1.model.Pessoa;

import exceptions.ObjetoInvalidoException;

@Entity
public class Queixa {

	@Id
	@GeneratedValue
	private Long id;

	private String descricao;

	private Pessoa solicitante;

	private String comentario = ""; // usado na atualizacao da queixa

	//private QueixaState queixaState;

	@Enumerated(EnumType.STRING)
	private SituacaoQueixa situacaoQueixa;

	public Queixa() {

	}

	public Queixa(String descricao, SituacaoQueixa situacao, Pessoa solicitanteId) {
		this.descricao = descricao;
		this.situacaoQueixa = situacao;
		//this.queixaState = new Aberta();
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
	
	public String getNomeSolicitante() {
		return this.solicitante.getNome();
	}
	
	public void setNomeSolicitante(String nome) {
		this.solicitante.setNome(nome);
	}
	
	public String getEmailSolicitante() {
		return this.solicitante.getEmail();
	}
	
	public void setEmailSolicitante(String email) {
		this.solicitante.setEmail(email);
	}
	
	public String getCidadeSolicitante() {
		return this.solicitante.getEndereco().getCidade();
	}
	
	public void setCidadeSolicitante(String cidade) {
		this.solicitante.getEndereco().setCidade(cidade);
	}
	
	public String getRuaSolicitante() {
		return this.solicitante.getEndereco().getRua();
	}
	
	public void setRuaSolicitante(String rua) {
		this.solicitante.getEndereco().setRua(rua);
	}
	
	public String getUfSolicitante() {
		return this.solicitante.getEndereco().getUf();
	}
	
	public void setUfSolicitante(String uf) {
		this.solicitante.getEndereco().setUf(uf);
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

//	public QueixaState getState() {
//		return this.queixaState;
//	}

	public SituacaoQueixa getSituacao() {
		return this.situacaoQueixa;
	}

	public void setSituacao(SituacaoQueixa situacao) {
		this.situacaoQueixa = situacao;
	}

	public void abrir() throws ObjetoInvalidoException {
		//this.queixaState.abrir();
		if (this.situacaoQueixa != SituacaoQueixa.EM_ANDAMENTO)
			this.situacaoQueixa = SituacaoQueixa.ABERTA;
	}

	public void fechar(String coment) throws ObjetoInvalidoException {
		//this.queixaState.fechar();
		if (this.situacaoQueixa == SituacaoQueixa.EM_ANDAMENTO || this.situacaoQueixa == SituacaoQueixa.ABERTA) {
				 			this.situacaoQueixa = SituacaoQueixa.FECHADA;
				 			this.comentario = coment;
		}
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