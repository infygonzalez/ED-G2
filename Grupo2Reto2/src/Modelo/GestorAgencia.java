package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



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
			return rs.next();
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
}
