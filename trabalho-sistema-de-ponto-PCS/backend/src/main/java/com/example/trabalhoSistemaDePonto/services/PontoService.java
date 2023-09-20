package com.example.trabalhoSistemaDePonto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.trabalhoSistemaDePonto.entitities.Ponto;
import com.example.trabalhoSistemaDePonto.repositories.PontoRepository;
import com.example.trabalhoSistemaDePonto.services.exceptions.DatabaseException;
import com.example.trabalhoSistemaDePonto.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PontoService {

	@Autowired
	private PontoRepository repository;

	public List<Ponto> findAll() {
		return repository.findAll();
	}

	public Ponto findById(Long id) {
		Optional<Ponto> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Ponto insert(Ponto obj) {
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

	public Ponto update(Long id, Ponto obj) {
		try {
			Ponto entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Ponto entity, Ponto obj) {
		entity.setDataHoraEntrada(obj.getDataHoraEntrada());
		entity.setDataHoraSaida(obj.getDataHoraSaida());
		entity.setJustificativa(obj.getJustificativa());
		entity.setHorasJustificadas(obj.getHorasJustificadas());
		entity.setAceite(obj.getAceite());
		entity.setFuncionario(obj.getFuncionario());
	}

}
