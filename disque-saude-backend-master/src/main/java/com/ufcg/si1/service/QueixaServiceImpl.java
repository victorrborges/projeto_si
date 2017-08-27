package com.ufcg.si1.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.ufcg.si1.model.queixa.Queixa;
import com.ufcg.si1.model.queixa.QueixaAnimal;
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
		this.queixaRepository.save(queixa);
	}

	public void save(QueixaAnimal queixaAnimal) throws ObjetoJaExistenteException {
		this.queixaRepository.save(queixaAnimal);
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
		this.queixaRepository.delete(queixaId);
	}

	public Queixa findOneQueixa(Long queixaId) throws ObjetoInexistenteException {
		return this.queixaRepository.findOne(queixaId);
	}

	@Override
	public double razaoQueixas() {
		double queixasTotais = this.findAllQueixas().size();

		if (queixasTotais == 0) {
			return 0;
		}

		double queixasAbertas = 0;
		for (Queixa queixa : this.findAllQueixas()) {
			if (queixa.getSituacao().equals(SituacaoQueixa.ABERTA)) {
				queixasAbertas++;
			}
		}
		System.out.println("queixas abertas: " + queixasAbertas);
		System.out.println("queixas totais: " + queixasTotais);
		System.out.println("indice: " + queixasAbertas / queixasTotais);

		return (queixasAbertas / queixasTotais);
	}

}
