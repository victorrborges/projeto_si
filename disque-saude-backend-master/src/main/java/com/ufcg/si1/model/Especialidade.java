package com.ufcg.si1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Especialidade {

	@Id
	@GeneratedValue
    private Long id;

    private String descricao;
    
    private Long unidadeSaudeId;

//    public Especialidade(String descricao) {
//        this.descricao = descricao;
//    }
    
    public Especialidade(String descricao, Long unidadeSaudeId) {
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUnidadeSaudeId() {
		return unidadeSaudeId;
	}

	public void setUnidadeSaudeId(Long unidadeSaudeId) {
		this.unidadeSaudeId = unidadeSaudeId;
	}

   
}
