package com.ufcg.si1.service;

import java.util.List;

import com.ufcg.si1.model.queixa.Queixa;
import com.ufcg.si1.model.queixa.QueixaAnimal;

import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;

public interface QueixaService {

	public List<Queixa> findAllQueixas();
	
	public void save(Queixa queixa) throws ObjetoJaExistenteException;
	
	public void save(QueixaAnimal queixaAnimal) throws ObjetoJaExistenteException;

    public Queixa findOneQueixa(Long id) throws ObjetoInexistenteException;

	public void updateQueixa(Queixa user) throws ObjetoInexistenteException;

	public void deleteQueixa(Long id) throws ObjetoInexistenteException;
	
	public double razaoQueixas();
	
}
