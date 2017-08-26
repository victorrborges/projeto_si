package com.ufcg.si1.model.prefeitura;

import javax.persistence.Embeddable;

@Embeddable
public class Normal implements AcoesPrefeitura {

	@Override
	public int getEficiencia(double razao) {
		if(razao > 0.2) {
			return 0;
		} else if(razao > 0.1) {
			return 1;
		} else {
			return 2;
		}
	}

}
