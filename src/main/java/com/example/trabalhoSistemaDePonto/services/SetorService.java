package com.example.trabalhoSistemaDePonto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trabalhoSistemaDePonto.entitities.Setor;
import com.example.trabalhoSistemaDePonto.repositories.SetorRepository;

@Service
public class SetorService {

	@Autowired
	private SetorRepository repository;

	public List<Setor> findAll() {
		return repository.findAll();
	}

	public Setor findById(Long id) {
		Optional<Setor> obj = repository.findById(id);
		return obj.get();
	}

}
