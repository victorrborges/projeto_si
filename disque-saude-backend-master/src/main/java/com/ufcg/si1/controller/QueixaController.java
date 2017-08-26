package com.ufcg.si1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ufcg.si1.model.queixa.Queixa;
import com.ufcg.si1.service.PrefeituraService;
import com.ufcg.si1.service.PrefeituraServiceImpl;
import com.ufcg.si1.service.QueixaService;
import com.ufcg.si1.service.QueixaServiceImpl;
import com.ufcg.si1.util.CustomErrorType;
import com.ufcg.si1.util.ObjWrapper;

import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class QueixaController {

	@Autowired
	private QueixaService queixaService = new QueixaServiceImpl();

	@Autowired
	private PrefeituraService prefeituraService = new PrefeituraServiceImpl();


	// -------------------Retrieve All
	// Complaints---------------------------------------------

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/queixa/", method = RequestMethod.GET)
	public ResponseEntity<List<Queixa>> listAllQueixas() {

		List<Queixa> queixas = queixaService.findAllQueixas();

		if (queixas.isEmpty()) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Queixa>>(queixas, HttpStatus.OK);
	}

	// -------------------Abrir uma
	// Queixa-------------------------------------------

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/queixa/", method = RequestMethod.POST)
	public ResponseEntity<?> abrirQueixa(@RequestBody Queixa queixa, UriComponentsBuilder ucBuilder) {
		try {
			queixaService.save(queixa);
		} catch (ObjetoJaExistenteException e) {
			return new ResponseEntity(new CustomErrorType("Esta queixa já existe"),
					HttpStatus.CONFLICT);
		}

		return new ResponseEntity<Object>(queixa, HttpStatus.CREATED);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/queixa/{queixaId}", method = RequestMethod.GET)
	public ResponseEntity<?> consultarQueixa(@PathVariable("queixaId") Long queixaId) {

		try {
			Queixa queixa = queixaService.findOneQueixa(queixaId);
			return new ResponseEntity<Queixa>(queixa, HttpStatus.OK);
		} catch (ObjetoInexistenteException e) {
			return new ResponseEntity(new CustomErrorType("Queixa with id " + queixaId + " not found"),
					HttpStatus.NOT_FOUND);
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/queixa/{queixaId}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateQueixa(@PathVariable("queixaId") Long queixaId, @RequestBody Queixa queixa) {
		try {
			Queixa currentQueixa = queixaService.findOneQueixa(queixaId);
			
			currentQueixa.setSituacao(queixa.getSituacao());
			currentQueixa.setComentario(queixa.getComentario());

			queixaService.updateQueixa(currentQueixa);
			return new ResponseEntity<Queixa>(currentQueixa, HttpStatus.OK);

		} catch (ObjetoInexistenteException e) {
			return new ResponseEntity(
					new CustomErrorType("Unable to upate. Queixa with id " + queixaId + " not found."),
					HttpStatus.NOT_FOUND);
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/queixa/{queixaId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@PathVariable("queixaId") Long queixaId) {

		try {
			queixaService.deleteQueixa(queixaId);
			return new ResponseEntity<Queixa>(HttpStatus.NO_CONTENT);
		} catch (ObjetoInexistenteException e) {
			return new ResponseEntity(
					new CustomErrorType("Unable to delete. Queixa with id " + queixaId + " not found."),
					HttpStatus.NOT_FOUND);
		}

	}


	@RequestMapping(value = "/geral/situacao", method = RequestMethod.GET)
	public ResponseEntity<?> getSituacaoGeralQueixas() {

		Integer eficiencia = this.prefeituraService.getEficiencia(this.queixaService.razaoQueixas());
		System.out.println(eficiencia);
		return new ResponseEntity<ObjWrapper<Integer>>(new ObjWrapper<Integer>(eficiencia), HttpStatus.OK);
	}

}
