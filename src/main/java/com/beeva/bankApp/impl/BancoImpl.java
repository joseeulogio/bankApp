package com.beeva.bankApp.impl;

/**
 * PROYECTO:	 Banco
 * ELABORADO:	 Cortes Del Angel Jose Eulogio
 * FECHA:		 14-07-2017 
 * PROGRAMA:	 BancoImpl
 * DESCRIPCION:  
 */
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beeva.bankApp.dao.BancoDao;
import com.beeva.bankApp.model.Banco;
import com.beeva.bankApp.model.Cliente;
import com.beeva.bankApp.model.Cuenta;

@Repository
public class BancoImpl extends BancoDao {

	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional
	public void agregarBanco(Banco banco) {
		em.persist(banco);
	}

	@Override
	@Transactional
	public void deposito(double cantidad, Cliente cliente, Cuenta cuenta) {
		if (cliente.getIdcliente() == cuenta.getIdcliente()) {
			double balanceCuenta = cuenta.getBalance();
			double newBalance = cantidad + balanceCuenta;
			cuenta.setBalance(newBalance);
			em.merge(cuenta);
			
		} else {
			System.out.println("ERROR");
		}
	}

	@Override
	@Transactional
	public void retiro(double cantidad, Cuenta cuenta) {
		if (cuenta.getIdtipoCuenta() == 1) {
			if (cuenta.getBalance() < 5000) {
				System.out.println("NO PUEDES RETIRAR MENOS 5000");
			} else {
				double retiro = cuenta.getBalance() - cantidad;
				cuenta.setBalance(retiro);
				System.out.println("TU SALDO ES: $" + retiro );
				em.merge(cuenta);
			}
		} else if (cuenta.getIdtipoCuenta() == 2) {

			Calendar now = Calendar.getInstance();
			String[] strDays = new String[] { "Domingo", "Lunes", "Martes",
					"Miercoles", "Jueves", "Viernes", "Sabado" };
			String hoy = strDays[now.get(Calendar.DAY_OF_WEEK) - 1];

			if (hoy == "Domingo" || hoy == "Sabado") {
				System.out.println("NO PUEDES RETIRAR EN " + hoy);
			} else {
				double retiro = cuenta.getBalance() - cantidad;
				cuenta.setBalance(retiro);
				em.merge(cuenta);
				System.out.println("TU SALDO ES: $" + retiro);
			}
		}

	}

}
