package com.ufcg.si1.service;

import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;
import exceptions.Rep;

import java.util.List;

import com.ufcg.si1.model.UnidadeSaude;



public interface UnidadeSaudeService {
    
	UnidadeSaude findOneUnidade(long unidadeSaudeId) throws ObjetoInexistenteException;

	List<UnidadeSaude> findAllUnidades();

    void save(UnidadeSaude us)throws Rep,ObjetoJaExistenteException;

    UnidadeSaude findByBairro(String bairro) throws ObjetoInexistenteException;

}
