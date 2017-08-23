package com.ufcg.si1.model.prefeitura;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Normal.class, name = "normal"),
        @JsonSubTypes.Type(value = Extra.class, name = "extra"),
        @JsonSubTypes.Type(value = Caos.class, name = "caos")
})

@Entity
public abstract class Prefeitura {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private SituacaoPrefeitura situacaoPrefeitura;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public abstract int getEficiencia(double razao);

	public SituacaoPrefeitura getSituacaoPrefeitura() {
		return situacaoPrefeitura;
	}

	public void setSituacaoPrefeitura(SituacaoPrefeitura situacaoPrefeitura) {
		this.situacaoPrefeitura = situacaoPrefeitura;
	}

}
