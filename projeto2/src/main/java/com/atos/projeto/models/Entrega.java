package com.atos.projeto.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Entrega {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;
	@NotEmpty
	private String bairro;
	
	private String endereco;
	@NotNull
	private Double valorCorrida;
	@NotEmpty
	private String data;
	private String horario;
	
	@ManyToOne
	private Entregador entregador;

	public Entrega() {

	}

	public Entrega(String bairro, String endereco, Double valorCorrida, String data, String horario, Entregador entregador) {
		super();
		this.bairro = bairro;
		this.endereco = endereco;
		this.valorCorrida = valorCorrida;
		this.data = data;
		this.horario = horario;
		this.entregador = entregador;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Double getValorCorrida() {
		return valorCorrida;
	}

	public void setValorCorrida(Double valorCorrida) {
		this.valorCorrida = valorCorrida;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}
	public Entregador getEntregador() {
		return entregador;
	}

	public void setEntregador(Entregador entregador) {
		this.entregador = entregador;
	}
}
