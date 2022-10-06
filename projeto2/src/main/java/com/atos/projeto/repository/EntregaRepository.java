package com.atos.projeto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.atos.projeto.models.Entrega;
import com.atos.projeto.models.Entregador;

@Repository
public interface EntregaRepository extends CrudRepository<Entrega, String>{
	Iterable<Entrega> findByEntregador(Entregador entregador);
	Entrega findByCodigo(int codigo);
}
