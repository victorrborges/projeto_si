package com.ufcg.si1.model.unidade;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
    private Long id;

    private String descricao;
    
    @Enumerated(EnumType.STRING)
    private TipoUnidade tipoUnidade;

    public UnidadeSaude(String descricao, TipoUnidade tipoUnidade) {
        this.descricao = descricao;
        this.tipoUnidade = tipoUnidade;
    }
    
    public UnidadeSaude() {
    	
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoUnidade getTipoUnidade() {
		return tipoUnidade;
	}

	public void setTipoUnidade(TipoUnidade tipoUnidade) {
		this.tipoUnidade = tipoUnidade;
	}
}
