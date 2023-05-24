package com.example.trabalhoSistemaDePonto.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.trabalhoSistemaDePonto.entitities.Funcionario;
import com.example.trabalhoSistemaDePonto.entitities.Ponto;
import com.example.trabalhoSistemaDePonto.repositories.FuncionarioRepository;
import com.example.trabalhoSistemaDePonto.repositories.PontoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private PontoRepository pontoRepository;

	@Override
	public void run(String... args) throws Exception {
		Funcionario f1 = new Funcionario(null, "Maria", "2315352634", "maria@gmail.com", "2134534", "1234", false);
		Funcionario f2 = new Funcionario(null, "Alex", "141345134", "alex@gmail.com", "132535", "1234", false);

		Ponto p1 = new Ponto(null, Instant.parse("2023-05-20T19:53:07Z"), Instant.parse("2023-05-20T23:53:07Z"), null,
				null, null, f2);

		funcionarioRepository.saveAll(Arrays.asList(f1, f2));
		pontoRepository.save(p1);
	}

}
