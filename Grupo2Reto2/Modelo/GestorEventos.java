package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GestorEventos {

	public ArrayList<Vuelo> mostrarVuelos() {
		Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet resultSet = null;
        ArrayList<Vuelo> vuelos = null;
        try {
            Class.forName(DBUtils.DRIVER);
            conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
            String sql = SQLQuerys.SELECT_TODOS_VUELOS;
            sentencia = conexion.prepareStatement(sql);
            resultSet = sentencia.executeQuery();
            vuelos = new ArrayList<Vuelo>();

            while (resultSet.next()) {
                Vuelo vuelo = new Vuelo();
                vuelo.setCodigoVuelo(resultSet.getString("codigoVuelo"));
                vuelo.setFecha(resultSet.getString("fecSalida"));
                vuelo.setPrecio(resultSet.getString("precio"));
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
	
	

	public ArrayList<Alojamiento> mostrarAlojamientos() {
		Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet resultSet = null;
        ArrayList<Alojamiento> alojamientos = null;
        try {
            Class.forName(DBUtils.DRIVER);
            conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
            String sql = SQLQuerys.SELECT_TODOS_ALOJAMIENTO;
            sentencia = conexion.prepareStatement(sql);
            resultSet = sentencia.executeQuery();
            alojamientos = new ArrayList<Alojamiento>();

            while (resultSet.next()) {
            	Alojamiento alojamiento = new Alojamiento();
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
	
	public ArrayList<Otros> mostrarOtros() {
		Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet resultSet = null;
        ArrayList<Otros> otros = null;
        try {
            Class.forName(DBUtils.DRIVER);
            conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
            String sql = SQLQuerys.SELECT_TODOS_OTROS;
            sentencia = conexion.prepareStatement(sql);
            resultSet = sentencia.executeQuery();
            otros = new ArrayList<Otros>();

            while (resultSet.next()) {
            	Otros otros1 = new Otros();
            	otros1.setNombreEvento(resultSet.getString("nombre"));
            	otros1.setFecha(resultSet.getString("fecSalida"));
            	otros1.setPrecio(resultSet.getString("precio"));
                otros.add(otros1);
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

}
