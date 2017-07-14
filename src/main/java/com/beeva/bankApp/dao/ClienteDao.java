package com.beeva.bankApp.dao;

/**
 * PROYECTO:	 Banco
 * ELABORADO:	 Cortes Del Angel Jose Eulogio
 * FECHA:		 14-07-2017 
 * PROGRAMA:	 ClienteDao
 * DESCRIPCION:  
 */
import com.beeva.bankApp.model.Cliente;

public abstract class ClienteDao {
	public abstract void agregarCliente(Cliente cliente);

	public abstract String obtenerCliente(int numero);

	public abstract int obtenerNCliente(Cliente cliente);
}
