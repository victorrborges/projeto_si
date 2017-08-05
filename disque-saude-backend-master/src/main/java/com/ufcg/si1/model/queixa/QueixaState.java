package com.ufcg.si1.model.queixa;

import exceptions.ObjetoInvalidoException;

public interface QueixaState {
	
	public QueixaState abrir() throws ObjetoInvalidoException;
	
	public QueixaState fechar() throws ObjetoInvalidoException;

}
