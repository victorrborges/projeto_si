package com.ufcg.si1.model.prefeitura;

public class Caos implements PrefeituraIF{
	
	@Override
	public int getEficiencia(double razao) {
		if(razao > 0.05) {
			return 0;
		} else if(razao > 0.02) {
			return 1;
		} else {
			return 2;
		}
	}
}
