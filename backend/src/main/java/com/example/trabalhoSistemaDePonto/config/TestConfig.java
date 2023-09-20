package com.example.trabalhoSistemaDePonto.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.trabalhoSistemaDePonto.entitities.Funcionario;
import com.example.trabalhoSistemaDePonto.entitities.Ponto;
import com.example.trabalhoSistemaDePonto.entitities.Setor;
import com.example.trabalhoSistemaDePonto.repositories.FuncionarioRepository;
import com.example.trabalhoSistemaDePonto.repositories.PontoRepository;
import com.example.trabalhoSistemaDePonto.repositories.SetorRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private PontoRepository pontoRepository;

	@Autowired
	private SetorRepository setorRepository;

	@Override
	public void run(String... args) throws Exception {
		Setor s1 = new Setor(null, "Informática");
		Setor s2 = new Setor(null, "Limpeza");

		Funcionario f1 = new Funcionario(null, "Maria", "2315352634", "maria@gmail.com", "2134534", "1234", false, s1);
		Funcionario f2 = new Funcionario(null, "Alex", "141345134", "alex@gmail.com", "132535", "1234", false, s2);

		Ponto p1 = new Ponto(null, Instant.parse("2023-05-20T19:53:07Z"), Instant.parse("2023-05-20T23:53:07Z"), null,
				null, null, f2);
		Ponto p2 = new Ponto(null, Instant.parse("2023-05-20T19:53:07Z"), Instant.parse("2023-05-20T23:53:07Z"), null,
				null, null, f1);
		Ponto p3 = new Ponto(null, Instant.parse("2023-05-20T19:53:07Z"), Instant.parse("2023-05-20T23:53:07Z"), null,
				null, null, f2);

		setorRepository.saveAll(Arrays.asList(s1, s2));
		funcionarioRepository.saveAll(Arrays.asList(f1, f2));
		pontoRepository.saveAll(Arrays.asList(p1, p2, p3));
	}

}
