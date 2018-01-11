package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.validation.annotation.Validated;

@Entity
@Table(name="pessoa")
public class Pessoa {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pessoa_id")
	@SequenceGenerator(
		    name="pessoa_id",
		    sequenceName="pessoa_sequence",
		    allocationSize=1,
		    initialValue=1
		)
	Long 	id;
	String 	nome;
	String 	email;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
