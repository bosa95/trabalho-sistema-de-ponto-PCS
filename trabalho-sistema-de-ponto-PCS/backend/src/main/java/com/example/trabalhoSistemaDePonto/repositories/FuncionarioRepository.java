package com.example.trabalhoSistemaDePonto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.trabalhoSistemaDePonto.entitities.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
