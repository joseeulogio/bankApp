package com.beeva.bankApp.impl;

/**
 * PROYECTO:	 Banco
 * ELABORADO:	 Cortes Del Angel Jose Eulogio
 * FECHA:		 14-07-2017 
 * PROGRAMA:	 TipoCuentaImpl
 * DESCRIPCION:  
 */
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beeva.bankApp.dao.TipoCuentaDao;
import com.beeva.bankApp.model.TipoCuenta;

@Repository
public class TipoCuentaImpl extends TipoCuentaDao {

	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional
	public void agregarTipoCuenta(TipoCuenta tipoCuenta) {
		em.persist(tipoCuenta);
	}

}
