package com.crud.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.demo.entities.Pessoa;
import com.crud.demo.repositories.PessoaRepository;


@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repository;
	
	
	
	public List<Pessoa> findAll(){
		return repository.findAll();
	}
	
	public Pessoa findById(Integer id){
		
		Optional<Pessoa> obj = repository.findById(id);
		return obj.get();
	}
	
	public Pessoa save(Pessoa pessoa) {
		return repository.save(pessoa);
	}
	
	public Pessoa update(Pessoa pessoa) {
		return repository.save(pessoa);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	

	
	
	
}
