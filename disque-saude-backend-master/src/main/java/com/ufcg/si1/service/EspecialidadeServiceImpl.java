package com.ufcg.si1.service;

import com.ufcg.si1.model.Especialidade;
import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;
import exceptions.Rep;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service("especialidadeService")
public class EspecialidadeServiceImpl implements EspecialidadeService {

	private Map<Integer, Especialidade> especialidades;
		
    private int geraCodigo;

    public EspecialidadeServiceImpl() {
    	this.especialidades = new HashMap<Integer, Especialidade>();
    	this.geraCodigo = 0;
    }

    @Override
    public Especialidade procura(int codigo) throws Rep,
            ObjetoInexistenteException {

    	Especialidade especialidadeProcurada = this.especialidades.get(codigo);
    	
    	
    	if (especialidadeProcurada != null)
			return especialidadeProcurada;
		else
			throw new ObjetoInexistenteException("Erro Especialidade");
    	
    }

    @Override
    public Collection<Especialidade> getListaEspecialidade()
            throws Rep, ObjetoInexistenteException {
    	
    	return this.especialidades.values();
    
    }

    @Override
    public int size() {
        return this.especialidades.size();
    }

    @Override
    public Especialidade getElemento(int posicao) {
        if (this.especialidades.containsKey(posicao))
        	return this.especialidades.get(posicao);
        else
            return null;
    }

    @Override
    public void insere(Especialidade esp) throws Rep,
            ObjetoJaExistenteException {

        esp.setCodigo(++geraCodigo);
        
        int chaveDaNovaEsp = this.especialidades.size();

        if (this.existe(esp.getCodigo())) {
            throw new ObjetoJaExistenteException("Objeto jah existe no array");
        }

        this.especialidades.put(chaveDaNovaEsp, esp);
    }

    @Override
    public boolean existe(int codigo) {
    	
        return (this.findById(codigo) != null) ? true:false;

    }

    public Especialidade findById(long id) {
        
    	Collection<Especialidade> colecaoDeEspecialidades = this.especialidades.values();
    	
    	for (Especialidade especialidade : colecaoDeEspecialidades) {
			if (especialidade.getCodigo() == id) {
				return especialidade;
			}
		}   	

        return null;
    }


}
