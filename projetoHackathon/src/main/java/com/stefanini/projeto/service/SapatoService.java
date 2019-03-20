package com.stefanini.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stefanini.projeto.exception.TreinaException;
import com.stefanini.projeto.model.Sapato;
import com.stefanini.projeto.repository.SapatoRepository;

@Service
public class SapatoService {
	
	@Autowired
	private SapatoRepository repository;
	
	public List<Sapato> todosSapatos() throws TreinaException {
		return (List<Sapato>) repository.findAll();
	}
	
	public Sapato salvarSapato(Sapato sapato) {
		return repository.save(sapato);
	}

	public void removerSapato(Long id) throws TreinaException  {
		repository.deleteById(id);
		
	}

}
