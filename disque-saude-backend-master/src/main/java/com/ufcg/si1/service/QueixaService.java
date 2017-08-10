package com.ufcg.si1.service;

import java.util.List;
import com.ufcg.si1.model.Queixa;

import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;

public interface QueixaService {

	public List<Queixa> findAllQueixas();
	
	public void save(Queixa queixa) throws ObjetoJaExistenteException;

    public Queixa findOneQueixa(long id) throws ObjetoInexistenteException;

	public void updateQueixa(Queixa user) throws ObjetoInexistenteException;

	public void deleteQueixa(long id) throws ObjetoInexistenteException;
	
	public double razaoQueixas();
	
}
