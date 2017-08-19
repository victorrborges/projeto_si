package com.ufcg.si1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufcg.si1.model.Administrador;
import com.ufcg.si1.repository.AdminRepository;

import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoInvalidoException;
import exceptions.ObjetoJaExistenteException;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	AdminRepository adminRepository;

	@Override
	public Administrador cadastrar(Administrador administrador)
			throws ObjetoJaExistenteException {
//		if (this.existe(administrador)) {
//			throw new ObjetoJaExistenteException("Administrador ja cadastrado");
//		}
		return this.adminRepository.save(administrador);
	}
	
	private boolean existe(Administrador administrador) {
		if (adminRepository.exists(administrador.getId())) {
			return true;
		}
		for (Administrador administradorBd : this.adminRepository.findAll()) {
			if (administrador.getLogin().equals(administradorBd.getLogin())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Administrador logar(Administrador administrador) throws ObjetoInvalidoException, ObjetoInexistenteException {
		return this.logar(administrador.getLogin(), administrador.getSenha());
	}

	private Administrador logar(String login, String senha) throws ObjetoInvalidoException, ObjetoInexistenteException {
		for (Administrador administrador : this.adminRepository.findAll()) {
			if (administrador.getLogin().equals(login)) {
				if (administrador.getSenha().equals(senha)) {
					return administrador;
				} else {
					throw new ObjetoInvalidoException("Senha incorreta");
				}
			}
		}
		throw new ObjetoInexistenteException("Administrador nao cadastrado");
	}

	
}
