package com.ufcg.si1.model.queixa;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import exceptions.ObjetoInvalidoException;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Fechada.class, name = "fechada"),
        @JsonSubTypes.Type(value = EmAndamento.class, name = "em_andamento"),
        @JsonSubTypes.Type(value = Aberta.class, name = "aberta")
})

@Embeddable
public abstract class QueixaState {

	public abstract QueixaState abrir() throws ObjetoInvalidoException;

	public abstract QueixaState fechar() throws ObjetoInvalidoException;

}
