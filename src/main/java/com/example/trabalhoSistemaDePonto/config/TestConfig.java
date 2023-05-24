package com.example.trabalhoSistemaDePonto.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.trabalhoSistemaDePonto.entitities.Funcionario;
import com.example.trabalhoSistemaDePonto.repositories.FuncionarioRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Override
	public void run(String... args) throws Exception {
		Funcionario f1 = new Funcionario(null, "Maria", "2315352634", "maria@gmail.com", "2134534", "1234", false);
		Funcionario f2 = new Funcionario(null, "Alex", "141345134", "alex@gmail.com", "132535", "1234", false);

		funcionarioRepository.saveAll(Arrays.asList(f1, f2));
	}

}
