package com.ufcg.si1.model.prefeitura;

public class Extra extends Prefeitura{
	
	@Override
	public int getEficiencia(double razao) {
		if(razao > 0.1) {
			return 0;
		} else if(razao > 0.05) {
			return 1;
		} else {
			return 2;
		}
	}
}
