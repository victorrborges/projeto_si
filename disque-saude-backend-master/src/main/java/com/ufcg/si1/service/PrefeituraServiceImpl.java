package com.ufcg.si1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufcg.si1.model.prefeitura.Normal;
import com.ufcg.si1.model.prefeitura.PrefeituraIF;

@Service("prefeituraService")
public class PrefeituraServiceImpl implements PrefeituraService{

	@Autowired
	private PrefeituraIF prefeitura = new Normal();

	public void setPrefeitura(PrefeituraIF prefeitura) {
		this.prefeitura = prefeitura;
	}

	@Override
	public int getEficiencia(double razao) {
		return prefeitura.getEficiencia(razao);
	}
	
}
