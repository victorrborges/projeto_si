package com.ufcg.si1.model.queixa;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SituacaoQueixa {
	ABERTA, FECHADA;

	private static Map<String, SituacaoQueixa> namesMap = new HashMap<String, SituacaoQueixa>(2);

	static {
		namesMap.put("FECHADA", FECHADA);
		namesMap.put("ABERTA", ABERTA);
	}

	@JsonCreator
	public static SituacaoQueixa forValue(String value) {
		return namesMap.get(value.toUpperCase());
	}

	@JsonValue
	public String toValue() {
		for (Entry<String, SituacaoQueixa> entry : namesMap.entrySet()) {
			if (entry.getValue() == this)
				return entry.getKey();
		}

		return null;
	}
}
