package com.ufcg.si1.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ufcg.si1.model.Especialidade;
import com.ufcg.si1.model.unidade.UnidadeSaude;
import com.ufcg.si1.service.EspecialidadeService;
import com.ufcg.si1.service.EspecialidadeServiceImpl;
import com.ufcg.si1.service.UnidadeSaudeService;
import com.ufcg.si1.service.UnidadeSaudeServiceImpl;
import com.ufcg.si1.util.CustomErrorType;

import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;
import exceptions.Rep;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class EspecialidadesController {

	@Autowired
	private EspecialidadeService especialidadeService = new EspecialidadeServiceImpl();

	@Autowired
	private UnidadeSaudeService unidadeSaudeService = new UnidadeSaudeServiceImpl();

	@RequestMapping(value = "/especialidade/", method = RequestMethod.POST)
	public ResponseEntity<String> incluirEspecialidade(@RequestBody Especialidade esp, UriComponentsBuilder ucBuilder) {

		try {
			this.especialidadeService.save(esp);
		} catch (ObjetoJaExistenteException e) {
			return new ResponseEntity<String>("Objeto ja existente", HttpStatus.CONFLICT);
		}

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/especialidade/{id}").buildAndExpand(esp.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/especialidade/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> consultarEspecialidade(@PathVariable("id") Long id) {

		try {
			Especialidade especialidadeConsultada = especialidadeService.findOneEspecialidade(id);
			return new ResponseEntity<Especialidade>(especialidadeConsultada, HttpStatus.OK);
		} catch (Rep e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		} catch (ObjetoInexistenteException e) {
			return new ResponseEntity(new CustomErrorType("Especialidade with id " + id + " not found"),
					HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "unidade/{unidadeSaudeId}/especialidades/", method = RequestMethod.GET)
	public ResponseEntity<?> consultaEspecialidadeporUnidadeSaude(@RequestBody Long unidadeSaudeId) {

		List<Especialidade> especialidades = especialidadeService.getEspecialidadesDaUnidade(unidadeSaudeId);
		return new ResponseEntity<>(especialidades, HttpStatus.OK);

	}

	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "especialidade/{descricao}/unidades", method = RequestMethod.GET)
	public ResponseEntity<?> unidadesComAEspecialidade(@PathVariable("descricao") String descricao) {
		List<Long> unidadesIds;
		try {
			unidadesIds = this.especialidadeService.getUnidadesPorEspecialidade(descricao);
			return getUnidadesPorId(unidadesIds);
		} catch (ObjetoInexistenteException e) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}

	}

	private ResponseEntity<?> getUnidadesPorId(List<Long> unidadesIds) throws ObjetoInexistenteException {
		List<UnidadeSaude> unidades = new ArrayList<UnidadeSaude>();
		for (Long id : unidadesIds) {
			unidades.add(this.unidadeSaudeService.findOneUnidade(id));
		}
		return new ResponseEntity<List<UnidadeSaude>>(unidades, HttpStatus.OK);
	}

}
