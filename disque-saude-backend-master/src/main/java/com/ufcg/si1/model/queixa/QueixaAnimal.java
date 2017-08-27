package com.ufcg.si1.model.queixa;

public class QueixaAnimal extends Queixa {

	private String tipoAnimal;

	public QueixaAnimal(String descricao, Long solicitanteId, String tipoAnimal) {
		// super(descricao, solicitanteId);
		this.setTipoAnimal(tipoAnimal);
	}

	public QueixaAnimal(String descricao, String comentario, Long solicitanteId, String tipoAnimal) {
		// super(descricao, comentario, solicitanteId);
		this.setTipoAnimal(tipoAnimal);
	}

	public String getTipoAnimal() {
		return tipoAnimal;
	}

	public void setTipoAnimal(String tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}

}
