package Controlador;

import java.util.ArrayList;

import Modelo.Aerolinea;
import Modelo.Aeropuerto;
import Modelo.Agencia;
import Modelo.Alojamiento;
import Modelo.Gestor;
import Modelo.Otros;
import Modelo.Pais;
import Modelo.Viaje;
import Modelo.Vuelo;



public class Controlador {

	public Agencia login(String nombre,String clave) {
	Gestor gestorAgencia = new Gestor();
	return gestorAgencia.login( nombre,clave);
	}
	
	public void crearAgencia(Agencia agencia) {
		Gestor gestorAgencia = new Gestor();
		gestorAgencia.crearAgencia(agencia);
	}
	
	public ArrayList<Viaje> mostrarViajes(Agencia agencia,ArrayList<Pais> paises) {
		ArrayList<Viaje>viajes= new ArrayList<Viaje>();
		Gestor gestor = new Gestor();
		viajes=gestor.mostrarViajes(agencia, paises);
		return viajes;	
	}
	
	public  ArrayList<Pais> mostrarPais() {
		ArrayList<Pais>paises= new ArrayList<Pais>();
		Gestor gestor = new Gestor();
		paises=gestor.mostrarPais();
		return paises;
}
	
	public  ArrayList<Aerolinea> mostrarAerolineas() {
		ArrayList<Aerolinea>aerolineas= new ArrayList<Aerolinea>();
		Gestor gestor = new Gestor();
		aerolineas=gestor.mostrarAerolineas();
		return aerolineas;
}
	public  ArrayList<Aeropuerto> mostrarAeropuertos() {
		ArrayList<Aeropuerto>aeropuertos= new ArrayList<Aeropuerto>();
		Gestor gestor = new Gestor();
		aeropuertos=gestor.mostrarAeropuertos();
		return aeropuertos;
}

	public ArrayList<Vuelo> mostrarVuelos(Viaje viaje) {
		ArrayList<Vuelo>vuelos= new ArrayList<Vuelo>();
		Gestor gestor = new Gestor();
		vuelos=gestor.mostrarVuelos(viaje);
		
		return vuelos;
	}

	public ArrayList<Alojamiento> mostrarAlojamientos(Viaje viaje) {
		ArrayList<Alojamiento>alojamientos= new ArrayList<Alojamiento>();
		Gestor gestor = new Gestor();
		alojamientos=gestor.mostrarAlojamientos(viaje);
		
		return alojamientos;
	}
	public ArrayList<Otros> mostrarOtros(Viaje viaje) {
		ArrayList<Otros>otros= new ArrayList<Otros>();
		Gestor gestor = new Gestor();
		otros=gestor.mostrarOtros(viaje);
		
		return otros;
	}
	
	public boolean borrarViaje(Viaje viaje) {
		Gestor gestor = new Gestor();
		boolean valido=true;
		ArrayList<Vuelo>vuelos= viaje.getVuelo();
		for(int i =0;i<vuelos.size();i++) {
			
			if(valido==true) {
				valido=eliminarVuelo(vuelos.get(i));
			}
			
		}
		ArrayList<Alojamiento>alojamientos= viaje.getAlojamiento();
		for(int i =0;i<alojamientos.size();i++) {
			
			if(valido==true) {
				valido=eliminarAlojamiento(alojamientos.get(i));
			}
			
		}
		ArrayList<Otros>otros= viaje.getOtros();
		for(int i =0;i<otros.size();i++) {
			
			if(valido==true) {
				valido=eliminarOtros(otros.get(i));
			}
			
		}
		if(valido==true) {
			valido=gestor.borrarViaje(viaje);
		}
		return valido;
	}
	
	public boolean eliminarVuelo(Vuelo vuelo){
	
		Gestor gestorVuelo = new Gestor();
		boolean valido=true;
		valido=gestorVuelo.eliminarVuelo(vuelo);
		if(vuelo.getVueloIda()!= null && valido==true) {
			valido= gestorVuelo.eliminarVuelo(vuelo.getVueloIda());
			
		}

		return valido;
	}
	
	public boolean eliminarAlojamiento(Alojamiento alojamiento){
		Gestor gestorAlojamiento = new Gestor();
		return gestorAlojamiento.eliminarAlojamiento(alojamiento);
	}
	
	public boolean eliminarOtros(Otros otro){
		Gestor gestorOtros = new Gestor();
		return gestorOtros.eliminarOtros(otro);
	}
	
}