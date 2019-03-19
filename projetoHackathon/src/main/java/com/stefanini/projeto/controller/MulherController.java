package com.stefanini.projeto.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
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

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) throws TreinaException {
		service.remover(id);

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
	public ResponseEntity<Optional<Mulher>> buscarPeloCodigo(@PathVariable Long id) {
		return service.buscarCodigo(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Mulher> atualizar(@PathVariable Long id, @Valid @RequestBody Mulher mulher) {
		Mulher mulherSalva = service.atualizar(id, mulher);
		return ResponseEntity.ok(mulherSalva);
	}

	public void letraMaiscula(Mulher mulher) {
		mulher.getNome().substring(0, 1).toUpperCase().concat(mulher.toString());

	}
}
