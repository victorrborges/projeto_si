package com.ufcg.si1.model.queixa;

import exceptions.ObjetoInvalidoException;

public class EmAndamento extends QueixaState{

	@Override
	public QueixaState abrir() throws ObjetoInvalidoException {
		throw new ObjetoInvalidoException("Status inválido");
	}

	@Override
	public QueixaState fechar() throws ObjetoInvalidoException {
		return new Fechada();
	}

}
