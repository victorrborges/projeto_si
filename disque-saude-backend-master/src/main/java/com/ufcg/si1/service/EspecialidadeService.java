package com.ufcg.si1.service;

import com.ufcg.si1.model.Especialidade;
import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;
import exceptions.Rep;

import java.util.Collection;
import java.util.List;


public interface EspecialidadeService {
    
	Especialidade getEspecialidade(long especialidadeId) throws Rep,ObjetoInexistenteException;

    public Collection<Especialidade> getListaEspecialidade();

    public int size();

    public void insere(Especialidade esp) throws ObjetoJaExistenteException;

    public boolean existe(long codigo);
    
    public List<Especialidade> especialidadesDaUnidade(long unidadeSaudeId);
}
