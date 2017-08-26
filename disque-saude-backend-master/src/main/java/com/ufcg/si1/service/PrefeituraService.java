package com.ufcg.si1.service;

import com.ufcg.si1.model.prefeitura.Prefeitura;

public interface PrefeituraService {
	
	public Prefeitura updatePrefeitura(Prefeitura prefeitura);
	
	public int getEficiencia(double razao);

	
}
