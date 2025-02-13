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
	Alojamiento alojamiento;
	Vuelo vuelo;
	Otros otro;
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
		agencia.setNombre("p");
		agencia.setColorMarca("colorMarca");
		agencia.setNumeroEmpleados("Entre 2 y 10 empleados");
		agencia.setTipoAgencia("minorista");
		agencia.setLogo("Logo");
		agencia.setClave("JUnit");

		viaje = new Viaje();
		viaje.setNombreViaje("Viaje");
		viaje.setDescripcion("pp");
		viaje.setTipoViaje("Novios");
		viaje.setFechaIda("2025-02-02");
		viaje.setFechaVuelta("2025-03-03");
		viaje.setDuracion("9");
		viaje.setDescServicio("aa");

		for (Pais pais : paises) {
			if (pais.getDescripPais().equals("Argentina")) {
				viaje.setPais(pais);
			}

		}
	}

	@Test
	public void test01_CrearAgencia() {
		boolean crearNuevaAgencia = gestor.crearAgencia(agencia);
		assertNotNull("La agencia no se crea correctamente", crearNuevaAgencia);

	}

	@Test
	public void test02_Login() {

		agencia = gestor.login("p", "JUnit");
		assertTrue("Login correcto", agencia instanceof Agencia);

	}

	@Test
	public void test03_CrearViaje() {
		agencia = gestor.login("p", "JUnit");
		viaje.setAgencia(agencia);
		boolean crearViaje = gestor.crearViaje(viaje);
		assertNotNull("La agencia no se crea correctamente", crearViaje);

	}

	@Test
	public void test04_CrearVuelo() {
		boolean crearVuelo = false;
		agencia = gestor.login("p", "JUnit");
		viaje.setAgencia(agencia);
		Vuelo vuelo = new Vuelo();
		ArrayList<Viaje> viajes = gestor.mostrarViajes(agencia, paises);

		if (viajes.size() != 0) {
			vuelo.setViaje(viajes.get(0));
			vuelo.setCodigoVuelo("123");
			vuelo.setFecha("2025-03-03");
			vuelo.setPrecio("123");
			vuelo.setHora("00:12:45");
			vuelo.setDuracion("00:12:45");

			for (Aerolinea aerolinea : aerolineas) {
				if (aerolinea.getCodigoAerolinea().equals("RK")) {
					vuelo.setAerolinea(aerolinea);
				}
			}
			for (Aeropuerto aeropuerto : aeropuertos) {
				if (aeropuerto.getCodigoAero().equals("OVD")) {
					vuelo.setAeropuertoOrigen(aeropuerto);
				}
			}
			for (Aeropuerto aeropuerto : aeropuertos) {
				if (aeropuerto.getCodigoAero().equals("OVD")) {
					vuelo.setAeropuertoDestino(aeropuerto);
				}
			}

			crearVuelo = gestor.crearVuelo(vuelo);
		}
		assertNotNull("La agencia no se crea correctamente", crearVuelo);
	}

	@Test
	public void test04_CrearAlojamiento() {
		agencia = gestor.login("p", "JUnit");
		viaje.setAgencia(agencia);
		Alojamiento alojamiento = new Alojamiento();
		ArrayList<Viaje> viajes = gestor.mostrarViajes(agencia, paises);
		boolean crearAlojamiento = false;
		if (viajes.size() != 0) {
			alojamiento.setViaje(viajes.get(0));
			alojamiento.setNombreHotel("Prueba");
			alojamiento.setFecEntrada("2025-03-03");
			alojamiento.setFecSalida("2025-03-08");
			alojamiento.setPrecio("12");
			alojamiento.setTipoHab("DB");
			alojamiento.setCiudad("Bilbao");
			crearAlojamiento = gestor.crearAlojamiento(alojamiento);
		}
		assertNotNull("La agencia no se crea correctamente", crearAlojamiento);

	}

	@Test
	public void test04_CrearOtros() {
		boolean crearOtros = false;
		agencia = gestor.login("p", "JUnit");
		viaje.setAgencia(agencia);
		Otros otro = new Otros();
		ArrayList<Viaje> viajes = gestor.mostrarViajes(agencia, paises);

		if (viajes.size() != 0) {
			otro.setViaje(viajes.get(0));
			otro.setNombreEvento("Prueba");
			otro.setFecha("2025-02-19");
			otro.setPrecio("123");
			otro.setDescripcion("Divertido");

			crearOtros = gestor.crearOtros(otro);

		}
		assertNotNull("La agencia no se crea correctamente", crearOtros);
	}

	@Test
	public void test05_MostrarVuelos() {
		agencia = gestor.login("p", "JUnit");
		viaje.setAgencia(agencia);
		ArrayList<Viaje> viajes = gestor.mostrarViajes(agencia, paises);
		boolean mostrar = false;

		if (viajes.size() != 0) {

			ArrayList<Vuelo> vuelos = gestor.mostrarVuelos(viajes.get(0));
			mostrar = vuelos.size() != 0;
		}
		assertTrue("Los vuelos no se cargan", mostrar);
	}

	@Test
	public void test05_MostrarAlojamientos() {
		agencia = gestor.login("p", "JUnit");
		viaje.setAgencia(agencia);
		ArrayList<Viaje> viajes = gestor.mostrarViajes(agencia, paises);
		boolean mostrar = false;

		if (viajes.size() != 0) {

			ArrayList<Alojamiento> alojamientos = gestor.mostrarAlojamientos(viajes.get(0));
			mostrar = alojamientos.size() != 0;
		}
		assertTrue("Los alojamientos no se cargan", mostrar);
	}

	@Test
	public void test05_MostrarOtros() {
		agencia = gestor.login("p", "JUnit");
		viaje.setAgencia(agencia);
		ArrayList<Viaje> viajes = gestor.mostrarViajes(agencia, paises);
		boolean mostrar = false;

		if (viajes.size() != 0) {

			ArrayList<Otros> otros = gestor.mostrarOtros(viajes.get(0));
			mostrar = otros.size() != 0;
		}
		assertTrue("Los otros eventos no se cargan", mostrar);
	}

	@Test
	public void test05_MostrarViajes() {
		agencia = gestor.login("p", "JUnit");
		viaje.setAgencia(agencia);
		ArrayList<Viaje> viajes = gestor.mostrarViajes(agencia, paises);
		assertTrue("No se carga lista de viajes", viajes.size() != 0);

	}

	@Test
	public void test06_EliminarVuelo() {
		agencia = gestor.login("p", "JUnit");
		viaje.setAgencia(agencia);
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
	public void test06_EliminarAlojamiento() {
		agencia = gestor.login("p", "JUnit");
		viaje.setAgencia(agencia);
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
	public void test06_EliminarOtros() {
		agencia = gestor.login("p", "JUnit");
		viaje.setAgencia(agencia);
		ArrayList<Viaje> viajes = gestor.mostrarViajes(agencia, paises);
		boolean borrar = false;
		if (viajes.size() != 0) {
			ArrayList<Otros> otros = gestor.mostrarOtros(viajes.get(0));
			if (otros.size() != 0) {
				borrar = gestor.eliminarOtros(otros.get(0));
			}
		}

		assertTrue("El otro evento no se elimina", borrar);
	}

	@Test
	public void test05_MostrarAerolineas() {

		assertTrue("Las aerolinea no se cargan", aerolineas.size() != 0);
	}

	@Test
	public void test05_MostrarAeropuertos() {
		assertTrue("Las aerolinea no se cargan", aeropuertos.size() != 0);
	}

	@Test
	public void test05_MostrarPais() {
		assertTrue("Los paises no se cargan", paises.size() != 0);

	}

	@Test
	public void test07_BorrarViaje() {
		agencia = gestor.login("p", "JUnit");
		viaje.setAgencia(agencia);
		ArrayList<Viaje> viajes = gestor.mostrarViajes(agencia, paises);
		boolean borrar = false;

		if (viajes.size() != 0) {
			borrar = gestor.borrarViaje(viajes.get(0));
		}
		assertTrue("Viaje no eliminado", borrar);
	}

}