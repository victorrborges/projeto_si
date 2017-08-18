package com.ufcg.si1.model.prefeitura;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
