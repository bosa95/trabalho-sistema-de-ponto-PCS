package com.example.trabalhoSistemaDePonto.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.trabalhoSistemaDePonto.entitities.Ponto;
import com.example.trabalhoSistemaDePonto.services.PontoService;

@RestController
@RequestMapping(value = "ponto")
public class PontoResource {

	@Autowired
	private PontoService service;

	@GetMapping
	public ResponseEntity<List<Ponto>> findAll() {
		List<Ponto> pontos = service.findAll();
		return ResponseEntity.ok().body(pontos);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Ponto> findById(@PathVariable Long id) {
		Ponto obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
