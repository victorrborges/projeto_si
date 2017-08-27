package com.ufcg.si1.model.unidade;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.ufcg.si1.model.Endereco;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = PostoSaude.class, name = "posto"),
        @JsonSubTypes.Type(value = HospitalAdapter.class, name = "hospital")
})
@Entity
@Inheritance
public abstract class UnidadeSaude {
	
	@Id
	@GeneratedValue
    private Long id;

    private String descricao;
    
    @Enumerated(EnumType.STRING)
    private TipoUnidade tipoUnidade;
    
    @Embedded
    private Endereco endereco;

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
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public Endereco getEndereco() {
		return this.endereco;
	}
}
