package com.example.trabalhoSistemaDePonto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trabalhoSistemaDePonto.entitities.Ponto;
import com.example.trabalhoSistemaDePonto.repositories.PontoRepository;

@Service
public class PontoService {

	@Autowired
	private PontoRepository repository;

	public List<Ponto> findAll() {
		return repository.findAll();
	}

	public Ponto findById(Long id) {
		Optional<Ponto> obj = repository.findById(id);
		return obj.get();
	}

}
