package com.ufcg.si1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ufcg.si1.model.Administrador;
import com.ufcg.si1.service.AdminService;
import com.ufcg.si1.service.AdminServiceImpl;

import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoInvalidoException;
import exceptions.ObjetoJaExistenteException;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AdminController {
	
	@Autowired
	private AdminService adminService = new AdminServiceImpl();
	
	 @RequestMapping(value = "/admin/", method = RequestMethod.POST) 
	 public ResponseEntity<Administrador> cadastrar(@RequestBody Administrador administrador) {
		 try {
			 Administrador administradorCadastrado = this.adminService.cadastrar(administrador);
			 return new ResponseEntity<Administrador>(administradorCadastrado, HttpStatus.CREATED);
		 } catch (ObjetoJaExistenteException e) {
			 return new ResponseEntity<>(HttpStatus.CONFLICT);
		 }
	 }
	 
	 @RequestMapping(value = "/admin/login/", method = RequestMethod.GET)
	 public void logar() {
		 System.out.println("=========>");
//		 try {
//			 Administrador administradorLogado = this.adminService.logar(administrador);
//			 return new ResponseEntity<Administrador>(administradorLogado, HttpStatus.OK);
//		 } catch (ObjetoInexistenteException e) {
//			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		 } catch (ObjetoInvalidoException e) {
//			 return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//		 }
	 }

}
