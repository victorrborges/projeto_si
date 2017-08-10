package com.ufcg.si1.service;

import com.ufcg.si1.model.Especialidade;
import com.ufcg.si1.repository.EspecialidadeRepository;

import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;
import exceptions.Rep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service("especialidadeService")
public class EspecialidadeServiceImpl implements EspecialidadeService {
	
	@Autowired
	EspecialidadeRepository especialidadeRespository;

    @Override
    public Especialidade getEspecialidade(long espId) throws Rep,ObjetoInexistenteException {
    	Especialidade especialidadeProcurada = this.especialidadeRespository.findOne(espId);
    	
    	if (especialidadeProcurada != null) return especialidadeProcurada;
		else throw new ObjetoInexistenteException("Especialidade nao encontrada");
    }

    @Override
    public Collection<Especialidade> getListaEspecialidade() {
    	return this.especialidadeRespository.findAll();
    }

    @Override
    public int size() {
        return this.getListaEspecialidade().size();
    }


    @Override
    public void insere(Especialidade esp) throws ObjetoJaExistenteException {
    	if (this.existe(esp.getId())) {
    		throw new ObjetoJaExistenteException("Objeto ja existente");
    	}
    	this.especialidadeRespository.save(esp);
    }

    @Override
    public boolean existe(long espId) {
        return (this.especialidadeRespository.findOne(espId) != null);
    }
    
    public List<Especialidade> especialidadesDaUnidade(long unidadeSaudeId) {
    	List<Especialidade> especialidadesDaUnidade = new ArrayList<Especialidade>();
    	for(Especialidade especialidade : this.getListaEspecialidade()) {
    		if (especialidade.getUnidadeSaudeId() == unidadeSaudeId) {
    			especialidadesDaUnidade.add(especialidade);
    		}
    	}
    	return especialidadesDaUnidade;
    }


}
