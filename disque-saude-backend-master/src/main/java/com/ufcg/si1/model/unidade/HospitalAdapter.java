package com.ufcg.si1.model.unidade;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;

import com.ufcg.si1.model.Especialidade;

import br.edu.ufcg.Hospital;

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

    @SuppressWarnings("unchecked")
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


//    public void adicionarEspecialidade(Especialidade esp) {
//    	List<Especialidade> especialidades = this.getEspecialidades();
//    	especialidades.add(esp);
//        this.hospital.setEspecialidades(especialidades);
//    }

//    public int pegaCodigo() {
//        return this.hospital.getCodigo();
//    }
//
//    public void mudaCodigo(int cod) {
//        this.hospital.setCodigo(cod);
//    }
//	
//    public int getAtendentes() {
//    	super.get
//    }
//
//    public void setAtendentes(int atendentes) {
//        this.hospital.setNumeroMedicos(atendentes);
//    }
//
//    public float getTaxaDiariaAtendimentos() {
//        return this.hospital.getNumeroPacientesDia();
//    }
//
//    public void setTaxaDiariaAtendimentos(float taxaDiariaAtendimentos) {
//        this.hospital.setNumeroPacientesDia(taxaDiariaAtendimentos);
//    }
}
