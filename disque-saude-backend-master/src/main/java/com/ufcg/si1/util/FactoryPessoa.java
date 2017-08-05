package com.ufcg.si1.util;

import com.ufcg.si1.model.Endereco;
import com.ufcg.si1.model.Pessoa;

public class FactoryPessoa {
	
	public FactoryPessoa() {
		
	}
	
	public static Pessoa criaPessoa(String nome, String email,
			  String rua, String uf, String cidade) {
		System.out.println("============>");
		Endereco endereco = new Endereco();
		endereco.setCidade(cidade);
		endereco.setRua(rua);
		endereco.setUf(uf);
		Pessoa pessoa = new Pessoa();
		pessoa.setEmail(email);
		pessoa.setNome(nome);
		pessoa.setEndereco(endereco);
		return pessoa;
	}

}
