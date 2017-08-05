package com.ufcg.si1.service;


import java.util.Iterator;
import java.util.List;

import com.ufcg.si1.model.queixa.Queixa;

public interface QueixaService {

	public List<Queixa> findAllQueixas();
	
	public void registraQueixa(Queixa queixa);

    public Queixa findById(long id);

	public void updateQueixa(Queixa user);

	public void deleteQueixaById(long id);

    public int size();

    public int numeroDeQueixasAbertas();
	
}
