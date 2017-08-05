package com.ufcg.si1.model.queixa;

import exceptions.ObjetoInvalidoException;

public class Fechada implements QueixaState {

	@Override
	public QueixaState abrir() throws ObjetoInvalidoException {
		return new Aberta();
	}

	@Override
	public QueixaState fechar() throws ObjetoInvalidoException {
		throw new ObjetoInvalidoException("Status Inválido");
	}

}
