package Modelo;

public class SQLQuerys {

	
	//INSERT
		public static final String INSERT_NUEVA_AGENCIA = "insert into agencia(nombre,colorMarca,numeroEmpleados,tipoAgencia,logo,clave) VALUES('";
		public static final String SEPARATOR = "', '";
		public static final String ENDBLOCK = "')";
	
	//SELECTS
		public static final String SELECT_USUARIO_CLAVE = "SELECT * FROM agencia WHERE nombre = ? AND clave = ?";
		public static final String SELECT_TODOS_VIAJES = "SELECT * FROM viajes WHERE idAgencia = ?";
		public static final String SELECT_TODOS_VUELOS = "SELECT * FROM vuelo where idViajes = ?";
		public static final String SELECT_TODOS_ALOJAMIENTO = "SELECT * FROM alojamiento where idViajes = ?";
		public static final String SELECT_TODOS_OTROS = "SELECT * FROM otros where idViajes = ?";
		public static final String SELECT_TODOS_PAISES = "SELECT * FROM pais";
		
		
		
	
	
}
