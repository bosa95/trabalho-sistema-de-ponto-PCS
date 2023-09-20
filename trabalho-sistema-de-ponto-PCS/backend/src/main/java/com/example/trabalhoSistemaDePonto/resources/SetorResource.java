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

import com.example.trabalhoSistemaDePonto.entitities.Setor;
import com.example.trabalhoSistemaDePonto.services.SetorService;

@RestController
@RequestMapping(value = "setores")
public class SetorResource {

	@Autowired
	private SetorService service;

	@GetMapping
	public ResponseEntity<List<Setor>> findAll() {
		List<Setor> setores = service.findAll();
		return ResponseEntity.ok().body(setores);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Setor> findById(@PathVariable Long id) {
		Setor obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Setor> insert(@RequestBody Setor obj) {
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
	public ResponseEntity<Setor> update(@PathVariable Long id, @RequestBody Setor obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

}
