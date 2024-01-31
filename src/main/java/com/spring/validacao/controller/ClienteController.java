package com.spring.validacao.controller;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.spring.validacao.entities.Cliente;
import com.spring.validacao.services.ClienteServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteServices services;
	
	@GetMapping("/buscarTodos")
	public ResponseEntity<List<Cliente>> findAll() {
		List<Cliente> list = services.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/buscarPorId/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Long id) {
		Cliente obj = services.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping("/salvar")
	public ResponseEntity<Cliente> insert(@RequestBody @Valid Cliente cli) {
		services.insert(cli);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cli.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		services.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cli) {
		services.update(id, cli);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cli.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
