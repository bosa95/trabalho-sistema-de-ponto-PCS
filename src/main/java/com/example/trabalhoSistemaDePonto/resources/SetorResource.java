package com.example.trabalhoSistemaDePonto.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.trabalhoSistemaDePonto.entitities.Setor;
import com.example.trabalhoSistemaDePonto.services.SetorService;

@RestController
@RequestMapping(value = "setores")
public class SetorResource {

	@Autowired
	private SetorService service;

	@GetMapping
	public ResponseEntity<List<Setor>> findAll() {
		List<Setor> pontos = service.findAll();
		return ResponseEntity.ok().body(pontos);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Setor> findById(@PathVariable Long id) {
		Setor obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
