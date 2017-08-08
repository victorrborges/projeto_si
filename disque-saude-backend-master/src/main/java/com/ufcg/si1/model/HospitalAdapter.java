package com.ufcg.si1.model;

import java.util.List;

import br.edu.ufcg.Hospital;

public class HospitalAdapter extends PostoSaude {

	private Hospital hospital;
	

    public void addQueixaProxima(long id) {
    	// TODO
    }

    public String pegaDescricao() {
        return this.hospital.getDescricao();
    }

    public void mudaDescricao(String descricao) {
        this.hospital.setDescricao(descricao);
    }

    @SuppressWarnings("unchecked")
	public List<Especialidade> getEspecialidades() {
        return this.hospital.getEspecialidades();
    }

    public void adicionarEspecialidade(Especialidade esp) {
    	List<Especialidade> especialidades = this.getEspecialidades();
    	especialidades.add(esp);
        this.hospital.setEspecialidades(especialidades);
    }

    public int pegaCodigo() {
        return this.hospital.getCodigo();
    }

    public void mudaCodigo(int cod) {
        this.hospital.setCodigo(cod);
    }
	
    public int getAtendentes() {
        return this.hospital.getNumeroMedicos();
    }

    public void setAtendentes(int atendentes) {
        this.hospital.setNumeroMedicos(atendentes);
    }

    public float getTaxaDiariaAtendimentos() {
        return this.hospital.getNumeroPacientesDia();
    }

    public void setTaxaDiariaAtendimentos(float taxaDiariaAtendimentos) {
        this.hospital.setNumeroPacientesDia(taxaDiariaAtendimentos);
    }
}
