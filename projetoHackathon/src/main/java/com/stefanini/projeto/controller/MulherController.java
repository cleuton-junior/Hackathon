package com.stefanini.projeto.controller;

import java.io.IOException;
import java.net.URI;
import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.stefanini.projeto.exception.TreinaException;
import com.stefanini.projeto.exception.ValidacaoMulherException;
import com.stefanini.projeto.model.Mulher;
import com.stefanini.projeto.service.MulherService;

@CrossOrigin
@Controller
@RequestMapping(value = "/mulher")
public class MulherController {

	@Autowired
	private MulherService service;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Mulher> findAll() throws TreinaException {
		return service.findAll();
	}

	@DeleteMapping("/{id}")
	public @ResponseBody ResponseEntity<Void> remover(@PathVariable("id") String id)
			throws IOException, TreinaException {
		Mulher mulher = service.buscarCodigo(Long.parseLong(id));
		service.remover(mulher);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	@Transactional
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> criar(@RequestBody Mulher mulher) {
		try {

			Mulher mulherSalva = service.salvar(mulher);
			URI location = URI.create("/id/" + mulherSalva.getId());
			return ResponseEntity.created(location).build();
		} catch (ValidacaoMulherException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}

	@GetMapping("/{id}")
	public @ResponseBody Mulher buscarPeloCodigo(@PathVariable("id") String id)
			throws NumberFormatException, IOException {
		return service.buscarCodigo(Long.parseLong(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Mulher> atualizar(@PathVariable Long id, @Valid @RequestBody Mulher mulher) {
		Mulher mulherSalva = service.atualizar(id, mulher);
		return ResponseEntity.ok(mulherSalva);
	}

}

