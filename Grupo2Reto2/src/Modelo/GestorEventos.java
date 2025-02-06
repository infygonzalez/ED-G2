package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComboBox;

public class GestorEventos {

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
	
	public boolean eliminarVuelo(Vuelo vuelo){
		

	 	Connection conexion = null;
        PreparedStatement sentencia = null;
        boolean valido=false;
       
        try {
            Class.forName(DBUtils.DRIVER);
            conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
            String sql = SQLQuerys.DELETE_EVENTO_VUELO;
            sentencia = conexion.prepareStatement(sql);          
            sentencia.setString(1, vuelo.getIdEvento());


            sentencia.executeUpdate();
            valido=true;
            
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
	
public boolean eliminarAlojamiento(Alojamiento alojamiento){
		

	 	Connection conexion = null;
        PreparedStatement sentencia = null;
  
        boolean valido=false;
       
        try {
            Class.forName(DBUtils.DRIVER);
            conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
            String sql = SQLQuerys.DELETE_EVENTO_ALOJAMIENTO;
            sentencia = conexion.prepareStatement(sql);          
            sentencia.setString(1, alojamiento.getIdEvento());
     

            sentencia.executeUpdate();
            valido=true;
            
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

public boolean eliminarOtros(Otros otro){
	

 	Connection conexion = null;
    PreparedStatement sentencia = null;
    boolean valido=false;
   
    try {
        Class.forName(DBUtils.DRIVER);
        conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
        String sql = SQLQuerys.DELETE_EVENTO_OTROS;
        sentencia = conexion.prepareStatement(sql);          
        sentencia.setString(1, otro.getIdEvento());
      

        sentencia.executeUpdate();
        valido=true;
        
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

}
