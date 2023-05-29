package com.example.trabalhoSistemaDePonto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.trabalhoSistemaDePonto.entitities.Setor;
import com.example.trabalhoSistemaDePonto.repositories.SetorRepository;
import com.example.trabalhoSistemaDePonto.services.exceptions.DatabaseException;
import com.example.trabalhoSistemaDePonto.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class SetorService {

	@Autowired
	private SetorRepository repository;

	public List<Setor> findAll() {
		return repository.findAll();
	}

	public Setor findById(Long id) {
		Optional<Setor> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Setor insert(Setor obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		try {
			if (repository.existsById(id)) {
				repository.deleteById(id);
			} else {
				throw new ResourceNotFoundException(id);
			}
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public Setor update(Long id, Setor obj) {
		try {
			Setor entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Setor entity, Setor obj) {
		entity.setNome(obj.getNome());
	}

}
