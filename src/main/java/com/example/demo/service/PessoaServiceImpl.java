package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Pessoa;
import com.example.demo.repositorio.IPessoaRepositorio;

@Service
public class PessoaServiceImpl implements PessoaService {


	@Autowired
	IPessoaRepositorio pessoaRepositorio;

	@Override
	public Pessoa createPessoa(Pessoa p) {
		// TODO Auto-generated method stub
		return pessoaRepositorio.save(p);
	}

	
	
	@Override
	public Pessoa updatePessoa(Pessoa p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePessoa(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pessoa getPessoaById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Pessoa> findAll() {
		// TODO Auto-generated method stub
		return (List<Pessoa>) pessoaRepositorio.findAll();
	}



	@Override
	public Iterable<Pessoa> createLotPessoas(Iterable<Pessoa> p) {
		// TODO Auto-generated method stub
		return pessoaRepositorio.save(p);
	}

	
	
}
