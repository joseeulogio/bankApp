package com.beeva.bankApp.impl;
/**
 * PROYECTO:	 Banco
 * ELABORADO:	 Cortes Del Angel Jose Eulogio
 * FECHA:		 14-07-2017 
 * PROGRAMA:	 CuentaImpl
 * DESCRIPCION:  
 */
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beeva.bankApp.dao.CuentaDao;
import com.beeva.bankApp.model.Cuenta;
@Repository
public class CuentaImpl extends CuentaDao{

	@PersistenceContext
	EntityManager em;
	
	@Override
	@Transactional
	public void agregarCuenta(Cuenta cuenta) {
		em.persist(cuenta);
	}
}