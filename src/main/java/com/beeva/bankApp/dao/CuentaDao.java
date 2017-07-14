package com.beeva.bankApp.dao;

/**
 * PROYECTO:	 Banco
 * ELABORADO:	 Cortes Del Angel Jose Eulogio
 * FECHA:		 14-07-2017 
 * PROGRAMA:	 CuentaDao
 * DESCRIPCION:  
 */
import com.beeva.bankApp.model.Cuenta;

public abstract class CuentaDao {
	public abstract void agregarCuenta(Cuenta cuenta);
}
