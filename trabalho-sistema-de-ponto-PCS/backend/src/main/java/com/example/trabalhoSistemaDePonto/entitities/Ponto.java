package com.example.trabalhoSistemaDePonto.entitities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ponto")
public class Ponto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant dataHoraEntrada;
	private Instant dataHoraSaida;
	private String justificativa;
	private Date horasJustificadas;
	private Boolean aceite;

	@ManyToOne
	@JoinColumn(name = "funcionario")
	private Funcionario funcionario;

	public Ponto() {
	}

	public Ponto(Long id, Instant dataHoraEntrada, Instant dataHoraSaida, String justificativa, Date horasJustificadas,
			Boolean aceite, Funcionario funcionario) {
		super();
		this.id = id;
		this.dataHoraEntrada = dataHoraEntrada;
		this.dataHoraSaida = dataHoraSaida;
		this.justificativa = justificativa;
		this.horasJustificadas = horasJustificadas;
		this.aceite = aceite;
		this.funcionario = funcionario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getDataHoraEntrada() {
		return dataHoraEntrada;
	}

	public void setDataHoraEntrada(Instant dataHoraEntrada) {
		this.dataHoraEntrada = dataHoraEntrada;
	}

	public Instant getDataHoraSaida() {
		return dataHoraSaida;
	}

	public void setDataHoraSaida(Instant dataHoraSaida) {
		this.dataHoraSaida = dataHoraSaida;
	}

	public String getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

	public Date getHorasJustificadas() {
		return horasJustificadas;
	}

	public void setHorasJustificadas(Date horasJustificadas) {
		this.horasJustificadas = horasJustificadas;
	}

	public Boolean getAceite() {
		return aceite;
	}

	public void setAceite(Boolean aceite) {
		this.aceite = aceite;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ponto other = (Ponto) obj;
		return Objects.equals(id, other.id);
	}

}
