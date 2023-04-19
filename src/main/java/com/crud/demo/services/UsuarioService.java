package com.crud.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.demo.entities.Pessoa;
import com.crud.demo.entities.Usuario;
import com.crud.demo.repositories.UsuarioRepository;


@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	
	public List<Usuario> findAll(){
		return usuarioRepository.findAll();
	}
	
	public Usuario findById(Long id){
		Optional<Usuario> obj = usuarioRepository.findById(id);
		return obj.get();
	}
	
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public Usuario update(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public void delete(Long id) {
		usuarioRepository.deleteById(id);
	}

}
