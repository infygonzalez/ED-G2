package Modelo;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GestorTest {

	Agencia agencia;
	Gestor gestor;
	Viaje viaje;
	ArrayList<Pais> paises;
	ArrayList<Vuelo> vuelos;
	ArrayList<Alojamiento> alojamientos;
	ArrayList<Otros> otros;
	ArrayList<Aeropuerto> aeropuertos;
	ArrayList<Aerolinea> aerolineas;
	
	@Before
	public void empezarGestorAgencia() {
		
		
		gestor = new Gestor();
		
		aeropuertos = gestor.mostrarAeropuertos();
		aerolineas = gestor.mostrarAerolineas();
		paises = gestor.mostrarPais();
		
		agencia = new Agencia();
		agencia.setIdAgencia(null);
		agencia.setNombre("ddddd");
        agencia.setColorMarca("colorMarca");
        agencia.setNumeroEmpleados("Entre 2 y 10 empleados");
        agencia.setTipoAgencia("minorista");
        agencia.setLogo("Logo");
        agencia.setClave("JUnit");
		
		viaje = new Viaje();
		viaje.setAgencia(agencia);
		viaje.setNombreViaje("Viaje a Marruecos");
		viaje.setDescripcion("pp");
		viaje.setTipoViaje("Novios");
		viaje.setFechaIda("2025-02-02");
		viaje.setFechaVuelta("2025-03-03");
		viaje.setDuracion("9");
		viaje.setDescServicio("aa");
		viaje.setIdViaje("19");
		for (Pais pais : paises) {
            if (pais.getDescripPais().equals("ARGENTINA")) {
                viaje.setPais(pais);
            }
        }
	}

	@Test
	public void test1_CrearAgencia() {
		boolean crearNuevaAgencia = gestor.crearAgencia(agencia);
		assertNotNull("La agencia no se crea correctamente",crearNuevaAgencia);
		
	}
	@Test
	public void test2_Login() {
	
		agencia = gestor.login("prueba JUnit", "JUnit");
		assertTrue("Login correcto", agencia instanceof Agencia);
		
	}
	
	@Test
	public void test3_MostrarVuelos() {

		ArrayList<Viaje> viajes = gestor.mostrarViajes(agencia, paises);
		boolean mostrar = false;

		if (viajes.size() != 0) {

			ArrayList<Vuelo> vuelos = gestor.mostrarVuelos(viajes.get(0));
			mostrar = vuelos.size() != 0;
		}
		assertTrue("Los vuelos no se cargan", mostrar);
	}

	@Test
	public void test3_MostrarAlojamientos() {
		ArrayList<Viaje> viajes = gestor.mostrarViajes(agencia, paises);
		boolean mostrar = false;

		if (viajes.size() != 0) {

			ArrayList<Alojamiento> alojamientos = gestor.mostrarAlojamientos(viajes.get(0));
			mostrar = alojamientos.size() != 0;
		}
		assertTrue("Los alojamientos no se cargan", mostrar);
	}

	@Test
	public void test3_MostrarOtros() {
		ArrayList<Viaje> viajes = gestor.mostrarViajes(agencia, paises);
		boolean mostrar = false;

		if (viajes.size() != 0) {

			ArrayList<Otros> otros = gestor.mostrarOtros(viajes.get(0));
			mostrar = otros.size() != 0;
		}
		assertTrue("Los otros eventos no se cargan", mostrar);
	}

	@Test
	public void test4_EliminarVuelo() {
		ArrayList<Viaje> viajes = gestor.mostrarViajes(agencia, paises);
		boolean borrar = false;

		if (viajes.size() != 0) {

			ArrayList<Vuelo> vuelos = gestor.mostrarVuelos(viajes.get(0));
			if (vuelos.size() != 0) {
				borrar = gestor.eliminarVuelo(vuelos.get(0));
			}

		}
		assertTrue("El vuelo no se elimina", borrar);

	}

	@Test
	public void test4_EliminarAlojamiento() {

		ArrayList<Viaje> viajes = gestor.mostrarViajes(agencia, paises);
		boolean borrar = false;

		if (viajes.size() != 0) {

			ArrayList<Alojamiento> alojamientos = gestor.mostrarAlojamientos(viajes.get(0));
			if (alojamientos.size() != 0) {
				borrar = gestor.eliminarAlojamiento(alojamientos.get(0));
			}

		}
		assertTrue("El vuelo no se elimina", borrar);
	}

	@Test
	public void test4_EliminarOtros() {
		ArrayList<Viaje> viajes = gestor.mostrarViajes(agencia, paises);
		boolean borrar = false;
		if (viajes.size() != 0) {
			ArrayList<Otros> otros = gestor.mostrarOtros(viajes.get(0));
			if (otros.size() != 0) {
				borrar = gestor.eliminarOtros(otros.get(0));
			}}

		assertTrue("El otro evento no se elimina", borrar);
	}

	@Test
	public void test3_MostrarAerolineas() {

		assertTrue("Las aerolinea no se cargan", aerolineas.size() != 0);
	}

	@Test
	public void test3_MostrarAeropuertos() {
		assertTrue("Las aerolinea no se cargan", aeropuertos.size() != 0);
	}


	

@Test
public void test3_MostrarPais() {
	assertTrue("Los paises no se cargan", paises.size()!=0);
	
}

@Test
public void test3_MostrarViajes() {
	ArrayList<Viaje> viajes = gestor.mostrarViajes(agencia ,paises);
	assertTrue("No se carga lista de viajes", viajes.size()!=0);
	
}

@Test
public void test5_BorrarViaje() {
	ArrayList<Viaje> viajes = gestor.mostrarViajes(agencia ,paises);
	boolean borrar = false;
	
	if(viajes.size()!=0) {
		borrar=gestor.borrarViaje(viajes.get(0));
	}
	assertTrue("Viaje no eliminado", borrar);
}

}