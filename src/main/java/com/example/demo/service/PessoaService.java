package com.example.demo.service;

import com.example.demo.model.Pessoa;

public interface PessoaService {

	Pessoa 	createPessoa(Pessoa p);
	Pessoa 	updatePessoa(Pessoa p);
	void 	deletePessoa(Long id);
	Pessoa	getPessoaById(Long id);
	Iterable<Pessoa> createLotPessoas(Iterable<Pessoa> p);
	
}
