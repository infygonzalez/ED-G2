package Controlador;

import java.util.ArrayList;

import Modelo.Agencia;
import Modelo.GestorAgencia;
import Modelo.GestorViajes;
import Modelo.Viaje;

public class Controlador {

	public void verificarDatos(String nombre,String clave) {
	GestorAgencia gestorAgencia = new GestorAgencia();
	gestorAgencia.verificarDatos( nombre,clave);
	}
	
	public void crearAgencia(Agencia agencia) {
		GestorAgencia gestorAgencia = new GestorAgencia();
		gestorAgencia.crearAgencia(agencia);
	}
	
	public ArrayList<Viaje> mostrarViajes() {
		ArrayList<Viaje>viajes=null;
		GestorViajes gestorViajes = new GestorViajes();
		viajes=gestorViajes.mostrarViajes();
		return viajes;
			
	}
}
