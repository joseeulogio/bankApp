package com.beeva.bankApp.dao;

/**
 * PROYECTO:	 Banco
 * ELABORADO:	 Cortes Del Angel Jose Eulogio
 * FECHA:		 14-07-2017 
 * PROGRAMA:	 BancoDao
 * DESCRIPCION:  
 */
import com.beeva.bankApp.model.Banco;
import com.beeva.bankApp.model.Cliente;
import com.beeva.bankApp.model.Cuenta;

public abstract class BancoDao {
	public abstract void agregarBanco(Banco banco);

	public abstract void deposito(double cantidad, Cliente cliente,
			Cuenta cuenta);

	public abstract void retiro(double cantidad, Cuenta cuenta);
}
