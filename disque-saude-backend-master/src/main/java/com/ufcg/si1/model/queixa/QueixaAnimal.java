package com.ufcg.si1.model.queixa;

import javax.persistence.Entity;

import com.ufcg.si1.model.Pessoa;

@Entity
public class QueixaAnimal extends Queixa {

	private String tipoAnimal;

	public QueixaAnimal(String descricao, Pessoa pessoa, String tipoAnimal) {
		super(descricao, pessoa);
		this.setTipoAnimal(tipoAnimal);
	}

	public QueixaAnimal(String descricao, String comentario, Pessoa pessoa, String tipoAnimal) {
		super(descricao, comentario, pessoa);
		this.setTipoAnimal(tipoAnimal);
	}

	public String getTipoAnimal() {
		return tipoAnimal;
	}

	public void setTipoAnimal(String tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}

}
