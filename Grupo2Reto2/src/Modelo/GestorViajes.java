package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GestorViajes {
	
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
	
	public ArrayList<Viaje> mostrarViajes(Agencia agencia,ArrayList<Pais> paises) {
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
                viaje.setNombreViaje(resultSet.getString("Nombre"));
                viaje.setDescripcion(resultSet.getString("Descripcion"));
                viaje.setTipoViaje(resultSet.getString("TipoViaje"));
                viaje.setFechaIda(resultSet.getString("FechaIda"));
                viaje.setFechaVuelta(resultSet.getString("FechaVuelta"));
                viaje.setDuracion(resultSet.getString("Duracion"));
                for (Pais pais: paises) {
                	if(pais.getCodigoPais().equals(resultSet.getString("codigoPais"))){
                		viaje.setPais(pais);
                	}else {
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
	

	
}

