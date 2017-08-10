package com.ufcg.si1.service;

import com.ufcg.si1.model.Especialidade;
import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;
import exceptions.Rep;

import java.util.Collection;
import java.util.List;


public interface EspecialidadeService {
    
	Especialidade findOneEspecialidade(long especialidadeId) throws Rep,ObjetoInexistenteException;

    public Collection<Especialidade> findAllEspecialidades();

    public void save(Especialidade esp) throws ObjetoJaExistenteException;
    
    public List<Especialidade> getEspecialidadesDaUnidade(long unidadeSaudeId);
}
