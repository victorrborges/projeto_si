package com.ufcg.si1.model.prefeitura;

import javax.persistence.Embeddable;

@Embeddable
public class Extra implements AcoesPrefeitura {

	@Override
	public int getEficiencia(double razao) {
		if (razao > 0.1) {
			return 0;
		} else if (razao > 0.05) {
			return 1;
		} else {
			return 2;
		}
	}
}
