package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GestorViajes {

	
	public ArrayList<Viaje> mostrarViajes() {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet resultSet = null;
        ArrayList<Viaje> viajes = null;
        try {
            Class.forName(DBUtils.DRIVER);
            conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
            String sql = SQLQuerys.SELECT_TODOS_VIAJES;
            sentencia = conexion.prepareStatement(sql);
            resultSet = sentencia.executeQuery();
            viajes = new ArrayList<Viaje>();

            while (resultSet.next()) {
                Viaje viaje = new Viaje();
                viaje.setNombreViaje(resultSet.getString("Nombre"));
                viaje.setDescripcion(resultSet.getString("Descripcion"));
                viaje.setTipoViaje(resultSet.getString("Tipo viajes"));
                viaje.setFechaIda(resultSet.getString("Fecha ida"));
                viaje.setFechaVuelta(resultSet.getString("Fecha Vuelta"));
                viaje.setDuracion(resultSet.getString("Duracion"));
                viaje.setDescServicio(resultSet.getString("Servicios no incluidos"));
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

