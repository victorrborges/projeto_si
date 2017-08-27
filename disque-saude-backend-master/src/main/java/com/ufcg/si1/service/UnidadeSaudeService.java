package com.ufcg.si1.service;

import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;
import exceptions.Rep;

import java.util.List;

import com.ufcg.si1.model.unidade.UnidadeSaude;

public interface UnidadeSaudeService {
    
	UnidadeSaude findOneUnidade(Long unidadeSaudeId) throws ObjetoInexistenteException;

	List<UnidadeSaude> findAllUnidades();

    void save(UnidadeSaude us)throws Rep,ObjetoJaExistenteException;

    List<UnidadeSaude> findByBairro(String bairro) throws ObjetoInexistenteException;
    
    List<UnidadeSaude> findByEspecialidade(String especialidadeBuscada);

}
