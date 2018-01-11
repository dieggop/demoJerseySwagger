package com.example.demo.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Pessoa;

public interface IPessoaRepositorio extends CrudRepository<Pessoa, Long> {
	 
}
