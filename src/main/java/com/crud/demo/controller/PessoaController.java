package com.crud.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.demo.entities.Pessoa;
import com.crud.demo.services.PessoaService;

@RestController
@RequestMapping(value="/pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaService service;
	
	@GetMapping
	public ResponseEntity<List<Pessoa>> findAll(){
		List<Pessoa> list = service.findAll();
		return ResponseEntity.ok().body(list);
	} 
	
	@GetMapping(path= {"/{id}"})
	public ResponseEntity<?> findById(@PathVariable Integer id){
		Pessoa list = service.findById(id);
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Pessoa>adicionar(@RequestBody Pessoa pessoa){
		pessoa = service.save(pessoa);
		return ResponseEntity.ok().body(pessoa);
	}
	
	@PutMapping(value= {"/{id}"})
	public Pessoa update(@RequestBody Pessoa pessoa, @PathVariable Integer id){
		pessoa.setId(id);
		return service.update(pessoa);
	}
	
	@DeleteMapping(value= {"/{id}"})
	public ResponseEntity<?> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();	
	}

	
}
