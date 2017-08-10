package com.ufcg.si1.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = PostoSaude.class, name = "posto")
})

@Entity
public class UnidadeSaude {
	
	@Id
	@GeneratedValue
    private long id;

    private String descricao;

    private long [] numeroQueixas = new long[1000];
    int contador = 0;

    public UnidadeSaude(String descricao) {
        this.descricao = descricao;
    }
    
    public UnidadeSaude() {
    	
    }

    public void addQueixaProxima(long id) {
        if (this instanceof PostoSaude){
            numeroQueixas[contador++] = id;
        }
    }

    public String pegaDescricao() {
        return this.descricao;
    }

    public void mudaDescricao(String descricao) {
        this.descricao = descricao;
    }

    // Método abaixo será implementado no service (varrer todas as queixas no db e 
    // retornar as que possuem o id da Unidade de Saude).
    
//    public List<Especialidade> getEspecialidades() {
//        return this.especialidades;
//    }
//
//    public void adicionarEspecialidade(Especialidade esp) {
//        this.especialidades.add(esp);
//    }
    
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
    

}
