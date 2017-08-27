package com.ufcg.si1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ufcg.si1.model.unidade.HospitalAdapter;
import com.ufcg.si1.model.unidade.PostoSaude;
import com.ufcg.si1.model.unidade.UnidadeSaude;
import com.ufcg.si1.service.UnidadeSaudeService;
import com.ufcg.si1.service.UnidadeSaudeServiceImpl;
import com.ufcg.si1.util.CustomErrorType;
import com.ufcg.si1.util.ObjWrapper;

import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;
import exceptions.Rep;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UnidadeSaudeController {
	
	@Autowired
	private UnidadeSaudeService unidadeSaudeService = new UnidadeSaudeServiceImpl();

	@RequestMapping(value = "/unidade/", method = RequestMethod.GET)
	public ResponseEntity<?> getAllUnidades() {
		List<UnidadeSaude> unidades = unidadeSaudeService.findAllUnidades();
		if (unidades.isEmpty())
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else {
			return new ResponseEntity<>(unidades, HttpStatus.OK);
		}
	}

	// how to save a subclass object?
	@RequestMapping(value = "/unidade/", method = RequestMethod.POST)
	public ResponseEntity<String> incluirUnidadeSaude(@RequestBody UnidadeSaude unidadeSaude, UriComponentsBuilder ucBuilder) {
		try {
			unidadeSaudeService.save(unidadeSaude);
			
			HttpHeaders headers = new HttpHeaders();
			//headers.setLocation(ucBuilder.path("/api/unidade/{id}").buildAndExpand(unidadeSaude.getId()).toUri());
			return new ResponseEntity<String>( HttpStatus.CREATED);
		} catch (Rep e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		} catch (ObjetoJaExistenteException e) {
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/unidade/busca/{bairro}", method = RequestMethod.GET)
	public ResponseEntity<?> consultarUnidadeSaudePorBairro(@PathVariable("bairro") String bairro) {
		try {
			List<UnidadeSaude>unidades = unidadeSaudeService.findByBairro(bairro);
			return new ResponseEntity<List<UnidadeSaude>>(unidades, HttpStatus.OK);
		} catch (ObjetoInexistenteException e) {
			return new ResponseEntity(new CustomErrorType("Unidade with bairro " + bairro + " not found"),
					HttpStatus.NOT_FOUND);
		}
		
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/unidade/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> consultarUnidadeSaude(@PathVariable("id") Long id) {
		try {
			UnidadeSaude unidadeSaude = unidadeSaudeService.findOneUnidade(id);
			return new ResponseEntity<>(unidadeSaude, HttpStatus.OK);
		} catch (ObjetoInexistenteException e) {
			return new ResponseEntity(new CustomErrorType("Unidade with id " + id + " not found"),
					HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/geral/medicos/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> calcularMediaMedicoPacienteDia(@PathVariable("id") Long id) {

		try {
			PostoSaude unidadeSaude = (PostoSaude) unidadeSaudeService.findOneUnidade(id);
			
			double c = (unidadeSaude.getAtendentes() / unidadeSaude.getTaxaDiariaAtendimentos());
			return new ResponseEntity<ObjWrapper<Double>>(new ObjWrapper<Double>(new Double(c)), HttpStatus.OK);
			
		} catch (ObjetoInexistenteException e) {
			return new ResponseEntity<ObjWrapper<Double>>(HttpStatus.NOT_FOUND);
		}
	}

}
