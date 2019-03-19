package com.stefanini.projeto.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.stefanini.projeto.exception.TreinaException;
import com.stefanini.projeto.exception.ValidacaoMulherException;
import com.stefanini.projeto.model.Mulher;
import com.stefanini.projeto.repository.MulherRepository;

@Service
public class MulherService {

	@Autowired
	private MulherRepository repository;
	
	public List<Mulher> findAll() throws TreinaException {
		return (List<Mulher>) repository.findAll();
	}

	public Mulher salvar(Mulher mulher) {
		validarMulher(mulher);
		return repository.save(mulher);
		
	}

	private void validarMulher(Mulher mulher) {
		validarNomeRepetido(mulher);	
	}

	private void validarNomeRepetido(Mulher mulher) {
		Mulher mulherDb = repository.buscarPorNome(mulher.getNome());
		if(mulherDb != null) {
			throw new ValidacaoMulherException("Já existe uma mulher com o nome"+ mulher.getNome());
		}
	}
	
	public void remover( Long id) throws TreinaException {
		repository.deleteById(id);
	}
	public Mulher atualizar(@PathVariable Long id,@Valid @RequestBody Mulher mulher){
		Mulher mulherSalva = repository.findById(id).orElse(null);
		BeanUtils.copyProperties(mulher, mulherSalva, "id");
		return repository.save(mulherSalva);
		
	}

	public ResponseEntity<Optional<Mulher>> buscarCodigo(@PathVariable Long id) {
		Optional<Mulher> mulherSalva = repository.findById(id);
		if (mulherSalva != null)
			return ResponseEntity.ok(mulherSalva);
		else
			return ResponseEntity.notFound().build();
		
	}
	
			
}