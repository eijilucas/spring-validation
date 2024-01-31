package com.spring.validacao.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.validacao.entities.Cliente;
import com.spring.validacao.repositories.ClienteRepository;

@Service
public class ClienteServices {

	@Autowired
	private ClienteRepository repository;
	
	public List<Cliente> findAll() {
		return repository.findAll();
	}
	
	public Cliente findById(Long id) {
		Optional<Cliente> cli = repository.findById(id);
		return cli.orElseThrow();
	}
	
	public Cliente insert(Cliente obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Cliente update(Long id, Cliente obj) {
		Cliente newObj = repository.getReferenceById(id);
		updateData(obj, newObj);
		return repository.save(newObj);
	}

	private void updateData(Cliente obj, Cliente newObj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}
}
