package com.ufcg.si1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufcg.si1.model.prefeitura.Prefeitura;
import com.ufcg.si1.repository.PrefeituraRepository;

@Service("prefeituraService")
public class PrefeituraServiceImpl implements PrefeituraService {

	@Autowired
	PrefeituraRepository prefeituraRepository;

	private Prefeitura getPrefeitura() {
		if (prefeituraRepository.findAll().isEmpty()) {
			return prefeituraRepository.save(Prefeitura.getInstancia());
		}
		return this.getSingleton();
	}

	private Prefeitura getSingleton() {
		for (Prefeitura prefeitura : this.prefeituraRepository.findAll()) {
			if (prefeitura instanceof Prefeitura) {
				return prefeitura;
			}
		}
		return null;
	}

	public Prefeitura updatePrefeitura(Prefeitura prefeitura) {
		Long id = this.getPrefeitura().getId();
		prefeitura.setId(id);
		return this.prefeituraRepository.save(prefeitura);
	}

	@Override
	public int getEficiencia(double razao) {
		return Prefeitura.getInstancia().getEficiencia(razao);
	}

}
