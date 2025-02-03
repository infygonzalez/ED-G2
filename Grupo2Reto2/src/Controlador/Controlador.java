package Controlador;

import java.util.ArrayList;

import Modelo.Agencia;
import Modelo.Alojamiento;
import Modelo.GestorAgencia;
import Modelo.GestorEventos;
import Modelo.GestorViajes;
import Modelo.Otros;
import Modelo.Pais;
import Modelo.Viaje;
import Modelo.Vuelo;

public class Controlador {

	public Agencia login(String nombre,String clave) {
	GestorAgencia gestorAgencia = new GestorAgencia();
	return gestorAgencia.login( nombre,clave);
	}
	
	public void crearAgencia(Agencia agencia) {
		GestorAgencia gestorAgencia = new GestorAgencia();
		gestorAgencia.crearAgencia(agencia);
	}
	
	public ArrayList<Viaje> mostrarViajes(Agencia agencia,ArrayList<Pais> paises) {
		ArrayList<Viaje>viajes= new ArrayList<Viaje>();
		GestorViajes gestorViajes = new GestorViajes();
		viajes=gestorViajes.mostrarViajes(agencia, paises);
		return viajes;	
	}
	
	public ArrayList<Pais> mostrarPais() {
		ArrayList<Pais>paises= new ArrayList<Pais>();
		GestorViajes gestorViajes = new GestorViajes();
		paises=gestorViajes.mostrarPais();
		return paises;
}

	public ArrayList<Vuelo> mostrarVuelos() {
		ArrayList<Vuelo>vuelos= new ArrayList<Vuelo>();
		GestorEventos gestorEventos = new GestorEventos();
		vuelos=gestorEventos.mostrarVuelos();
		
		return vuelos;
	}

	public ArrayList<Alojamiento> mostrarAlojamientos() {
		ArrayList<Alojamiento>alojamientos= new ArrayList<Alojamiento>();
		GestorEventos gestorEventos = new GestorEventos();
		alojamientos=gestorEventos.mostrarAlojamientos();
		
		return alojamientos;
	}
	public ArrayList<Otros> mostrarOtros() {
		ArrayList<Otros>otros= new ArrayList<Otros>();
		GestorEventos gestorEventos = new GestorEventos();
		otros=gestorEventos.mostrarOtros();
		
		return otros;
	}
	

}
