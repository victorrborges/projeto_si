package com.ufcg.si1.model.queixa;

public class QueixaFactory {

	public QueixaState criarQueixa(int situacao) {

		if (situacao == 1) {
			return new Aberta();
		} else if (situacao == 2) {
			return new EmAndamento();
		} else {
			return new Fechada();
		}
	}
}
