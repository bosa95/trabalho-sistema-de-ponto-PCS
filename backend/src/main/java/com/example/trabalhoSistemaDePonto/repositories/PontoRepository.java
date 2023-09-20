package com.example.trabalhoSistemaDePonto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.trabalhoSistemaDePonto.entitities.Ponto;

public interface PontoRepository extends JpaRepository<Ponto, Long> {

}
