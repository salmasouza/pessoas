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

import com.crud.demo.entities.Usuario;
import com.crud.demo.services.UsuarioService;


@RestController
@RequestMapping(value="/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll(){
		List<Usuario> list = usuarioService.findAll();
		return ResponseEntity.ok().body(list);
	} 
	
	@GetMapping(path= {"/{id}"})
	public ResponseEntity<?> findById(@PathVariable Long id){
		Usuario list = usuarioService.findById(id);
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Usuario>adicionar(@RequestBody Usuario usuario){
		usuario = usuarioService.save(usuario);
		return ResponseEntity.ok().body(usuario);
	}
	
	@PutMapping(value= {"/{id}"})
	public Usuario update(@RequestBody Usuario usuario, @PathVariable Long id){
		usuario.setId(id);
		return usuarioService.update(usuario);
	}
	
	@DeleteMapping(value= {"/{id}"})
	public ResponseEntity<?> delete(@PathVariable Long id){
		usuarioService.delete(id);
		return ResponseEntity.noContent().build();	
	}

}
