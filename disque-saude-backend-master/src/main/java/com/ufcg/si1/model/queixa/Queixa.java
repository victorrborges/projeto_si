package com.ufcg.si1.model.queixa;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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

	private String comentario = "";
	
//	@Enumerated(EnumType.STRING)
	//private SituacaoQueixa situacaoQueixa;
	
	public Queixa() {

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
	
	public void setSolicitanteId(Pessoa solicitante) {
		this.solicitante = solicitante;
	}
	
//	public void setNome(String nome) {
//		this.solicitante.setNome(nome);
//	}
//	
//	public String getNome() {
//		return this.solicitante.getNome();
//	}
//	
//	public void setEmail(String email) {
//		this.solicitante.setEmail(email);
//	}
//	
//	public String getEmail() {
//		return this.solicitante.getEmail();
//	}
//	
//	public void setRua(String rua) {
//		this.solicitante.getEndereco().setRua(rua);
//	}
//	
//	public String getRua() {
//		return this.solicitante.getEndereco().getRua();
//	}
//	
//	public void setCidade(String cidade) {
//		this.solicitante.getEndereco().setCidade(cidade);
//	}
//	
//	public String getCidade() {
//		return this.solicitante.getEndereco().getCidade();
//	}
//	
//	public void setUf(String uf) {
//		this.solicitante.getEndereco().setUf(uf);
//	}
//	
//	public String getUf() {
//		return this.solicitante.getEndereco().getUf();
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