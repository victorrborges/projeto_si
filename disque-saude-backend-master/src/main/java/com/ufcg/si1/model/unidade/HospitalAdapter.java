package com.ufcg.si1.model.unidade;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;

@Entity
public class HospitalAdapter extends UnidadeSaude {

	@ElementCollection
	List<String> especialidades;

	private int atendentes;

	private float taxaDiariaAtendimentos;

	public String getDescricao() {
		return super.getDescricao();
	}

	public void setDescricao(String descricao) {
		super.setDescricao(descricao);
	}

	public List<String> getEspecialidades() {
		return this.especialidades;
	}

	public void setEspecialidades(List<String> especialidades) {
		this.especialidades = especialidades;
	}

	public int getAtendentes() {
		return atendentes;
	}

	public void setAtendentes(int atendentes) {
		this.atendentes = atendentes;
	}

	public float getTaxaDiariaAtendimentos() {
		return taxaDiariaAtendimentos;
	}

	public void setTaxaDiariaAtendimentos(float taxaDiariaAtendimentos) {
		this.taxaDiariaAtendimentos = taxaDiariaAtendimentos;
	}
	
}
