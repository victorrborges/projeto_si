package com.ufcg.si1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ufcg.si1.model.prefeitura.Caos;
import com.ufcg.si1.model.prefeitura.Prefeitura;
import com.ufcg.si1.service.PrefeituraService;
import com.ufcg.si1.service.PrefeituraServiceImpl;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PrefeituraController {
	
	@Autowired
	private PrefeituraService prefeituraService = new PrefeituraServiceImpl();
	
	@RequestMapping(value = "/prefeitura/{situacao}", method = RequestMethod.POST)
	public ResponseEntity mudarSituacaoPrefeitura(@PathVariable("situacao") String situacao) {
		try {
			Prefeitura.getInstancia().setSituacao(situacao);
			return new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		
	}
	
}
