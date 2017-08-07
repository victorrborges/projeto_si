package com.ufcg.si1.controller;

import java.util.List;

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

import com.ufcg.si1.model.UnidadeSaude;
import com.ufcg.si1.model.queixa.Queixa;
import com.ufcg.si1.service.QueixaService;
import com.ufcg.si1.service.QueixaServiceImpl;
import com.ufcg.si1.util.CustomErrorType;
import com.ufcg.si1.util.ObjWrapper;

import exceptions.ObjetoInvalidoException;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class QueixaController {

	private QueixaService queixaService = new QueixaServiceImpl();

	/*
	 * situação normal =0 situação extra =1
	 */
	private int situacaoAtualPrefeitura = 0;

	// -------------------Retrieve All
	// Complaints---------------------------------------------

	@RequestMapping(value = "/queixa/", method = RequestMethod.GET)
	public ResponseEntity<List<Queixa>> listAllUsers() {
		List<Queixa> queixas = queixaService.findAllQueixas();

		if (queixas.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Queixa>>(queixas, HttpStatus.OK);
	}

	// -------------------Abrir uma
	// Queixa-------------------------------------------

	@RequestMapping(value = "/queixa/", method = RequestMethod.POST)
	public ResponseEntity<?> abrirQueixa(@RequestBody Queixa queixa, UriComponentsBuilder ucBuilder) {

		// este codigo estava aqui, mas nao precisa mais
		/*
		 * if (queixaService.doesQueixaExist(queixa)) { return new
		 * ResponseEntity(new CustomErrorType("Esta queixa já existe+
		 * queixa.pegaDescricao()),HttpStatus.CONFLICT); }
		 */

		// TODO: VERIFICAR SE A QUEIXA JA EXISTE
		queixaService.registraQueixa(queixa);

		return new ResponseEntity<Queixa>(queixa, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/queixa/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> consultarQueixa(@PathVariable("id") long id) {

		Queixa q = queixaService.findById(id);
		if (q == null) {
			return new ResponseEntity(new CustomErrorType("Queixa with id " + id + " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Queixa>(q, HttpStatus.OK);
	}

	@RequestMapping(value = "/queixa/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateQueixa(@PathVariable("id") long id, @RequestBody Queixa queixa) {

		Queixa currentQueixa = queixaService.findById(id);

		if (currentQueixa == null) {
			return new ResponseEntity(new CustomErrorType("Unable to upate. Queixa with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		currentQueixa.setDescricao(queixa.getDescricao());
		currentQueixa.setComentario(queixa.getComentario());

		queixaService.updateQueixa(currentQueixa);
		return new ResponseEntity<Queixa>(currentQueixa, HttpStatus.OK);
	}

	@RequestMapping(value = "/queixa/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {

		Queixa user = queixaService.findById(id);
		if (user == null) {
			return new ResponseEntity(new CustomErrorType("Unable to delete. Queixa with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		queixaService.deleteQueixaById(id);
		return new ResponseEntity<Queixa>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/queixa/fechamento", method = RequestMethod.POST)
	public ResponseEntity<?> fecharQueixa(@RequestBody Queixa queixaAFechar) {
		try {
			queixaAFechar.fechar("fechar");
		} catch (ObjetoInvalidoException e) {
			return new ResponseEntity<Queixa>(queixaAFechar, HttpStatus.BAD_REQUEST);
		}
		queixaService.updateQueixa(queixaAFechar);
		return new ResponseEntity<Queixa>(queixaAFechar, HttpStatus.OK);
	}

	@RequestMapping(value = "/geral/situacao", method = RequestMethod.GET)
	public ResponseEntity<?> getSituacaoGeralQueixas() {

		// dependendo da situacao da prefeitura, o criterio de avaliacao muda
		// se normal, mais de 20% abertas eh ruim, mais de 10 eh regular
		// se extra, mais de 10% abertas eh ruim, mais de 5% eh regular
		if (situacaoAtualPrefeitura == 0) {
			if ((double) numeroQueixasAbertas() / queixaService.numeroDeQueixasTotais() > 0.2) {
				return new ResponseEntity<ObjWrapper<Integer>>(new ObjWrapper<Integer>(0), HttpStatus.OK);
			} else {
				if ((double) numeroQueixasAbertas() / queixaService.numeroDeQueixasTotais() > 0.1) {
					return new ResponseEntity<ObjWrapper<Integer>>(new ObjWrapper<Integer>(1), HttpStatus.OK);
				}
			}
		}
		if (this.situacaoAtualPrefeitura == 1) {
			if ((double) numeroQueixasAbertas() / queixaService.numeroDeQueixasTotais() > 0.1) {
				return new ResponseEntity<ObjWrapper<Integer>>(new ObjWrapper<Integer>(0), HttpStatus.OK);
			} else {
				if ((double) numeroQueixasAbertas() / queixaService.numeroDeQueixasTotais() > 0.05) {
					return new ResponseEntity<ObjWrapper<Integer>>(new ObjWrapper<Integer>(1), HttpStatus.OK);
				}
			}
		}

		// situacao retornada
		// 0: RUIM
		// 1: REGULAR
		// 2: BOM
		return new ResponseEntity<ObjWrapper<Integer>>(new ObjWrapper<Integer>(2), HttpStatus.OK);
	}

	private double numeroQueixasAbertas() {
		return this.queixaService.numeroDeQueixasAbertas();
	}

}
