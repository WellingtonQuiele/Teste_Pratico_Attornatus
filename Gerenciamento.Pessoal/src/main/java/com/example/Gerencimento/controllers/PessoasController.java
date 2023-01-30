package com.example.Gerencimento.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Gerencimento.Geral.Pessoas;
import com.example.Gerencimento.Pessoal.repositories.PessoasRepository;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoasController {
	
	@Autowired
	private PessoasRepository repository;
	
	@GetMapping
	public List<Pessoas> findAll(){
		List<Pessoas>result = repository.findAll();
		return result;
		
	}
	
	@GetMapping(value = "/{id}")
	public Pessoas findById(@PathVariable Long id){
		Pessoas result = repository.findById(id).get();
		return result;
		
	}
	
	@PostMapping
	public Pessoas insert(@RequestBody Pessoas pessoas){
		Pessoas result = repository.save(pessoas);
		return result;
		
	}



}
