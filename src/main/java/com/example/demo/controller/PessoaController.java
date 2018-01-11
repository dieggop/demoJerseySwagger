package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Pessoa;
import com.example.demo.repositorio.IPessoaRepositorio;

@RestController
@RequestMapping("/")
public class PessoaController {

	@Autowired
	DataSource dataSource;
	
	@Autowired
	IPessoaRepositorio pessoaRepositorio;
	
	
	
	@RequestMapping
	public String index() {
		return "Texto";
	}
	
	@GET
	@RequestMapping("/algo")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pessoa> algo() {
		
		List<Pessoa> pessoas = (List<Pessoa>) pessoaRepositorio.findAll();
		
		return pessoas;
	}
	
}
