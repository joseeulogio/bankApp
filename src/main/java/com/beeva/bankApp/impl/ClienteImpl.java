package com.beeva.bankApp.impl;

/**
 * PROYECTO:	 Banco
 * ELABORADO:	 Cortes Del Angel Jose Eulogio
 * FECHA:		 14-07-2017 
 * PROGRAMA:	 ClienteImpl
 * DESCRIPCION:  
 */
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beeva.bankApp.dao.ClienteDao;
import com.beeva.bankApp.model.Cliente;

@Repository
public class ClienteImpl extends ClienteDao {

	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional
	public void agregarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		em.persist(cliente);
	}

	@Override
	@Transactional
	public String obtenerCliente(int numero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public int obtenerNCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		return 0;
	}
}