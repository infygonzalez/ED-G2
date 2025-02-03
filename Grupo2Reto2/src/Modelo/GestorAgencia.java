package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class GestorAgencia {

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
             
            if (resultSet.isBeforeFirst() &&resultSet.next()) {
                agencia = new Agencia();
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
	
	
public void crearAgencia(Agencia agencia) {
        
        Connection conexion = null;
        Statement sentencia = null;
        
        try {
            Class.forName(DBUtils.DRIVER);
            conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
            sentencia=conexion.createStatement();
            String sql = SQLQuerys.INSERT_NUEVA_AGENCIA + agencia.getNombre()+ SQLQuerys.SEPARATOR +agencia.getColorMarca()
                    + SQLQuerys.SEPARATOR + agencia.getNumeroEmpleados()+ SQLQuerys.SEPARATOR
                    + agencia.getTipoAgencia()+ SQLQuerys.SEPARATOR
                    +agencia.getLogo() + SQLQuerys.SEPARATOR
                    + agencia.getClave() + SQLQuerys.ENDBLOCK;
            sentencia.executeUpdate(sql);
            
        } catch (SQLException sqle) {
            System.out.println("Error con la base de datos" + sqle.getMessage());
        }
        catch (Exception e) {
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
    }
	
	
	
}
