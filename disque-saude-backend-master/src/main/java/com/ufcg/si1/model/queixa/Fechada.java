package com.ufcg.si1.model.queixa;

import exceptions.ObjetoInvalidoException;

public class Fechada extends QueixaState {

	@Override
	public QueixaState abrir() throws ObjetoInvalidoException {
		return new Aberta();
	}

	@Override
	public QueixaState fechar() throws ObjetoInvalidoException {
		return new Fechada();
	}

}
