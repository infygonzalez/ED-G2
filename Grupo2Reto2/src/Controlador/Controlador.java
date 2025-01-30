package Controlador;

import java.util.ArrayList;

import Modelo.Agencia;
import Modelo.GestorAgencia;

public class Controlador {

	public void verificarDatos(String nombre,String clave) {
	GestorAgencia gestorAgencia = new GestorAgencia();
	gestorAgencia.verificarDatos( nombre,clave);
	}
	
	public void crearAgencia(Agencia agencia) {
		GestorAgencia gestorAgencia = new GestorAgencia();
		gestorAgencia.crearAgencia(agencia);
	}
}
