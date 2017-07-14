package com.beeva.bankApp.impl;

/**
 * PROYECTO:	 Banco
 * ELABORADO:	 Cortes Del Angel Jose Eulogio
 * FECHA:		 14-07-2017 
 * PROGRAMA:	 BancosClientesImplementacion
 * DESCRIPCION:  
 */
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beeva.bankApp.dao.BancosClientesDao;
import com.beeva.bankApp.model.BancosClientes;

@Repository
public class BancosClientesImpl extends BancosClientesDao {

	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional
	public void agregarBancosClientes(BancosClientes bancosClientes) {
		em.persist(bancosClientes);
	}
}
