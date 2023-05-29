package com.example.trabalhoSistemaDePonto.resources;

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

import com.example.trabalhoSistemaDePonto.entitities.Ponto;
import com.example.trabalhoSistemaDePonto.services.PontoService;

@RestController
@RequestMapping(value = "pontos")
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

	@PostMapping
	public ResponseEntity<Ponto> insert(@RequestBody Ponto obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping(value = "{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "{id}")
	public ResponseEntity<Ponto> update(@PathVariable Long id, @RequestBody Ponto obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

}
