package com.spring.validacao.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.validacao.entities.Cliente;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
	
	@PostMapping("/salvar")
	public ResponseEntity<Cliente> save(@RequestBody @Valid Cliente cliente) {
		return ResponseEntity.ok().body(cliente);
	}
}
