package com.example.demo.rest;

import java.util.List;

import javax.sql.DataSource;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.Pessoa;
import com.example.demo.service.PessoaServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Path("/pessoas")
@Api(value = "Hello resource", produces = "application/json")

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PessoaRest {

	@Autowired
	DataSource dataSource;
	
	@Autowired
	PessoaServiceImpl pessoaService;
	 
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Pegar uma pessoa", response = Pessoa.class)
	  @ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Retornando uma pessoa"),
	    @ApiResponse(code = 404, message = "Deu erro no retorno")
	  })
	public List<Pessoa> hello() {
		
		
	List<Pessoa> pessoas = (List<Pessoa>) pessoaService.findAll();
		
		
		return pessoas;
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Cadastrar uma pessoa", response = Pessoa.class)
	  @ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Cadastrou uma pessoa"),
	    @ApiResponse(code = 404, message = "Deu erro no cadastro de uma pessoa")
	  })
	@Path("/add")
	public Pessoa cadastro(@ApiParam Pessoa p) 
	{
		Pessoa pessoaRetorno = pessoaService.createPessoa(p);
		
		
		return pessoaRetorno;
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Cadastro de diversas pessoas", response = Pessoa.class)
	  @ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Cadastrou varias pessoas"),
	    @ApiResponse(code = 404, message = "Deu erro")
	  })
	@Path("/addAll")
	
	public String cadastroAll(@ApiParam List<Pessoa> p) 
	{
		List<Pessoa> pessoasRetorno = (List<Pessoa>) pessoaService.createLotPessoas(p);
		
		
		return "Cadastro Efetuado";
	}
	
	
}
