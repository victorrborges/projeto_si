package com.ufcg.si1.model.prefeitura;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Normal.class, name = "normal"),
        @JsonSubTypes.Type(value = Extra.class, name = "extra"),
        @JsonSubTypes.Type(value = Caos.class, name = "caos")
})

@Entity
public class Prefeitura {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private static Prefeitura instancia;
	
	@Embedded
	private AcoesPrefeitura acoes;
	
	private Prefeitura(String situacao) throws Exception {
		acoes = alteraSituacao(situacao);
		
	}

	private AcoesPrefeitura alteraSituacao(String situacao) throws Exception {
		if(situacao.equalsIgnoreCase("normal")) {
			return new Normal();
		}
		
		if(situacao.equalsIgnoreCase("caos")) {
			return new Caos();
		}
		
		if(situacao.equalsIgnoreCase("extra")) {
			return new Extra();
		}
		
		throw new Exception("Situacao da prefeitura invalida");
	}
	
	public void setSituacao(String situacao) throws Exception {
		acoes = this.alteraSituacao(situacao);
	}
	
	public AcoesPrefeitura getSituacao() {
		return this.acoes;
	}
	
	public static Prefeitura getInstancia() {
		if (instancia == null) {
			try {
				instancia = new Prefeitura("normal");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return instancia;
		} else {
			return instancia;
		}
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public int getEficiencia(double razao) {
		System.out.println("razao na preifeitura: " + razao);
		return acoes.getEficiencia(razao);
	}
	

}
