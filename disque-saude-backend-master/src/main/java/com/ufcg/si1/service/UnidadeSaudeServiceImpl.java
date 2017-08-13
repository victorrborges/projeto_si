package com.ufcg.si1.service;

import com.ufcg.si1.model.UnidadeSaude;
import com.ufcg.si1.repository.UnidadeSaudeRepository;

import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;
import exceptions.Rep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("unidadeSaudeService")
public class UnidadeSaudeServiceImpl implements UnidadeSaudeService {

	@Autowired
	UnidadeSaudeRepository unidadeSaudeRepository;

	@Override
	public UnidadeSaude findOneUnidade(Long unidadeSaudeId) throws ObjetoInexistenteException {
		if (!this.existe(unidadeSaudeId)) {
			throw new ObjetoInexistenteException("Unidade de saude inexistente");
		}
		return this.unidadeSaudeRepository.findOne(unidadeSaudeId);
	}

	private boolean existe(Long unidadeSaudeId) {

		return this.unidadeSaudeRepository.exists(unidadeSaudeId);
	}
	
	@Override
	public List<UnidadeSaude> findAllUnidades() {
		return this.unidadeSaudeRepository.findAll();
	}

	@Override
	public void save(UnidadeSaude unidadeSaude) throws Rep, ObjetoJaExistenteException {

		if (unidadeSaude == null) {
			throw new Rep("Erro!");
		} 
		
		if(this.existe(unidadeSaude.getId())) {
			throw new ObjetoJaExistenteException("Unidade de saude ja existente");
		}

		this.unidadeSaudeRepository.save(unidadeSaude);
	}



	@Override
	public UnidadeSaude findByBairro(String bairro) throws ObjetoInexistenteException {
		
		List<UnidadeSaude> unidades = this.findAllUnidades();
		
		for(UnidadeSaude unidadeSaude : unidades) {
			if(unidadeSaude.getDescricao().equals(bairro)) {
				return unidadeSaude;
			}
		}
		
		throw new ObjetoInexistenteException("Unidade de saude nao existente");
	}

}
