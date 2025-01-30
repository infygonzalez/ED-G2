package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class GestorAgencia {

	public boolean verificarDatos (String nombre, String clave) {
		Connection conexion = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = SQLQuerys.SELECT_USUARIO_CLAVE;
		
		try {
			Class.forName(DBUtils.DRIVER);
			
			conexion=DBUtils.getConnection();
			
			stmt=conexion.prepareStatement(sql);
			stmt.setString(1,nombre);
			stmt.setString(2,clave);
			rs=stmt.executeQuery();
			
			if(rs.next()) {
				return true;
			}
			else {
				return false;
			}	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (rs !=null) rs.close();
				if(stmt !=null)stmt.close();
				if(conexion !=null)conexion.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
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
