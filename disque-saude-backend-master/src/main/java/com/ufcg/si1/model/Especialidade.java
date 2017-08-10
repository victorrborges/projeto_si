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

    public Especialidade(String descricao) {
        this.descricao = descricao;
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

   
}
