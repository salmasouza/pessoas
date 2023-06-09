package com.crud.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.demo.entities.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
	

}
