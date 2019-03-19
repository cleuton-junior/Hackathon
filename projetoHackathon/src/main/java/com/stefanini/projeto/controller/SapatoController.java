package com.stefanini.projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.stefanini.projeto.exception.TreinaException;
import com.stefanini.projeto.model.Sapato;
import com.stefanini.projeto.service.SapatoService;

@CrossOrigin
@Controller
@RequestMapping(value = "/sapato")
public class SapatoController {

	@Autowired
	private SapatoService service;
	
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody Sapato criarSapato(@RequestBody Sapato sapato) {
		 return service.salvarSapato(sapato);
		
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) throws TreinaException {
		 service.removerSapato(id);
		
	}
	
	
}
