package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Gestor {

	public Agencia login(String usuario, String contraseña) {
		Connection conexion = null;
		PreparedStatement sentencia = null;
		ResultSet resultSet = null;
		Agencia agencia = null;
		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
			String sql = SQLQuerys.SELECT_USUARIO_CLAVE;
			sentencia = conexion.prepareStatement(sql);
			sentencia.setString(1, usuario);
			sentencia.setString(2, contraseña);
			resultSet = sentencia.executeQuery();

			if (resultSet.isBeforeFirst() && resultSet.next()) {
				agencia = new Agencia();
				agencia.setIdAgencia(resultSet.getString("idAgencia"));
				agencia.setNombre(resultSet.getString("nombre"));
				agencia.setColorMarca(resultSet.getString("colorMarca"));
				agencia.setNumeroEmpleados(resultSet.getString("numeroEmpleados"));
				agencia.setTipoAgencia(resultSet.getString("tipoAgencia"));
				agencia.setLogo(resultSet.getString("Logo"));

			}
		} catch (SQLException sqle) {
			System.out.println("Error con la base de datos" + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error génerico" + e.getMessage());
		}

		try {
			resultSet.close();
		} catch (Exception e) {
			System.out.println("Error al cerrar el resultSet" + e.getMessage());
		}
		try {
			sentencia.close();
		} catch (SQLException sqle) {
			System.out.println("Error al cerrar la sentencia" + sqle.getMessage());
		}
		try {
			conexion.close();
		} catch (SQLException sqle) {
			System.out.println("Error al cerrar la conexión" + sqle.getMessage());
		}
		return agencia;
	}

	public boolean crearAgencia(Agencia agencia) {
		boolean valido = false;
		Connection conexion = null;
		Statement sentencia = null;

		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
			sentencia = conexion.createStatement();
			String sql = SQLQuerys.INSERT_NUEVA_AGENCIA + agencia.getNombre() + SQLQuerys.SEPARATOR
					+ agencia.getColorMarca() + SQLQuerys.SEPARATOR + agencia.getNumeroEmpleados() + SQLQuerys.SEPARATOR
					+ agencia.getTipoAgencia() + SQLQuerys.SEPARATOR + agencia.getLogo() + SQLQuerys.SEPARATOR
					+ agencia.getClave() + SQLQuerys.ENDBLOCK;
			sentencia.executeUpdate(sql);
			if (sentencia != null) {
				valido = true;
			}
		} catch (SQLException sqle) {
			System.out.println("Error con la base de datos" + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error genérico" + e.getMessage());
		}

		try {
			sentencia.close();
		} catch (SQLException e) {
			System.out.println("Error al cerrar sentencia");
		}
		try {
			conexion.close();
		} catch (SQLException e) {
			System.out.println("Error al cerrar conexión");
		}
		return valido;
	}

	public ArrayList<Vuelo> mostrarVuelos(Viaje viaje) {
		Connection conexion = null;
		PreparedStatement sentencia = null;
		ResultSet resultSet = null;
		ArrayList<Vuelo> vuelos = null;
		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
			String sql = SQLQuerys.SELECT_TODOS_VUELOS;
			sentencia = conexion.prepareStatement(sql);
			sentencia.setString(1, viaje.getIdViaje());
			resultSet = sentencia.executeQuery();
			vuelos = new ArrayList<Vuelo>();

			while (resultSet.next()) {
				Vuelo vuelo = new Vuelo();
				vuelo.setViaje(viaje);
				vuelo.setIdEvento(resultSet.getString("idEvento"));
				vuelo.setCodigoVuelo(resultSet.getString("codigoVuelo"));
				vuelo.setFecha(resultSet.getString("fecSalida"));
				vuelo.setPrecio(resultSet.getString("precio"));
				vuelo.setHora(resultSet.getString("horaSalida"));
				vuelo.setDuracion(resultSet.getString("horaSalida"));
				vuelos.add(vuelo);
			}
		} catch (SQLException sqle) {
			System.out.println("Error con la base de datos" + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error génerico" + e.getMessage());
		}

		try {
			resultSet.close();
		} catch (Exception e) {
			System.out.println("Error al cerrar el resultSet" + e.getMessage());
		}
		try {
			sentencia.close();
		} catch (SQLException sqle) {
			System.out.println("Error al cerrar la sentencia" + sqle.getMessage());
		}
		try {
			conexion.close();
		} catch (SQLException sqle) {
			System.out.println("Error al cerrar la conexión" + sqle.getMessage());
		}

		return vuelos;
	}

	public ArrayList<Alojamiento> mostrarAlojamientos(Viaje viaje) {
		Connection conexion = null;
		PreparedStatement sentencia = null;
		ResultSet resultSet = null;
		ArrayList<Alojamiento> alojamientos = null;
		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
			String sql = SQLQuerys.SELECT_TODOS_ALOJAMIENTO;
			sentencia = conexion.prepareStatement(sql);
			sentencia.setString(1, viaje.getIdViaje());
			resultSet = sentencia.executeQuery();
			alojamientos = new ArrayList<Alojamiento>();

			while (resultSet.next()) {
				Alojamiento alojamiento = new Alojamiento();
				alojamiento.setViaje(viaje);
				alojamiento.setIdEvento(resultSet.getString("idEvento"));
				alojamiento.setNombreEvento(resultSet.getString("nombreHotel"));
				alojamiento.setFecha(resultSet.getString("fecSalida"));
				alojamiento.setPrecio(resultSet.getString("precio"));
				alojamientos.add(alojamiento);
			}
		} catch (SQLException sqle) {
			System.out.println("Error con la base de datos" + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error génerico" + e.getMessage());
		}

		try {
			resultSet.close();
		} catch (Exception e) {
			System.out.println("Error al cerrar el resultSet" + e.getMessage());
		}
		try {
			sentencia.close();
		} catch (SQLException sqle) {
			System.out.println("Error al cerrar la sentencia" + sqle.getMessage());
		}
		try {
			conexion.close();
		} catch (SQLException sqle) {
			System.out.println("Error al cerrar la conexión" + sqle.getMessage());
		}

		return alojamientos;
	}

	public ArrayList<Otros> mostrarOtros(Viaje viaje) {
		Connection conexion = null;
		PreparedStatement sentencia = null;
		ResultSet resultSet = null;
		ArrayList<Otros> otros = null;
		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
			String sql = SQLQuerys.SELECT_TODOS_OTROS;
			sentencia = conexion.prepareStatement(sql);
			sentencia.setString(1, viaje.getIdViaje());
			resultSet = sentencia.executeQuery();
			otros = new ArrayList<Otros>();

			while (resultSet.next()) {
				Otros otro = new Otros();
				otro.setViaje(viaje);
				otro.setIdEvento(resultSet.getString("idEvento"));
				otro.setNombreEvento(resultSet.getString("nombre"));
				otro.setFecha(resultSet.getString("fecSalida"));
				otro.setPrecio(resultSet.getString("precio"));
				otro.setDescripcion(resultSet.getString("descripcion"));
				otros.add(otro);
			}
		} catch (SQLException sqle) {
			System.out.println("Error con la base de datos" + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error génerico" + e.getMessage());
		}

		try {
			resultSet.close();
		} catch (Exception e) {
			System.out.println("Error al cerrar el resultSet" + e.getMessage());
		}
		try {
			sentencia.close();
		} catch (SQLException sqle) {
			System.out.println("Error al cerrar la sentencia" + sqle.getMessage());
		}
		try {
			conexion.close();
		} catch (SQLException sqle) {
			System.out.println("Error al cerrar la conexión" + sqle.getMessage());
		}

		return otros;
	}

	public boolean eliminarVuelo(Vuelo vuelo) {

		Connection conexion = null;
		PreparedStatement sentencia = null;
		boolean valido = false;

		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
			String sql = SQLQuerys.DELETE_EVENTO_VUELO;
			sentencia = conexion.prepareStatement(sql);
			sentencia.setString(1, vuelo.getIdEvento());

			sentencia.executeUpdate();
			valido = true;

		} catch (SQLException sqle) {
			System.out.println("Error con la base de datos" + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error génerico" + e.getMessage());
		}

		try {
			sentencia.close();
		} catch (SQLException sqle) {
			System.out.println("Error al cerrar la sentencia" + sqle.getMessage());
		}
		try {
			conexion.close();
		} catch (SQLException sqle) {
			System.out.println("Error al cerrar la conexión" + sqle.getMessage());
		}

		return valido;

	}

	public boolean eliminarAlojamiento(Alojamiento alojamiento) {

		Connection conexion = null;
		PreparedStatement sentencia = null;

		boolean valido = false;

		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
			String sql = SQLQuerys.DELETE_EVENTO_ALOJAMIENTO;
			sentencia = conexion.prepareStatement(sql);
			sentencia.setString(1, alojamiento.getIdEvento());

			sentencia.executeUpdate();
			valido = true;

		} catch (SQLException sqle) {
			System.out.println("Error con la base de datos" + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error génerico" + e.getMessage());
		}

		try {
			sentencia.close();
		} catch (SQLException sqle) {
			System.out.println("Error al cerrar la sentencia" + sqle.getMessage());
		}
		try {
			conexion.close();
		} catch (SQLException sqle) {
			System.out.println("Error al cerrar la conexión" + sqle.getMessage());
		}

		return valido;

	}

	public boolean eliminarOtros(Otros otro) {

		Connection conexion = null;
		PreparedStatement sentencia = null;
		boolean valido = false;

		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
			String sql = SQLQuerys.DELETE_EVENTO_OTROS;
			sentencia = conexion.prepareStatement(sql);
			sentencia.setString(1, otro.getIdEvento());

			sentencia.executeUpdate();
			valido = true;

		} catch (SQLException sqle) {
			System.out.println("Error con la base de datos" + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error génerico" + e.getMessage());
		}

		try {
			sentencia.close();
		} catch (SQLException sqle) {
			System.out.println("Error al cerrar la sentencia" + sqle.getMessage());
		}
		try {
			conexion.close();
		} catch (SQLException sqle) {
			System.out.println("Error al cerrar la conexión" + sqle.getMessage());
		}

		return valido;

	}

	public ArrayList<Aerolinea> mostrarAerolineas() {
		Connection conexion = null;
		PreparedStatement sentencia = null;
		ResultSet resultSet = null;
		ArrayList<Aerolinea> aerolineas = null;
		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
			String sql = SQLQuerys.SELECT_TODAS_AEROLINEAS;
			sentencia = conexion.prepareStatement(sql);
			resultSet = sentencia.executeQuery();
			aerolineas = new ArrayList<Aerolinea>();

			while (resultSet.next()) {
				Aerolinea aerolinea = new Aerolinea();
				aerolinea.setCodigoAerolinea(resultSet.getString("codigoAerolinea"));
				aerolinea.setDescripcionAerolinea(resultSet.getString("nombreAerolinea"));
				aerolineas.add(aerolinea);
			}
		} catch (SQLException sqle) {
			System.out.println("Error con la base de datos" + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error génerico" + e.getMessage());
		}

		try {
			resultSet.close();
		} catch (Exception e) {
			System.out.println("Error al cerrar el resultSet" + e.getMessage());
		}
		try {
			sentencia.close();
		} catch (SQLException sqle) {
			System.out.println("Error al cerrar la sentencia" + sqle.getMessage());
		}
		try {
			conexion.close();
		} catch (SQLException sqle) {
			System.out.println("Error al cerrar la conexión" + sqle.getMessage());
		}
		return aerolineas;
	}

	public ArrayList<Aeropuerto> mostrarAeropuertos() {
		Connection conexion = null;
		PreparedStatement sentencia = null;
		ResultSet resultSet = null;
		ArrayList<Aeropuerto> aeropuertos = null;
		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
			String sql = SQLQuerys.SELECT_TODAS_AEROPUERTOS;
			sentencia = conexion.prepareStatement(sql);
			resultSet = sentencia.executeQuery();
			aeropuertos = new ArrayList<Aeropuerto>();

			while (resultSet.next()) {
				Aeropuerto aeropuerto = new Aeropuerto();
				aeropuerto.setCodigoAero(resultSet.getString("codigoAeropuerto"));
				aeropuerto.setLugarAero(resultSet.getString("lugarAeropuerto"));
				aeropuertos.add(aeropuerto);
			}
		} catch (SQLException sqle) {
			System.out.println("Error con la base de datos" + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error génerico" + e.getMessage());
		}

		try {
			resultSet.close();
		} catch (Exception e) {
			System.out.println("Error al cerrar el resultSet" + e.getMessage());
		}
		try {
			sentencia.close();
		} catch (SQLException sqle) {
			System.out.println("Error al cerrar la sentencia" + sqle.getMessage());
		}
		try {
			conexion.close();
		} catch (SQLException sqle) {
			System.out.println("Error al cerrar la conexión" + sqle.getMessage());
		}
		return aeropuertos;
	}

	public ArrayList<Pais> mostrarPais() {
		Connection conexion = null;
		PreparedStatement sentencia = null;
		ResultSet resultSet = null;
		ArrayList<Pais> paises = null;
		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
			String sql = SQLQuerys.SELECT_TODOS_PAISES;
			sentencia = conexion.prepareStatement(sql);
			resultSet = sentencia.executeQuery();
			paises = new ArrayList<Pais>();

			while (resultSet.next()) {
				Pais pais = new Pais();
				pais.setCodigoPais(resultSet.getString("codigoPais"));
				pais.setDescripPais(resultSet.getString("descripcion"));
				paises.add(pais);
			}
		} catch (SQLException sqle) {
			System.out.println("Error con la base de datos" + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error génerico" + e.getMessage());
		}

		try {
			resultSet.close();
		} catch (Exception e) {
			System.out.println("Error al cerrar el resultSet" + e.getMessage());
		}
		try {
			sentencia.close();
		} catch (SQLException sqle) {
			System.out.println("Error al cerrar la sentencia" + sqle.getMessage());
		}
		try {
			conexion.close();
		} catch (SQLException sqle) {
			System.out.println("Error al cerrar la conexión" + sqle.getMessage());
		}
		return paises;
	}

	public ArrayList<Viaje> mostrarViajes(Agencia agencia, ArrayList<Pais> paises) {
		Connection conexion = null;
		PreparedStatement sentencia = null;
		ResultSet resultSet = null;
		ArrayList<Viaje> viajes = null;
		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
			String sql = SQLQuerys.SELECT_TODOS_VIAJES;
			sentencia = conexion.prepareStatement(sql);
			sentencia.setString(1, agencia.getIdAgencia());
			resultSet = sentencia.executeQuery();
			viajes = new ArrayList<Viaje>();

			while (resultSet.next()) {
				Viaje viaje = new Viaje();
				viaje.setAgencia(agencia);
				viaje.setIdViaje(resultSet.getString("idViajes"));
				viaje.setDescripcion(resultSet.getString("Descripcion"));
				viaje.setTipoViaje(resultSet.getString("TipoViaje"));
				viaje.setFechaIda(resultSet.getString("FechaIda"));
				viaje.setFechaVuelta(resultSet.getString("FechaVuelta"));
				viaje.setDuracion(resultSet.getString("Duracion"));
				for (Pais pais : paises) {
					if (pais.getCodigoPais().equals(resultSet.getString("codigoPais"))) {
						viaje.setPais(pais);
					}

				}

				viajes.add(viaje);
			}
		} catch (SQLException sqle) {
			System.out.println("Error con la base de datos" + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error génerico" + e.getMessage());
		}

		try {
			resultSet.close();
		} catch (Exception e) {
			System.out.println("Error al cerrar el resultSet" + e.getMessage());
		}
		try {
			sentencia.close();
		} catch (SQLException sqle) {
			System.out.println("Error al cerrar la sentencia" + sqle.getMessage());
		}
		try {
			conexion.close();
		} catch (SQLException sqle) {
			System.out.println("Error al cerrar la conexión" + sqle.getMessage());
		}
		return viajes;
	}

	public boolean borrarViaje(Viaje viaje) {

		Connection conexion = null;
		PreparedStatement sentencia = null;
		boolean valido = false;

		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
			String sql = SQLQuerys.DELETE_VIAJE;
			sentencia = conexion.prepareStatement(sql);
			sentencia.setString(1, viaje.getIdViaje());

			sentencia.executeUpdate();
			valido = true;

		} catch (SQLException sqle) {
			System.out.println("Error con la base de datos" + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error génerico" + e.getMessage());
		}

		try {
			sentencia.close();
		} catch (SQLException sqle) {
			System.out.println("Error al cerrar la sentencia" + sqle.getMessage());
		}
		try {
			conexion.close();
		} catch (SQLException sqle) {
			System.out.println("Error al cerrar la conexión" + sqle.getMessage());
		}

		return valido;
	}

	public boolean crearViaje(Viaje viaje) {
		boolean valido = false;
		Connection conexion = null;
		Statement sentencia = null;

		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
			sentencia = conexion.createStatement();
			String sql = SQLQuerys.INSERT_NUEVO_VIAJE + viaje.getNombreViaje() + SQLQuerys.SEPARATOR
					+ viaje.getDescripcion() + SQLQuerys.SEPARATOR + viaje.getTipoViaje() + SQLQuerys.SEPARATOR
					+ viaje.getFechaIda() + SQLQuerys.SEPARATOR + viaje.getFechaVuelta() + SQLQuerys.SEPARATOR
					+ viaje.getDuracion() + SQLQuerys.SEPARATOR + viaje.getDescServicio() + SQLQuerys.SEPARATOR
					+ viaje.getAgencia().getIdAgencia() + SQLQuerys.SEPARATOR + viaje.getPais().getCodigoPais()
					+ SQLQuerys.ENDBLOCK;
			sentencia.executeUpdate(sql);
			if (sentencia != null) {
				valido = true;
			}
		} catch (SQLException sqle) {
			System.out.println("Error con la base de datos" + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error genérico" + e.getMessage());
		}

		try {
			sentencia.close();
		} catch (SQLException e) {
			System.out.println("Error al cerrar sentencia");
		}
		try {
			conexion.close();
		} catch (SQLException e) {
			System.out.println("Error al cerrar conexión");
		}
		return valido;
	}

	public boolean crearVuelo(Vuelo vuelo) {
		boolean valido = false;
		Connection conexion = null;
		Statement sentencia = null;

		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
			sentencia = conexion.createStatement();
			String sql = SQLQuerys.INSERT_NUEVO_VUELO + vuelo.getCodigoVuelo() + SQLQuerys.SEPARATOR + vuelo.getPrecio()
					+ SQLQuerys.SEPARATOR + vuelo.getFecha() + SQLQuerys.SEPARATOR + vuelo.getHora()
					+ SQLQuerys.SEPARATOR + vuelo.getDuracion() + SQLQuerys.SEPARATOR
					+ vuelo.getAeropuertoOrigen().getCodigoAero() + SQLQuerys.SEPARATOR
					+ vuelo.getAeropuertoDestino().getCodigoAero() + SQLQuerys.SEPARATOR
					+ vuelo.getAerolinea().getCodigoAerolinea() + SQLQuerys.SEPARATOR + vuelo.getViaje().getIdViaje()
					+ SQLQuerys.ENDBLOCK;

			sentencia.executeUpdate(sql);
			if (sentencia != null) {
				valido = true;
			}
		} catch (SQLException sqle) {
			System.out.println("Error con la base de datos" + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error genérico" + e.getMessage());
		}

		try {
			sentencia.close();
		} catch (SQLException e) {
			System.out.println("Error al cerrar sentencia");
		}
		try {
			conexion.close();
		} catch (SQLException e) {
			System.out.println("Error al cerrar conexión");
		}
		return valido;
	}

	public boolean crearVueloVuelta(Vuelo vuelo) {
		boolean valido = false;
		Connection conexion = null;
		Statement sentencia = null;

		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
			sentencia = conexion.createStatement();
			String sql = SQLQuerys.INSERT_NUEVO_VUELO_VUELTA + vuelo.getNombreEvento() + SQLQuerys.SEPARATOR
					+ vuelo.getPrecio() + SQLQuerys.SEPARATOR + vuelo.getFecha() + SQLQuerys.SEPARATOR + vuelo.getHora()
					+ SQLQuerys.SEPARATOR + vuelo.getDuracion() + SQLQuerys.SEPARATOR
					+ vuelo.getAeropuertoOrigen().getCodigoAero() + SQLQuerys.SEPARATOR
					+ vuelo.getAeropuertoDestino().getCodigoAero() + SQLQuerys.SEPARATOR
					+ vuelo.getAerolinea().getCodigoAerolinea() + SQLQuerys.SEPARATOR + maximoIdEvento()
					+ SQLQuerys.SEPARATOR + vuelo.getViaje().getIdViaje() + SQLQuerys.ENDBLOCK;
			System.out.println(SQLQuerys.INSERT_NUEVO_VUELO_VUELTA + vuelo.getNombreEvento() + SQLQuerys.SEPARATOR
					+ vuelo.getPrecio() + SQLQuerys.SEPARATOR + vuelo.getFecha() + SQLQuerys.SEPARATOR + vuelo.getHora()
					+ SQLQuerys.SEPARATOR + vuelo.getDuracion() + SQLQuerys.SEPARATOR
					+ vuelo.getAeropuertoOrigen().getCodigoAero() + SQLQuerys.SEPARATOR
					+ vuelo.getAeropuertoDestino().getCodigoAero() + SQLQuerys.SEPARATOR
					+ vuelo.getAerolinea().getCodigoAerolinea() + SQLQuerys.SEPARATOR
					+ vuelo.getVueloIda().getIdEvento() + SQLQuerys.SEPARATOR + vuelo.getViaje().getIdViaje()
					+ SQLQuerys.ENDBLOCK);

			sentencia.executeUpdate(sql);
			if (sentencia != null) {
				valido = true;
			}
		} catch (SQLException sqle) {
			System.out.println("Error con la base de datos" + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error genérico" + e.getMessage());
		}

		try {
			sentencia.close();
		} catch (SQLException e) {
			System.out.println("Error al cerrar sentencia");
		}
		try {
			conexion.close();
		} catch (SQLException e) {
			System.out.println("Error al cerrar conexión");
		}
		return valido;
	}

	public boolean crearAlojamiento(Alojamiento alojamiento) {
		boolean valido = false;
		Connection conexion = null;
		Statement sentencia = null;

		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
			sentencia = conexion.createStatement();
			String sql = SQLQuerys.INSERT_NUEVO_ALOJAMIENTO + alojamiento.getNombreEvento() + SQLQuerys.SEPARATOR
					+ alojamiento.getCiudad() + SQLQuerys.SEPARATOR + alojamiento.getPrecio() + SQLQuerys.SEPARATOR
					+ alojamiento.getFecha() + SQLQuerys.SEPARATOR + alojamiento.getTipoHab() + SQLQuerys.SEPARATOR
					+ alojamiento.getViaje().getIdViaje() + SQLQuerys.ENDBLOCK;
			sentencia.executeUpdate(sql);
			if (sentencia != null) {
				valido = true;
			}
		} catch (SQLException sqle) {
			System.out.println("Error con la base de datos" + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error genérico" + e.getMessage());
		}

		try {
			sentencia.close();
		} catch (SQLException e) {
			System.out.println("Error al cerrar sentencia");
		}
		try {
			conexion.close();
		} catch (SQLException e) {
			System.out.println("Error al cerrar conexión");
		}
		return valido;
	}

	public boolean crearOtros(Otros otros) {
		boolean valido = false;
		Connection conexion = null;
		Statement sentencia = null;

		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
			sentencia = conexion.createStatement();
			String sql = SQLQuerys.INSERT_NUEVO_OTROS + otros.getNombreEvento() + SQLQuerys.SEPARATOR
					+ otros.getDescripcion() + SQLQuerys.SEPARATOR + otros.getPrecio() + SQLQuerys.SEPARATOR
					+ otros.getFecha() + SQLQuerys.SEPARATOR + otros.getViaje().getIdViaje() + SQLQuerys.ENDBLOCK;

			sentencia.executeUpdate(sql);
			if (sentencia != null) {
				valido = true;
			}
		} catch (SQLException sqle) {
			System.out.println("Error con la base de datos" + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error genérico" + e.getMessage());
		}

		try {
			sentencia.close();
		} catch (SQLException e) {
			System.out.println("Error al cerrar sentencia");
		}
		try {
			conexion.close();
		} catch (SQLException e) {
			System.out.println("Error al cerrar conexión");
		}
		return valido;
	}

	public String maximoIdEvento() {
		Connection conexion = null;
		PreparedStatement sentencia = null;
		ResultSet resultSet = null;
		String suma = "29";
		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
			String sql = SQLQuerys.SELECT_MAXIMO_ID_EVENTO;
			sentencia = conexion.prepareStatement(sql);
			resultSet = sentencia.executeQuery();

			if (resultSet.isBeforeFirst() && resultSet.next()) {
				suma = resultSet.getString("idEvento");

			}
		} catch (SQLException sqle) {
			System.out.println("Error con la base de datos" + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error génerico" + e.getMessage());
		}

		try {
			resultSet.close();
		} catch (Exception e) {
			System.out.println("Error al cerrar el resultSet" + e.getMessage());
		}
		try {
			sentencia.close();
		} catch (SQLException sqle) {
			System.out.println("Error al cerrar la sentencia" + sqle.getMessage());
		}
		try {
			conexion.close();
		} catch (SQLException sqle) {
			System.out.println("Error al cerrar la conexión" + sqle.getMessage());
		}

		return suma;
	}
}