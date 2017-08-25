package com.ufcg.si1.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.ufcg.si1.model.queixa.Queixa;
import com.ufcg.si1.model.queixa.SituacaoQueixa;
import com.ufcg.si1.repository.QueixaRepository;

import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;

import java.util.List;


@Service("queixaService")
public class QueixaServiceImpl implements QueixaService {
	
	@Autowired
	QueixaRepository queixaRepository;

    public List<Queixa> findAllQueixas() {
        return this.queixaRepository.findAll();
    }

    public void save(Queixa queixa) throws ObjetoJaExistenteException {
 //   	if (this.existe(queixa)) {
   // 		throw new ObjetoJaExistenteException("Queixa ja existente");
    //	}
        this.queixaRepository.save(queixa);       
    }

    public void updateQueixa(Queixa queixa) throws ObjetoInexistenteException {
    	if (!this.existe(queixa)) {
    		throw new ObjetoInexistenteException("Queixa nao existente");
    	}
    	this.queixaRepository.save(queixa);
    }
    
    private boolean existe(Queixa queixa) {
    	return this.queixaRepository.exists(queixa.getId());
        
    }

    public void deleteQueixa(Long queixaId) throws ObjetoInexistenteException {
   // 	if (!this.existe(queixaId)) {
    //		throw new ObjetoInexistenteException("Queixa nao existente");
    	//}
    	this.queixaRepository.delete(queixaId);
    }

    public Queixa findOneQueixa(Long queixaId) throws ObjetoInexistenteException {
    //	if (!this.existe(queixaId)) {
    //		throw new ObjetoInexistenteException("Queixa nao existente");
    //	}
        return this.queixaRepository.findOne(queixaId);
    }
    
 //   private boolean existe(Long queixaId) {
  //      return this.queixaRepository.exists(queixaId);
   // }

	@Override
	public double razaoQueixas() {
		int queixasTotais = this.findAllQueixas().size();
		int queixasAbertas = 0;
//		for (Queixa queixa : this.findAllQueixas()) {
//			if (queixa.getSituacao().equals(SituacaoQueixa.ABERTA)) {
//				queixasAbertas++;
//			}
//		}
		return (queixasAbertas / queixasTotais);
	}

}
