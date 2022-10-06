package com.atos.projeto.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

@Entity
public class Entregador implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;
	@NotEmpty
	public String nome;
	public String contato;
	
	@NotEmpty
	public String cnh;
	
	@OneToMany(mappedBy="entregador", orphanRemoval=true, cascade=CascadeType.PERSIST)
	private List<Entrega> entrega;
	
	public Entregador() {

	}

	public Entregador(String nome, String contato, String cnh) {
		super();
		this.nome = nome;
		this.contato = contato;
		this.cnh = cnh;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}
}
