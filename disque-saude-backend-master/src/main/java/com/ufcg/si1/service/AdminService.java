package com.ufcg.si1.service;

import com.ufcg.si1.model.Administrador;

import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoInvalidoException;
import exceptions.ObjetoJaExistenteException;

public interface AdminService {

	Administrador cadastrar(Administrador administrador) throws ObjetoJaExistenteException;
	
	Administrador logar(Administrador administrador) throws ObjetoInvalidoException, ObjetoInexistenteException;
	
}
