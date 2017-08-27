package com.ufcg.si1.service;

import com.ufcg.si1.model.unidade.HospitalAdapter;
import com.ufcg.si1.model.unidade.UnidadeSaude;
import com.ufcg.si1.repository.UnidadeSaudeRepository;

import br.edu.ufcg.Hospital;
import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;
import exceptions.Rep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("unidadeSaudeService")
public class UnidadeSaudeServiceImpl implements UnidadeSaudeService {

	@Autowired
	UnidadeSaudeRepository unidadeSaudeRepository;

	@Override
	public UnidadeSaude findOneUnidade(Long unidadeSaudeId) throws ObjetoInexistenteException {
		return this.unidadeSaudeRepository.findOne(unidadeSaudeId);
	}


	
	@Override
	public List<UnidadeSaude> findAllUnidades() {
		return this.unidadeSaudeRepository.findAll();
	}

	@Override
	public void save(UnidadeSaude unidadeSaude) throws Rep, ObjetoJaExistenteException {

		this.unidadeSaudeRepository.save(unidadeSaude);
	}



	@Override
	public List<UnidadeSaude> findByBairro(String bairro) throws ObjetoInexistenteException {
		
		List<UnidadeSaude> unidades = this.findAllUnidades();
		List<UnidadeSaude> unidadesDoBairro = new ArrayList<UnidadeSaude>();
		
		for(UnidadeSaude unidadeSaude : unidades) {
			if(unidadeSaude.getEndereco().getCidade().equals(bairro)) {
				unidadesDoBairro.add(unidadeSaude);
	
			}
			
		
		}
		return unidadesDoBairro;
	}
	
	@Override
	public List<UnidadeSaude> findByEspecialidade(String especialidadeBuscada) {
		
		List<UnidadeSaude> unidades = this.findAllUnidades();
		List<UnidadeSaude> unidadesEspecialidade = new ArrayList<UnidadeSaude>();
		
		for(UnidadeSaude unidadeSaude : unidades) {
			if(unidadeSaude instanceof HospitalAdapter) {
				HospitalAdapter hospital = (HospitalAdapter) unidadeSaude;
				for(String especialidade : hospital.getEspecialidades()) {
					if(especialidade.equalsIgnoreCase(especialidadeBuscada)) {
						unidadesEspecialidade.add(hospital);
					}
				}
	
			}
			
		
		}
		return unidadesEspecialidade;
	}

}
