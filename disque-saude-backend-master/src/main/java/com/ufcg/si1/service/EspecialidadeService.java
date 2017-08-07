package com.ufcg.si1.service;

import com.ufcg.si1.model.Especialidade;
import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;
import exceptions.Rep;

import java.util.Collection;
import java.util.List;


public interface EspecialidadeService {
    Especialidade procura(int codigo) throws Rep,
            ObjetoInexistenteException;

    public Collection<Especialidade> getListaEspecialidade()
                    throws Rep, ObjetoInexistenteException;

    public int size();

    public Especialidade getElemento(int posicao);

    public void insere(Especialidade esp)throws Rep,
            ObjetoJaExistenteException;

    public boolean existe(int codigo);

    public Especialidade findById(long id);
}
