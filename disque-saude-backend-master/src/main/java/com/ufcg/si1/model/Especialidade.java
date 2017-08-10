package com.ufcg.si1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Especialidade {

	@Id
	@GeneratedValue
    private long id;

    private String descricao;
    
    private long unidadeSaudeId;

//    public Especialidade(String descricao) {
//        this.descricao = descricao;
//    }
    
    public Especialidade(String descricao, long unidadeSaudeId) {
        this.descricao = descricao;
        this.unidadeSaudeId = unidadeSaudeId;
    }

    public Especialidade(){

    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUnidadeSaudeId() {
		return unidadeSaudeId;
	}

	public void setUnidadeSaudeId(long unidadeSaudeId) {
		this.unidadeSaudeId = unidadeSaudeId;
	}

   
}
