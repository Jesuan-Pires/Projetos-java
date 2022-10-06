package com.atos.projeto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.atos.projeto.models.Entregador;

@Repository
public interface EntregadorRepository  extends CrudRepository<Entregador, String>{
	Entregador findById(long id);	
}
