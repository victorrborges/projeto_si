package com.ufcg.si1.service;

import com.ufcg.si1.model.Especialidade;
import com.ufcg.si1.model.UnidadeSaude;
import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;
import exceptions.Rep;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service("unidadeSaudeService")
public class UnidadeSaudeServiceImpl implements UnidadeSaudeService {
	private Object[] vetor;

	private int indice;

	private int geraCodigo = 0; // para gerar codigos das queixas cadastradas

	public UnidadeSaudeServiceImpl() {
		vetor = new Object[100];
		indice = 0;
	}

	@Override
	public Object procura(int codigo) throws Rep, ObjetoInexistenteException {
		int i = 0;
		while (i < indice) {
			if (vetor[i] instanceof UnidadeSaude) {
				UnidadeSaude unidadeSaude = (UnidadeSaude) vetor[i];
				if (unidadeSaude.getId() == codigo) {
					return vetor[i];
				}
			}
			i++;
		}
		throw new ObjetoInexistenteException("Não achou unidade");
	}

	@Override
	public List<Object> getAll() {
		return Arrays.asList(vetor);
	}

	@Override
	public void insere(Object us) throws Rep, ObjetoJaExistenteException {

		if (us == null) {
			throw new Rep("Erro!");
		} else {
			if (us instanceof UnidadeSaude) {
				((UnidadeSaude) us).setId(++geraCodigo);
			}
		}

		if (indice == this.vetor.length) {
			throw new Rep("Erro ao incluir no array");
		}

		if (us instanceof UnidadeSaude) {
			UnidadeSaude unidadeSaude = (UnidadeSaude) us;
			if (this.existe(unidadeSaude.getId())) {
				throw new ObjetoJaExistenteException("Objeto jah existe no array");
			}
		}

		this.vetor[indice] = us;
		indice++;
	}

	@Override
	public boolean existe(long codigo) {

		boolean existe = false;

		for (int i = 0; i < indice; i++) {
			if (this.vetor[i] instanceof UnidadeSaude) {
				UnidadeSaude unidadeSaude = (UnidadeSaude) vetor[i];
				if (unidadeSaude.getId() == codigo) {
					existe = true;
					break;
				}
			}
		}

		return existe;
	}

	public Object findById(long id) {
		for (Object esp : vetor) {
			if (esp instanceof UnidadeSaude) {
				UnidadeSaude unidadeSaude = (UnidadeSaude) esp;
				if (unidadeSaude != null && unidadeSaude.getId() == id) {
					return unidadeSaude;
				}
			}
		}
		return null;
	}

	@Override
	public Object findByBairro(String bairro) {
		for (Object esp : vetor) {
			if (esp instanceof UnidadeSaude) {
				UnidadeSaude u = (UnidadeSaude) esp;
				if (u.pegaDescricao().equals(bairro)) {
					return esp;
				}
			}
		}
		return null;
	}

}
