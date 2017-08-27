package com.ufcg.si1.model.unidade;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.ufcg.si1.model.Endereco;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @JsonSubTypes.Type(value = PostoSaude.class, name = "posto"),
		@JsonSubTypes.Type(value = HospitalAdapter.class, name = "hospital") })
@Entity
@Inheritance
public abstract class UnidadeSaude {

	@Id
	@GeneratedValue
	private Long id;

	private String descricao;

	@Embedded
	private Endereco endereco;

	public UnidadeSaude(String descricao) {
		this.descricao = descricao;
	}

	public UnidadeSaude() {

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

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Endereco getEndereco() {
		return this.endereco;
	}
}
