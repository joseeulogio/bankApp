package com.beeva.bankApp.model;

/**
 * PROYECTO:	 Banco
 * ELABORADO:	 Cortes Del Angel Jose Eulogio
 * FECHA:		 14-07-2017 
 * PROGRAMA:	 BancosClientes
 * DESCRIPCION:  
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bancosclientes")
public class BancosClientes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idbancosclientes")
	private int idbancoCliente;
	@Column(name = "idcliente")
	private int idcliente;
	@Column(name = "idbanco")
	private int idbanco;

	public int getIdbancoCliente() {
		return idbancoCliente;
	}

	public void setIdbancoCliente(int idbancoCliente) {
		this.idbancoCliente = idbancoCliente;
	}

	public int getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	public int getIdbanco() {
		return idbanco;
	}

	public void setIdbanco(int idbanco) {
		this.idbanco = idbanco;
	}

}
