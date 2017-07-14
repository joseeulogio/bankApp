package com.beeva.bankApp;

import java.util.Calendar;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beeva.bankApp.dao.BancoDao;
import com.beeva.bankApp.dao.BancosClientesDao;
import com.beeva.bankApp.dao.ClienteDao;
import com.beeva.bankApp.dao.CuentaDao;
import com.beeva.bankApp.dao.TipoCuentaDao;
import com.beeva.bankApp.impl.BancoImpl;
import com.beeva.bankApp.impl.BancosClientesImpl;
import com.beeva.bankApp.impl.ClienteImpl;
import com.beeva.bankApp.impl.CuentaImpl;
import com.beeva.bankApp.impl.TipoCuentaImpl;
import com.beeva.bankApp.model.Banco;
import com.beeva.bankApp.model.BancosClientes;
import com.beeva.bankApp.model.Cliente;
import com.beeva.bankApp.model.Cuenta;
import com.beeva.bankApp.model.TipoCuenta;
import com.beeva.bankApp.mongo.Conexion;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;


/**
 * PROYECTO: Banco 
 * ELABORADO: Cortes Del Angel Jose Eulogio 
 * FECHA: 14-07-2017
 * PROGRAMA: App DESCRIPCION:
 */
public class App {
	public static void main(String[] args) {
		String nombre;
		String apellido;
		int totalClientes;
		int tipo;
		String tipoDeCuenta;
		String tipoDeBanco;
		int tipoCuenta = 1;
		int tipoBanco = 1;

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"core-context.xml");
		ClienteDao clienteDao = (ClienteDao) context.getBean(ClienteImpl.class);
		CuentaDao cuentaDao = (CuentaDao) context.getBean(CuentaImpl.class);
		BancoDao bancoDao = (BancoDao) context.getBean(BancoImpl.class);
		TipoCuentaDao tipoCuentaDao = (TipoCuentaDao) context
				.getBean(TipoCuentaImpl.class);
		BancosClientesDao bancosClientesDao = (BancosClientesDao) context
				.getBean(BancosClientesImpl.class);

		Scanner in = new Scanner(System.in);
		Banco banco1 = new Banco();
		Banco banco2 = new Banco();
		TipoCuenta tipoCuenta1 = new TipoCuenta();
		TipoCuenta tipoCuenta2 = new TipoCuenta();

		
		banco1.setNombre("BANCOMER");
		banco2.setNombre("BANAMEX");
		tipoCuenta1.setNombre("AHORRO");
		tipoCuenta2.setNombre("CHEQUE");
		
        tipoCuentaDao.agregarTipoCuenta(tipoCuenta1);
		tipoCuentaDao.agregarTipoCuenta(tipoCuenta2);
		bancoDao.agregarBanco(banco1);
		bancoDao.agregarBanco(banco2);
		
		Conexion con = (Conexion)context.getBean("mongo");
    	con.prueba();


        DB db = con.getMongo().getDB("BancoLog");
    	
    	DBCollection tableCliente = db.getCollection("Cliente");
    	DBCollection tableCuenta = db.getCollection("Cuenta");
    	
    	BasicDBObject documentCliente = new BasicDBObject();
    	BasicDBObject documentCuenta = new BasicDBObject();

		System.out.println("BIENVENIDO AL MEJOR BANCO\n¿CLIENTES A AGREGAR?");
		totalClientes = in.nextInt();
		Cliente cliente[] = new Cliente[totalClientes];
		Cuenta cuenta[] = new Cuenta[totalClientes];
		BancosClientes bancosClientes[] = new BancosClientes[totalClientes];
		for (int i = 0; i < totalClientes; i++) {
			cliente[i] = new Cliente();
			cuenta[i] = new Cuenta();
			bancosClientes[i] = new BancosClientes();
			System.out.println("AGREGAR AL CLIENTE: " + (i + 1));
			System.out.println("NOMBRE: ");
			nombre = in.next();
			cliente[i].setNombre(nombre);

			System.out.println("APELLIDO: ");
			apellido = in.next();
			cliente[i].setApellido(apellido);
			
			System.out.println("NOMBRE DE BANCO\n BANCOMER BANAMEX: ");
			tipoDeBanco = in.next();

			if (tipoDeBanco.equalsIgnoreCase("bancomer")) {
				tipoBanco = 1;
			} else if (tipoDeBanco.equalsIgnoreCase("banamex")) {
				tipoBanco = 2;
			} else {
				System.out.println("BANCO NO VALIDO.\nINGRESA BANCO VALIDO");
				i--;
				continue;
			}
			

			System.out.println("QUE TIPO DE CUENTA PREFIERES\n  AHORRO o CHEQUES: ");
			tipoDeCuenta = in.next();

			if (tipoDeCuenta.equalsIgnoreCase("ahorro")) {
				tipoCuenta = 1;
			} else if (tipoDeCuenta.equalsIgnoreCase("cheques")) {
				tipoCuenta = 2;
			} else {
				System.out
						.println("CUENTA NO VALIDA\n INGRESA CUENTA VALIDA");
				i--;
				continue;
			}
			try {
				clienteDao.agregarCliente(cliente[i]);

				cuenta[i].setBalance(0.0);
				cuenta[i].setIdtipoCuenta(tipoCuenta);
				cuenta[i].setIdcliente(cliente[i].getIdcliente());

				cuentaDao.agregarCuenta(cuenta[i]);
				bancosClientes[i].setIdbanco(tipoBanco);
				bancosClientes[i].setIdcliente(cliente[i].getIdcliente());
				bancosClientesDao.agregarBancosClientes(bancosClientes[i]);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			int fecha;
			
			boolean salir = false;
			int opc; 
			while (!salir) {
				System.out.println("---QUE DESEAS HACER--- ");
				System.out.println("1. RETIRAR SALDO");
				System.out.println("2. DEPOSITAR SALDO");
				System.out.println("3. SALIR");

				opc = in.nextInt();

				switch (opc) {
				case 1:
					System.out.println("BIEVENIDO "+cliente[i].getNombre().toUpperCase()+" DE CUANTO ES TU RETIRO");
					bancoDao.retiro(in.nextDouble(), cuenta[i]);
					
					break;
				case 2:
					System.out.println("BIEVENIDO "+cliente[i].getNombre().toUpperCase()+" DE CUANTO ES TU DEPOSITO");
					bancoDao.deposito(in.nextDouble(), cliente[i], cuenta[i]);
					break;
				case 3:
					System.out.println("GRACIAS POR VISITARNOS\n *VUELVE PRONTO "+cliente[i].getNombre().toUpperCase()+"*");
					salir = true;
					break;
				default:
					System.out
							.println("OPCION NO VALIDA "+cliente[i].getNombre().toUpperCase());
				}
			}
			Calendar c = Calendar.getInstance();
			fecha=c.get(Calendar.HOUR_OF_DAY);
			documentCliente.put("mensaje", "Se inserto cliente");
        	documentCliente.put("fecha",fecha);
        	documentCliente.put("id", cliente[i].getIdcliente());
    		documentCliente.put("nombre", cliente[i].getNombre());
    		documentCliente.put("apellido", cliente[i].getApellido());
    		tableCliente.insert(documentCliente);
		}
	}

	
}
